package Entity;

public class Product {
	
	public String name;
	public double price;
	public int quantity;
	
	public double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProdutcs(int quantity) {
		this.quantity -= quantity;
	}
	
	public void print() {
		System.out.printf("Product Data:%s, $ %.2f, %d units, Total $ %.2f",name,price,quantity,totalValueInStock());
		
	}
	
	public String toString() {
		return name
				+", $ "
				+ String.format("%.2f", price)
				+ ", "
				+ quantity
				+ " units, Total: $"
				+ String.format("%.2f", totalValueInStock());
				
	}
	
	
}
