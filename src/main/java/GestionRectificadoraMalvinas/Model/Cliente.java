package GestionRectificadoraMalvinas.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "dni_cliente", unique = true, nullable = false)
    private String dni;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombre;

    @Column(name = "apellido_cliente", nullable = false)
    private String apellido;

    @Column(name = "numero_cliente", unique = true, nullable = false)
    private String numero;

    @Column(name = "domicilio", nullable = false)
    private String domicilio;

    @Column(name = "altura_domicilio", nullable = false)
    private String altura;

    @Column(name = "metodo_de_pago", nullable = false)
    private String metodoPago;

    //Constructor


    public Cliente() {

    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
