package Exercisios_get;

import java.util.Scanner;

import Entity.Conta_Bancaria;

public class Banco {

	public static void main(String[] args) {
		Conta_Bancaria conta = new Conta_Bancaria();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o numero da conta:");
		int AccNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Digite o nome da conta:");
		String name = sc.nextLine();
		System.out.print("Tem algum deposito inicial (Y/N)?");
		char initial = sc.next().charAt(0);
		if (initial == 'y') {
			System.out.println("Deposite um valor inicial: ");
			double deposito = sc.nextDouble();
			
			conta = new Conta_Bancaria(name,AccNumber,deposito);
			System.out.printf("Dados da conta:%nConta: %d, Nome da conta: %s, quantidade: $ %.2f ",conta.getAccNumer(),conta.getName(),conta.getDinheiro());
		}
		else {
			conta = new Conta_Bancaria(name,AccNumber);
			System.out.printf("Dados da conta:%nConta: %d, Nome da conta: %s, quantidade: $ %.2f ",conta.getAccNumer(),conta.getName(),conta.getDinheiro());

		}
		System.out.println();
		System.out.println("Digite o numero de deposito");
		double deposito = sc.nextDouble();
		conta.Deposito(deposito);
		System.out.printf("Dados da conta atualizados:%nConta: %d, Nome da conta: %s, quantidade: $ %.2f ",conta.getAccNumer(),conta.getName(),conta.getDinheiro());
		System.out.println();
		System.out.println("Digite o valor que deseja retirar:");
		double remove = sc.nextDouble();
		conta.Remove(remove);
		System.out.printf("Dados da conta atualizados:%nConta: %d, Nome da conta: %s, quantidade: $ %.2f ",conta.getAccNumer(),conta.getName(),conta.getDinheiro());
		
		sc.close();

	}

}
