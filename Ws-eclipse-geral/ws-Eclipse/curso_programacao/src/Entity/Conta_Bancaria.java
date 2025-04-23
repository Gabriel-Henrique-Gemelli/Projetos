package Entity;

public class Conta_Bancaria {

	private String name;
	private int AccNumer;
	private double Dinheiro;

	
	public Conta_Bancaria() {
	}

	public Conta_Bancaria(String name, int accNumer, double Dinheiro) {
		this.name = name;
		this.AccNumer = accNumer;
		this.Dinheiro = Dinheiro;
	}

	public Conta_Bancaria(String name, int accNumber) {
		this.name = name;
		this.AccNumer = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccNumer() {
		return AccNumer;
	}

	public void setAccNumer(int accNumer) {
		AccNumer = accNumer;
	}

	public double getDinheiro() {
		return Dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		Dinheiro = dinheiro;
	}

	public void Deposito(double valor) {
		if (getDinheiro() == 0) {
			setDinheiro(valor);
		}

		else {
			double a = getDinheiro();
			setDinheiro(a += valor);
		}
	}

	public void Remove(double valor) {
		double a = getDinheiro();
		setDinheiro((a -= valor) - 5);

	}

}
