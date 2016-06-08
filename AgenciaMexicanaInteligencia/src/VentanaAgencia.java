
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gargui3
 */
public class VentanaAgencia extends JFrame {
    
    private JTextField ruta;
    private JTextField rutaArchivo;
    private JTextField nameArchivo;
    private JTextField partes;
    private JTextField rutaFinal;
    
   
    
    public VentanaAgencia(){
        
        super("Agencia Mexicana de Inteligencia");
        super.setSize(500, 500);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel bvn = new JLabel("Encriptar");
        bvn.setBounds(200, 10, 100, 20);
        super.add(bvn);
        
        JLabel selectText = new JLabel("Seleccionar archivo: ");
        selectText.setBounds(10, 40, 150, 20);
        super.add(selectText);
        
        rutaArchivo = new JTextField();
        rutaArchivo.setBounds(110, 70, 200, 20);
        super.add(rutaArchivo);
        
        nameArchivo = new JTextField();
        nameArchivo.setBounds(320, 70, 100, 20);
        super.add(nameArchivo);
        
        JButton botonSelect = new JButton("...");
        botonSelect.setBounds(180, 40, 20, 20);
        super.add(botonSelect);
        botonSelect.addActionListener(new SeleccionaArchivo(rutaArchivo, nameArchivo));
        
        JLabel numPartes = new JLabel("Partes a encriptar: ");
        numPartes.setBounds(210, 40, 150, 20);
        super.add(numPartes);
        
        partes = new JTextField();
        partes.setBounds(370, 40, 100, 20);
        super.add(partes);
        
        JLabel arcText = new JLabel("Ruta Archivo: ");
        arcText.setBounds(10, 70, 100, 20);
        super.add(arcText);
        
        JLabel guardarText = new JLabel("Ruta a guardar el archivo: ");
        guardarText.setBounds(10, 100, 200, 20);
        super.add(guardarText);
        
        ruta = new JTextField();
        ruta.setBounds(70, 130, 300, 20);
        super.add(ruta);
        
        JButton botonArchivo = new JButton("...");
        botonArchivo.setBounds(220, 100, 20, 20);
        super.add(botonArchivo);
        botonArchivo.addActionListener(new SeleccionaRuta(ruta));
        
        JLabel rutaText = new JLabel("Ruta: ");
        rutaText.setBounds(10, 130, 50, 20);
        super.add(rutaText);
        
        JButton encriptar = new JButton("Encriptar");
        encriptar.setBounds(380, 130, 100, 20);
        super.add(encriptar);
        encriptar.addActionListener(new Encriptar(ruta, rutaArchivo, partes, nameArchivo));
        
        JLabel bvnDes = new JLabel("Desencriptar");
        bvnDes.setBounds(200, 200, 100, 20);
        super.add(bvnDes);
        
        JLabel elegir = new JLabel("Elegir archivos: ");
        elegir.setBounds(10, 290, 130, 20);
        super.add(elegir);
        
        JLabel rutaTexto = new JLabel("Ruta: ");
        rutaTexto.setBounds(10, 260, 50, 20);
        super.add(rutaTexto);
        
        rutaFinal = new JTextField();
        rutaFinal.setBounds(70, 260, 300, 20);
        super.add(rutaFinal);
        
        JButton elegirArchivos = new JButton("Seleccionar Archivos y Desencriptar");
        elegirArchivos.setBounds(150, 290, 300, 20);
        super.add(elegirArchivos);
        elegirArchivos.addActionListener(new ArchivosDesencriptar(rutaFinal));
        
        
        JLabel guardarTexto = new JLabel("Ruta a guardar el archivo: ");
        guardarTexto.setBounds(10, 230, 200, 20);
        super.add(guardarTexto);
        
        
        
        JButton botonSave = new JButton("...");
        botonSave.setBounds(220, 230, 20, 20);
        super.add(botonSave);
        botonSave.addActionListener(new SeleccionaRuta2(rutaFinal));
        
        JLabel myName = new JLabel("Alejandro García Guillén");
        myName.setBounds(10, 450, 200, 20);
        super.add(myName);
        
        
        super.setVisible(true);
        
    }
    
    public static void main(String[] args){
        
        VentanaAgencia v1 = new VentanaAgencia();
        
    }
    
}


class ArchivosDesencriptar implements ActionListener{

    private File[] files;
    private JTextField farc;

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
    
    public ArchivosDesencriptar(JTextField f){
        
        farc=f;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setMultiSelectionEnabled(true);
        fileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ret = fileOpen.showDialog(new JPanel(), "Seleccionar Archivos y Desencriptar");
        if (ret == JFileChooser.APPROVE_OPTION) {
            files = fileOpen.getSelectedFiles();
        }
        
        try {
            String a = farc.getText();
            EncriptarDesencriptar e1 = new EncriptarDesencriptar(files);
            e1.Desencriptar(a);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ArchivoInexistenteException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}

class SeleccionaArchivo implements ActionListener {
    
    private JTextField ruta;
    private JTextField name;
    
    public SeleccionaArchivo(JTextField r, JTextField aR){
        
        ruta = r;
        name = aR;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ret = fileOpen.showDialog(new JPanel(), "Seleecionar Archivo");
        if (ret == JFileChooser.APPROVE_OPTION) {
            ruta.setText(fileOpen.getSelectedFile().getPath());
            name.setText(fileOpen.getSelectedFile().getName());
        }
        
    }
     
}

class SeleccionaRuta implements ActionListener {
    
    private JTextField ruta;    
    
    public SeleccionaRuta(JTextField r){
        
        ruta = r;
        
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ret = fileOpen.showDialog(new JPanel(), "Seleecionar carpeta");
        if (ret == JFileChooser.APPROVE_OPTION) {
            ruta.setText(fileOpen.getSelectedFile().getPath());
        }
        
    }
     
}

class SeleccionaRuta2 implements ActionListener {
    
    private JTextField rutaFinal;    
    
    public SeleccionaRuta2(JTextField r){
        
        rutaFinal = r;
        
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ret = fileOpen.showDialog(new JPanel(), "Seleecionar carpeta");
        if (ret == JFileChooser.APPROVE_OPTION) {
            rutaFinal.setText(fileOpen.getSelectedFile().getPath());
        }
        
    }
     
}

class Encriptar implements ActionListener{
    
    private JTextField ruta;
    private JTextField rutaArchivo;
    private JTextField partes;
    private JTextField nameArchivo;
    
    public Encriptar(JTextField r, JTextField rA, JTextField p, JTextField aR){
        
        ruta = r;
        rutaArchivo = rA;
        partes = p;
        nameArchivo = aR;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            
            Integer numPart = Integer.parseInt(partes.getText());         
            
            EncriptarDesencriptar e1 = new EncriptarDesencriptar(rutaArchivo.getText());
            e1.encriptar(numPart, ruta.getText(),nameArchivo.getText());
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ArchivoInexistenteException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}