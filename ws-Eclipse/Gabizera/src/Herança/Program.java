package Herança;

public class Program {

	public static void main(String[] args) {
		
		Account acc = new Account(1001,"Alex",0.0);
		BusinessAccount bacc = new BusinessAccount(1002,"Maria",0.0,500.00);
		
		// UPCASTING
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003,"Bob",0.0,200.0);
		Account acc3 = new SavingsAccount(1004,"ANA",0.0,0.56);
		
		// DOWNCASTING
		
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.00);
		System.out.println(acc + "" + acc1 +"" + acc3);
		
		// BusinessAcount acc5 = (BusinessAccount) acc3;
		// ISSO AQUI ESTOURA UM EXCEPTION DIZENDO QUE O TIPO SavingsAccount NAO PODE SER CONVERTIDO PARA BusinessAccount.
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		else if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!!");
		}
		
		//o final pode ser usado para melhora de performanse
		
		
		

	}

}
