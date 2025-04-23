package Oi;

import java.util.Scanner;

public class Matrix2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int L = sc.nextInt();
		 sc.nextLine();
		 int C = sc.nextInt();
		 int[][] mat = new int[L][C];
		 
		 for (int i=0; i<L;i++) {
			 for (int j=0; j<C; j++) {
				 mat[i][j] = sc.nextInt();
			 }
		 }
		 
		 int num = sc.nextInt();
		 for (int i=0; i<L;i++) {
			 for (int j=0; j<C; j++) {
				 if (mat[i][j] == num) {
					 System.out.printf("Position:%d,%d%n",i,j);
					 if ((j -1) >= 0){
						 System.out.println("Left:" + mat[i][j - 1]); 
					 }
					 if ((j +1) < C){
						 System.out.println("Right:" + mat[i][j + 1]); 
					 }
					 if ((i -1) >= 0){
						 System.out.println("Up:" + mat[i- 1][j]); 
					 }
					 if ((i +1) < L){
						 System.out.println("Down:" + mat[i + 1][j]); 
					 }
				 }
				 
			 }
		 }
		 
		
		
		sc.close();

	}

}
