package macca.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "saleDetail")
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_saleDetail;

    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;

    private String reference;
    private String size;

    // Getters & Setters

    public Long getId_saleDetail() {
        return id_saleDetail;
    }

    public void setId_saleDetail(Long id_saleDetail) {
        this.id_saleDetail = id_saleDetail;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
