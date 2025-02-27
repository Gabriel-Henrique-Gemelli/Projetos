package Enum;

import java.time.LocalDate;

import Entities.Order;

public class Program {

	public static void main(String[] args) {
		
		Order order = new Order(1080, LocalDate.now(), Orderenum.Aguardando_Pagamento);
		
		System.out.println(order);
		
		Orderenum os1 = Orderenum.entregue;
		
		Orderenum os2 = Orderenum.valueOf("entregue");
		
		System.out.println(os1);
		System.out.println(os2);
		
		//CONTROLADOR FAZ O MEIO DE CAMPO ENTRE A TELA E O SISTEMA 
	}

}
