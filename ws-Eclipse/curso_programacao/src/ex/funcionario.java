package ex;

public class funcionario {
	public String Name;
	public double GrossSalary;
	public double Tax;
	
	public double NetSalary() {
		return GrossSalary - Tax;
	}
	
	public double increaseSalary(double percentage) {
		double a = (percentage/100) * GrossSalary;
		
		return (GrossSalary += a) - Tax;
		
		
	}
	
	
}
