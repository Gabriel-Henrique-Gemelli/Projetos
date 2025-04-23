package Interface.ex2.program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

import Interface.ex2.entities.Contract;
import Interface.ex2.entities.Installment;
import Interface.ex2.service.ContractService;
import Interface.ex2.service.PaypallService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy)");
		LocalDate date = LocalDate.parse(sc.next(),fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number,date,totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		ContractService service = new ContractService(new PaypallService());	
		
		service.processContract(contract, n);
		
		System.out.println("Parcelas: ");
		for (Installment installment : contract.getInstallment()) {
			System.out.println(installment);
			
		}
		
		
		sc.close();
	}

}
