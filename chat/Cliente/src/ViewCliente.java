
import java.awt.BorderLayout;
import javax.swing.JFrame;
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
public class ViewCliente extends JFrame {
    
    public ViewCliente(){
        
        super("Chat");
        
        MenuCliente panel = new MenuCliente(this);
        
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.add(panel, BorderLayout.CENTER);
        super.setSize(550, 550);
        
        super.setVisible(true);
        
    }
    
    public static void main(String[] args){
        new ViewCliente();
    }
    
}
