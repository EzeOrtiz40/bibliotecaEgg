package com.egg.biblioteca.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
    @Autowired
    AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiException{
        validar(nombre);
        Autor autor = new Autor();

        autor.setNombre(nombre);
        autorRepositorio.save(autor);
        
    }

    public List<Autor> listarAutor(){
        List<Autor> autores = new ArrayList<>();

        autores = autorRepositorio.findAll();
        return autores;
    }

    public void modificarAutor(String idAutor, String nombre) throws MiException{
        validar(nombre,idAutor);
        Optional<Autor> respuesta = autorRepositorio.findById(idAutor);

        if(respuesta.isPresent()){
            Autor autor = respuesta.get();

            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }

    private void validar(String nombre) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombrer no puede estar vacio ni ser nulo");
        }
    }
    
    private void validar(String nombre, String idAutor) throws MiException{
        
        if(idAutor.isEmpty() || idAutor == null){
            throw new MiException("El idAutor no puede estar vacio ni ser nulo");
        }

        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede quedar vacio o ser nulo");
        }

    }
}

