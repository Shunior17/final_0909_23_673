/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroController {
    Libro[] tablaLibro;
    int indiceArray;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }       
    
    public String guardarLibro(Libro libro){        
        String sql = "INSERT INTO alumno(isbn, titulo_libro, , anio_publicacion, autor, clasificacion, cantidad_paginas, tipo_pasta_id_tipo_pasta) ";
             sql += " VALUES(?,?,?,?,?,?,?)";              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setString(1, libro.getIsbn());
            statement.setString(2, libro.getTitulo());
            statement.setString(3, libro.getAnio());
            statement.setString(4, libro.getAutor());
            statement.setString(5, libro.getClasificacion());
            statement.setString(6, libro.getPaginas());
            statement.setInt(7, libro.getPasta());
                int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    public void getLibros(StringBuffer respuesta){   
        String sql="SELECT libro.isbn, libro.titulo_libro, libro.anio_publicacion, libro.autor, libro.clasificacion, libro.cantidad_paginas, libro.tipo_pasta_id_tipo_pasta FROM libro, tipo_pasta WHERE libro.tipo_pasta.id_tipo_pasta=tipo_pasta.id_tipo_pasta ORDER BY isbn asc";
        try{
        abrirConexion();
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if(result!=null){
                while (result.next()){
                respuesta.append("<tr>");//crear la fila y la etique td son las columnas
                respuesta.append("<td >").append(result.getString("isbn")).append("</td>");
                respuesta.append("<td >").append(result.getString("titulo_libro")).append("</td>");
                respuesta.append("<td >").append(result.getString("anio_publicacion")).append("</td>");
                respuesta.append("<td >").append(result.getString("autor")).append("</td>");
                respuesta.append("<td >").append(result.getString("clasificacion")).append("</td>");
                respuesta.append("<td >").append(result.getString("cantidad_paginas")).append("</td>");
                respuesta.append("<td >").append(result.getString("tipo_pasta_id-tipo_pasta")).append("</td>");
                
                }
            }else{
                respuesta.append("error al consultar");
            }           
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
    // *** FUNCIONALIDAD PARA TRABAJAR CON ARRAYS ***
    public LibroController(){// Construcctor para trabar con arrays
        this.tablaLibro = new Libro[100];
        this.indiceArray=0;
    }
    
     public void guardarLibroEnArray(Libro libro){
        this.tablaLibro[this.indiceArray]=libro;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Libro[] getLibroFromArray(){
        return this.tablaLibro;
    }
    
}
