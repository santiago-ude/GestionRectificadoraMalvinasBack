package GestionRectificadoraMalvinas.Controller;

import GestionRectificadoraMalvinas.Model.Presupuesto;
import GestionRectificadoraMalvinas.Service.PresupuestoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


//FALTA TERMINAR
@RestController
@RequestMapping("/presupuestos")
public class PresupuestoController {

    //Inyeccion de dependencia del servicio de presupuesto
    @Autowired
    PresupuestoService PS;

    //GET
    @GetMapping
    public ResponseEntity<?> getPresupuestos(){
        return ResponseEntity.ok(PS.getPresupuestos());
    }

    //GETById
    @GetMapping("/{id}")
    public ResponseEntity<?> getPresupuestoById(@PathVariable Long id){
        Optional<Presupuesto> search = PS.getPresupuestoById(id);
        if(search.isPresent()){
            return ResponseEntity.ok(search);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Presupuesto no encontrado");
    }

    //POST
    @PostMapping
    public ResponseEntity<?> postPresupuesto(@RequestBody Presupuesto newPresupuesto){
        Presupuesto aux = PS.postPresupuesto(newPresupuesto);
        if(aux != null){

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newPresupuesto.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Presupuesto incompleto");
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> putPresupuesto(@PathVariable Long id, @RequestBody Presupuesto newPresupuesto){
        Presupuesto aux = PS.putPresupuesto(id, newPresupuesto);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Presupuesto no encontrado o incompleto");
    }

    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPresupuesto(@PathVariable Long id, @RequestBody Presupuesto newPresupuesto){
        Presupuesto aux = PS.patchPresupuesto(id, newPresupuesto);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Presupuesto no encontrado");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePresupuesto(@PathVariable Long id){
        Presupuesto aux = PS.deletePresupuesto(id);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Presupuesto no encontrado");
    }


}
