package com.restapi.backend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;





// REST CONTROLLER RETURNS IN JSON
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("/accounts")
    public String getTest() {
        // Envia listado de cuentas existentes
        return new String("Prueba GET");
    }
    
    @GetMapping("/accounts/{id}")
    public String getTests(@PathVariable(value="id") String id) {
        // Envia información específica de una cuenta de acuerdo
        //  al id en la URL
        return new String("Prueba GETs " + id);
    }

    @PostMapping("/accounts")
    public String postMethodName(@RequestBody String entity) {
        // Creación de nueva cuenta
        // TODO: Registro debe viajar en el /body/ en formato JSON

        return new String("Prueba POST: " + entity);
    }
    
    @PutMapping("/accounts/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        // Modificar SALDO de cuenta
        // TODO: Campos a modificar deben ir en el /body/ en JSON
        
        return new String("Prueba PUT, entity:" + entity + "; id: " + id);
    }

    @DeleteMapping("/accounts/{id}")
    public String deleteMethodName(@PathVariable String id, @RequestBody String entity) {
        // ELIMINAR = DESACTIVAR CUENTA
        //TODO: process PUT request
        
        return new String("Prueba DELETE, entity:" + entity + "; id: " + id);
    }
    

}
