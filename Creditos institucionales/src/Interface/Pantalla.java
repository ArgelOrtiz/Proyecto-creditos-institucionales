package Interface;

import Entidades.Alumno;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import process.Procesamiento;


public class Pantalla extends JFrame {
    
    //Default
    JPanel panelBase;
    JPanel panelPrincipal;
    JPanel paneles[];
    ManejaBoton manejador;
    JFrame login;
    JTextField usuarioIn;
    JPasswordField contraseñaIn;
    Alumno a;
    
    //interfaces
    JButton botones[];
    JTextField camposT[];
    JLabel etiquetas[];
    JLabel etiquetasD[];
    
    //arreglos de nombres
    String BOTONES [];
    String ETIQUETAS[];
    String ETIQUETASD[];
    
    //clases necesarias
    PantallaMensajes pm;
    Procesamiento p;
    
    //apariencia
    private UIManager.LookAndFeelInfo apariencias[];
    
    public Pantalla(){
        Interface();
        
        //indicar la primera pantalla a mostrar
        inicioVisible(true);
        consultarAlumnoVisible(false);
        alumnoVisible(false);
        reunionesVisibleI(false);
        reunionesVisibleII(false);
        creditoVisible(false);
        conferenciaVisible(false);
        consultarVisible(false);
        
        
        
    }
    
    public void Interface(){
        apariencia();
        //estructurar todos los componentes necesarios para la interface
        construye();
        arma();
        lanza();
    }
    
    //modifica la apariencia de la interfaace
    private void apariencia(){
        
        apariencias = UIManager.getInstalledLookAndFeels();
        try{
            
        UIManager.setLookAndFeel(apariencias[1].getClassName());
        SwingUtilities.updateComponentTreeUI(this);
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | NullPointerException e){
            
        }
       
    }
 
