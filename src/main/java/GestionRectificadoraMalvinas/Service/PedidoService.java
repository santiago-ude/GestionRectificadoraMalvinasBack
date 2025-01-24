package GestionRectificadoraMalvinas.Service;

import GestionRectificadoraMalvinas.Model.Cliente;
import GestionRectificadoraMalvinas.Model.Pedido;
import GestionRectificadoraMalvinas.Model.Presupuesto;
import GestionRectificadoraMalvinas.Repository.ClienteRepository;
import GestionRectificadoraMalvinas.Repository.PedidoRepository;
import GestionRectificadoraMalvinas.Repository.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository PR;

    @Autowired
    ClienteRepository CR;

    @Autowired
    PresupuestoService PS;


    //GET
    public List<Pedido> getPedidos(){
        return PR.findAll();
    }

    //GETById
    public Optional<Pedido> getPedidoById(Long id){
        return PR.findById(id);
    }

    //POST
    public Pedido postPedido(Pedido newPedido) {
        // Validar que todos los campos de Pedido son válidos
            if (newPedido.getCliente().getId() != null
                && newPedido.getFechaEntrada() != null
                && newPedido.getFechaSalidaEstimada() != null
                && newPedido.getFechaEntregaEfectiva() != null
                && newPedido.getEstado() != null
                && newPedido.getPresupuesto() != null
                && newPedido.getMarcaAuto() != null
                && newPedido.getModeloAuto() != null
                && newPedido.getNumeroSerie() != null
                && newPedido.getDescripcion() != null) {

                // Verificar que el cliente existe
                Optional<Cliente> clienteExistente = CR.findById(newPedido.getCliente().getId());
                if (clienteExistente.isPresent()) {

                    // Asociar cliente existente
                    newPedido.setCliente(clienteExistente.get());



                    //Asociar y persistir presupuesto antes del pedido
                    Presupuesto presupuesto = PS.postPresupuesto(newPedido.getPresupuesto());


                    if (presupuesto != null) {

                        newPedido.setPresupuesto(presupuesto); //asocio al pedido

                        PR.save(newPedido);

                        return newPedido;
                    }
                }
            }
        // Si falla alguna validación, retorna null o lanza una excepción
        return null;
    }

    //PUT
    public Pedido putPedido(Long id, Pedido newPedido){

        if(newPedido.getCliente() != null
                && newPedido.getFechaEntrada() != null
                && newPedido.getFechaSalidaEstimada() != null
                && newPedido.getFechaEntregaEfectiva() != null
                && newPedido.getEstado() != null
                && newPedido.getPresupuesto() != null
                && newPedido.getMarcaAuto() != null
                && newPedido.getModeloAuto() != null
                && newPedido.getNumeroSerie() != null
                && newPedido.getDescripcion() != null){

            Optional<Pedido> search = PR.findById(id);
            if(search.isPresent()){
                Pedido aux = search.get();
                aux.setCliente(newPedido.getCliente());
                aux.setFechaEntrada(newPedido.getFechaEntrada());
                aux.setFechaSalidaEstimada(newPedido.getFechaSalidaEstimada());
                aux.setFechaEntregaEfectiva(newPedido.getFechaEntregaEfectiva());
                aux.setEstado(newPedido.getEstado());
                aux.setPresupuesto(newPedido.getPresupuesto());
                aux.setMarcaAuto(newPedido.getMarcaAuto());
                aux.setModeloAuto(newPedido.getModeloAuto());
                aux.setNumeroSerie(newPedido.getNumeroSerie());
                aux.setDescripcion(newPedido.getDescripcion());

                PR.save(aux);
                return aux;
            }
        }
        return null;
    }

    //PATCH
    public Pedido patchPedido(Long id, Pedido newPedido){

            Optional<Pedido> search = PR.findById(id);
            if(search.isPresent()){
                Pedido aux = search.get();

                if(newPedido.getCliente() != null){aux.setCliente(newPedido.getCliente());};
                if(newPedido.getFechaEntrada() != null){aux.setFechaEntrada(newPedido.getFechaEntrada());}
                if(newPedido.getFechaSalidaEstimada() != null){aux.setFechaSalidaEstimada(newPedido.getFechaSalidaEstimada());}
                if(newPedido.getFechaEntregaEfectiva() != null){aux.setFechaEntregaEfectiva(newPedido.getFechaEntregaEfectiva());}
                if(newPedido.getEstado() != null){aux.setEstado(newPedido.getEstado());}
                if(newPedido.getPresupuesto() != null){aux.setPresupuesto(newPedido.getPresupuesto());}
                if(newPedido.getMarcaAuto() != null){aux.setMarcaAuto(newPedido.getMarcaAuto());}
                if(newPedido.getModeloAuto() != null){aux.setModeloAuto(newPedido.getModeloAuto());}
                if(newPedido.getNumeroSerie() != null){aux.setNumeroSerie(newPedido.getNumeroSerie());}
                if(newPedido.getDescripcion() != null){aux.setDescripcion(newPedido.getDescripcion());}

                PR.save(aux);
                return aux;
            }
        return null;
    }

    /**
     * DELETE : Borra el Pedido con el ID especificado
     * @param id : Parametro por el que se busca el Pedido que se quiere eliminar
     * @return : Retorna el Pedido eliminado, o null en caso de no haberlo encontrado
     */
    public Pedido deletePedido(Long id){
        Optional<Pedido> search = PR.findById(id);
        if(search.isPresent()){
            PR.deleteById(id);
            return search.get();
        }
    return null;
    }

}
