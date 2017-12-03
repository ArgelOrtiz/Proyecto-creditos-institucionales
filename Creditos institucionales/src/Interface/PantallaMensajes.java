
package Interface;

import javax.swing.JOptionPane;

/**
 *
 * @author argel
 */
public class PantallaMensajes {
   
    String opcionesAgregar[];
   
    
   public PantallaMensajes(){
       opcionesAgregar = new String[3];
       
       
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
   
   public String opcionAgregar(){
        crearOpciones(); 
        String s = new String();
       try{ 
        s = (String)JOptionPane.showInputDialog(null,
                "Escoje la Opcion que Deseas Agregar",
                "Agregar",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesAgregar,
                opcionesAgregar[0]);

       }catch(NullPointerException e){
           System.out.println("error");
           
       }  
       
       return s;
   }
   
   public void vacio(String op){
       JOptionPane.showMessageDialog(null,
               "El Campo " + op + " es Obligatorio", 
               "Advertencia",
               JOptionPane.ERROR_MESSAGE);
       
       
   }
   
   public void confirmacion(String op){
       JOptionPane.showMessageDialog(null,
               op + " se ha Registrado Correctamente", 
               "Operacion Exitosa",
               JOptionPane.INFORMATION_MESSAGE);
       
   }
   
   public int advertenciaSalir(){
       
       return(JOptionPane.showConfirmDialog(null,
               "¿Estas Seguro que Deceas Salir?" + "\n"+
               "Se Perderan lo Datos Ingresados"
               ));
       
   }
   
   public void crearOpciones(){
       
       opcionesAgregar [0] = "Credito";
       opcionesAgregar [1] = "Conferencia";
       opcionesAgregar [2] = "Reunion";
       
   }
   
    
}
