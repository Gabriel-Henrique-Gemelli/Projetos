package Interface.model.entities;

public class invoice {

	private Double basicPaymente;
	private Double tax;
	
	
	public invoice() {
		
	}


	public invoice(Double basicPaymente, Double tax) {
		super();
		this.basicPaymente = basicPaymente;
		this.tax = tax;
	}


	public Double getBasicPaymente() {
		return basicPaymente;
	}


	public void setBasicPaymente(Double basicPaymente) {
		this.basicPaymente = basicPaymente;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment(){
		return getBasicPaymente() - getTax();
	}
}
