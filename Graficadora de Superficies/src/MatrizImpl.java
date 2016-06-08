
public class MatrizImpl implements Matriz {


	@Override
	public double[] trasladar(double[] puntoInicial, double[] vectorTraslacion){
		
		double[] trasladado = {puntoInicial[0] + vectorTraslacion[0], puntoInicial[1] + vectorTraslacion[1]};
		
		return trasladado;	
		
	}

	@Override
	public double[] escalar(double[] puntoInicial, int dimension, double k) {
		
		double x=0;
		double y=0;
		double z=0;
		double[] f = {0,0,0};
		
		if(dimension == 2){
			x = (puntoInicial[0]*k);
			y = (puntoInicial[1]*k);
			f[0]=x;
			f[1]=y;
		}else if(dimension == 3){
			
			System.out.println("Por el momento no existe esta opcion");
			
		}
		
		return f;
	}

	@Override
	public double[] rotar(double[] puntoInicial, int dimension, double g) {

		double x=0;
		double y=0;
		double z=0;
		double[] f = {0,0,0};
		
		if(dimension == 2){
			x =  ((puntoInicial[0]*Math.cos(Math.toRadians(g)))+(puntoInicial[1]*(Math.sin(Math.toRadians(g))*-1)));
			y =  ((puntoInicial[0]*Math.sin(Math.toRadians(g)))+(puntoInicial[1]*Math.cos(Math.toRadians(g))));
			f[0]=x;
			f[1]=y;
		}else if(dimension == 3){
			
			System.out.println("Por el momento no existe esta opcion");
			
		}
		
		return f;
		
	}

	public double[] transformada(double[] punto, double g){
		
		double l = .6;
		
		double x = punto[1]+(-l*punto[0]*Math.sin(Math.toRadians(g)));
		
		double y = punto[2]+(l*punto[0]*Math.cos(Math.toRadians(g)));
		
		double[] tmp = {x, y};
		
		return tmp;		
		
	}

	@Override
	public double[] trasladarR3(double[] p, double[] t) {
		double x = p[0] + t[0];
		double y = p[1] + t[1];
		double z = p[2] + t[2];
		
		double[] tmp = {x,y,z};
		
		return tmp;
	}

	@Override
	public double[] escalarR3(double[] p, double k) {
		double x = p[0] * k;
		double y = p[1] * k;
		double z = p[2] * k;
		
		double[] tmp = {x,y,z};
		
		return tmp;
	}

	@Override
	public double[] rotarR3(double[] p, double g, int e) {
		
		double x=0;
		double y=0;
		double z=0;
		
		if(e==1){
			
			x = p[0];
			y = ((Math.cos(Math.toRadians(g)) * p[1]) + (Math.sin(Math.toRadians(g)) * p[2]));
			z = ((-Math.sin(Math.toRadians(g)) * p[1]) + (Math.cos(Math.toRadians(g)) * p[2]));
			
		}else if(e==2){
			
			x = ((Math.cos(Math.toRadians(g)) * p[0]) + (Math.sin(Math.toRadians(g)) * p[2]));
			y = p[1];
			z = ((-Math.sin(Math.toRadians(g)) * p[0]) + (Math.cos(Math.toRadians(g)) * p[2]));
			
		}else if(e==3){
			
			x = ((Math.cos(Math.toRadians(g)) * p[0]) + (Math.sin(Math.toRadians(g)) * p[1]));
			y = ((-Math.sin(Math.toRadians(g)) * p[0]) + (Math.cos(Math.toRadians(g)) * p[1]));
			z = p[2];
			
		}
		
		double[] tmp = {x,y,z};
		
		return tmp;
	}
	
	

}
