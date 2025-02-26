package Oi;

import java.util.Arrays;
import java.util.Scanner;

public class Altura {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();
		int[] idade = new int[n];
		float[] altura = new float[n];
		String[] nome = new String[n];
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Dados da %da pessoa: ",i+1);
			System.out.println();
			System.out.print("Nome: ");
			nome[i] = sc.next();
			System.out.print("Idade: ");
			idade[i] = sc.nextInt();
			System.out.print("Altura: ");
			altura[i] = sc.nextFloat();
		}
		
		System.out.printf("Media das pessoas e: %.2f", calculaAlturaMedia(altura));
		System.out.println();
		calculoDePorcentagem(idade,nome);
		
		
		sc.close();
		

	}
	
	public static float calculaAlturaMedia(float[] vect) {
		float calc = 0;
		for (int i=0; i < vect.length; i++) {
			
			calc += vect[i];
			
		}
		return calc/vect.length;
		
	}
	
	public static void calculoDePorcentagem(int[] vect, String[]vect2) {
		float calc = 0;
		String[] nomes = new String[vect2.length];
		int count = 0;
		for (int i=0; i < vect.length; i++) {
			
			if (vect[i] < 16) {
				nomes[count] = vect2[i];
				count++;
				
			}
			
		}
		 calc = ((float) count / vect.length) * 100;
		
		String[] NomesFiltrados = Arrays.copyOf(nomes, count);
		
		String nomesFormatados = String.join(", ", NomesFiltrados);

	    System.out.printf("Porcentagem de pessoas com menos de 16 anos: %.2f%%\n", calc);
	    System.out.println("Nomes das pessoas: " + nomesFormatados);
		
	}
	

}
