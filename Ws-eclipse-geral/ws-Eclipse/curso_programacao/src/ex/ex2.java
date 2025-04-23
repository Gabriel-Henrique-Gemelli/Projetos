package ex;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		funcionario func = new funcionario();
		Scanner sc = new Scanner(System.in);
		
		func.Name = sc.nextLine();
		func.GrossSalary = sc.nextDouble();
		func.Tax = sc.nextDouble();
		
		System.out.printf("Employee: %s, $ %.2f",func.Name, func.NetSalary());
		System.out.println();
		System.out.println("wich porcente to increase salary?:");
		double p = sc.nextDouble(); 
		System.out.printf("Updated data: %s, $ %.2f",func.Name,func.increaseSalary(p));
		
		sc.close();

	}

}
