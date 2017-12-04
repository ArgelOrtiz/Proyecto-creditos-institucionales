
package process;



import Entidades.Alumno;
import Interface.PantallaMensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author argel
 */
public class Procesamiento {
    
    private final String USUARIO;
    private final String CONTRASEÑA;
    private final PantallaMensajes pm;
    private Conexion c;
    private Alumno a;
    
    public Procesamiento(){
        
        c = new Conexion();
        pm = new PantallaMensajes();
        USUARIO = "Administrador";
        CONTRASEÑA = "7624000";
        a = new Alumno();
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
    public Alumno ConsultarAlumno(int num){
        
        if (c.conectarBD()) {
            
            ResultSet res = c.ejecutarSQLSelect("select Semestre, Nombre, count(Id_cre) \n" +
                                                "from Alumno a join Creditos c\n" +
                                                "where a.No_Control = c.No_Control_FK and a.No_Control ="+num);
            
           try{ 
               if (res.next()) {
                   
                 a.setNombre(res.getString(2));
                 a.setSemestre(res.getInt(1));
                 a.setCreditos(res.getInt(3));
                   
               }
            
            
           }catch(Exception e){
               
           }
            
           
        }
        
        return a;
    }
    
    public boolean verificarUsuario(String usuario){
        
        return usuario.equals(USUARIO);
        
        
        }
    
    public boolean verificarContraseña(String contraseña){
        
        return contraseña.equals(CONTRASEÑA);
    }
    
    public void registrarAlumno(int control, String nombre, int semestre ){
        
                if(c.conectarBD()){
                
            try{
                if (!c.conexion.isClosed()) {
                   
                    PreparedStatement ps = Conexion.conexion.prepareStatement("insert into Alumno values (?,?,?);");
                    
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
