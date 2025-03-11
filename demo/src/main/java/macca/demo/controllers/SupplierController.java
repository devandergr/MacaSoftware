package macca.demo.controllers;

import macca.demo.models.Supplier;
import macca.demo.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSupplier() {
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @PostMapping("/save")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.saveSupplier(supplier));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return updatedSupplier != null ? ResponseEntity.ok(updatedSupplier) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Supplier>> searchSupplier(@RequestParam String factoryName) {
        if (factoryName != null && !factoryName.isEmpty()) {
            return ResponseEntity.ok(supplierService.findByFactory(factoryName));
        }
        return ResponseEntity.badRequest().build();
    }
}
