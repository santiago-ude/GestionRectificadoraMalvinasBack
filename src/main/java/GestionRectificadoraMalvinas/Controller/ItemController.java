//@RequestMapping("/items")
//@CrossOrigin(origins = "http://localhost:4200") // Cambia a la URL de tu frontend
//public class ItemController {
//
//    //Inyeccion de dependencias servicio para los item
//    @Autowired
//    ItemService IS;
//
//    //GET
//    @GetMapping
//    public ResponseEntity<?> getItem(){
//        return ResponseEntity.ok(IS.getItems());
//    }
//
//    //GETById
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getItemById(@PathVariable Long id){
//        Optional<Item> search = IS.getItemById(id);
//        if(search.isPresent()){
//            return ResponseEntity.ok(search.get());
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
//    }
//
//    //POST
//    @PostMapping
//    public ResponseEntity<?> postItem(@RequestBody Item newItem){
//
//        Item aux = IS.postItem(newItem);
//        if(aux != null){
//
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(newItem.getId())
//                    .toUri();
//
//            return ResponseEntity.created(location).build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item incompleto");
//    }
//
//    //PUT
//    @PutMapping("/{id}")
//    public ResponseEntity<?> putItem(@PathVariable Long id, @RequestBody Item newItem){
//
//        Item aux = IS.putItem(id,newItem);
//        if(aux != null){
//
//         return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado o incompleto");
//    }
//
//    //PATCH
//    @PatchMapping("/{id}")
//    public ResponseEntity<?> patchItem(@PathVariable Long id, @RequestBody Item newItem){
//
//        Item aux = IS.patchItem(id,newItem);
//        if(aux != null){
//
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
//    }
//
//    //DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteItem(@PathVariable Long id){
//
//        Item aux = IS.deleteItem(id);
//        if(aux != null){
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
//    }
//
//}
