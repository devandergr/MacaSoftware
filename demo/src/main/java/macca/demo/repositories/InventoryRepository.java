package macca.demo.repositories;

import macca.demo.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByReference(String reference);
    List<Inventory> findByReferenceAndSize(String reference, String size);
}
