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

    //GET By ID
    public Optional<Cliente> getClienteById(Long id){
        return CR.findById(id);
    }

    //POST
    public Cliente postCliente(Cliente newCliente){

        if(newCliente.getAltura() != null
                && newCliente.getDni() != null
                && newCliente.getApellido() != null
                && newCliente.getDomicilio() != null
                && newCliente.getNombre() != null
                && newCliente.getMetodoPago() != null
                && newCliente.getAltura() != null
                && newCliente.getNumero() != null){
            CR.save(newCliente);
            return newCliente;

        }
        return null;
    }

    //PUT
    public Cliente putCliente(Long id, Cliente newCliente){

        if(newCliente.getAltura() != null
                && newCliente.getDni() != null
                && newCliente.getApellido() != null
                && newCliente.getDomicilio() != null
                && newCliente.getNombre() != null
                && newCliente.getMetodoPago() != null
                && newCliente.getAltura() != null
                && newCliente.getNumero() != null) {

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
        }
        return null;
    }

    //PATCH
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

    //DELETE
    public Cliente deleteCliente(Long id){
        Optional<Cliente> search = CR.findById(id);
        if(search.isPresent()){
            CR.deleteById(id);
            return search.get();
        }
        return null;
    }



}
