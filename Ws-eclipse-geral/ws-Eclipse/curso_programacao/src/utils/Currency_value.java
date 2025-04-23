package utils;

public class Currency_value {
	public static double CalculoDeIOF(double dolar, double valor) {
		double TotalImposto = (dolar * valor ) * 0.06;
		
		return TotalImposto + (dolar * valor);
	}
}