    private void construye(){
        //construir los simientos del frame
        ImageIcon icono = new ImageIcon("src/Imagenes/logo.jpg");
        this.setSize(700,450);
        this.setTitle("ITL Creditos institucionales");
        this.setIconImage(icono.getImage());
        login = new JFrame();
        
        //inicializar paneles y componentes a utilizar
        panelBase = new JPanel();
        panelPrincipal = new JPanel();
        paneles = new JPanel[14];
        botones = new JButton[16];
        BOTONES = new String[botones.length];
        camposT = new JTextField[15];
        etiquetas = new JLabel[22];
        ETIQUETAS = new String[etiquetas.length];
        etiquetasD = new JLabel[3];
        ETIQUETASD = new String[etiquetasD.length];

        //Otros
        manejador = new ManejaBoton();
        pm = new PantallaMensajes();
        p = new Procesamiento();
//        a = new Alumno();
       
    }
    
    
    private void arma(){
        //Añadir espesificaciones a los componentes asi como caracteristicas
        panelBase.setLayout(null);
        panelBase.setBounds(0, 0, 700, 400);
        panelPrincipal.setLayout(new GridLayout(7,2));
        panelPrincipal.setBounds(0, 0, 700, 400);
        panelBase.add(panelPrincipal);
        
       
       //instanciar arreglo de paneles
        for (int i = 0; i < paneles.length; i++) {
            
            paneles[i] = new JPanel();
            paneles[i].setLayout(new FlowLayout());
            panelPrincipal.add(paneles[i]);
            paneles[i].setBackground(Color.white);
        }
        
        //arreglos de los nombres de todos los componentes
        armarNombres();
        
        //instanciar arreglo de botones
        for (int i = 0; i < botones.length; i++) {
            
            botones[i] = new JButton();
            botones[i].setText(BOTONES[i]);
            botones[i].setFont(new Font("arial",Font.ITALIC,15));
            botones[i].addActionListener(manejador);
            
        }
        
        //instanciar etiquetas
        for (int i = 0; i < etiquetas.length; i++) {
         
            etiquetas[i] = new JLabel();
            etiquetas[i].setText(ETIQUETAS[i]); 
            etiquetas[i].setFont(new Font("Book Antiqua",Font.ITALIC,25));
        }
        
        //instanciar etiquetasD
        for (int i = 0; i < etiquetasD.length; i++) {
         
            etiquetasD[i] = new JLabel();
            etiquetasD[i].setText(ETIQUETASD[i]); 
            etiquetasD[i].setFont(new Font("Book Antiqua",Font.ITALIC,25));
        }
        
        //instanciar campos de texto
        for (int i = 0; i < camposT.length; i++) {
            
            camposT[i] = new JTextField(25);
            
        }
        
        //Agregar distintos componentes al panelPrincipal principal
                
                //campo (1,1) del layout                //campo (1,2) del layout
                paneles[0].add(etiquetas[0]);  
                paneles[0].add(etiquetas[16]);
                paneles[0].add(etiquetas[17]);
                paneles[0].add(etiquetas[18]);
                paneles[0].add(etiquetas[19]);
                paneles[0].add(etiquetas[20]);
                
             
         
                //campo (2,1) del layout                //campo (2,2) del layout
                paneles[2].add(botones[0]);             paneles[3].add(camposT[0]);
                paneles[2].add(etiquetas[1]);           
           
                
                //campo (3,1) del layout                //campo (3,2) del layout
                paneles[4].add(botones[1]);             paneles[5].add(camposT[9]);
                paneles[4].add(etiquetas[2]);           paneles[5].add(camposT[1]);
                paneles[4].add(etiquetas[10]);          paneles[5].add(camposT[12]);
                paneles[4].add(etiquetas[13]);          paneles[5].add(etiquetasD[0]);
                paneles[4].add(etiquetas[4]);           paneles[5].add(camposT[3]);
                paneles[4].add(etiquetas[8]);           paneles[5].add(camposT[7]);
                
                //campo (4,1) del layout                //campo (4,2) del layout
                paneles[6].add(etiquetas[3]);           paneles[7].add(camposT[2]);
                paneles[6].add(etiquetas[7]);           paneles[7].add(camposT[8]);
                paneles[6].add(etiquetas[11]);          paneles[7].add(camposT[10]);
                paneles[6].add(etiquetas[14]);          paneles[7].add(camposT[13]);
                paneles[6].add(etiquetas[5]);           paneles[7].add(camposT[4]);
                paneles[6].add(etiquetas[9]);
                
                                                        paneles[7].add(etiquetasD[1]);
                
                
                
                //campo (5,1) del layout                //campo (5,2) del layout
                paneles[8].add(etiquetas[6]);           
                paneles[8].add(etiquetas[12]);          paneles[9].add(camposT[11]);
                paneles[8].add(etiquetas[15]);          paneles[9].add(camposT[14]);
                paneles[8].add(etiquetas[21]);          paneles[9].add(camposT[5]);
                                                        
                                                        
                                                        paneles[9].add(etiquetasD[2]);
                                                        
                //campo (6,1) del layout                //campo (6,2) del layout
                paneles[10].add(botones[3]);            paneles[11].add(camposT[6]);
                paneles[10].add(etiquetas[7]);          
                                                                                   
                //campo (7,1) del layout                //campo (7,2) del layout
                paneles[12].add(botones[4]);            
                paneles[12].add(botones[6]);            paneles[13].add(botones[5]);
                paneles[12].add(botones[8]);            paneles[13].add(botones[7]);
                paneles[12].add(botones[10]);           paneles[13].add(botones[9]);
                paneles[12].add(botones[12]);           paneles[13].add(botones[11]);
                paneles[12].add(botones[2]);            paneles[13].add(botones[13]);
                          
                camposT[0].addKeyListener(new KeyListener ()  {

            @Override
            public void keyTyped(KeyEvent e) {
                if (camposT[0].getText().length() == 8) {
                    e.consume();
                    }
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
      
                });
                
                
    }
    
    
    
    private void inicioVisible(boolean x){
        etiquetas[0].setFont(new Font("Book Antiqua",Font.BOLD,25));
        etiquetas[0].setVisible(x);
        botones[0].setVisible(x);
        botones[1].setVisible(x);
        botones[3].setVisible(x);
    }
    
    private void alumnoVisible(boolean x){
        etiquetas[16].setFont(new Font("Book Antiqua",Font.BOLD,25));
        etiquetas[1].setVisible(x);
        camposT[0].setVisible(x);
        etiquetas[2].setVisible(x);
        camposT[1].setVisible(x);
        etiquetas[3].setVisible(x);
        camposT[2].setVisible(x);
        botones[4].setVisible(x);
        botones[5].setVisible(x);
        etiquetas[16].setVisible(x);
    }
    
    private void consultarAlumnoVisible(boolean x){
        etiquetas[2].setVisible(x);
        etiquetas[3].setVisible(x);
        etiquetas[21].setVisible(x);
        etiquetasD[0].setVisible(x);
        etiquetasD[1].setVisible(x);
        etiquetasD[2].setVisible(x);
        botones[2].setVisible(x);
        
    }
    
    
    private void reunionesVisibleI(boolean x){
        etiquetas[17].setFont(new Font("Book Antiqua",Font.BOLD,25));
        etiquetas[4].setVisible(x);
        etiquetas[5].setVisible(x);
        etiquetas[6].setVisible(x);
        etiquetas[7].setVisible(x);

        camposT[3].setVisible(x);
        camposT[4].setVisible(x);
        camposT[5].setVisible(x);
        camposT[6].setVisible(x);
        
        etiquetas[17].setVisible(x);
        botones[6].setVisible(x);
        botones[7].setVisible(x);
        
    }
    
    private void reunionesVisibleII(boolean x){
        etiquetas[8].setVisible(x);
        etiquetas[9].setVisible(x);
        camposT[7].setVisible(x);
        camposT[8].setVisible(x);
        botones[6].setVisible(x);
        botones[7].setVisible(x);
        etiquetas[17].setVisible(x);
    }
    
    private void creditoVisible(boolean x){
        etiquetas[18].setFont(new Font("Book Antiqua",Font.BOLD,25));
        etiquetas[10].setVisible(x);
        etiquetas[11].setVisible(x);
        etiquetas[12].setVisible(x);
        camposT[9].setVisible(x);
        camposT[10].setVisible(x);
        camposT[11].setVisible(x);
        botones[8].setVisible(x);
        botones[9].setVisible(x);
        etiquetas[18].setVisible(x);
        
    }
    
    private void conferenciaVisible(boolean x){
        etiquetas[19].setFont(new Font("Book Antiqua",Font.BOLD,25));
        etiquetas[13].setVisible(x);
        etiquetas[14].setVisible(x);
        etiquetas[15].setVisible(x);
        camposT[12].setVisible(x);
        camposT[13].setVisible(x);
        camposT[14].setVisible(x);
        botones[10].setVisible(x);
        botones[11].setVisible(x);
        etiquetas[19].setVisible(x);
    }
    
    private void consultarVisible(boolean x){
        etiquetas[20].setFont(new Font("Book Antiqua",Font.BOLD,25));
        etiquetas[1].setVisible(x);
        botones[12].setVisible(x);
        botones[13].setVisible(x);
        camposT[0].setVisible(x);
        etiquetas[20].setVisible(x);
        
    }
    
    
    private void armarNombres(){
     
        BOTONES[0] = "Registrar ";
        BOTONES[1] = "Consultar "; 
        BOTONES[2] = "Agregar   ";
        BOTONES[3] = "  Salir   ";
        BOTONES[4] = "Aceptar   ";
        BOTONES[5] = "Cancelar  ";
        BOTONES[6] = "Aceptar   "; 
        BOTONES[7] = "Cancelar  ";
        BOTONES[8] = "Aceptar   ";
        BOTONES[9] = "Cancelar  ";
        BOTONES[10] = "Aceptar  ";
        BOTONES[11] = "Cancelar ";
        BOTONES[12] = "Aceptar  ";
        BOTONES[13] = "Cancelar ";
        BOTONES[14] = "Aceptar  ";
        BOTONES[15] = "Cancelar ";
        
        ETIQUETAS[0] =  "Inicio";
        ETIQUETAS[1] =  "Numero de Control          ";
        ETIQUETAS[2] =  "Nombre del Alumno          ";
        ETIQUETAS[3] =  "Semestre en Curso          ";
        ETIQUETAS[4] =  "Nombre del Tutor           ";
        ETIQUETAS[5] =  "Fecha de la reunion        ";
        ETIQUETAS[6] =  "Lugar de la Reunion        ";
        ETIQUETAS[7] =  "Motivo de la Reunion       ";
        ETIQUETAS[8] =  "Hora de la reunion         ";
        ETIQUETAS[9] =  "Comentarios                ";
        ETIQUETAS[10] = "Numero de Credito          ";
        ETIQUETAS[11] = "Fecha del credito          ";
        ETIQUETAS[12] = "Concepto del redito        ";
        ETIQUETAS[13] = "Nombre de la Conferencia   ";
        ETIQUETAS[14] = "Fecha de la Conferencia    ";
        ETIQUETAS[15] = "Horas Asistidas            ";
        ETIQUETAS[16] = "Registro de Nuevo Alumno   ";
        ETIQUETAS[17] = "Registrar Reuniones        ";
        ETIQUETAS[18] = "Registrar Credito          ";
        ETIQUETAS[19] = "Registrar Conferencias     ";
        ETIQUETAS[20] = "Consultar Alumno           ";
        ETIQUETAS[21] = "Creditos                   ";
        
        ETIQUETASD[0] = "Prueba";
        ETIQUETASD[1] = "Prueba";
        ETIQUETASD[2] = "Prueba";
        
        
    }
    
    private void lanza(){
        //Especificar las opciones del Jframe
        this.setContentPane(panelBase);
        this.setVisible(true);
        this.setResizable(false);
        //abrebiatura utilizada EXIT_ON_CLOSE = 3
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);   
            
    }
    
