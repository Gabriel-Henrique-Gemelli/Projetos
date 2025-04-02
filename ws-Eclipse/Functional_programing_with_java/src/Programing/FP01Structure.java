package Programing;

import java.util.List;

public class FP01Structure {

	public static void main(String[] args) {
		printAllNumbersInListFunctional(List.of(12, 9, 8, 7, 6, 5, 4, 3, 2, 1, 123, 123, 43));
		System.out.println("Separaçao");
		printAllNumbersInListStructured(List.of(12, 9, 8, 7, 6, 5, 4, 3, 2, 1, 123, 123, 43));

	}

	private static void print(int number) {
		System.out.println(number);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream().forEach(FP01Structure::print);

	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		for (int i : numbers) {
			System.out.println(i);
		}

	}

}
