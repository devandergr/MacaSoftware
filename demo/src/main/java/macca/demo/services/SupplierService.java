package macca.demo.services;

import macca.demo.models.Supplier;
import macca.demo.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier saveSupplier(Supplier supplier) {
        if (supplier.getFactory() == null || supplier.getTel1() == null || supplier.getDpto() == null || supplier.getCity() == null) {
            throw new RuntimeException("No pueden existir valores nulos");
        }
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setFactory(updatedSupplier.getFactory());
            supplier.setTel1(updatedSupplier.getTel1());
            supplier.setTel2(updatedSupplier.getTel2());
            supplier.setAddress(updatedSupplier.getAddress());
            supplier.setEmail(updatedSupplier.getEmail());
            supplier.setDpto(updatedSupplier.getDpto());
            supplier.setCity(updatedSupplier.getCity());

            return supplierRepository.save(supplier);
        }
        return null;
    }

    public List<Supplier> findByFactory(String factory) {
        return supplierRepository.findByFactory(factory);
    }
}
