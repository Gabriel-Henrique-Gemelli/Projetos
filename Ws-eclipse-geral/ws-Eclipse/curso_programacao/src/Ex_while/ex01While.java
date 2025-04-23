package Ex_while;

import java.util.Scanner;

public class ex01While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int acertou = 0;

		while (acertou == 0) {
			int senha = 210;

			int tentativa = sc.nextInt();

			if (senha != tentativa) {
				System.out.println("Senha invalida");
			} else {
				System.out.println("Senha correta");
				acertou = 1;
			}

		}

	}

}
