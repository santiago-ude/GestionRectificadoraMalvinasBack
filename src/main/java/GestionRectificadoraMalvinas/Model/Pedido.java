package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.naming.ldap.PagedResultsControl;
import java.util.Date;

@Entity //Lo transforma en una entidad para la BDD
@Table(name = "tbl_pedido") //Nombre que tendra en la BDD
@Data //Evita crear Getters and Setters
public class Pedido {

    private Integer id;
    private Cliente cliente;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Date fechaEntregaEstimada;
    private String estado; //activo, entregado o atrasado
    private Presupuesto presupuesto;
    private String marcaAuto;
    private String modeloAuto;
    private String numeroSerie;
    private String descripcion;

}
