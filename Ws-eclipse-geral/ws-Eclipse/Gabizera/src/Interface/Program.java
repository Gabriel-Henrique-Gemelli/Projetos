package Interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Interface.model.entities.Vehicle;
import Interface.model.entities.carRental;
import Interface.model.services.BrazilTaxService;
import Interface.model.services.rentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm)");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
		System.out.println("Retorno (dd/MM/yyyy hh:mm)");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
		
		carRental cr = new carRental(start,finish,new Vehicle(carModel));
	
		System.out.print("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		rentalService service = new rentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		service.processinvoice(cr);
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento basico:" + cr.getInvoice().getBasicPaymente());
		System.out.println("Imposto:" + cr.getInvoice().getTax());
		System.out.println("Pagamentos tota: " + cr.getInvoice().getTotalPayment());
		
		
		
		
		
		sc.close();
		
		
		
	}

}
