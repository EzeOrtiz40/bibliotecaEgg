package com.egg.biblioteca.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Libro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    @Temporal(TemporalType.DATE)
    private Date alta;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editorial editorial;
    public Libro(){
    }

    

    /**
     * @return Long return the isbn
     */
    public Long getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    /**
     * @return String return the nombre
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setTitulo(String nombre) {
        this.titulo = nombre;
    }

    /**
     * @return Integer return the ejemplares
     */
    public Integer getEjemplares() {
        return ejemplares;
    }

    /**
     * @param ejemplares the ejemplares to set
     */
    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    /**
     * @return Date return the alta
     */
    public Date getAlta() {
        return alta;
    }

    /**
     * @param alta the alta to set
     */
    public void setAlta(Date alta) {
        this.alta = alta;
    }



    public Autor getAutor() {
        return autor;
    }


    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }



    public Editorial getEditorial() {
        return editorial;
    }


    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }



    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", nombre=" + titulo + ", ejemplares=" + ejemplares + ", alta=" + alta
                + ", autor=" + autor + ", editorial=" + editorial + "]";
    }

}


