package macca.demo.repositories;

import macca.demo.models.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository <PurchaseInvoice, Long>{
}
