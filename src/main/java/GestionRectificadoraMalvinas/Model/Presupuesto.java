package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity //Lo transforma en una entidad para la BDD
@Table(name = "tbl_presupuesto") //Nombre que tendra en la BDD
@Data //Evita crear Getters and Setters
public class Presupuesto {

    private Integer id;
    private Date fecha;
    private Number descuento;
    private List<Item> items;
    private Number total;




}
