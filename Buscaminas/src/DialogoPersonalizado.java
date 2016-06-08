
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class DialogoPersonalizado extends JDialog {
    
    private JTextField tFilas;
    private JTextField tColum;
    private JTextField tBomb;
    private Boolean canClose;
    private Integer f;
    private Integer c;
    private Integer b;

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
    
    
    public Boolean cerreComo(){
        
        return canClose;
        
    }
    
    
    
    ActionListener aceptarAc = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            
            f = Integer.parseInt(tFilas.getText());
            c = Integer.parseInt(tColum.getText());
            b = Integer.parseInt(tBomb.getText());
            
            canClose=true;
            
            if(b==0 || b>=((f*c)-10)){
                float dat = (f*c)*.10f;
                b=(int) dat;
            }
            
            if( f>=5 && c>=5){
                canClose=false;
            }else{
                JOptionPane.showMessageDialog(null,
                        "Campos Invalidos",
                            "Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            
            setVisible(canClose);
            
            
        }
    };
    
    ActionListener cancelarAc = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            
            setVisible(false);
            
        }
    };
    
    public DialogoPersonalizado(JFrame p){
        super(p,"Personalizado",true);
        super.setSize(300, 300);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        
        JLabel filas = new JLabel("Filas: ");
        filas.setBounds(20, 20, 50, 20);
        super.add(filas);
        
        tFilas = new JTextField("0");
        tFilas.setBounds(80, 20, 50, 20);
        super.add(tFilas);
        
        JLabel colum = new JLabel("Columnas: ");
        colum.setBounds(20, 50, 100, 20);
        super.add(colum);
        
        tColum = new JTextField("0");
        tColum.setBounds(130, 50, 50, 20);
        super.add(tColum);
        
        JLabel bomb = new JLabel("Bombas: ");
        bomb.setBounds(20, 80, 70, 20);
        super.add(bomb);
        
        tBomb = new JTextField("0");
        tBomb.setBounds(100, 80, 50, 20);
        super.add(tBomb);
        
        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(175, 200, 100, 30);
        aceptar.addActionListener(aceptarAc);
        super.add(aceptar);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(25, 200, 100, 30);
        cancelar.addActionListener(cancelarAc);
        super.add(cancelar);
        
        super.setVisible(true);
    }
    
}
