package Programaçao_funcional_e_Funçao_lambda;

import java.util.Arrays;

public class Program {
	public static int globalValue = 3;

	public static void main(String[] args) {
		int[] vect = new int[] { 3, 4, 5 };
		chageOddValues(vect);
		System.out.println(Arrays.toString(vect));

	}
	
	public static void chageOddValues(int[] number) {
		for(int i = 0; i<number.length; i++) {
			if(number[i] % 2 != 0) {
				number[i] += globalValue;
			}
		}
	}

}
