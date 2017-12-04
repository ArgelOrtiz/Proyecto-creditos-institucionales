
package process;


import DataBase.Conexion;
import static DataBase.Conexion.conectarBD;
import static DataBase.Conexion.conexion;
import Interface.PantallaMensajes;
import java.sql.PreparedStatement;

/**
 *
 * @author argel
 */
public class Procesamiento {
    
    private final String USUARIO;
    private final String CONTRASEÑA;
    private final PantallaMensajes pm;
    
    
    public Procesamiento(){
        
        pm = new PantallaMensajes();
        USUARIO = "Administrador";
        CONTRASEÑA = "7624000";
    }
    
    public String consultaNombre(){
        
        return "Nombre";
    }
    public String consultaSemestre(){
        
        return "Cuarto";
    }
    public String consultaCreditos(){
        
        return "5";
    }
    public String consultarNoCredito(){
        
        return "875";
    }
    
    public boolean registrarCredito(){
        
        return true;
    }
    
    public boolean registrarConferencia(){
        
        return true;
    }
    
    public boolean registrarReunion(){
        
        return true;
    }
    public boolean verificarNoControl(int Numero){
        
        return true;
    }
    
    public boolean verificarUsuario(String usuario){
        
        return usuario.equals(USUARIO);
        
        
        }
    
    public boolean verificarContraseña(String contraseña){
        
        return contraseña.equals(CONTRASEÑA);
    }
    
    public void registrarAlumno(int control, String nombre, int semestre ){
        
                conectarBD();
            try{
                if (!conexion.isClosed()) {
                    System.out.println("1");
                    PreparedStatement ps = Conexion.conexion.prepareStatement("insert into Alumno values(?,?,?)");
                    
                    ps.setInt(1, control);
                    ps.setInt(2, semestre);
                    ps.setString(3, nombre);
                    
                    ps.executeUpdate();
                    ps.close();
                    pm.confirmacion("El Alumno");
                }
                
            }catch(Exception e){
                
                System.err.println(e);
                
            }           
        
        
        
    }
    
    public  void agregarCredito(){
        
        
        pm.confirmacion("El Credito");
    }
    
    public void agregarConferencia(){
        
        pm.confirmacion("La Conferencia");
    }
    
    public void agregarReunion(){
        
       pm.confirmacion("La Reunion");
    }
          
}
