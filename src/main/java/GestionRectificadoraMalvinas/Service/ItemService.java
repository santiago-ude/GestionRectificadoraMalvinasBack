//    //POST
//    public Item postItem(Item newItem){
//        if(newItem.getNombre() != null
//            && newItem.getDescripcion() != null
//            && newItem.getPrecioUnitario() != null
//            && newItem.getPrecioManoObra() != null
//            && newItem.getPrecioFinal() != null){
//
//            IR.save(newItem);
//            return newItem;
//        }
//       return null;
//    }
//
//    //PUT
//    public Item putItem(Long id, Item newItem){
//
//        if(newItem.getNombre() != null
//        && newItem.getDescripcion() != null
//        && newItem.getPrecioUnitario() != null
//        && newItem.getPrecioManoObra() != null
//        && newItem.getPrecioFinal() != null){
//
//            Optional<Item> search = IR.findById(id);
//            if(search.isPresent()){
//                Item aux = search.get();
//                aux.setNombre(newItem.getNombre());
//                aux.setDescripcion(newItem.getDescripcion());
//                aux.setPrecioUnitario(newItem.getPrecioUnitario());
//                aux.setPrecioManoObra(newItem.getPrecioManoObra());
//                aux.setPrecioFinal(newItem.getPrecioFinal());
//
//                IR.save(aux);
//                return aux;
//            }
//        }
//        return null;
//    }
//
//    //PATCH
//    public Item patchItem(Long id, Item newItem){
//
//        Optional<Item> search = IR.findById(id);
//        if(search.isPresent()){
//            Item aux = search.get();
//
//            if(newItem.getNombre() != null){aux.setNombre(newItem.getNombre());}
//            if(newItem.getDescripcion() != null){aux.setDescripcion(newItem.getDescripcion());}
//            if(newItem.getPrecioUnitario() != null){aux.setPrecioUnitario(newItem.getPrecioUnitario());}
//            if(newItem.getPrecioManoObra() != null){aux.setPrecioManoObra(newItem.getPrecioManoObra());}
//            if(newItem.getPrecioFinal() != null){aux.setPrecioFinal(newItem.getPrecioFinal());}
//
//            IR.save(aux);
//            return aux;
//        }
//        return null;
//    }
//
//    //DELETE
//    public Item deleteItem(Long id){
//
//        Optional<Item> search = IR.findById(id);
//        if(search.isPresent()){
//
//            IR.deleteById(id);
//            return search.get();
//        }
//        return null;
//    }
//
//
//}
