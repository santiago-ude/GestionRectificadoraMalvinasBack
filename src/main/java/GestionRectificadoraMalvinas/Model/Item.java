package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Embeddable
public class Item {



    private String nombre;
    private String descripcion;
    private BigDecimal precioUnitario;
    private BigDecimal precioManoObra;
    private BigDecimal precioFinal;


    //Constructor
    public Item() {
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

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioManoObra() {
        return precioManoObra;
    }

    public void setPrecioManoObra(BigDecimal precioManoObra) {
        this.precioManoObra = precioManoObra;
    }

    public BigDecimal getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }
}
