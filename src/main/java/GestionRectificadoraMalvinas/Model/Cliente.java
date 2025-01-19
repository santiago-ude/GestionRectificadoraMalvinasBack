package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String numero;

    @Column(unique = true, nullable = false)
    private String domicilio;

    @Column(unique = true, nullable = false)
    private String altura;

    @Column(name = "metodo_de_pago", unique = true, nullable = false)
    private String metodoPago;
    
}
