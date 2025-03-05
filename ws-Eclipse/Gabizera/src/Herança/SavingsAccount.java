package Herança;

public class SavingsAccount extends Account{
	
	private Double interrestRate;
	
	public SavingsAccount() {
		
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interrestRate) {
		super(number, holder, balance);
		this.interrestRate = interrestRate;
	}


	public Double getInterrestRate() {
		return interrestRate;
	}

	public void setInterrestRate(Double interrestRate) {
		this.interrestRate = interrestRate;
	}
	
	public void updateBalance() {
		Double a = getBalance();
		
		a += a * interrestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interrestRate=" + interrestRate + ", getInterrestRate()=" + getInterrestRate()
				+ ", getNumber()=" + getNumber() + ", getHolder()=" + getHolder() + ", getBalance()=" + getBalance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
