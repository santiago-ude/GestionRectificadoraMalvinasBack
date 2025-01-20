package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @Column(name = "nombre_item", nullable = false)
    private String nombre;

    @Column(name = "descripcion_item", nullable = false)
    private String descripcion;

    @Column(name = "precio_unitario", nullable = false)
    private Number precioUnitario;

    @Column(name = "precio_mano_de_obra", nullable = false)
    private Number precioManoObra;

    @Column(name = "precio_final", nullable = false)
    private Number precioFinal;


    //Getters and Setters

    public Long getId() {
        return id;
    }

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

    public void setPrecioFinal(Number precioFinal) {
        this.precioFinal = precioFinal;
    }
}
