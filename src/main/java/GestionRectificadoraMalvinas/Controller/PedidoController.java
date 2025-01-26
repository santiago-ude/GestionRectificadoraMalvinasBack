package GestionRectificadoraMalvinas.Controller;

import GestionRectificadoraMalvinas.Model.Pedido;
import GestionRectificadoraMalvinas.Service.PedidoService;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    //Inyeccion dependencia del servicio de pedidos
    @Autowired
    PedidoService PS;


    //GET
    @GetMapping
    public ResponseEntity<?> getPedidos(){
        return ResponseEntity.ok(PS.getPedidos());
    }

    //GETById
    @GetMapping("/{id}")
    public ResponseEntity<?> getPedidoById(@PathVariable Long id){
        Optional<Pedido> search = PS.getPedidoById(id);
        if(search.isPresent()){
            return ResponseEntity.ok(search.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
    }

    //POST
    @PostMapping
    public ResponseEntity<?> postPedido(@RequestBody Pedido newPedido){

        Pedido aux = PS.postPedido(newPedido);


        if(aux != null){

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newPedido.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido incompleto");
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> putPedido(@PathVariable Long id, @RequestBody Pedido newPedido){
    Pedido aux = PS.putPedido(id,newPedido);
    if(aux != null){
        return ResponseEntity.noContent().build();
    }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado o incompleto");
    }

    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPedido(@PathVariable Long id, @RequestBody Pedido newPedido){
        Pedido aux = PS.patchPedido(id,newPedido);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id){
        Pedido aux = PS.deletePedido(id);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
    }


}
