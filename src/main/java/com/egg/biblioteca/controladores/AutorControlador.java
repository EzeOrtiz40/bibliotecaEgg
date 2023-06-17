package com.egg.biblioteca.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicio.AutorServicio;



@Controller
@RequestMapping("/autor")
public class AutorControlador {
    
   @Autowired
   private AutorServicio autorServicio;
   
    @GetMapping("/registrar")
    public String registrar(){
        return "autor-Form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){
        try{
            autorServicio.crearAutor(nombre);
            modelo.put("exito", "Subido correctamente");

        }catch(MiException ex){

            modelo.put("error", ex.getMessage());
            System.out.println("Entro al catch");  
            return "Autor-Form";
        
        }
       return "Autor-Form";
    }

    

}