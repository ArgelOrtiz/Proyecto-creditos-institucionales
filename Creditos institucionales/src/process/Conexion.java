/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author argel
 */
public class Conexion {

    public static Connection conexion ;

    public Conexion() {
        conexion = null;
    }

    public boolean conectarBD(){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/credito_institucional", "root", "");

        } catch (ClassNotFoundException | SQLException ae) {
            
            System.err.println(ae);
            return false;
        }
        return true;

    }

    public  boolean ejecutarSQLUpdate(String sql) {
        try {

            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            return true;

        } catch (SQLException ex) {

            System.out.println("Error en instruccion:  " + ex);
            return false;
        }

    }

    public  ResultSet ejecutarSQLSelect(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            return sentencia.executeQuery(sql);

        } catch (SQLException ex) {

            System.out.println("Error al ejecutar instruccion: " + ex);
            return null;
        }

    }

    public  void cerrarConexion() {

        try {
            conexion.close();
        } catch (SQLException ex) {

            System.out.println("Error al cerrar conexion");
        }
    }

}
