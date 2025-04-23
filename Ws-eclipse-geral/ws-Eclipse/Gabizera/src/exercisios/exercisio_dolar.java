package exercisios;

import java.util.Scanner;

public class exercisio_dolar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CurrencyChanger x = new CurrencyChanger();
		
		double quantity;
		System.out.println("Quanto dolares voce quer comprar?");
		quantity = sc.nextDouble();
		
		System.out.printf("Para comprar %.2f voce vai pagar %.2f em reais", quantity,x.Calc(quantity));
		
		sc.close();
		
		
		

	}

}
