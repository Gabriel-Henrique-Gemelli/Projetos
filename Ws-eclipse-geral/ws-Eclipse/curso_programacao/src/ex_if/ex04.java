package ex_if;

import java.util.Scanner;

public class ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Item = sc.nextInt();
		int qnt = sc.nextInt();
		double valor = 0;
		switch (Item) {
		case 1:
			valor = qnt * 4;
			break;
		case 2:
			valor = qnt * 4.5;
			break;
		case 3:
			valor = qnt * 5;
			break;
		case 4:
			valor = qnt * 2;
			break;
		case 5:
			valor = qnt * 1.5;
			break;
		default:
			break;
		}

		System.out.printf("Total: R$ %.2f ", valor);

	}

}
