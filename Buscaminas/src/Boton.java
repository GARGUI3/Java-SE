
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
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
public class Boton extends JButton implements ActionListener, MouseListener {

    private Integer estado=0;
    private Integer cont=0;
    private Integer x;
    private Integer y;
    private CrearTablero n2;
    private Boton[][] m1;
    private JLabel[][] l1;
    private Integer fil;
    private Integer col;
    private static Integer check[][];
    private Integer Bom=0;
    private Integer bombas;
    private JFrame fr;
    private JButton fa;
    
    public Boton(){
        
    }
   
    public Boton(Integer i, Integer j, CrearTablero n1, Boton[][] m,Integer f,Integer c,JLabel[][] l, Integer b, JFrame fe, JButton face){
        x=i;
        y=j;
        n2=n1;
        m1=m;
        fil=f;
        col=c;
        l1=l;
        check = new Integer[f][c];
        bombas=b;
        fr=fe;
        fa=face;
        for (int k = 0; k < fil; k++) {
            for (int n = 0; n < col; n++) {
                check[k][n]=0;
            }
        }
        super.addActionListener(this);
        super.addMouseListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(estado==0){
            if(n2.comprobar(x, y)){
                for (int i = 0; i < fil; i++) {
                    for (int j = 0; j < col; j++) {
                        m1[i][j].setVisible(false);
                    }
                }
                fa.setText(":(");
                DialogoGuardarScore g = new DialogoGuardarScore(fr,"Perdiste!",n2.getScore());
            }else if(n2.isCero(x, y)){
                setVisible(false);
                expander(x-1,y-1);
                check[x-1][y-1]=1;
            }else if("1".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.BLUE);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("2".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.GREEN);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("3".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.ORANGE);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("4".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.MAGENTA);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("5".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.PINK);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("6".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.RED);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("7".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.CYAN);
                check[x-1][y-1]=1;
                setVisible(false);
            }else if("8".equals(l1[x-1][y-1].getText())){
                l1[x-1][y-1].setForeground(Color.YELLOW);
                check[x-1][y-1]=1;
                setVisible(false);
            }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(fil>10){
            setFont(new java.awt.Font("Arial", 0, 3));
        }else{
            setFont(new java.awt.Font("Arial", 0, 8));
        }
        if((me.getModifiers()==4)&&(super.isEnabled())){
            if(cont==0){              
                setText("B");
                if(n2.comprobar(x, y)){
                    l1[x-1][y-1].setText("bD");
                    check[x-1][y-1]=2;
                    Bom=n2.mas();
                    n2.setScore(n2.getScore()+10);
                }
                if(Bom==bombas-1){
                    for (int i = 0; i < fil; i++) {
                        for (int j = 0; j < col; j++) {
                            m1[i][j].setVisible(false);
                            if("1".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.BLUE);
                            }else if("2".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.GREEN);
                            }else if("3".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.ORANGE);
                            }else if("4".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.MAGENTA);
                            }else if("5".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.PINK);
                            }else if("6".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.RED);
                            }else if("7".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.CYAN);
                            }else if("8".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.YELLOW);
                            }
                        }
                    }
                    
                    DialogoGuardarScore g = new DialogoGuardarScore(fr,"Ganaste!",n2.getScore());
                }
                estado=1;
                cont=1;
            }else if(cont==1){
                setText("?");
                if(n2.comprobar(x, y)){
                    l1[x-1][y-1].setText("bC");
                    check[x-1][y-1]=3;
                    Bom=n2.menos();
                    n2.setScore(n2.getScore()-10);
                }
                estado=2;
                cont=2;
            }else if(cont==2){
                setText("");  
                if(n2.comprobar(x, y)){
                    l1[x-1][y-1].setText("b");
                    check[x-1][y-1]=0;
                }
                estado=0;
                cont=0;
            }
         }
    }
    
    public void expander(Integer a, Integer b){
            for (int i = a-1; i <= a+1; i++) {
                for (int j = b-1; j <= b+1; j++) {
                    if(!(i==a && j==b)){
                        if((i >= 0 && i < fil) && (j >= 0 && j < col )){
                            if(n2.isCero(i+1, j+1) && check[i][j]==0){
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                                expander(i,j);
                            }else if("1".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.BLUE);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("2".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.GREEN);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("3".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.ORANGE);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("4".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.MAGENTA);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("5".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.PINK);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("6".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.RED);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("7".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.CYAN);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }else if("8".equals(l1[i][j].getText())){
                                l1[i][j].setForeground(Color.YELLOW);
                                check[i][j]=1;
                                m1[i][j].setVisible(false);
                            }
                        }
                    }
                }
            }
    }
    
    public static Integer valorCheck(Integer i, Integer j){
        return check[i][j];
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
