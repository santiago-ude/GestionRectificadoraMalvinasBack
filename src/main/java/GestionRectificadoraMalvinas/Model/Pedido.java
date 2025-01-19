package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.ldap.PagedResultsControl;
import java.util.Date;

@Entity //Lo transforma en una entidad para la BDD
@Table(name = "tbl_pedido") //Nombre que tendra en la BDD
@Data //Evita crear Getters and Setters
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "cliente_asociado", nullable = false)
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrada", nullable = false)
    private Date fechaEntrada;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega_estimada", nullable = false)
    private Date fechaEntregaEstimada;

    @Column(nullable = false)
    private String estado; //activo, entregado o atrasado

    @Column(name = "presupuesto_asociado", nullable = false)
    private Presupuesto presupuesto;

    @Column(name = "marca_auto", nullable = false)
    private String marcaAuto;

    @Column(name = "modelo_auto", nullable = false)
    private String modeloAuto;

    @Column(name = "numero_serie", nullable = false)
    private String numeroSerie;

    @Column(nullable = false)
    private String descripcion;

}
