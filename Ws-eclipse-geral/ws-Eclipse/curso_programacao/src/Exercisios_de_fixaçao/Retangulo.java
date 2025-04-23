package Exercisios_de_fixaçao;

public class Retangulo {
		public double widht;
		public double height;
		
		
		public double Area() {
			return widht * height;
		}
		
		public double perimeter() {
			return 2*(widht + height);
		}
		
		public double Diagonal() {
			return Math.sqrt(Math.pow(widht,2) + Math.pow(height,2));
		}
		
		public void print() {
			System.out.printf("AREA = %.2f%nPERIMETER = %.2f%nDIAGONAL = %.2f%n", Area(),perimeter(),Diagonal());
					
		}
		
		
}
