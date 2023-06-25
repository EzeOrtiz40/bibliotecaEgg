package com.egg.biblioteca.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.egg.biblioteca.entidades.Autor;
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
    public String registro(@RequestParam String nombre, ModelMap modelo, RedirectAttributes redirectAttributes){
        try{
            autorServicio.crearAutor(nombre);
            modelo.put("exito", "Se cargo correctamente");
            redirectAttributes.addFlashAttribute("exito", "Subido correctamente");
            return "redirect:/";
        }catch(MiException ex){

            modelo.put("error", ex.getMessage());
            
            return "Autor-Form";
        
        }
       
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        List<Autor> autores = autorServicio.listarAutor();
        modelo.addAttribute("autores", autores);
        return "autor_lista";
    }

    

}