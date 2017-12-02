
package Interface;

import javax.swing.JOptionPane;

/**
 *
 * @author argel
 */
public class PantallaDeMensajes {
   
   
    
   public PantallaDeMensajes(){
       
       
       
   }
    
   public void consultaErr(){
       
       JOptionPane.showMessageDialog(null,
               "Formato incorrecto para el numero de control", 
               "Advertencia",
               JOptionPane.ERROR_MESSAGE);
       
   }
   
   public void usuarioIncorrecto(){
       JOptionPane.showMessageDialog(null,
               "Usuario incorecto", 
               "Error",
               JOptionPane.ERROR_MESSAGE);
       
   }
   
   public void contraseñaIncorrecta(){
       JOptionPane.showMessageDialog(null,
               "Contraseña incorrecta", 
               "Error",
               JOptionPane.ERROR_MESSAGE);
       
   }
   
    
}
