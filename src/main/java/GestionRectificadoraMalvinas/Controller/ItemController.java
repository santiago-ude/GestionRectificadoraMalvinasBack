package GestionRectificadoraMalvinas.Controller;


import GestionRectificadoraMalvinas.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    //Inyeccion de dependencias servicio para los item
    @Autowired
    ItemService IS;




}
