package Programaçao_funcional_e_Funçao_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Set.entities.Product;

public class ExperienciaComComparator {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		
		Comparator<Product> comp = (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()); // isso e uma expressao lambda
		
		list.sort(comp);
		
		for(Product p : list) {
			System.out.println(p);
		}

	}

}
