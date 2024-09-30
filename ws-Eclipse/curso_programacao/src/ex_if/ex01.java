package ex_if;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Valor = sc.nextInt();
		
		if (Valor < 0) {
			System.out.println("Valor negativo");
			
		}
		else {
			System.out.println("Valor positivo");
		}
	}

}
