package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;

@Embeddable
public class Item {


    private String nombre;
    private String descripcion;
    private Number precioUnitario;
    private Number precioManoObra;
    private Number precioFinal;


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

    public void setPrecioFinal(Number precioFinal) {
        this.precioFinal = precioFinal;
    }
}
