
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
    
    public String consultarNoCredito(){
        
        return "875";
    }
    
    public boolean registrarCredito(String motivo, String fecha, int numero){
        //registrar un nuevo credito
        
        if(c.conectarBD()){
                
            try{
                if (!c.conexion.isClosed()) {
                    
                    PreparedStatement ps = Conexion.conexion.prepareStatement("insert into Creditos(Concepto, Fecha, No_Control_FK) values (?,?,?);");
                    
                    ps.setString(1,motivo);
                    ps.setString(2,fecha);
                    ps.setInt(3, numero);
                    
                    ps.executeUpdate();
                    ps.close();
                    pm.confirmacion("El Credito");
                   
                }
                
            }catch(Exception e){
                
                System.err.println(e);
                return false;
            }           
        }
        
        return true;
    }
    
    public boolean registrarConferencia(String Nombre,String Fecha,int Horas, int Numero){
        //registrar una nueva conferencia de alumno
         int id = 0;
        if(c.conectarBD()){
                
            try{
                if (!c.conexion.isClosed()) {
                    
                    
                    PreparedStatement ps = Conexion.conexion.prepareStatement("insert into Conferencias(Nombre, Fecha, Horas) values (?,?,?);");
                    
                    ps.setString(1,Nombre);
                    ps.setString(2,Fecha);
                    ps.setInt(3,Horas);
                    
                    ps.executeUpdate();
                    ps.close();
                    
                   
                }   
            }catch(Exception e){
                
                System.err.println(e + "1");
                return false;
            }  
            
            
            
        }if(c.conectarBD()){
            
            ResultSet res = c.ejecutarSQLSelect("select Id_Confe\n" +
                                                "from Conferencias \n" +
                                                "where Nombre = " + "'"+Nombre+"'");
            System.out.println("__");
            try{
                if (res.next()) {
                    
                    id = res.getInt(1);
                }
                
            }catch(Exception e){
                System.err.println(e + "2");
                return false;
            }
            
        }if (c.conectarBD()) {
            
            try{
                if (!c.conexion.isClosed()) {
                    
                    PreparedStatement pst = Conexion.conexion.prepareStatement("insert into Asiste(No_Control, Id_Confe) values (?,?);");
                    
                    pst.setInt(1,Numero);
                    pst.setInt(2,id);
                    
                    pst.executeUpdate();
                    pst.close();
                    pm.confirmacion("la confernecia");
                }
                
                
            }catch (Exception e){
                System.err.println(e + "3");
                return false;
            }
            
        }

        
        return true;
    }
    
    public boolean registrarReunion(String tutor, String lugar, String motivo, String fecha, String hora, String comentarios, int control){
        
        if(c.conectarBD()){
                
            try{
                if (!c.conexion.isClosed()) {
                    
                    PreparedStatement ps = Conexion.conexion.prepareStatement("insert into Reuniones(Nombre_Tutor, Lugar, Motivo, Fecha, Hora, Comentarios, No_Control_FK) values (?,?,?,?,?,?,?);");
                    
                    ps.setString(1,tutor);
                    ps.setString(2,lugar);
                    ps.setString(3,motivo);
                    ps.setString(4,fecha);
                    ps.setString(5,hora);
                    ps.setString(6,comentarios);
                    ps.setInt(7,control);
                    
                    
                    ps.executeUpdate();
                    ps.close();
//                    pm.confirmacion("La reunion");
                   
                }
                
            }catch(Exception e){
                
                System.err.println(e);
                return false;
            }           
        }
        
        
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
    
    public boolean existenciaAlumno(int control){
        if (c.conectarBD()) {
            
            ResultSet res = c.ejecutarSQLSelect("select No_Control\n" +
                                                "from Alumno\n" +
                                                "where No_Control = " + control);
            
           try{ 
               if (res.next()) {
                   
                 return true;
                   
               }else{
                   return false;
               }
            
            
           }catch(Exception e){
               System.out.println("e");
               return false;
               
           } 
        }
        
        
       return false;
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
          
}
