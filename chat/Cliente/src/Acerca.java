
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Acerca extends JDialog {
    
    ActionListener close = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    public Acerca(JFrame f){
        
        super(f,"Acerca de", true);
        super.setLayout(null);
        super.setSize(400, 120);
        
        JLabel txtName = new JLabel("Elaborado por: Alejandro García Guillén");
        txtName.setBounds(50, 10, 300, 20);
        super.add(txtName);
        
        JButton cerrar = new JButton("Cerrar");
        cerrar.setBounds(150, 50, 100, 20);
        cerrar.addActionListener(close);
        super.add(cerrar);
        
        super.setVisible(true);
        
    }
    
}
