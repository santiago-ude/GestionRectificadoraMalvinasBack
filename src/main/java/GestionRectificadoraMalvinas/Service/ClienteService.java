package GestionRectificadoraMalvinas.Service;

import GestionRectificadoraMalvinas.Model.Cliente;
import GestionRectificadoraMalvinas.Repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository CR;


    /**
     * GET: Retorna todos los clientes almacenados
     * @return : Retorna una lista con o sin clientes almacenados.
     */
    public List<Cliente> getClientes(){
        return CR.findAll();
    }


    /**
     * GETByID: Busca un cliente por ID
     * @param id : Parametro por el que se busca el cliente
     * @return : Retorna un Optional con el Cliente encontrado, o vacio en caso de no ecnontrarlo
     */
    public Optional<Cliente> getClienteById(Long id){
        return CR.findById(id);
    }

    /**
     * POST: Guarda y almacena un nuevo cliente en caso de que todos sus campos esten completos
     * @param newCliente : Cliente el cual se valida y almacena en caso de exito
     * @return : Retorna el nuevo cliente o null en caso de estar incompleto
     */
    public Cliente postCliente(Cliente newCliente){

            CR.save(newCliente);
            return newCliente;
    }

    /**
     * PUT: Actualiza de manera completa un Cliente validado para que no falte ningun campo
     * @param id : Parametro por el que se busca el cliente que se quiere actualizar
     * @param newCliente : Cliente el cual va a reemplazar al buscado
     * @return : retorna el nuevo cliente en caso de exito, o null en caso de invalidez.
     */
    public Cliente putCliente(Long id, Cliente newCliente){

            Optional<Cliente> search = CR.findById(id);
            if (search.isPresent()) {
                Cliente aux = search.get();

                //Actualizacion
                aux.setDni(newCliente.getDni());
                aux.setApellido(newCliente.getApellido());
                aux.setDomicilio(newCliente.getDomicilio());
                aux.setNombre(newCliente.getNombre());
                aux.setMetodoPago(newCliente.getMetodoPago());
                aux.setAltura(newCliente.getAltura());
                aux.setNumero(newCliente.getNumero());

                //guardado
                CR.save(aux);
                return aux;
            }
        return null;
    }

    /**
     * PATCH: Actualiza de manera parcial, campo por campo, sin necesitar un cliente entero
     * @param id : Parametro por el que se busca el cliente que se quiere actualizar
     * @param newCliente : Nuevo cliente, puede ser un solo campo, que reemplazara al buscado
     * @return : retorna el nuevo cliente o null en caso de no encontrarlo
     */
    public Cliente patchCliente(Long id, Cliente newCliente){

            Optional<Cliente> search = CR.findById(id);
            if (search.isPresent()) {

                Cliente aux = search.get();

                //Actualizacion
               if(newCliente.getDni() != null){aux.setDni(newCliente.getDni());};
               if(newCliente.getApellido() != null){aux.setApellido(newCliente.getApellido());};
               if(newCliente.getDomicilio() != null){aux.setDomicilio(newCliente.getDomicilio());};
               if(newCliente.getNombre() != null){aux.setNombre(newCliente.getNombre());};
               if(newCliente.getMetodoPago() != null){aux.setMetodoPago(newCliente.getMetodoPago());};
               if(newCliente.getAltura() != null){aux.setAltura(newCliente.getAltura());};
               if(newCliente.getNumero() != null){aux.setNumero(newCliente.getNumero());};

                //guardado
                CR.save(aux);
                return aux;
            }
        return null;
    }

    /**
     * DELETE: Borra el cliente con el ID especificado
     * @param id : Parametro por el que se busca el cliente que se quiere eliminar
     * @return : Retorna el cliente eliminado, o null en caso de no haberlo encontrado
     */
    public Cliente deleteCliente(Long id){
        Optional<Cliente> search = CR.findById(id);
        if(search.isPresent()){
            CR.deleteById(id);
            return search.get();
        }
        return null;
    }



}
