package curso_programacao;

import java.util.Scanner;

public class Ex_01 {

	public static void main(String[] args) {
		int num1,num2, soma;
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		soma = num1 + num2;
		
		System.out.println(soma);

	}

}
