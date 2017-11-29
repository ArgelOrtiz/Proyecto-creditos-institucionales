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
        
        //estructurar todos los componentes necesarios para la interface
        construye();
        arma();
        lanza();
        
        //indicar la primera pantalla a mostrar
        inicioVisible(false);
        alumnoVisible(true);
        
    }
 
    private void construye(){
        //construir los simientos del frame
        ImageIcon icono = new ImageIcon("src/Imagenes/logo.jpg");
        this.setSize(600,400);
        this.setTitle("ITL Creditos institucionales");
        this.setIconImage(icono.getImage());
        
        //inicializar paneles y componentes a utilizar
        
        panelPrincipal = new JPanel();
        paneles = new JPanel[14];
        botones = new JButton[12];
        BOTONES = new String[botones.length];
        camposT = new JTextField[15];
        etiquetas = new JLabel[17];
        ETIQUETAS = new String[etiquetas.length];

       
    }
    
    
    private void arma(){
        //Añadir espesificaciones a los componentes asi como caracteristicas
        panelPrincipal.setLayout(new GridLayout(7,2));
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
            
            camposT[i] = new JTextField(25);
            
        }
        
        //Agregar distintos componentes al panelPrincipal principal
                
                //campo (1,1) del layout                //campo (1,2) del layout
                paneles[0].add(etiquetas[0]);  
                paneles[0].add(etiquetas[16]);
                
             
         
                //campo (2,1) del layout                //campo (2,2) del layout
                paneles[2].add(botones[0]);             paneles[3].add(camposT[0]);
                paneles[2].add(etiquetas[1]);
                
                //campo (3,1) del layout                //campo (3,2) del layout
                paneles[4].add(botones[1]);             paneles[5].add(camposT[1]);
                paneles[4].add(etiquetas[2]);
                
                //campo (4,1) del layout                //campo (4,2) del layout
                paneles[6].add(botones[2]);             paneles[7].add(camposT[2]);
                paneles[6].add(etiquetas[3]);
                
                //campo (5,1) del layout                //campo (5,2) del layout
                paneles[8].add(etiquetas[4]);           paneles[9].add(camposT[3]);
                
                //campo (6,1) del layout                //campo (6,2) del layout
                                                                    
                                                       
                //campo (7,1) del layout                //campo (7,2) del layout
                paneles[12].add(botones[4]);            paneles[13].add(botones[3]);
                                                        paneles[13].add(botones[5]);
                
        
    }
    
    private void inicioVisible(boolean x){
        etiquetas[0].setVisible(x);
        botones[0].setVisible(x);
        botones[1].setVisible(x);
        botones[2].setVisible(x);
        botones[3].setVisible(x);
    }
    
    private void alumnoVisible(boolean x){
        etiquetas[1].setVisible(x);
        camposT[0].setVisible(x);
        etiquetas[2].setVisible(x);
        camposT[1].setVisible(x);
        etiquetas[3].setVisible(x);
        camposT[2].setVisible(x);
        etiquetas[4].setVisible(x);
        camposT[3].setVisible(x);
        botones[4].setVisible(x);
        botones[5].setVisible(x);
        etiquetas[16].setVisible(x);
        
        
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
        ETIQUETAS[1] = "Nombre del Alumno";
        ETIQUETAS[2] = "Numero de Control";
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
        ETIQUETAS[16] = "Registro de Nuevo Alumno";
        
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