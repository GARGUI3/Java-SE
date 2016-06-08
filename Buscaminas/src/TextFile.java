/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 *
 * @author gargui3
 */
public class TextFile {

    private File file;
    private Apertura type;
    private FileInputStream reader;
    private FileOutputStream writer;
    
    public TextFile( String nameFile, Apertura type, Boolean forzar) throws IOException, ArchivoInexistenteException{
        file = new File(nameFile);
        if (!file.exists()){
            if (forzar) {
                file.createNewFile();
            }else 
                throw new ArchivoInexistenteException("El archivo no existe");
        }  
        this.type=type;
        switch (type){
            case READ:
                reader = new FileInputStream(file);
                break;
            case REWRITE:
                writer = new FileOutputStream(file);
                break;
            case APPEND:
                writer = new FileOutputStream(file, true);
                break;
            default:
                break;
        }
    }
    
    public void write( String palabra)throws IOException {
        writer.write(palabra.getBytes());
    }
    
    public void write( SpecialChar c)throws IOException {
        writer.write(c.getBytes());
    }
    
    public void writeLn( String s)throws IOException {
        write(s);
        write(SpecialChar.ENTER);
    }
    
    public void write(Integer i)throws IOException {
        writer.write(i.toString().getBytes());
    }
    public void writeLn(Integer i)throws IOException {
        writer.write(i.toString().getBytes());
        write(SpecialChar.ENTER);
    }
    
    public String readLn()throws IOException {
        int dato = 0;
        String r = "";
        while(!eof() && ((dato = reader.read()) != 10) ){
            r += (char) dato;
        }
        return r;
    }
    
    public void cerrarArchivo()throws IOException{
        if(type ==Apertura.READ){
            reader.close();
        }else{
            writer.close();
        }
    }
    
    
    public Boolean eof()throws IOException {
        return reader.available() > 0 ? false : true;
        
    }
    
}

enum Apertura{
    REWRITE, 
    READ,
    APPEND,
    EDIT
}

enum SpecialChar{
    ENTER("\n"),
    ESPACIO(" "),
    TABULADOR("\t"),
    COMILLAS("\""),
    APOSROFE("\'"),
    DIAGONAL_INVERTIDA("\\");
    
    private String formato;
    
    private SpecialChar(String formato){
        this.formato = formato;
    }
    
    public byte[] getBytes(){
        return formato.getBytes();
    }
}