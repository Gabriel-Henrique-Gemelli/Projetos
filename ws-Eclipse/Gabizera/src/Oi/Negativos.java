package Oi;

import java.util.Locale;
import java.util.Scanner;



public class Negativos {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce quer digitar");
		int n = sc.nextInt();
		
		int[] vet = new int[n];
		
		for(int i=0; i < n; i++) {
			System.out.print("Digite o numero que quer testar");
			vet[i] = sc.nextInt();
			
			
		}
		System.out.println("NUMEROS NEGATIVOS:");
		for (int i = 0; i <n;i++) {
			if (vet[i] < 0) {
				System.out.println(vet[i]);
			}
		}
		
		
		sc.close();
	}
}
