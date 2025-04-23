package curso_programacao;

import java.util.Scanner;

public class ex_03 {
	public static void main(String[] args) {
		int a,b,c,d,formula;
		
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		formula = a * b - c * d;
		
		System.out.printf("DIFERENCA = %d",formula);
		
	}
}
