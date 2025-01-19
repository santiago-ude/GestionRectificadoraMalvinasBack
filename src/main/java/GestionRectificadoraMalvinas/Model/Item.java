package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_item")
@Data
public class Item {

    private String nombre;
    private String descripcion;
    private Number precioUnitario;
    private Number manoObra;
    private Number precioFinal;


}
