package Programaçao_funcional_e_Funçao_lambda.util;

import java.util.function.Function;

import Set.entities.Product;

public class UpercaseName implements Function<Product,String>{

	@Override
	public String apply(Product p) {
		
		return p.getName().toUpperCase();
	}

}
