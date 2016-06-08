
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gargui3
 */
public class Menu extends JPanel {
    
    static final Boolean bT = new Boolean(true);
    static final Boolean bF = new Boolean(false);
    static ButtonGroup grupoBotones;
    private Integer fil=10;
    private Integer col=10;
    private Integer tfil=10;
    private Integer tcol=10;
    private Integer bombas=10;
    private Integer nivel=1;
    private Boolean n=false;
    private int g=0;
    JPanel p = new JPanel();
    private JButton face;
    
    JFrame f;
    
    private Boton[][] matriz;
    private JLabel[][] label;   
    
    
    static class TipoMenu{
      TipoMenu(int i){}  
    };
    
    static final TipoMenu mi = new TipoMenu(1);
    static final TipoMenu cb = new TipoMenu(2);
    static final TipoMenu rb = new TipoMenu(3);
    
    
    ActionListener guardar = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            if(g==1){
                try{
                    String nombre="";
                    JFileChooser file=new JFileChooser();
                    file.showSaveDialog(f);
                    File guarda =file.getSelectedFile();

                    if(guarda !=null){
                        /*guardamos el archivo y le damos el formato directamente,
                         * si queremos que se guarde en formato doc lo definimos como .doc*/
                         TextFile  save=new TextFile(guarda+".bsc", Apertura.REWRITE,true);
                         save.writeLn(nivel);
                         save.writeLn(fil);
                         save.writeLn(col);
                         save.writeLn(bombas);
                         for (int i = 0; i < fil; i++) {
                             for (int j = 0; j < col; j++) {
                                 String p = label[i][j].getText();
                                 save.writeLn(p);
                            }
                         }
                         for (int i = 0; i < fil; i++) {
                             for (int j = 0; j < col; j++) {
                                 Integer n = Boton.valorCheck(i, j);
                                 save.writeLn(n);
                            }
                         }
                         save.cerrarArchivo();
                         JOptionPane.showMessageDialog(null,
                              "El archivo se a guardado Exitosamente",
                                  "Información",JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha guardado",
                            "Advertencia",JOptionPane.WARNING_MESSAGE);
                } catch (ArchivoInexistenteException ex) {

                }
            }
        }
    };
    
    ActionListener abrir = new ActionListener(){
        
        String ruta;
        
        public void actionPerformed(ActionEvent evt){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int ret = fileOpen.showDialog(new JPanel(), "Seleecionar Archivo");
            if (ret == JFileChooser.APPROVE_OPTION) {
                ruta=fileOpen.getSelectedFile().getPath();
                if(n){
                    for (int i = 0; i < tfil; i++) {
                        for (int j = 0; j < tcol; j++) {
                              matriz[i][j].setVisible(false);
                              label[i][j].setVisible(false);
                        }
                    }
                }
                face.setText(":)");
                n=true;
                if(nivel>=2 && fil>=15 & col>=15){
                    f.setSize(700, 700);
                    face.setBounds(320, 30, 50, 20);
                }else if(nivel==1 || nivel==4){
                    f.setSize(550, 550);
                }
                try {
                    TextFile t = new TextFile(ruta, Apertura.READ, false);
                    String strLinea = t.readLn();
                    nivel = Integer.valueOf(strLinea);
                    strLinea = t.readLn();
                    fil = Integer.valueOf(strLinea);
                    strLinea = t.readLn();
                    col = Integer.valueOf(strLinea);
                    strLinea = t.readLn();
                    bombas = Integer.valueOf(strLinea);
                    matriz= new Boton[fil][col];
                    label = new JLabel[fil][col];
                    CrearTablero n1 = new CrearTablero(fil,col,bombas);
                    for (int i = 0; i < fil; i++) {
                        for (int j = 0; j < col; j++) {
                            strLinea = t.readLn();
                            if("b".equals(strLinea)){
                                n1.valorT(i+1, j+1, -1);
                            }else if("bD".equals(strLinea)){
                                n1.valorT(i+1, j+1, -3);    
                            }else if("bC".equals(strLinea)){
                                n1.valorT(i+1, j+1, -2);    
                            }else if(" ".equals(strLinea)){
                                n1.valorT(i+1, j+1, 0); 
                            }else{
                                n1.valorT(i+1, j+1, Integer.valueOf(strLinea)); 
                            }
                            label[i][j]=new JLabel(strLinea,JLabel.CENTER);
                            matriz[i][j]=new Boton(i+1,j+1,n1, matriz,fil,col,label,bombas,f,face);
                            if(fil<=10 && col<=10){
                                label[i][j].setBounds(40+j*40, 50+i*40, 40, 40);
                                matriz[i][j].setBounds(40+j*40, 50+i*40, 40, 40);
                            }else if(fil<=20 && col<=20){
                                label[i][j].setBounds(40+j*30, 50+i*30, 30, 30);
                                matriz[i][j].setBounds(40+j*30, 50+i*30, 30, 30);
                            }else{
                                label[i][j].setBounds(40+j*20, 50+i*20, 20, 20);
                                matriz[i][j].setBounds(40+j*20, 50+i*20, 20, 20);
                            }

                            p.add(matriz[i][j]);
                            p.add(label[i][j]);

                                if("1".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.BLUE);
                                }else if("2".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.GREEN);
                                }else if("3".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.ORANGE);
                                }else if("4".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.MAGENTA);
                                }else if("5".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.PINK);
                                }else if("6".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.RED);
                                }else if("7".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.CYAN);
                                }else if("8".equals(label[i][j].getText())){
                                    label[i][j].setForeground(Color.YELLOW);
                                }

                        }
                    }

                    for (int i = 0; i < fil; i++) {
                        for (int j = 0; j < col; j++) {
                            matriz[i][j].setFont(new java.awt.Font("Tahoma", 0, 8));
                            strLinea = t.readLn();
                            if((Integer.valueOf(strLinea))==1){
                                matriz[i][j].setVisible(false);
                            }else if((Integer.valueOf(strLinea))==2){
                                matriz[i][j].setText("B");
                            }else if((Integer.valueOf(strLinea))==3){
                                matriz[i][j].setText("?");
                            }
                        }
                    }
                    tfil=fil;
                    tcol=col;
                    t.cerrarArchivo();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                        "No se pudo abrir archivo",
                            "Advertencia",JOptionPane.WARNING_MESSAGE);
                } catch (ArchivoInexistenteException ex) {

                }
            }
        }
    };
    
    ActionListener scores = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            DialogoScore s = new DialogoScore(f);
        }
    };
    
    ActionListener salir = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            try {
                DialogoConfirmar c = new DialogoConfirmar(f);
                if(c.isOpc()){
                    guardar();
                    System.exit(0);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ArchivoInexistenteException ex) {
                System.out.println(ex.getMessage());
            }
        }
    };
    
    ActionListener acerca = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            DialogoAcerca a = new DialogoAcerca(f);
        }
    };
    
    ActionListener personalizado = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            DialogoPersonalizado d1 = new DialogoPersonalizado(f);
            if(!d1.cerreComo()){
                fil=d1.getF();
                col=d1.getC();
                bombas=d1.getB();
                nivel=4;
            }
        }
    };
    
    ActionListener facil = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            fil=10;
            col=10;
            bombas=10;
            nivel=1;
        }
    };
    
    ActionListener medio = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            fil=20;
            col=20;
            bombas=40;
            nivel=2;
        }
    };
    
    ActionListener dificil = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            fil=30;
            col=30;
            bombas=100;
            nivel=3;
        }
    };
    
    ActionListener nuevo = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            g=1;
            if(n){
                for (int i = 0; i < tfil; i++) {
                    for (int j = 0; j < tcol; j++) {
                          matriz[i][j].setVisible(false);
                          label[i][j].setVisible(false);
                    }
                }
            }
            if(nivel>=2 && fil>=15 && col>=15){
                f.setSize(700, 700);
                face.setBounds(320, 30, 50, 20);
            }else if(nivel==1 || nivel==4){
                f.setSize(550, 550);
            }
            face.setText(":)");
            n=true;
            CrearTablero n1 = new CrearTablero(fil,col,bombas);
            matriz= new Boton[fil][col];
            label = new JLabel[fil][col];
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < col; j++) {
                    if((n1.valor(i+1, j+1))==-1){
                        label[i][j]=new JLabel("b",JLabel.CENTER);
                    }else if((n1.valor(i+1, j+1))==0){
                        label[i][j]=new JLabel(" ",JLabel.CENTER);
                    }else{
                        String da = n1.valor(i+1, j+1).toString();
                        label[i][j]=new JLabel(da,JLabel.CENTER);
                    }
                    matriz[i][j]=new Boton(i+1,j+1,n1, matriz,fil,col,label,bombas,f,face);
                    if(fil<=10 && col<=10){
                        label[i][j].setBounds(40+j*40, 50+i*40, 40, 40);
                        matriz[i][j].setBounds(40+j*40, 50+i*40, 40, 40);
                    }else if(fil<=20 && col<=20){
                        label[i][j].setBounds(40+j*30, 50+i*30, 30, 30);
                        matriz[i][j].setBounds(40+j*30, 50+i*30, 30, 30);
                    }else{
                        label[i][j].setBounds(40+j*20, 50+i*20, 20, 20);
                        matriz[i][j].setBounds(40+j*20, 50+i*20, 20, 20);
                    }
                    
                    p.add(matriz[i][j]);
                    p.add(label[i][j]);
                    
                }
            }
            tfil=fil;
            tcol=col;
            p.repaint();
            
        }
    };
    
    public Object Archivo[][] = {
        {"Archivo", new Character('A')},
        {"Nuevo Partida",mi, new Character('N'),nuevo,bT},
        {"Abrir Partida",mi, new Character('b'),abrir,bT},
        {"Guardar Partida",mi, new Character('G'),guardar,bT},
        {null /*separador*/},
        {"Salir",mi, new Character('S'),salir,bT},
    };
    
    public Object Niveles[][] = {
        {"Nivel", new Character('j')},
        {"Facil",mi, new Character('f'),facil,bT},
        {"Medio",mi, new Character('m'),medio,bT},
        {"Dificil",mi, new Character('d'),dificil,bT},
        {"Personalizado",mi, new Character('p'),personalizado,bT},
    };
    
    public Object Ayuda[][] = {
        {"Ayuda", new Character('j')},
        {"Acerca de",mi, new Character('q'),acerca,bT},
        {"Scores",mi, new Character('z'),scores,bT},
    };
    
    public Object barraMenu[] = { Archivo, Niveles, Ayuda };  
    
    static public JMenuBar creaMenuBarra( Object barraMenuDato[] ){
        JMenuBar barraMenu = new JMenuBar();
        for(int i=0; i<barraMenuDato.length;i++){
            barraMenu.add( creaMenu( (Object[][])barraMenuDato[i]) );
        }
        return (barraMenu);
    }
    
    static public JMenu creaMenu( Object[][] menuDato){
        JMenu menu = new JMenu();
        menu.setText( (String)menuDato[0][0] );
        menu.setMnemonic( ((Character)menuDato[0][1]).charValue() );
        grupoBotones = new ButtonGroup();
        for (int i = 1; i < menuDato.length; i++) {
            if(menuDato[i][0] == null){
                menu.add( new JSeparator() );
            }else{
                menu.add( creaMenuItem( menuDato[i] ) );
            }
        }
        return (menu);
    }
    
    static public JMenuItem creaMenuItem( Object[] dato ){
        JMenuItem m = null;
        TipoMenu tipo = (TipoMenu)dato[1];
        
        if(tipo == mi){
            m=new JMenuItem();
        }else if(tipo == cb){
            m=new JCheckBoxMenuItem();
        }else if(tipo == rb){
            m= new JRadioButtonMenuItem();
            grupoBotones.add(m);
        }
        m.setText((String)dato[0]);
        m.setMnemonic(((Character)dato[2]).charValue());
        m.addActionListener((ActionListener)dato[3]);
        m.setEnabled(((Boolean)dato[4]).booleanValue());
        return (m);
    }
    
    public void cargar() throws IOException, ArchivoInexistenteException{
        TextFile t = new TextFile("cargar.bscData", Apertura.READ, false);
        String strLinea = t.readLn();
        nivel = Integer.valueOf(strLinea);
        strLinea = t.readLn();
        fil = Integer.valueOf(strLinea);
        strLinea = t.readLn();
        col = Integer.valueOf(strLinea);
        strLinea = t.readLn();
        bombas = Integer.valueOf(strLinea);
        tfil=fil;
        tcol=col;
        t.cerrarArchivo();
    }
    
    public void guardar() throws IOException, ArchivoInexistenteException{
        TextFile t = new TextFile("cargar.bscData", Apertura.REWRITE, false);
        t.writeLn(nivel);
        t.writeLn(fil);
        t.writeLn(col);
        t.writeLn(bombas);
        t.cerrarArchivo();
    }
    
    public Menu(JFrame f1) throws IOException, ArchivoInexistenteException{
        f=f1;
        setLayout( new BorderLayout());
        add( creaMenuBarra( barraMenu ),BorderLayout.NORTH);
        p.setLayout(null);
        face = new JButton(":)");
        face.setBounds(210, 30, 50, 20);
        face.addActionListener(nuevo);
        f.add(face);
        add(p);
        f.setResizable(false);
        cargar();
    }
    
}
