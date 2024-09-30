package Ex_while;

import java.util.Scanner;

public class ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int compra = sc.nextInt();
		int gasolina = 0, diesel = 0, alcool = 0;

		while (compra != 4) {

			switch (compra) {
			case 1:
				alcool += 1;
				break;
			case 2:
				gasolina += 1;
				break;
			case 3:
				diesel += 1;
				break;

			case 4:
				break;

			}
			
			compra = sc.nextInt();

		}
		System.out.printf("Muito Obrigado %nAlcool:%d%ngasolina:%d%ndiesel:%d%n",alcool ,gasolina, diesel);

	}
}
