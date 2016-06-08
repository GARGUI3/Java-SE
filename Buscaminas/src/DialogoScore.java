
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gargui3
 */
public class DialogoScore extends JDialog {
    
    ActionListener cerrar = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    public DialogoScore(JFrame f){

        super(f,"Scores", true);
        super.setLayout(null);
        super.setSize(400, 400);
        
        try {
                TextFile t = new TextFile("score.bscData", Apertura.READ, false);
                String pun = t.readLn();
                String name = t.readLn();
                JLabel num1 = new JLabel("1.- " + name + " " + pun);
                num1.setBounds(10, 10, 300, 20);
                super.add(num1);
                
                pun = t.readLn();
                name = t.readLn();
                JLabel num2 = new JLabel("2.- " + name + " " + pun);
                num2.setBounds(10, 40, 300, 20);
                super.add(num2);
                
                pun = t.readLn();
                name = t.readLn();
                JLabel num3 = new JLabel("3.- " + name + " " + pun);
                num3.setBounds(10, 70, 300, 20);
                super.add(num3);
                
                pun = t.readLn();
                name = t.readLn();
                JLabel num4 = new JLabel("4.- " + name + " " + pun);
                num4.setBounds(10, 100, 300, 20);
                super.add(num4);
                
                pun = t.readLn();
                name = t.readLn();
                JLabel num5 = new JLabel("5.- " + name + " " + pun);
                num5.setBounds(10, 130, 300, 20);
                super.add(num5);
                
                JButton ok = new JButton("Ok");
                ok.setBounds(150, 300, 100, 30);
                ok.addActionListener(cerrar);
                super.add(ok);
                
                t.cerrarArchivo();
        } catch (IOException ex) {
            
        } catch (ArchivoInexistenteException ex) {
            
        }
        
        super.setVisible(true);
    }
    
}
