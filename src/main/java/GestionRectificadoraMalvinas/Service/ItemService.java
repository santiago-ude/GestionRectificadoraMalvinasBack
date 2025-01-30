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
