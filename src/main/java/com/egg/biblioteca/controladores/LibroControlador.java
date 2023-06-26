package com.egg.biblioteca.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
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
    public String registrar(ModelMap modelo){

        List<Autor> autores = autorServicio.listarAutor();
        List<Editorial> editoriales = editorialServicio.listarEditorial();
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);

        return "libro_form";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo, @RequestParam(required = false) Integer ejemplares,
                           @RequestParam String idAutor, @RequestParam String idEditorial, ModelMap modelo){
                    try {
                        
                        libroServicio.crearLibro(isbn, titulo, ejemplares,idAutor, idEditorial);
                        modelo.put("exito", "El libro fue cargado correctamente");
                        System.out.println("Entro al try");
                        return "index"; 
                    } catch (Exception e) {
                        List<Autor> autores = autorServicio.listarAutor();
                        List<Editorial> editoriales = editorialServicio.listarEditorial();
                        modelo.addAttribute("autores", autores);
                        modelo.addAttribute("editoriales", editoriales);
                        modelo.put("error", e.getMessage());
                        
                        return "libro_form";
                    } 
            
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        List <Libro> libros = libroServicio.listarLibros();
        modelo.addAttribute("libros", libros);

        return "libro_lista";
    }


}
