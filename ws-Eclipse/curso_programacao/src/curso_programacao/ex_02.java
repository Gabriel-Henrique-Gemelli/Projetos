package curso_programacao;

import java.util.Scanner;

public class ex_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double pi = 3.14159;
		
		float raio = sc.nextFloat();
		
		
		double area = pi * Math.pow(raio, 2);
		
		System.out.printf("A=%.4f", area);
		
	}
}
