package main;

import java.util.Scanner;

import Entity.Triangle;

public class program {
	 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Triangle y = new Triangle();
		Triangle x = new Triangle();
		
		System.out.println("Enter the measure of X:");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		double areaX = x.area();
		
		System.out.println("ENter the measure of Y:");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		double areaY = y.area();
		sc.close();
		
		System.out.printf("Triangle x area: %.4f%n",areaX);
		System.out.printf("Triangle y area: %.4f%n",areaY);
		
	}
	 
	 
	 
	 
}
