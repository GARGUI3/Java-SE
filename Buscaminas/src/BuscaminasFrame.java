
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class BuscaminasFrame extends JFrame {
    
    public BuscaminasFrame() throws IOException, ArchivoInexistenteException{
        
        super("Buscaminas");
        
        Menu panel = new Menu(this);
        
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.add(panel, BorderLayout.CENTER);
        super.setSize(550, 550);

        
        
        super.setVisible(true);
        
    }
    
    public static void main(String[] args) throws IOException, ArchivoInexistenteException{
        
        BuscaminasFrame b1 = new BuscaminasFrame();
        
    }
    
}
