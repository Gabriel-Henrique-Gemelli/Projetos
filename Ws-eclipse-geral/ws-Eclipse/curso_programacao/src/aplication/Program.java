package aplication;

import java.util.Locale;
import java.util.Scanner;

import Entity.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product product = new Product();
		System.out.println("Enter produtc Data:");
		System.out.println("Name:");
		product.name = sc.nextLine();
		System.out.println("Price:");
		product.price = sc.nextDouble();
		System.out.println("Quantity in stock:");
		product.quantity = sc.nextInt();
		
		product.print();
		System.out.println("");
		System.out.println(product);
		
		System.out.println("Enter the number of products to be added in stock: ");
		int quantity = sc.nextInt();
		product.addProducts(quantity);
		
		
		System.out.println();
		System.out.println("Updated product" + product);
		
		System.out.println();
		System.out.println("Enther the number to be removed: ");
		quantity = sc.nextInt();
		product.removeProdutcs(quantity);
		sc.close();

	}

}
