package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "precio_mano_obra")
    private Number precioManoObra;

    @Column(name = "precio_final")
    private Number precioFinal;


    //Constructor
    public Item() {
    }

    public Long getId() {
        return id;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Number getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Number precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Number getPrecioManoObra() {
        return precioManoObra;
    }

    public void setPrecioManoObra(Number precioManoObra) {
        this.precioManoObra = precioManoObra;
    }

    public Number getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }
}
