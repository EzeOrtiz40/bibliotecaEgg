package com.egg.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Autor {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String idAutor;
    private String nombre;

    public Autor(){
    }



    /**
     * @return String return the id
     */
    public String getIdAutor() {
        return idAutor;
    }

    /**
     * @param id the id to set
     */
    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "Autor [id=" + idAutor + ", nombre=" + nombre + "]";
    }

    

}