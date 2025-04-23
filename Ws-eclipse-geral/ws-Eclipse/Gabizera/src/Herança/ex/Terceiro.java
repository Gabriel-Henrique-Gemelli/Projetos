package Herança.ex;

public class Terceiro extends employee{
	private Double aditionalCharging;
	
	public Terceiro() {
		
	}

	public Terceiro(String name, Integer hours, Double valuePerHour, Double aditionalCharging) {
		super(name, hours, valuePerHour);
		this.aditionalCharging = aditionalCharging;
	}

	public Double getAditionalCharging() {
		return aditionalCharging;
	}

	public void setAditionalCharging(Double aditionalCharging) {
		this.aditionalCharging = aditionalCharging;
	}
	
	@Override
	public double payment() {
		return super.payment() + aditionalCharging * 1.10;
		
	}
	
}
