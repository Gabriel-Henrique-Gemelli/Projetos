package Oi;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count =0;
		int n = sc.nextInt();
		int[][] mat = new int[n][n];  //Para criar uma matrix bidimencional
		
		for (int i=0; i<n;i++) {
			for (int j=0; j<n; j++) {
				mat[i][j] = sc.nextInt();
				if (mat[i][j] < 0) {
					count++;
				}
				
			}
		}
		
		System.out.println("Main diagonal:");
		
		for(int i=0; i<n; i++) {
			System.out.print(mat[i][i] + " ");
		}
		
		System.out.printf("Negative number: %d", count);
		
		
		
		sc.close();
	}

}
