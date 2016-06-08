import java.util.ArrayList;
import java.util.Stack;


public class Postfijo {
	
	private Stack<String> operador = new Stack<String>();
	private ArrayList<String> postfijo = new ArrayList<String>();
	
	public ArrayList<String> infijoPostfijo(String c){
		
		c = "(" + c + ")";
		
		c = c.replaceAll("sin", "s,");
		c = c.replaceAll("cos", "c,");
		c = c.replaceAll("tan", "t,");
		c = c.replaceAll("log", "l,");
		c = c.replaceAll("sqrt", "q,");
		c = c.replaceAll("\\+", ",+,");
		c = c.replaceAll("\\-", ",-,");
		c = c.replaceAll("\\*", ",*,");
		c = c.replaceAll("/", ",/,");
		c = c.replaceAll("\\^", ",^,");
		c = c.replaceAll("\\)", ",),");
		c = c.replaceAll("\\(", ",(,");
		
		System.out.println(c);
		
		String[] c1 = c.split(",");
		
		for(int i=0; i<c1.length; i++){
			
			String v = c1[i];
			
			
			if(v.equals("(")){
				
				operador.add("(");
				
			}else if(v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/") || v.equals("^")|| v.equals("s")|| v.equals("c")|| v.equals("t")|| v.equals("l")|| v.equals("q")){
				
				Boolean des = operador.empty();
				if(!des){
					
					int tmp = verifica(v);
					Boolean bandera = true;
					while(bandera){
						
						String s = operador.peek();
						int x = verifica(s);
						if(tmp <= x){

							System.out.println("Guardado: " + s);
							
							postfijo.add(s);
							operador.pop();
						
						}else{
							
							
							operador.add("" + v);
							bandera = false;
							
						}
						
					}
				
				}else{
					
					operador.add("" + v);
					
				}
				
			}else if(v.equals(")")){
				
				while(!operador.peek().equals("(")){
				
					
					
					String tmp = operador.peek();
					postfijo.add(tmp);
					System.out.println("Guardado: " + tmp);
					operador.pop();
				
				}
				operador.pop();
				
			}else if(!v.equals("")){
				
				System.out.println("Guardado: " + v);
				
				postfijo.add(v);
				
			}		
			
		}
		
		while(!operador.empty()){
			
			postfijo.add(operador.peek());
			operador.pop();
			
		}
		
		return postfijo;
		
	}
	
	public Integer verifica(String v){
		
		int com=0;
		
		
		if(v.equals("s")|| v.equals("c")|| v.equals("t")|| v.equals("l")) com = 5;
		if(v.equals("^")|| v.equals("q")) com = 4;
		if(v.equals("*") || v.equals("/")) com = 3;
		if(v.equals("+") || v.equals("-")) com = 2;
		if(v.equals("(") || v.equals(")")) com = 1;
		
		return com;
		
	}

}
