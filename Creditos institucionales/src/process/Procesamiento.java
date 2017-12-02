
package process;

/**
 *
 * @author argel
 */
public class Procesamiento {
    
    private final String USUARIO;
    private final String CONTRASEÑA;
    
    public Procesamiento(){
        
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
        
        return contraseña.equals(USUARIO);
    }
}
