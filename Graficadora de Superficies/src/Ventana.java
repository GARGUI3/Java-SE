import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class Ventana extends JFrame {
	
	public static final int escala = 10;
	public JFrame f;
	public JTextField txtNodos;
	public JPanel p;
	public ArrayList<JTextField> x = new ArrayList<JTextField>();
	public ArrayList<JTextField> y = new ArrayList<JTextField>();
	
	public double matrizXR2[][];
	public double matrizYR2[][];
	
	public double matrizXR3[][];
	public double matrizYR3[][];
	public double matrizZR3[][];
	
	public int tamX=0;
	public int tamY=0;
	
	MatrizImpl m = new MatrizImpl();
	Postfijo p1 = new Postfijo();
	Ecuacion e = new Ecuacion();
	
	ActionListener grafica = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ArrayList<String> tmp = p1.infijoPostfijo(txtNodos.getText());
			
			int itX = 0;
			int itY = 0;
			
			int xmin = Integer.parseInt(x.get(0).getText());
			int xmax = Integer.parseInt(y.get(0).getText());
			
			int ymin = Integer.parseInt(x.get(1).getText());
			int ymax = Integer.parseInt(y.get(1).getText());
			
			int zmin = Integer.parseInt(x.get(2).getText());
			int zmax = Integer.parseInt(y.get(2).getText());
			
			tamX =(int) -((xmin+(-xmax))/0.3); 
			tamY =(int) -((ymin+(-ymax))/0.3);
			
			matrizXR2 = new double[tamX+1][tamY+1];
			matrizYR2 = new double[tamX+1][tamY+1];
			
			matrizXR3 = new double[tamX+1][tamY+1];
			matrizYR3 = new double[tamX+1][tamY+1];
			matrizZR3 = new double[tamX+1][tamY+1];
			
			System.out.println(tamX);
			System.out.println(tamY);
			
			
			for (double i = xmin; i < xmax; i = i + 0.3) {
				for (double j = ymin; j < ymax; j = j + 0.3) {
					
					double z = e.resolver(tmp, i, j);
					if(z>=zmin && z<=zmax){
						double[] pInicial = {i,j,z};
						double[] pFinal = m.transformada(pInicial, 135);
						matrizXR2[itX][itY] = pFinal[0];
						matrizYR2[itX][itY] = pFinal[1];
						
						matrizXR3[itX][itY] = i;
						matrizYR3[itX][itY] = j;
						matrizZR3[itX][itY] = z;
						
					}else {
						matrizXR2[itX][itY] = -1000;
						matrizYR2[itX][itY] = -1000;
						
						matrizXR3[itX][itY] = -1000;
						matrizYR3[itX][itY] = -1000;
						matrizZR3[itX][itY] = -1000;
						
					}
					
					itY++;
				}
				itX++;
				itY = 0;
			}
			
			JButton tT = new JButton("Rotar Z");
			tT.setBounds(350, 20, 100, 30);
			tT.addActionListener(rotarZ);
			f.add(tT);

			JButton tL = new JButton("Rotar Y");
			tL.setBounds(300, 50, 100, 30);
			tL.addActionListener(rotarY);
			f.add(tL);

			JButton tR = new JButton("Rotar X");
			tR.setBounds(400, 50, 100, 30);
			tR.addActionListener(rotarX);
			f.add(tR);
			

			Graphics g = f.getGraphics();

			paint(g);

		}	
		
	};
	
	public void rotandoR3(int e){
		
		for (int i = 0; i < tamX+1; i++) {
			for (int j = 0; j < tamY+1; j++) {
				
				if(matrizXR3[i][j]!=-1000 && matrizYR3[i][j]!=-1000 && matrizZR3[i][j] != -1000){
					double[] pInicial = {matrizXR3[i][j],matrizYR3[i][j],matrizZR3[i][j]};
					double[] pRotado = m.rotarR3(pInicial, 10, e);
					double[] pFinal = m.transformada(pRotado, 135);
					matrizXR2[i][j] = pFinal[0];
					matrizYR2[i][j] = pFinal[1];
					
					matrizXR3[i][j] = pRotado[0];
					matrizYR3[i][j] = pRotado[1];
					matrizZR3[i][j] = pRotado[2];
					
				}else {
					matrizXR2[i][j] = -1000;
					matrizYR2[i][j] = -1000;
					
					matrizXR3[i][j] = -1000;
					matrizYR3[i][j] = -1000;
					matrizZR3[i][j] = -1000;
					
				}
				
			}
		}
		
	}
	
	ActionListener rotarZ = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			rotandoR3(3);
			
			Graphics g = f.getGraphics();

			paint(g);
			
		}
		
	};
	
	ActionListener rotarY = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			rotandoR3(2);
			
			Graphics g = f.getGraphics();

			paint(g);
			
		}
		
	};
	
	ActionListener rotarX = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			rotandoR3(1);
			
			Graphics g = f.getGraphics();

			paint(g);
			
		}
		
	};
	
	
	public Ventana(){
		
		f = this;
		
		f.setTitle("Graficadora de Superficies");
		
		Border b = new TitledBorder("Datos");
		
		p = new JPanel();
		p.setBounds(10, 10, 280, 680);
		p.setLayout(null);
		p.setBorder(b);
		add(p);

		JLabel lbl = new JLabel("Ingresa la ecuacion a graficar");
		lbl.setBounds(20, 20, 220, 20);
		p.add(lbl);
		
		JLabel lbl2 = new JLabel("Z=");
		lbl2.setBounds(20, 60, 30, 20);
		p.add(lbl2);
		
		txtNodos = new JTextField("0");
		txtNodos.setBounds(50, 60, 200, 20);
		p.add(txtNodos);
		
		JLabel lblN = new JLabel("Ingresa los minimos y maximos");
		lblN.setBounds(20, 100, 220, 20);
		p.add(lblN);
		
		JLabel lblN2 = new JLabel("que van a ser graficados");
		lblN2.setBounds(20, 120, 220, 20);
		p.add(lblN2);
		
		String[] var = {"X","Y","Z"};
		
		for (int i = 0; i < 3; i++) {
			
			JLabel lblX = new JLabel(var[i]+" - MIN:");
			lblX.setBounds(20, 150+(30*i), 100, 20);
			p.add(lblX);
			
			JTextField txtX = new JTextField("0");
			txtX.setBounds(80, 150+(30*i), 50, 20);
			p.add(txtX);
		
			JLabel lblY = new JLabel(var[i]+" - MAX:");
			lblY.setBounds(140, 150+(30*i), 100, 20);
			p.add(lblY);
			
			JTextField txtY = new JTextField("0");
			txtY.setBounds(200, 150+(30*i), 50, 20);
			p.add(txtY);
			
			x.add(txtX);
			y.add(txtY);
			
		}
		
		JButton graficar = new JButton("Graficar");
		graficar.setBounds(140, 160+(30*3), 100, 20);
		graficar.addActionListener(grafica);
		p.add(graficar);

	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		g.drawLine(coordx(0), coordy(0), coordx(32), coordy(0)); //eje Y
		
		g.drawLine(coordx(0), coordy(0), coordx(0), coordy(24)); //eje Z
		
		g.drawLine(coordx(0), coordy(0), coordx(-20), coordy(-20)); //eje X
		
		
		g.setColor(Color.BLUE);
		if(matrizXR2 != null){
			for (int i = 0; i < tamX; i++) {
				for (int j = 0; j < tamY; j++) {
					
					if(matrizXR2[i][j] != -1000 && matrizXR2[i][j+1] != -1000 && matrizXR2[i+1][j] != -1000){
						g.drawLine(coordx(matrizXR2[i][j]), coordy(matrizYR2[i][j]), coordx(matrizXR2[i][j+1]), coordy(matrizYR2[i][j+1]));
						g.drawLine(coordx(matrizXR2[i][j]), coordy(matrizYR2[i][j]), coordx(matrizXR2[i+1][j]), coordy(matrizYR2[i+1][j]));
					}
				}
			}
		}
		
		
		
	}
	
	public int coordx(double x) {

		return (int) (680 + (x*escala));

	}

	public int coordy(double y) {

		return (int) (360 - (y*escala));

	}
	

}
