import java.util.ArrayList;
import java.util.Stack;


public class Ecuacion {
	
	private Stack<Double> pila = new Stack<Double>();
	private Double suma;
	
	public Double resolver(ArrayList<String> c, double x, double y){
		
		for(int i=0; i<c.size(); i++){
			
			String a = c.get(i);
			
			if(a.equals("x") || a.equals("X")){
				a = "" + x;
			}else if(a.equals("y") || a.equals("Y")){
				a = "" + y;
			}
			
			
			if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") || a.equals("^")|| a.equals("s")|| a.equals("c")|| a.equals("t")|| a.equals("l")|| a.equals("q")){
				
				Double n1 = pila.peek();
                pila.pop();
                
                Double n2 = 0.0;

				switch(a){
		            case "+":
		            	
		            	n2 = pila.peek();
		                pila.pop();
		            	
		                suma=n2+n1;
		                pila.add(suma);
		             break;
		            case "-":
		            	
		            	n2 = pila.peek();
		                pila.pop();
		            	
		                suma=n2-n1;
		                pila.add(suma);
		             break;

		             case "*":
		            	 
		            	n2 = pila.peek();
		                pila.pop(); 
		            	 
		                suma=n2*n1;
		                pila.add(suma);
		             break;

		             case "/":
		            	
		            	n2 = pila.peek();
		                pila.pop();
		            	 
		                suma=n2/n1;
		                pila.add(suma);
		             break;
		             
		             case "^":
			            	
		            	 n2 = pila.peek();
			             pila.pop();
			            	 
			             suma=Math.pow(n2, n1);
			             pila.add(suma);
			         break;
			         
		             case "q":
			            	 
			             suma=Math.sqrt(n1);
			             pila.add(suma);
			         break;
		             
		             case "s":
		            	 suma=Math.sin(n1);
			             pila.add(suma);
			         break;
			         
		             case "c":
		            	 suma=Math.cos(n1);
			             pila.add(suma);
			         break;
			         
		             case "t":
		            	 suma=Math.tan(n1);
			             pila.add(suma);
			         break;
			         
		             case "l":
		            	 suma=Math.log(n1);
			             pila.add(suma);
			         break;
		             
		        }



		     }else {
		    	 Double v = Double.parseDouble(a);
		      	 pila.add(v);
		     }
			
		}
		
		return pila.peek();
		
	}

}
