package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicio.EditorialServicio;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador {
    @Autowired
    EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar(){

        return "editorial_form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){
        try {
            editorialServicio.crearEditorial(nombre);
            modelo.put("exito", "Se cargo correctamente");

        } catch (MiException e) {
            modelo.put("error", e.getMessage());
            return "editorial_form";
        }
        return "editorial_form";

    }

    
}