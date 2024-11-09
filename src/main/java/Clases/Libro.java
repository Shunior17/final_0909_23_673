/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Junior
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String anio;
    private String autor;
    private String clasificacion;
    private String paginas;
    private int pasta;
    
    public Libro(String isbn,String titulo,String anio,String autor,String clasificacion,String paginas,int pasta){
        this.isbn=isbn;
        this.titulo=titulo;
        this.anio=anio;
        this.autor=autor;
        this.clasificacion=clasificacion;
        this.paginas=paginas;
        this.pasta=pasta;
    }
    
    public Libro (){
        
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public int getPasta() {
        return pasta;
    }

    public void setPasta(int pasta) {
        this.pasta = pasta;
    }
    
    
}
