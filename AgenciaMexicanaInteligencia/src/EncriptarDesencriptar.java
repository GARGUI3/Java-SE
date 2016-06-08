
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gargui3
 */
public class EncriptarDesencriptar {
    
    private ArrayList<TextFile> archivos = new ArrayList<TextFile>();
    private ArrayList<TextFile> archivosDes = new ArrayList<TextFile>();
    private File[] files;
    private TextFile[] docs;
    private TextFile t;
    
    public EncriptarDesencriptar(String ruta) throws IOException{
        
        try{
           t = new TextFile(ruta, Apertura.READ, false);
            
        }catch(ArchivoInexistenteException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public EncriptarDesencriptar(File[] f) throws IOException{
        
        files = f;
        for (int i = 0; i < files.length; i++) {
            try{
                String r = files[i].toString();
                archivosDes.add(new TextFile(r, Apertura.READ, false));

            }catch(ArchivoInexistenteException ex){
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    public void Desencriptar(String e) throws IOException, ArchivoInexistenteException{
        
        int j=0;
        String name="";
        
        docs = new TextFile[archivosDes.size()];
        
        for (int i = 0; i < archivosDes.size(); i++) {
            
            j=Integer.parseInt(archivosDes.get(i).readLn());
            String r = files[i].toString();
            docs[j]=new TextFile(r, Apertura.READ, false);
            archivosDes.get(i).cerrarArchivo();
            
        }
        
        
        for (int i = 0; i < docs.length; i++) {
            
            docs[i].readLn();
            
            name = docs[i].readLn();
            
        }
        
        e+="/"+name;
        
        TextFile original = new TextFile(e,Apertura.REWRITE, true);
        int i=0;
        
        while(!docs[i].eof()){
            byte tem=docs[i].read();
            original.write(tem);
            i++;
            if (i==docs.length){
                i=0;
            }
        }
        
        original.cerrarArchivo();
        
    }
    
    public void encriptar(Integer numArchivo, String ruta, String name) throws IOException, ArchivoInexistenteException{
        
        for (int i = 1; i <= numArchivo; i++) {
            
            String r = "/Archivo" + i + ".gargui3";
            
            archivos.add(new TextFile(ruta + r, Apertura.REWRITE, true));
            
        }
        
        int i=0;
        
        for (int k = 0; k < numArchivo; k++) {
            archivos.get(k).writeLn(k);
            archivos.get(k).writeLn(name);
        }
        
        int j=0;
        
        while (! t.eof()) {
            archivos.get(j).write((byte) t.read());
            j++;
            if (j == archivos.size())
                j = 0;
        }
        
        for (int k = 0; k < numArchivo; k++) {
            archivos.get(k).cerrarArchivo();
        }
        t.cerrarArchivo();
        t.borrarArchivo();
        
    }
    
}
