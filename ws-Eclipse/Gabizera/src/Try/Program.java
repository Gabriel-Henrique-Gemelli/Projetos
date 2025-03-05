package Try;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		method2();
		System.out.println("Fim do programa");

	}

	public static void method2() {
		Scanner sc = new Scanner(System.in);

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}

}
