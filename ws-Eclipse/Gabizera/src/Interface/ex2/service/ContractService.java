package Interface.ex2.service;

import java.time.LocalDate;

import Interface.ex2.entities.Contract;
import Interface.ex2.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {
		
	}

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		contract.getInstallment().add(new Installment(LocalDate.of(2018, 7, 25),206.0));
		contract.getInstallment().add(new Installment(LocalDate.of(2018, 8, 25),208.08));
	}

	
}
