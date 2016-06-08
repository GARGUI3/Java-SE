
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
public class DialogoAcerca extends JDialog {
    
    ActionListener oka = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    public DialogoAcerca(JFrame f){
        
        super(f,"Acerca de",true);
        super.setLayout(null);
        super.setSize(400, 400);
        
        JLabel titulo = new JLabel("Buscaminas desarrollado por Alejandro García");
        titulo.setBounds(10, 10, 400, 20);
        super.add(titulo);
        
        JLabel acerca = new JLabel("Guillén");
        acerca.setBounds(10, 30, 300, 20);
        super.add(acerca);
        
        JLabel de = new JLabel("Simbolos");
        de.setBounds(100, 60, 150, 20);
        super.add(de);
        
        JLabel b = new JLabel("b - Bomba no detectada");
        b.setBounds(10, 90, 300, 20);
        super.add(b);
        
        JLabel bD = new JLabel("bD - Bomba Detectada");
        bD.setBounds(10, 120, 300, 20);
        super.add(bD);
        
        JLabel bC = new JLabel("bC - Bomba casi detectada");
        bC.setBounds(10, 150, 300, 20);
        super.add(bC);
        
        JLabel ban = new JLabel("B - Bandera colocada en el boton");
        ban.setBounds(10, 180, 300, 20);
        super.add(ban);
        
        JLabel inte = new JLabel("? - Interrogacion colocada en el boton");
        inte.setBounds(10, 210, 300, 20);
        super.add(inte);
        
        JLabel salir = new JLabel("Al dar click en salir guardara tu configuracion");
        salir.setBounds(10, 240, 400, 20);
        super.add(salir);
        
        JButton ok = new JButton("Ok");
        ok.setBounds(120, 300, 150, 30);
        ok.addActionListener(oka);
        super.add(ok);
        
        super.setVisible(true);
        
    }
    
}
