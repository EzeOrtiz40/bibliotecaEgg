package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.servicio.AutorServicio;
import com.egg.biblioteca.servicio.EditorialServicio;
import com.egg.biblioteca.servicio.LibroServicio;

@Controller
@RequestMapping("/libro")
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;
    @Autowired
    private AutorServicio autorServicio;
    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar(){
        return "libro_form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo, @RequestParam(required = false) Integer ejemplares,
                           @RequestParam String idAutor, @RequestParam String idEditorial, ModelMap modelo){
                    try {
                        
                        libroServicio.crearLibro(isbn, titulo, ejemplares,idAutor, idEditorial);

                        modelo.put("exito", "El libro fue cargado correctamente");
                        System.out.println("Entro al try");
                    } catch (Exception e) {
                        modelo.put("error", e.getMessage());
                        System.out.println("Entro al catch");
                        return "libro_form";
                    } 
            return "index"; 
    }
}
