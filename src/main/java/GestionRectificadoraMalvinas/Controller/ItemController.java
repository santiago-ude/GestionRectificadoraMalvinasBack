package GestionRectificadoraMalvinas.Controller;

import GestionRectificadoraMalvinas.Model.Item;
import GestionRectificadoraMalvinas.Service.ItemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService IS;


    //GET
    @GetMapping
    public ResponseEntity<?> getItems(){
        return ResponseEntity.ok(IS.getItems());
    }

    //GETByID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id){
        Optional<Item> search = IS.getItemById(id);
        if(search.isPresent()){
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
    }

    //POST
    @PostMapping
    public ResponseEntity<?> postItem(@RequestBody Item newItem){
        Item aux = IS.postItem(newItem);
        if(aux != null){
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newItem.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado o incompleto");
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> putItem(@PathVariable Long id, @RequestBody Item newItem){

        Item aux = IS.putItem(id,newItem);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado o incompleto");
    }

    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchItem(@PathVariable Long id, @RequestBody Item newItem){

        Item aux = IS.patchItem(id,newItem);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id){
        Item aux = IS.deleteItem(id);
        if(aux != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
    }



}
