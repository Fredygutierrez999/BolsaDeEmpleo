/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.internet.MailDateFormat;

/**
 *
 * @author fredy Gamer
 */
public class Empleo {

    private int Id;
    private String Nombre;
    private String Descripcion;
    private Date Fecha;
    private Double Salario;
    private int Destacado;
    private String Estatus;
    private String Detalle;
    private Categoria Categoria;

    public Empleo() {
    }

    public Empleo(int Id, String Nombre, String Descripcion, Date Fecha, Double Salario, int Destacado, String Estatus, String Detalle, Categoria Categoria) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
        this.Salario = Salario;
        this.Destacado = Destacado;
        this.Estatus = Estatus;
        this.Detalle = Detalle;
        this.Categoria = Categoria;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public int getDestacado() {
        return Destacado;
    }

    public void setDestacado(int Destacado) {
        this.Destacado = Destacado;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }
    
    public String getFechaString(){
        SimpleDateFormat objFormat = new SimpleDateFormat("yyyy-MM-dd");
        return objFormat.format(Fecha);
    }
    
}
