package Programaçao_funcional_e_Funçao_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Programaçao_funcional_e_Funçao_lambda.util.UpercaseName;
import Programaçao_funcional_e_Funçao_lambda.util.priceUpdate;
import Set.entities.Product;

public class Lista {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Lanche", 40.00));
		list.add(new Product("Abraço", 80.00));
		list.add(new Product("Almofada", 1000.00));
		list.add(new Product("TV plus", 1900.00));
		
		
		List<String> names =  list.stream().map(new UpercaseName()).collect(Collectors.toList());
		
		names.forEach(System.out :: println);
		
		
		/*
		list.forEach(new priceUpdate());
		
		list.forEach(System.out :: println);
		
		list.removeIf(p -> p.getPrice() >= 100);
		
		for (Product p : list) {
			System.out.println(p);
		}
		*/
		

	}

}
