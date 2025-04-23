package Programaçao_funcional_e_Funçao_lambda.util;

import java.util.function.Consumer;

import Set.entities.Product;

public class priceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() * 1.1);
		
	}

}
