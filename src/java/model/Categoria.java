/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fredy Gamer
 */
public class Categoria {

    private int Id;
    private String Nombre;
    private String Descripcion;

    public Categoria() {
    }

    
    
    public Categoria(int Id, String Nombre, String Descripcion) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}
