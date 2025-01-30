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
