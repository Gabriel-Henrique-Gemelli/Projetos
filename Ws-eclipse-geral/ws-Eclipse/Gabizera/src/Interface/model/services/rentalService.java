package Interface.model.services;

import java.time.Duration;

import Interface.model.entities.carRental;
import Interface.model.entities.invoice;

public class rentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	private texService tax;
	
	
	public rentalService(Double pricePerDay, Double pricePerHour, texService tax) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.tax = tax;
	}

	public void processinvoice(carRental rental) {
		
		double minutes = Duration.between(rental.getStart(), rental.getFinish()).toMinutes();
		double hours = minutes / 60;
		double bacisPayment;
		
		if (hours <= 12) {
			bacisPayment = pricePerHour * Math.ceil(hours);
			
		}
		else {
			bacisPayment = pricePerDay * Math.ceil(hours / 24.0);
		}
		
		
		double taxas = tax.tax(bacisPayment);
		
		rental.setInvoice(new invoice(bacisPayment,taxas)); 
	}
}
