package macca.demo.services;

import jakarta.transaction.Transactional;
import macca.demo.models.Employee;
import macca.demo.models.Supplier;
import macca.demo.models.User;
import macca.demo.models.UserType;
import macca.demo.repositories.EmployeeRepository;
import macca.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity<User> registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(user.getUserType() == null) {
            user.setUserType(UserType.USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            // Actualizar la información del storage
            if (updatedEmployee.getStorage() != null) {
                employee.setStorage(updatedEmployee.getStorage());
            }

            // Actualizar la información del usuario asociado
            if (updatedEmployee.getUser() != null) {
                User existingUser = employee.getUser();
                User updatedUser = updatedEmployee.getUser();

                if (updatedUser.getFirst_name() != null) {
                    existingUser.setFirst_name(updatedUser.getFirst_name());
                }
                if (updatedUser.getLast_name() != null) {
                    existingUser.setLast_name(updatedUser.getLast_name());
                }
                if (updatedUser.getPhone() != null) {
                    existingUser.setPhone(updatedUser.getPhone());
                }
                if (updatedUser.getAddress() != null) {
                    existingUser.setAddress(updatedUser.getAddress());
                }

                if (updatedUser.getUserType() != null) {
                    existingUser.setUserType(updatedUser.getUserType());
                }
                userRepository.save(existingUser);
            }

            return employeeRepository.save(employee);
        }
        return null;
    }

    @Transactional
    public ResponseEntity<?> updatePassword(Long employeeId, String oldPassword, String newPassword) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null && employee.getUser() != null) {
            User user = employee.getUser();

            // Verificar que la contraseña anterior sea correcta
            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("La contraseña actual es incorrecta");
            }
        }
        return ResponseEntity.notFound().build();
    }

    public List<Employee> findByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new RuntimeException("El username de búsqueda no puede estar vacío");
        }

        User user = userRepository.findByUsername(username.trim());
        if (user != null && user.getEmployee() != null) {
            return List.of(user.getEmployee());
        }
        return List.of();
    }

}
