package GestionRectificadoraMalvinas.Service;

import GestionRectificadoraMalvinas.Model.Item;
import GestionRectificadoraMalvinas.Model.Presupuesto;
import GestionRectificadoraMalvinas.Repository.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresupuestoService {

    @Autowired
    PresupuestoRepository PR;


    //GET
    public List<Presupuesto> getPresupuestos(){
        return PR.findAll();
    }

    //GETByID
    public Optional<Presupuesto> getPresupuestoById(Long id){
        return PR.findById(id);
    }

    //POST
    public Presupuesto postPresupuesto(Presupuesto newPresupuesto){

        if(newPresupuesto.getFecha() != null
           && newPresupuesto.getDescuento() != null
           && newPresupuesto.getItems() != null
           && newPresupuesto.getTotal() != null){
            PR.save(newPresupuesto);
            return newPresupuesto;
        }
    return null;
    }

    //PUT
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

    //PATCH
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


    //DELETE
    public Presupuesto deletePresupuesto(Long id){
        Optional<Presupuesto> search = PR.findById(id);
        if(search.isPresent()){
            PR.deleteById(id);
            return search.get();
        }
    return null;
    }

}