    public void UsuarioInterface(){
        //default
        JPanel panelBaseu, panelPrincipalU, panelesU [];
        JLabel usuario, contraseña, imagen;
        JButton aceptar, cancelar;
    
        ImageIcon icono = new ImageIcon("src/Imagenes/logo.jpg");
        login.setSize(500, 200);
        login.setTitle("ITL Creditos institucionales");
        login.setIconImage(icono.getImage());
        
        panelBaseu = new JPanel();
        panelPrincipalU = new JPanel();
        panelesU = new JPanel[6];
        usuario = new JLabel("Usuario");
        contraseña = new JLabel("Contraseña:");
        imagen = new JLabel(new ImageIcon("src/Imagenes/login.png"));
        usuarioIn = new JTextField(10);
        contraseñaIn = new JPasswordField(10);
        
        panelBaseu.setLayout(new GridLayout(1,2));
        panelBaseu.setBounds(0, 0, 500, 200);
        panelBaseu.setBackground(Color.WHITE);
        
        panelPrincipalU.setLayout(new GridLayout(3,2));
        panelPrincipalU.setBounds(0, 0, 500, 200);
       
        
        usuario.setFont(new Font("Book Antiqua",Font.ITALIC,20));
        contraseña.setFont(new Font("Book Antiqua",Font.ITALIC,20));
        
        for (int i = 0; i < panelesU.length; i++) {
           
        panelesU[i] = new JPanel();
        panelesU[i].setLayout(new FlowLayout());
        panelPrincipalU.add(panelesU[i]);
        panelesU[i].setBackground(Color.WHITE);
       
        panelBaseu.add(imagen);
        panelBaseu.add(panelPrincipalU);
         
        }

        //campo (2,2) del layout                //campo (2,3) del layout    
        panelesU[0].add(usuario);         panelesU[1].add(usuarioIn);
        
        //campo (3,2) del layout                //campo (3,3) del layout  
        panelesU[2].add(contraseña);      panelesU[3].add(contraseñaIn);
        
        //campo (4,2) del layout                //campo (4,3) del layout
        panelesU[4].add(botones[14]);         panelesU[5].add(botones[15]);
        
        
        
         //Especificar las opciones del Jframe
        login.setContentPane(panelBaseu);
        login.setVisible(true);
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        login.setLocationRelativeTo(null);   
        
        
          }
      
