package GestionRectificadoraMalvinas.Service;

import GestionRectificadoraMalvinas.Model.Item;
import GestionRectificadoraMalvinas.Model.Presupuesto;
import GestionRectificadoraMalvinas.Repository.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//FALTA TERMINAR

@Service
public class PresupuestoService {

    @Autowired
    PresupuestoRepository PR;


    /**
     * GET: Retorna todos los Presupuestos almacenados
     * @return : Retorna una lista con o sin Presupuestos almacenados.
     */
    public List<Presupuesto> getPresupuestos(){
        return PR.findAll();
    }

    /**
     * GETByID: Busca un Presupuesto por ID
     * @param id : Parametro por el que se busca el Presupuesto
     * @return : Retorna un Optional con el Presupuesto encontrado, o vacio en caso de no ecnontrarlo
     */
    public Optional<Presupuesto> getPresupuestoById(Long id){
        return PR.findById(id);
    }

    /**
     * POST: Guarda y almacena un nuevo Presupuesto en caso de que todos sus campos esten completos
     * @param newPresupuesto : Presupuesto el cual se valida y almacena en caso de exito
     * @return : Retorna el nuevo Presupuesto o null en caso de estar incompleto
     */
    public Presupuesto postPresupuesto(Presupuesto newPresupuesto){

           && newPresupuesto.getTotal() != null){

            return PR.save(newPresupuesto);
        }
    return null;
    }

    /**
     * PUT: Actualiza de manera completa un Presupuesto validado para que no falte ningun campo
     * @param id : Parametro por el que se busca el Presupuesto que se quiere actualizar
     * @param newPresupuesto : Presupuesto el cual va a reemplazar al buscado
     * @return : retorna el nuevo Presupuesto en caso de exito, o null en caso de invalidez.
     */
    public Presupuesto putPresupuesto(Long id, Presupuesto newPresupuesto){

        if(newPresupuesto.getFecha() != null
            && newPresupuesto.getDescuento() != null
            && newPresupuesto.getItems() != null
            && newPresupuesto.getTotal() != null){

            Optional<Presupuesto> search = PR.findById(id);
            if(search.isPresent()){
                Presupuesto aux = search.get();

            //update
            aux.setDescuento(newPresupuesto.getDescuento());
            aux.setFecha(newPresupuesto.getFecha());
            aux.setItems(newPresupuesto.getItems());
            aux.setTotal(newPresupuesto.getTotal());

            //save
            PR.save(aux);
            return aux;
        }
    }
   return null;
}

    /**
     * PATCH: Actualiza de manera parcial, campo por campo, sin necesitar un Presupuesto entero
     * @param id : Parametro por el que se busca el Presupuesto que se quiere actualizar
     * @param newPresupuesto : Nuevo Presupuesto, puede ser un solo campo, que reemplazara al buscado
     * @return : retorna el nuevo Presupuesto o null en caso de no encontrarlo
     */
    public Presupuesto patchPresupuesto(Long id, Presupuesto newPresupuesto){

            Optional<Presupuesto> search = PR.findById(id);
            if(search.isPresent()){
                Presupuesto aux = search.get();

                //update
                if(newPresupuesto.getDescuento() != null){aux.setDescuento(newPresupuesto.getDescuento());};
                if(newPresupuesto.getFecha() != null){aux.setFecha(newPresupuesto.getFecha());};
                if(newPresupuesto.getItems() != null){aux.setItems(newPresupuesto.getItems());};
                if(newPresupuesto.getTotal() != null){aux.setTotal(newPresupuesto.getTotal());};

                //save
                PR.save(aux);
                return aux;
            }

        return null;
    }


    /**
     * DELETE: Borra el Presupuesto con el ID especificado
     * @param id : Parametro por el que se busca el Presupuesto que se quiere eliminar
     * @return : Retorna el Presupuesto eliminado, o null en caso de no haberlo encontrado
     */
    public Presupuesto deletePresupuesto(Long id){
        Optional<Presupuesto> search = PR.findById(id);
        if(search.isPresent()){
            PR.deleteById(id);
            return search.get();
        }
    return null;
    }

}
