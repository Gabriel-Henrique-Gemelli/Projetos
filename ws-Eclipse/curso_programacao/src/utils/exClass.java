package utils;

import java.util.Scanner;

public class exClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o valor do dolar: ");
		double dolar = sc.nextDouble();
		System.out.println("Digite a quantidade que deseja comprar: ");

		double valor = sc.nextDouble();
		System.out.printf("Quantidade necessaria para pagar em reais: %.2f", Currency_value.CalculoDeIOF(dolar, valor));

		sc.close();
	}

}
