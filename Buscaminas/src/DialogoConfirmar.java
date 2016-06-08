
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
public class DialogoConfirmar extends JDialog {
    
    private Boolean opc=false;

    public Boolean isOpc() {
        return opc;
    }

    public void setOpc(Boolean opc) {
        this.opc = opc;
    }
    
    
    
    ActionListener oka = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            opc=true;
            setVisible(false);
        }
    };
    
    ActionListener cancelar = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    public DialogoConfirmar(JFrame f){
        
        super(f,"Salir",true);
        super.setLayout(null);
        super.setSize(400, 200);
        
        JLabel answer = new JLabel("¿Desea Salir?");
        answer.setBounds(150, 5, 100, 100);
        super.add(answer);
        
        JButton ok = new JButton("Aceptar");
        ok.setBounds(250, 120, 100, 30);
        ok.addActionListener(oka);
        super.add(ok);
        
        JButton cancel = new JButton("Cancelar");
        cancel.setBounds(50, 120, 100, 30);
        cancel.addActionListener(cancelar);
        super.add(cancel);
        
        super.setVisible(true);
        
    }
    
}
