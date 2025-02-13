package macca.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_credit;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "id_payment1")
    private Payment payment1;
    private Double valuePayment1;

    @ManyToOne
    @JoinColumn(name = "id_payment2")
    private Payment payment2;
    private Double valuePayment2;

    // Getters & Setters

    public Long getId_credit() {
        return id_credit;
    }

    public void setId_credit(Long id_credit) {
        this.id_credit = id_credit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
