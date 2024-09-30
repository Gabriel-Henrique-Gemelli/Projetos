package ex_if;

import java.util.Scanner;

public class ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Hora1 = sc.nextInt();
		int Hora2 = sc.nextInt();
		int duracao;

		if (Hora1 < Hora2) {
			duracao = Hora2 - Hora1;
		}
		else {
			duracao = 24 - Hora1 + Hora2;
		}
		
		
		System.out.printf("O jogo durou:%d Hora(s)",duracao);
		
	}

}
