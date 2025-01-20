package GestionRectificadoraMalvinas.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_presupuesto")
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presupuesto")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_presupuesto", nullable = false)
    private Date fecha;

    @Column(name = "descuento")
    private Number descuento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "items_asociados", nullable = false)

    private List<Item> items;

    @Column(name = "total_presupuesto", nullable = false)
    private Number total;


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

    public Number getDescuento() {
        return descuento;
    }

    public void setDescuento(Number descuento) {
        this.descuento = descuento;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }
}
