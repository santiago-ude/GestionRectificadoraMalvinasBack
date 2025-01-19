package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity //Lo transforma en una entidad para la BDD
@Table(name = "tbl_presupuesto") //Nombre que tendra en la BDD
@Data //Evita crear Getters and Setters
public class Presupuesto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presupuesto")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Number descuento;

    @Column(name = "items_asociados", nullable = false)
    private List<Item> items;

    @Column(nullable = false)
    private Number total;


}
