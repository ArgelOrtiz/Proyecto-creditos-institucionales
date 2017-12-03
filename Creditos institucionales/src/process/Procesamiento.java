
package process;

import Interface.PantallaMensajes;

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
    
    public boolean verificarNoControl(int Numero){
        
        return true;
    }
    
    public boolean verificarUsuario(String usuario){
        
        return usuario.equals(USUARIO);
        
        
        }
    
    public boolean verificarContraseña(String contraseña){
        
        return contraseña.equals(CONTRASEÑA);
    }
    
    public void registrarAlumno(int control, String nombre, String semestre, String tutor ){
        
        pm.confirmacion("El Alumno");
        
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
