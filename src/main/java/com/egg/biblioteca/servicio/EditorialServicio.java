package com.egg.biblioteca.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {
    
    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException{
        validar(nombre);
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditorial(){
        List<Editorial> editoriales = new ArrayList<>();

        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }

    public void moficarEditorial(String idEditorial, String nombre) throws MiException{
        validar(idEditorial, nombre);
        Optional<Editorial> respuesta = editorialRepositorio.findById(idEditorial);

        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();

            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);

        }

    }

    private void validar(String nombre) throws MiException{
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede estar vacio ni debe ser null");
        }
    }

    private void validar(String idEditorial, String nombre) throws MiException{
        if(idEditorial.isEmpty() || idEditorial == null){
            throw new MiException("El idEditorial no puede ser nulo ni estr vacio");
        }
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede estar vacio ni ser nulo");
        }
    }

}