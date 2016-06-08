
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class DialogoGuardarScore extends JDialog {
    
    private JTextField tName;
    private String[] scoreName = new String[5];
    private Integer[] scoreP = new Integer[5];
    private Integer sC;
    
    ActionListener scores = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            int bandera=0;
            for(int i=0;i<5;i++){
                if(sC>=scoreP[i]){
                    if (i<4) {
                        int aux=scoreP[i];
                        String auxn = scoreName[i];
                        scoreP[i]=sC;
                        scoreName[i]=tName.getText();
                        for (int j = i+1; j < 5; j++) {
                            int aux2=scoreP[j];
                            scoreP[j]=aux;
                            aux=aux2;
                            String auxn2=scoreName[j];
                            scoreName[j]=auxn;
                            auxn=auxn2;
                        }
                        bandera=1;
                    }else if(i==4){
                        scoreP[i]=sC;
                        scoreName[i]=tName.getText();
                    }  
                    
                    if(bandera==1)break;
                }
            }
            try {
                escribir();
            } catch (IOException ex) {

            } catch (ArchivoInexistenteException ex) {

            }
            setVisible(false);
        }
    };
    
    ActionListener cancelar = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    public void escribir() throws IOException, ArchivoInexistenteException{
        
        TextFile t = new TextFile("score.bscData", Apertura.REWRITE, false);
        for (int i = 0; i < 5; i++) {
            t.writeLn(scoreP[i]);
            t.writeLn(scoreName[i]);
        }
        t.cerrarArchivo();
        
    }
    
    public DialogoGuardarScore(JFrame f, String a,Integer s){
        
        super(f,a,true);
        super.setLayout(null);
        super.setSize(400, 200);
        
        sC=s;
        
        JLabel name = new JLabel("Nombre: ");
        name.setBounds(10, 20, 70, 20);
        super.add(name);
        
        tName = new JTextField("Jugador");
        tName.setBounds(90, 20, 200, 20);
        super.add(tName);
        
        JLabel score = new JLabel("Score: " + s);
        score.setBounds(10, 50, 150, 20);
        super.add(score);
        
        try {
                TextFile t = new TextFile("score.bscData", Apertura.READ, false);
                String strLinea = t.readLn();
                scoreP[0] = Integer.valueOf(strLinea);
                strLinea = t.readLn();
                scoreName[0] = strLinea;
                strLinea = t.readLn();
                scoreP[1] = Integer.valueOf(strLinea);
                strLinea = t.readLn();
                scoreName[1] = strLinea;
                strLinea = t.readLn();
                scoreP[2] = Integer.valueOf(strLinea);
                strLinea = t.readLn();
                scoreName[2] = strLinea;
                strLinea = t.readLn();
                scoreP[3] = Integer.valueOf(strLinea);
                strLinea = t.readLn();
                scoreName[3] = strLinea;
                strLinea = t.readLn();
                scoreP[4] = Integer.valueOf(strLinea);
                strLinea = t.readLn();
                scoreName[4] = strLinea;
                t.cerrarArchivo();
        } catch (IOException ex) {
            
        } catch (ArchivoInexistenteException ex) {
            
        }
        
        JButton ok = new JButton("Aceptar");
        ok.setBounds(250, 140, 100, 30);
        ok.addActionListener(scores);
        super.add(ok);
        
        JButton cancel = new JButton("Cancelar");
        cancel.setBounds(30, 140, 100, 30);
        cancel.addActionListener(cancelar);
        super.add(cancel);
        
        super.setVisible(true);
    }
    
}
