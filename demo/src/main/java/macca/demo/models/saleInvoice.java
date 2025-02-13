package macca.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "saleInvoice")
public class saleInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id_saleInvoice;

    @OneToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;

    private Double nequi;
    private Double daviplata;
    private Double datafono;
    private Double bancolombia;
    private Double cash;
    private Double total;

    // Getters & Setters

    public Long getId_saleInvoice() {
        return id_saleInvoice;
    }

    public void setId_saleInvoice(Long id_saleInvoice) {
        this.id_saleInvoice = id_saleInvoice;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Double getNequi() {
        return nequi;
    }

    public void setNequi(Double nequi) {
        this.nequi = nequi;
    }

    public Double getDaviplata() {
        return daviplata;
    }

    public void setDaviplata(Double daviplata) {
        this.daviplata = daviplata;
    }

    public Double getDatafono() {
        return datafono;
    }

    public void setDatafono(Double datafono) {
        this.datafono = datafono;
    }

    public Double getBancolombia() {
        return bancolombia;
    }

    public void setBancolombia(Double bancolombia) {
        this.bancolombia = bancolombia;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
