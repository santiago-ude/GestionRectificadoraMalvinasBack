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
