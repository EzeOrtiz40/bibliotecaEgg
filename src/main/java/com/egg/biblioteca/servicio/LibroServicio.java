package com.egg.biblioteca.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;



@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        validar(isbn, titulo, ejemplares,idAutor, idEditorial);
        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);

    }

    public List<Libro> listarLibros(){
        List <Libro> libros = new ArrayList<>();

        libros = libroRepositorio.findAll();
        return libros;
    }

    
    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException{
        validar(isbn, titulo, ejemplares,idAutor, idEditorial);
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        Editorial editorial = new Editorial();
        Autor autor = new Autor();

        if(respuestaAutor.isPresent()){
            autor = respuestaAutor.get();
        }

        if(respuestaEditorial.isPresent()){
            editorial = respuestaEditorial.get();
        }

        if(respuesta.isPresent()){
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);

            libroRepositorio.save(libro);
        }
        
    }

    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        
        if(isbn == null){
           throw new MiException("El isbn no puede ser nulo");
        }

        if(titulo.trim().isEmpty() || titulo == null){
            throw new MiException("El titulo no puede estar vacio ni nulo");
        }

        if(ejemplares == null){
            throw new  MiException("Ejemplares no pueden ser nulos");
        }

        if(idAutor.trim().isEmpty() || idAutor == null){
            throw new MiException("el idAutor no puede ser nulo");
        }

        if(idEditorial.trim().isEmpty() || idEditorial == null){
            throw new MiException("el idEditorial no puede ser nulo");
        }
    }


}