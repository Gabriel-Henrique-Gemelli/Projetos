package curso_programacao;

import java.util.Scanner;

public class ex_04 {
	public static void main(String[] args) {
		int numFunc;
		double HorasTrab,ValorHora, Total;
		
		Scanner sc = new Scanner(System.in);
		
		numFunc = sc.nextInt();
		HorasTrab = sc.nextDouble();
		ValorHora = sc.nextDouble();
		
		Total = HorasTrab * ValorHora;
		
		System.out.printf("NUMBER = %d%nSALARY = U$ %.2f", numFunc, Total );
	}
}
