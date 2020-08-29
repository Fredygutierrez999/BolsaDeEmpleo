/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author fredy Gamer
 */
public class CategoriasJDBC {

    private static CategoriasJDBC categoriaJDBC = null;

    private CategoriasJDBC() {
    }

    public static CategoriasJDBC instancia() {
        if (categoriaJDBC == null) {
            categoriaJDBC = new CategoriasJDBC();
        }
        return categoriaJDBC;
    }

    private final String SQL_SELECT_INS = "INSERT INTO Categorias(ID,Nombre,descripcion) VALUES(?,?,?)";

    public boolean insertar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_SELECT_INS);
            stm.setInt(1, categoria.getId());
            stm.setString(2, categoria.getNombre());
            stm.setString(3, categoria.getDescripcion());
            stm.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return false;
    }

    private final String SQL_SELECT_UPDATE = "UPDATE Categorias SET Nombre = ?,descripcion = ? WHERE ID = ?";

    public boolean actualizar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_SELECT_UPDATE);
            stm.setString(1, categoria.getNombre());
            stm.setString(2, categoria.getDescripcion());
            stm.setInt(3, categoria.getId());
            stm.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return false;
    }

    private final String SQL_DELETE = "DELETE Categorias WHERE ID = ?";
    public boolean eliminar(int ID) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_DELETE);
            stm.setInt(1, ID);
            stm.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return false;
    }

    private final String SQL_SELECT_CAT = "SELECT ID, Nombre, descripcion FROM Categorias WHERE Id = ?";
    public Categoria consultarCategoria(int id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Categoria categoria = null;
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_SELECT_CAT);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return categoria;
    }

    private final String SQL_SELECT_ALL = "SELECT ID, Nombre, descripcion FROM Categorias";

    public List<Categoria> consultarCategoriaTodas() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            conn = Conexion.getConection();
            stm = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return categorias;
    }

}
