package Interface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Pantalla extends JFrame {
    
    //Default
    JPanel panelPrincipal;
    JPanel paneles[];
    
    //interfaces
    JButton botones[];
    JTextField camposT[];
    JLabel etiquetas[];
    
    //arreglos de nombres
    String BOTONES [];
    String ETIQUETAS[];
    
    public Pantalla(){
        
        construye();
        arma();
        lanza();
        
    }
 
    private void construye(){
        //construir los simientos del frame
        ImageIcon icono = new ImageIcon("src/Imagenes/logo.jpg");
        this.setSize(600,400);
        this.setTitle("ITL Creditos institucionales");
        this.setIconImage(icono.getImage());
        
        //inicializar paneles y componentes a utilizar
        
        panelPrincipal = new JPanel();
        paneles = new JPanel[6];
        botones = new JButton[12];
        BOTONES = new String[botones.length];
        camposT = new JTextField[15];
        
        etiquetas = new JLabel[16];
        ETIQUETAS = new String[etiquetas.length];

       
    }
    
    
    private void arma(){
        //Añadir espesificaciones a los componentes asi como caracteristicas
        panelPrincipal.setLayout(new GridLayout(6,2));
        panelPrincipal.setBounds(0, 0, 600, 400);
        
       this.setLayout(null);
       
       //instanciar arreglo de paneles
        for (int i = 0; i < paneles.length; i++) {
            
            paneles[i] = new JPanel();
            paneles[i].setLayout(new FlowLayout());
            panelPrincipal.add(paneles[i]);
        }
        
        //arreglos de los nombres de todos los componentes
        armarNombres();
        
        //instanciar arreglo de botones
        for (int i = 0; i < botones.length; i++) {
            
            botones[i] = new JButton();
            botones[i].setText(BOTONES[i]);
            
        }
        
        //instanciar etiquetas
        for (int i = 0; i < etiquetas.length; i++) {
         
            etiquetas[i] = new JLabel();
            etiquetas[i].setText(ETIQUETAS[i]);
        }
        
        //instanciar campos de texto
        for (int i = 0; i < camposT.length; i++) {
            
            camposT[i] = new JTextField();
            
        }
        
        //Agregar distintos componentes al panelPrincipal principal
                
                //campo (1,1) del layout
                paneles[0].add(etiquetas[0]);
         
                //campo (2,1) del layout
                paneles[1].add(botones[0]);
    }
    
    private void armarNombres(){
     
        BOTONES[0] = "Registrar";
        BOTONES[1] = "Consultar"; 
        BOTONES[2] = "Agregar";
        BOTONES[3] = "Salir";
        BOTONES[4] = "Aceptar";
        BOTONES[5] = "Cancelar";
        BOTONES[6] = "Aceotar"; 
        BOTONES[7] = "Cancelar";
        BOTONES[8] = "Aceptar";
        BOTONES[9] = "Cancelar";
        BOTONES[10] = "Aceptar";
        BOTONES[11] = "Cancelar";
        
        ETIQUETAS[0] = "Inicio";
        ETIQUETAS[1] = "Numero de Control";
        ETIQUETAS[2] = "Nombre del Alumno";
        ETIQUETAS[3] = "Semestre en Curso";
        ETIQUETAS[4] = "Nombre del Tutor";
        ETIQUETAS[5] = "Fecha de la reunion";
        ETIQUETAS[6] = "Lugar de la Reunion";
        ETIQUETAS[7] = "Motivo de la Reunion";
        ETIQUETAS[8] = "Hora de la reunion";
        ETIQUETAS[9] = "Comentarios";
        ETIQUETAS[10] = "Numero de Credito";
        ETIQUETAS[11] = "Fecha del credito";
        ETIQUETAS[12] = "Concepto del redito";
        ETIQUETAS[13] = "Nombre de la Conferencia";
        ETIQUETAS[14] = "Fecha de la Conferencia";
        ETIQUETAS[15] = "Horas Asistidas";
      
       
        
        
        
    }
    
    
    private void lanza(){
        //Especificar las opciones del Jframe
        this.setContentPane(panelPrincipal);
        this.setVisible(true);
        this.setResizable(false);
        //abrebiatura utilizada EXIT_ON_CLOSE = 3
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);   
        
        
    }
    
    
}