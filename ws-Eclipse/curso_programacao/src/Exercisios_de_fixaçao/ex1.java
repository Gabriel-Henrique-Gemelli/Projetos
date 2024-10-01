package Exercisios_de_fixaçao;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		Retangulo retangulo = new Retangulo();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a comprimento do retangulo: ");
		retangulo.widht = sc.nextDouble();
		System.out.println("Digite a altura do retangulo: ");
		retangulo.height = sc.nextDouble();
		retangulo.print();
		
		sc.close();

	}

}
