
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
   
    
}
