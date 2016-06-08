
public interface Matriz {
	
	public double[] trasladar(double[] puntoInicial, double[] vectorTraslacion);
	public double[] escalar(double[] puntoInicial, int dimension, double k);
	public double[] rotar(double[] puntoInicial, int dimension, double g);
	public double[] transformada(double[] punto, double g);
	public double[] trasladarR3(double[] p, double[] t);
	public double[] escalarR3(double[] p, double k);
	public double[] rotarR3(double[] p, double g, int e);

}
