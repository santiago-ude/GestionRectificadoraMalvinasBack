package GestionRectificadoraMalvinas.Controller;

import GestionRectificadoraMalvinas.Model.Cliente;
import GestionRectificadoraMalvinas.Service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200") // Cambia a la URL de tu frontend
public class ClienteController {

    //Inyeccion dependencia del servicio del cliente
    @Autowired
    ClienteService CS;

    //GET
    @GetMapping
    public ResponseEntity<?> getClientes(){
        return ResponseEntity.ok(CS.getClientes());
    }

    //GET By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id){

        Optional<Cliente> search = CS.getClienteById(id);
        if(search.isPresent()){
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.notFound().build();
    }

    //POST
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Cliente newCliente){

        Cliente aux = CS.postCliente(newCliente);
        if(aux != null){

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newCliente.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Incompleto");
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> putCliente(@PathVariable Long id, @RequestBody Cliente newCliente){

    Cliente aux = CS.putCliente(id,newCliente);
    if(aux != null){
        return ResponseEntity.ok(aux);
    }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado o incompleto");
    }

    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchCliente(@PathVariable Long id, @RequestBody Cliente newCliente){
        Cliente aux = CS.patchCliente(id,newCliente);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){

        Cliente aux = CS.deleteCliente(id);

        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
    }


}
