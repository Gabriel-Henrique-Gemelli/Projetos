package Oi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double Salario;
		Double Bonus;
		Salario = sc.nextDouble();
		Bonus = sc.nextDouble();
		
		Double SalarioATT = calcularSalario(Salario,Bonus);
	
		System.out.println(SalarioATT);
		sc.close();
		
	}
	public static Double calcularSalario(Double SALARIO,Double BONUS) {
		return SALARIO * BONUS;
	}

}