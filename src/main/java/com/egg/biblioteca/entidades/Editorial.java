package com.egg.biblioteca.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idEditorial;
    private String nombre;

    public Editorial(){

    }

    

    /**
     * @return String return the id
     */
    public String getIdEditorial() {
        return idEditorial;
    }

    /**
     * @param id the id to set
     */
    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
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
        return "Editorial [id=" + idEditorial + ", nombre=" + nombre + "]";
    }

    

}