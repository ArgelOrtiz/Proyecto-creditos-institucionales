
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author argel
 * 
 */
public class Conexion {

    public static Connection conexion;

    public Conexion() {
        conexion = null;
               
    }

    public static boolean conectarBD() {
        //conectar con la base de datos
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Credito", "Argel", "");

                   
        } catch (ClassNotFoundException | SQLException ae) {
            System.err.println(ae);
            return false;
            
        }
         return true;

    }

    public static boolean ejecutarSQLUpdate(String sql) {
        //ejecutar de app a sql
        try {

            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            return true;

        } catch (SQLException ex) {

            System.out.println("Error en instruccion:  " + ex);
            return false;
        }

    }

    public static ResultSet ejecutarSQLSelect(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            return sentencia.executeQuery(sql);

        } catch (SQLException ex) {

            System.out.println("Error al ejecutar instruccion: " + ex);
            return null;
        }

    }

    public static void cerrarConexion() {

        try {
            conexion.close();
        } catch (SQLException ex) {

            System.out.println("Error al cerrar conexion");
        }
    }

}
