package macca.demo.repositories;

import macca.demo.models.SaleInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleInvoiceRepository extends JpaRepository <SaleInvoice, Long> {
}
