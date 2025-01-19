package GestionRectificadoraMalvinas.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity //Lo transforma en una entidad para la BDD
@Table(name = "tbl_cliente") //Nombre que tendra en la BDD
@Data //Evita crear Getters and Setters
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String numero;

    @Column(nullable = false)
    private String domicilio;

    @Column(nullable = false)
    private String altura;

    @Column(name = "metodo_de_pago", nullable = false)
    private String metodoPago;

}
