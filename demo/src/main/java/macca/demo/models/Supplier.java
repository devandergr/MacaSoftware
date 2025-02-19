package macca.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_supplier;

    private String factory;
    private String tel1;
    private String tel2;
    private String address;
    private String email;
    private String dpto;
    private String city;

    @OneToMany(mappedBy = "supplier")
    private List<PurchaseInvoice> PurchaseInvoices;

    // Getters & Setters

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<PurchaseInvoice> getPurchaseInvoices() {
        return PurchaseInvoices;
    }

    public void setPurchaseInvoices(List<PurchaseInvoice> PurchaseInvoices) {
        this.PurchaseInvoices = PurchaseInvoices;
    }
}
