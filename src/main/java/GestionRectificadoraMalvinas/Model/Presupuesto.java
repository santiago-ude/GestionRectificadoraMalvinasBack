package GestionRectificadoraMalvinas.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_presupuesto")
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presupuesto",nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_presupuesto", nullable = false)
    private Date fecha;

    @Column(name = "descuento")
    private Integer descuento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_presupuesto")
    private List<Item> items;

    @Column(name = "total_presupuesto", nullable = false)
    private BigDecimal total;




    //Constructor
    public Presupuesto() {
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "id=" + id +
                "\n, fecha=" + fecha +
                "\n, descuento=" + descuento +
                "\n, items=" + items +
                "\n, total=" + total +
                '}';
    }
}
