package macca.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_payment;

    private String name;

    @OneToMany(mappedBy = "payment1")
    private List<Sale> salePayment1;

    @OneToMany(mappedBy = "payment2")
    private List<Sale> salePayment2;

    @OneToMany(mappedBy = "payment1")
    private List<purchaseInvoice> purchaseInvoicesP1;

    @OneToMany(mappedBy = "payment2")
    private List<purchaseInvoice> purchaseInvoicesP2;

    @OneToMany(mappedBy = "payment1")
    private List<Credit> creditsPayment1;

    @OneToMany(mappedBy = "payment2")
    private List<Credit> creditsPayment2;

    // Getters & Setters

    public Long getId_payment() {
        return id_payment;
    }

    public void setId_payment(Long id_payment) {
        this.id_payment = id_payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sale> getSalePayment1() {
        return salePayment1;
    }

    public void setSalePayment1(List<Sale> salePayment1) {
        this.salePayment1 = salePayment1;
    }

    public List<Sale> getSalePayment2() {
        return salePayment2;
    }

    public void setSalePayment2(List<Sale> salePayment2) {
        this.salePayment2 = salePayment2;
    }

    public List<purchaseInvoice> getPurchaseInvoicesP1() {
        return purchaseInvoicesP1;
    }

    public void setPurchaseInvoicesP1(List<purchaseInvoice> purchaseInvoicesP1) {
        this.purchaseInvoicesP1 = purchaseInvoicesP1;
    }

    public List<purchaseInvoice> getPurchaseInvoicesP2() {
        return purchaseInvoicesP2;
    }

    public void setPurchaseInvoicesP2(List<purchaseInvoice> purchaseInvoicesP2) {
        this.purchaseInvoicesP2 = purchaseInvoicesP2;
    }

    public List<Credit> getCreditsPayment1() {
        return creditsPayment1;
    }

    public void setCreditsPayment1(List<Credit> creditsPayment1) {
        this.creditsPayment1 = creditsPayment1;
    }

    public List<Credit> getCreditsPayment2() {
        return creditsPayment2;
    }

    public void setCreditsPayment2(List<Credit> creditsPayment2) {
        this.creditsPayment2 = creditsPayment2;
    }
}