    private class ManejaBoton implements ActionListener{
        
        private int seleccionLogin;
        
        public ManejaBoton(){
                
        seleccionLogin = 0;   
            
            }
        
        
        @Override
        public void actionPerformed(ActionEvent ae){
            
            
            if (ae.getSource().equals(botones[0])) {
                
                seleccionLogin = 1;
                UsuarioInterface();
                
                
            }else if(ae.getSource().equals(botones[1])){
                //Consultar Alumno
                inicioVisible(false);
                consultarVisible(true);
                
                
            }else if(ae.getSource().equals(botones[2])){
                //boton agregar detalles a alumno
                seleccionLogin = 2;
                UsuarioInterface();
            
            }else if(ae.getSource().equals(botones[4])){
                
                //boton imtentar registrar un alumno
                String numeroS = camposT[0].getText();
                int numeroI = 0;
//                try{
                    
                numeroI = Integer.parseInt(numeroS);
                    
                    //verificar la cantidad de diguitos equivalentes para un numero de control
                    if (numeroS.length()== 8) {
                        
                        if (!"".equals(camposT[1].getText())) {
                            if (!"".equals(camposT[2].getText())) {
                                    
                                    p.registrarAlumno(numeroI, camposT[1].getText(), Integer.parseInt(camposT[2].getText()));
                                    
                                    alumnoVisible(false);
                                    inicioVisible(true);
                                    camposT[0].setText("");
                                    camposT[1].setText("");
                                    camposT[2].setText("");
                                    
                            
                            }else{
                            pm.vacio("Semestre");
                        }
                            
                        }else{
                            pm.vacio("Nombre Alumno");
                        }
                        
                    }else{
                        
                        pm.consultaErr();
                        
                    }
//                }catch(Exception e){
//                     
//                    pm.consultaErr();
//                }
               
                
            }else if (ae.getSource().equals(botones[5])) {
                //boton cancelar en la accion "registrar alumno"
                alumnoVisible(false);
                inicioVisible(true);
                camposT[0].setText("");
                
            }else if(ae.getSource().equals(botones[6])){
                //boton agregar reunion
                
                if (!"".equals(camposT[3].getText())) {
                        if (!"".equals(camposT[4].getText())) {
                            if (!"".equals(camposT[5].getText())) {
                                if (!"".equals(camposT[6].getText())) {
                                    //primera parte de reunion
                                    reunionesVisibleI(false);
                                    reunionesVisibleII(true);
                                    
                                    if (!"".equals(camposT[7].getText())) {
                                        if (!"".equals(camposT[8].getText())) {
                                            
                                                if (p.registrarReunion()) {
                                                pm.confirmacion("La Reunion");
                                                etiquetas[1].setVisible(false);
                                                camposT[0].setVisible(false);
                                                camposT[0].setEnabled(true);
                                                reunionesVisibleI(false);
                                                reunionesVisibleII(false);
                                                inicioVisible(true);
                                            }
                                            
                                            
                                        }else{
                                            
                                            camposT[8].setText("Sin Comentarios");
                                            if (p.registrarReunion()) {
                                                pm.confirmacion("La Reunion");
                                                etiquetas[1].setVisible(false);
                                                camposT[0].setVisible(false);
                                                camposT[0].setEnabled(true);
                                                reunionesVisibleI(false);
                                                reunionesVisibleII(false);
                                                inicioVisible(true);
                                            }
                                            
                                        }
                                    }else{
                                        
                                        pm.vacio("Hora");
                                        
                                    }
                                    
                                }else{
                                    
                                    pm.vacio("Motivo");
                                    
                                }
                                
                            }else{
                                
                                pm.vacio("Lugar");
                                
                            }
                            
                    }else{
                          
                            pm.vacio("Fecha");
                            
                        }
                
                }else{
                    pm.vacio("Nombre Tutor");
                    
                }
            
            }else if (ae.getSource().equals(botones[7])) {
                //boton cancelar en la accion "registrar Reunion"
                etiquetas[1].setVisible(false);
                camposT[0].setVisible(false);
                camposT[0].setEnabled(true);
                reunionesVisibleI(false);
                reunionesVisibleII(false);
                inicioVisible(true);
                  
            }else if(ae.getSource().equals(botones[8])){
                //Boton aceptar en agregar credito
                if (!"".equals(camposT[9].getText())) {
                            if (!"".equals(camposT[10].getText())) {
                                if (!"".equals(camposT[11].getText())) {
                                    
                                    if(p.registrarCredito()){
                                    
                                    pm.confirmacion("El Credito");
                                    creditoVisible(false);
                                    etiquetas[1].setVisible(false);
                                    camposT[0].setVisible(false);
                                    camposT[0].setEnabled(true);
                                    inicioVisible(true);
                                    camposT[0].setText("");
                                    botones[2].setVisible(false);
                                    consultarAlumnoVisible(false);
                                    camposT[9].setEnabled(true);
                                    }
                                    
                                    
                                }else{
                            pm.vacio("Concepto");
                        }
                            }else{
                            pm.vacio("Fecha");
                        }
                            
                        }else{
                            pm.vacio("Numero");
                        }
            
            
            }else if(ae.getSource().equals(botones[9])){
                //boton cancelar agregar credito
                if (pm.advertenciaSalir() == 0) {
                    
                    creditoVisible(false);
                    etiquetas[1].setVisible(false);
                    camposT[0].setVisible(false);
                    camposT[0].setEnabled(true);
                    inicioVisible(true);
                    camposT[0].setText("");
                    botones[2].setVisible(false);
                    consultarAlumnoVisible(false);
                    camposT[9].setEnabled(true);
                    }
            
            }else if(ae.getSource().equals(botones[10])){
            
                    if (!"".equals(camposT[12].getText())) {
                            if (!"".equals(camposT[13].getText())) {
                                if (!"".equals(camposT[14].getText())) {
                                    //registrar conferencia
                                        if (p.registrarConferencia()) {
                                            
                                            pm.confirmacion("La Conferencia");
                                            conferenciaVisible(false);
                                            etiquetas[1].setVisible(false);
                                            camposT[0].setVisible(false);
                                            camposT[0].setEnabled(true);
                                            inicioVisible(true);
                                            camposT[0].setText("");
                                            botones[2].setVisible(false);
                                            consultarAlumnoVisible(false);
                                            camposT[9].setEnabled(true);
                                    }
                                    
                                }else{
                            pm.vacio("Horas");
                        }
                            }else{
                            pm.vacio("Fecha");
                        }
                            
                        }else{
                            pm.vacio("Nombre");
                        }
            
            }else if(ae.getSource().equals(botones[11])){
            
                if (pm.advertenciaSalir() == 0) {
                    
                    conferenciaVisible(false);
                    etiquetas[1].setVisible(false);
                    camposT[0].setVisible(false);
                    camposT[0].setEnabled(true);
                    inicioVisible(true);
                    camposT[0].setText("");
                    botones[2].setVisible(false);
                    consultarAlumnoVisible(false);
                    }
            
            }else if (ae.getSource().equals(botones[12])) {
                //boton para intentar aconsultar un alumno
                String numeroS = camposT[0].getText();
                int numeroI = 0;
                try{
                    
                     numeroI = Integer.parseInt(numeroS);
                     
                    //verificar la cantidad de diguitos equivalentes para un numero de control
                    if (numeroS.length()== 8) {
                        //verificar la existencia del numero 
                        if (true) {
                                a = p.ConsultarAlumno(numeroI);
                            etiquetasD[0].setText(a.getNombre());
                            etiquetasD[1].setText(a.getSemestre()+"");
                            etiquetasD[2].setText(a.getCreditos()+"");
                            
                            consultarAlumnoVisible(true);
                            
                        }else{
                            //notificar la inexistencia de ese numero 
                        }
                    
                    
                    }else{
                        //notificar el error al ingresar un numero en formato incorrecto
                        consultarAlumnoVisible(false);

                        pm.consultaErr();
                    }
                     
                }catch(NumberFormatException e){
                   consultarAlumnoVisible(false);
                   
                   pm.consultaErr();
                   
                }

            } else if (ae.getSource().equals(botones[13])) {
                //boton cancelar en la accion "consulatar alumno"
                
                    consultarVisible(false);
                    inicioVisible(true);
                    camposT[0].setText("");
                    botones[2].setVisible(false);
                    consultarAlumnoVisible(false);
                                  
            }else if (ae.getSource().equals(botones[14])) {
                
               
                if (p.verificarUsuario(usuarioIn.getText())) {
                    
                    if (p.verificarContraseña(contraseñaIn.getText())){
                        
                        if (seleccionLogin == 1) {

                        //Agregar Alumno
                        
                        inicioVisible(false);
                        alumnoVisible(true);
                        login.dispose();
                        
                        }else if (seleccionLogin == 2) {
                            
                            consultarVisible(false);
                            consultarAlumnoVisible(false);
                            login.dispose();
                            String s = pm.opcionAgregar();
                           
                            
                            if (s != null) {
                                
                                if (s.equals(pm.opcionesAgregar[0])) {
                                    
                                    //Agregar credito
                                    camposT[9].setText(p.consultarNoCredito());
                                    camposT[9].setEnabled(false);
                                    etiquetas[1].setVisible(true);
                                    camposT[0].setVisible(true);
                                    camposT[0].setEnabled(false);
                                    creditoVisible(true);
                                    
                                    
                                }else if (s.equals(pm.opcionesAgregar[1])) {
                                    
                                    //Agregar Conferencia
                                    etiquetas[1].setVisible(true);
                                    camposT[0].setVisible(true);
                                    camposT[0].setEnabled(false);
                                    conferenciaVisible(true);
                                    
                                }else if (s.equals(pm.opcionesAgregar[2])) {
                                    
                                    //Agregar reunion
                                    etiquetas[1].setVisible(true);
                                    camposT[0].setVisible(true);
                                    camposT[0].setEnabled(false);
                                    reunionesVisibleI(true);
                                    
                                   
                                    
                                }
                            
                                }else{
                                //Boton cancelar en opciones de agregar
                                consultarVisible(false);
                                inicioVisible(true);
                                camposT[0].setText("");
                                botones[2].setVisible(false);
                                consultarAlumnoVisible(false);
                                
                            }
                        }
                    }else{
                        pm.contraseñaIncorrecta();
                        
                    }
                
                }else{
                        
                    pm.usuarioIncorrecto();
                    
                
                }     
                
            }else if(ae.getSource().equals(botones[15])){
            
            login.dispose();
            
            }else if (ae.getSource().equals(botones[3])) {
                
                System.exit(0);
               
            }
            
        }

        
    }
    
}