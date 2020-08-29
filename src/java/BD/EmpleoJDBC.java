/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Empleo;

/**
 *
 * @author fredy Gamer
 */
public class EmpleoJDBC {

    private static EmpleoJDBC emeploJDBC = null;

    private EmpleoJDBC() {
    }

    public static EmpleoJDBC instancia() {
        if (emeploJDBC == null) {
            emeploJDBC = new EmpleoJDBC();
        }
        return emeploJDBC;
    }

    private final String SQL_CONSULTA_ID = "SELECT Id,Nombre,Descripcion,Fecha,Salario,Destacado,Estatus,Detalle,IDCategoria FROM EMPLEO WHERE Id=?";

    public Empleo consultarEmpleo(int id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Empleo empleo = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_CONSULTA_ID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                empleo = new Empleo();
                empleo.setId(rs.getInt(1));
                empleo.setNombre(rs.getString(2));
                empleo.setDescripcion(rs.getString(3));
                empleo.setFecha(rs.getDate(4));
                empleo.setSalario(rs.getDouble(5));
                empleo.setDestacado(rs.getInt(6));
                empleo.setEstatus(rs.getString(7));
                empleo.setDetalle(rs.getString(8));
                empleo.setCategoria(CategoriasJDBC.instancia().consultarCategoria(rs.getInt(9)));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return empleo;
    }

    private final String SQL_CONSULTA = "SELECT Id,Nombre,Descripcion,Fecha,Salario,Destacado,Estatus,Detalle,IDCategoria FROM EMPLEO";

    public List<Empleo> consultarEmpleoTodos() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Empleo> lstEmpleos = new ArrayList<Empleo>();
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_CONSULTA);
            rs = stm.executeQuery();
            while (rs.next()) {
                Empleo empleo = new Empleo();
                empleo.setId(rs.getInt(1));
                empleo.setNombre(rs.getString(2));
                empleo.setDescripcion(rs.getString(3));
                empleo.setFecha(rs.getDate(4));
                empleo.setSalario(rs.getDouble(5));
                empleo.setDestacado(rs.getInt(6));
                empleo.setEstatus(rs.getString(7));
                empleo.setDetalle(rs.getString(8));
                empleo.setCategoria(CategoriasJDBC.instancia().consultarCategoria(rs.getInt(9)));
                lstEmpleos.add(empleo);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return lstEmpleos;
    }

    private final String SQL_INSERT = "INSERT INTO EMPLEO(Id,Nombre,Descripcion,Fecha,Salario,Destacado,Estatus,Detalle,IDCategoria) VALUES(?,?,?,?,?,?,?,?,?)";

    public String insertar(Empleo empleo) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int row = 0;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stm.setInt(index++, empleo.getId());
            stm.setString(index++, empleo.getNombre());
            stm.setString(index++, empleo.getDescripcion());
            java.sql.Date fechaSQL = new Date(empleo.getFecha().getTime());
            stm.setDate(index++, fechaSQL);
            stm.setDouble(index++, empleo.getSalario());
            stm.setInt(index++, empleo.getDestacado());
            stm.setString(index++, empleo.getEstatus());
            stm.setString(index++, empleo.getDetalle());
            stm.setInt(index++, empleo.getCategoria().getId());
            row = stm.executeUpdate();
            return "Se inserto " + row + " registros|0| satisfactoriamente";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
    }

    private final String SQL_UPDATE = "UPDATE EMPLEO SET Nombre=?,Descripcion=?,Fecha=?,Salario=?,Destacado=?,Estatus=?,Detalle=?,IDCategoria=? WHERE Id=?";

    public String actualizar(Empleo empleo) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stm.setString(index++, empleo.getNombre());
            stm.setString(index++, empleo.getDescripcion());
            java.sql.Date fechaSQL = new Date(empleo.getFecha().getTime());
            stm.setDate(index++, fechaSQL);
            stm.setDouble(index++, empleo.getSalario());
            stm.setInt(index++, empleo.getDestacado());
            stm.setString(index++, empleo.getEstatus());
            stm.setString(index++, empleo.getDetalle());
            stm.setInt(index++, empleo.getCategoria().getId());
            stm.setInt(index++, empleo.getId());
            stm.executeUpdate();
            return "Se actualizo el registro satisfactoriamente";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
    }
    
    
    
    
    private final String SQL_DELETE = "DELETE FROM EMPLEO WHERE Id = ?";

    public String eliminar(int Id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_DELETE);
            int index = 1;
            stm.setInt(index++, Id);
            stm.executeUpdate();
            return "Se elimino el registro satisfactoriamente";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
    }
    

}
