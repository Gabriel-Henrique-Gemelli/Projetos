package Generics_set_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
	
	public static void main(String[] args) {
		
		List<Integer> myints = Arrays.asList(1,2,3,4,5);
		List<Double> myDoubles = Arrays.asList(3.14,6.18);
		List<Object> myObjects = new ArrayList<Object>();
		
		copy(myints,myObjects);
		printList(myObjects);
		copy(myDoubles,myObjects);
		printList(myObjects);
	}
	
	public static void copy(List<? extends Number> source,List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
			
		}
	}
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + " , ");
		}
		System.out.println();
	}
/*
	private List<T> list = new ArrayList<>(); // isso e generics criando algo de um tipo qualquer chamado de <T>
	
	// generics e como se fosse um object so que garantindo a segurança de tipo ou seja type safety.
	
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List cant be empty");
			
		}
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
			
		}
		return max;
	}
	
	//Curingas delimitados tipos coringas nao podem ser adicionados na lista, apenas acessados


	public static double totalArea(List<? extends Abstratas.entities.Shape> list) {
		double sum = 0.0;
		for (Abstratas.entities.Shape s : list) {
			sum += s.area();
		}
	}
	*/
}
