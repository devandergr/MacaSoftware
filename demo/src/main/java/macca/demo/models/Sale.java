package macca.demo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_sale;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_storage")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "id_inventory")
    private Inventory inventory;

    private Date dateSale;
    private Integer quantity;
    private Double finalPrice;

    @ManyToOne
    @JoinColumn(name = "id_payment1")
    private Payment payment1;
    private Double valuePayment1;

    @ManyToOne
    @JoinColumn(name = "id_payment2")
    private Payment payment2;
    private Double ValuePayment2;

    private Double total;

    @OneToOne(mappedBy = "sale")
    private SaleInvoice saleInvoice;
}
