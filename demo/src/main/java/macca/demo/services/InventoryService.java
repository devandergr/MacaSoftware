package macca.demo.services;

import macca.demo.models.Inventory;
import macca.demo.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory saveInventory(Inventory inventory) {
        if (inventory.getReference() == null && inventory.getFactory() == null && inventory.getMaterial() == null
                && inventory.getSize() == null & inventory.getSellingPrice() == null ) {
            throw new RuntimeException("No pueden existir valores nulos");
        }
        if (inventory.getQuantity() == null && inventory.getUnitCost() == null) {
            inventory.setQuantity(0);  // Por defecto, si no se proporciona, se establece en 0
            inventory.setUnitCost(0.0); // Por defecto, si no se proporciona, se establece en 0
        }
        else {
            throw new RuntimeException("La referencia no puede ser nula");
        }
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    public Inventory updateInventory(Long id, Inventory updatedInventory) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory != null) {
            inventory.setReference(updatedInventory.getReference());
            inventory.setFactory(updatedInventory.getFactory());
            inventory.setMaterial(updatedInventory.getMaterial());
            inventory.setColor(updatedInventory.getColor());
            inventory.setSize(updatedInventory.getSize());
            inventory.setQuantity(updatedInventory.getQuantity());
            inventory.setUnitCost(updatedInventory.getUnitCost());
            inventory.setSellingPrice(updatedInventory.getSellingPrice());

            return inventoryRepository.save(inventory);
        }
        return null;
    }
}
