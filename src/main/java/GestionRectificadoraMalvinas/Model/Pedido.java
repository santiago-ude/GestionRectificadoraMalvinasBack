package GestionRectificadoraMalvinas.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrada", nullable = false)
    private Date fechaEntrada;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_salida_estimada", nullable = false)
    private Date fechaSalidaEstimada;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega_efectiva")
    private Date fechaEntregaEfectiva;

    @Column(name = "estado_pedido", nullable = false)
    private String estado; //o enum

    @OneToOne
    @JoinColumn(name = "id_presupuesto_asociado", referencedColumnName = "id_presupuesto")
    private Presupuesto presupuesto;

    @Column(name = "marca_auto", nullable = false)
    private String marcaAuto;

    @Column(name = "modelo_auto", nullable = false)
    private String modeloAuto;

    @Column(name = "numero_serie", nullable = false)
    private String numeroSerie;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    //Constructor
    public Pedido() {
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalidaEstimada() {
        return fechaSalidaEstimada;
    }

    public void setFechaSalidaEstimada(Date fechaSalidaEstimada) {
        this.fechaSalidaEstimada = fechaSalidaEstimada;
    }

    public Date getFechaEntregaEfectiva() {
        return fechaEntregaEfectiva;
    }

    public void setFechaEntregaEfectiva(Date fechaEntregaEfectiva) {
        this.fechaEntregaEfectiva = fechaEntregaEfectiva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
