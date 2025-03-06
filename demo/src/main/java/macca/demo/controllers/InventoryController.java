package macca.demo.controllers;

import macca.demo.models.Inventory;
import macca.demo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @PostMapping("/save")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.saveInventory(inventory));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory updatedInventory = inventoryService.updateInventory(id, inventory);
        return updatedInventory != null ? ResponseEntity.ok(updatedInventory) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Inventory>> searchInventory(
            @RequestParam(required = false) String reference,
            @RequestParam(required = false) String size) {
        if (reference != null && size != null) {
            return ResponseEntity.ok(inventoryService.findByReferenceAndSize(reference, size));
        } else if (reference != null) {
            return ResponseEntity.ok(inventoryService.findByReference(reference));
        }
        return ResponseEntity.badRequest().build();
    }
}
