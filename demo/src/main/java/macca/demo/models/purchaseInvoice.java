package macca.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchaseInvoice")
public class purchaseInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_purchaseInvoice;

    private Date date;
    private String numInvoice;
    private Double totalCost;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "id_storage")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "id_credit")
    private Credit credit;

    @ManyToOne
    @JoinColumn(name = "id_payment1")
    private Payment payment1;
    private Double valuePayment1;

    @ManyToOne
    @JoinColumn(name = "id_payment2")
    private Payment payment2;
    private Double valuePayment2;

    // Getters & Setters

    public Long getId_purchaseInvoice() {
        return id_purchaseInvoice;
    }

    public void setId_purchaseInvoice(Long id_purchaseInvoice) {
        this.id_purchaseInvoice = id_purchaseInvoice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumInvoice() {
        return numInvoice;
    }

    public void setNumInvoice(String numInvoice) {
        this.numInvoice = numInvoice;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Payment getPayment1() {
        return payment1;
    }

    public void setPayment1(Payment payment1) {
        this.payment1 = payment1;
    }

    public Double getValuePayment1() {
        return valuePayment1;
    }

    public void setValuePayment1(Double valuePayment1) {
        this.valuePayment1 = valuePayment1;
    }

    public Payment getPayment2() {
        return payment2;
    }

    public void setPayment2(Payment payment2) {
        this.payment2 = payment2;
    }

    public Double getValuePayment2() {
        return valuePayment2;
    }

    public void setValuePayment2(Double valuePayment2) {
        this.valuePayment2 = valuePayment2;
    }
}
