package macca.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_storage;

    private String name;

    @OneToMany(mappedBy = "storage")
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "storage")
    private List<Employee> employees;

    // Getters & Setters

    public Long getId_storage() {
        return id_storage;
    }

    public void setId_storage(Long id_storage) {
        this.id_storage = id_storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
