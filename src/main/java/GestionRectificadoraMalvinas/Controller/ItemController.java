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
