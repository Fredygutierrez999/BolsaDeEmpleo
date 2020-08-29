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

/**
 *
 * @author fredy Gamer
 */
public class Conexion {

    public static Connection getConection() {
        Connection con = null;

        String password = "SISTEMAS.2018";
        String usuario = "administrador";
        String url = "jdbc:derby://localhost:1527/BDBolsaEmpleo";
        try {
            con = DriverManager.getConnection(url,usuario,password);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return con;
    }

    public static void closed(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }
    
    
    public static void closed(PreparedStatement con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }
    
    
    public static void closed(ResultSet con) {
       /* try {
            con.close();
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }*/
    }

}
