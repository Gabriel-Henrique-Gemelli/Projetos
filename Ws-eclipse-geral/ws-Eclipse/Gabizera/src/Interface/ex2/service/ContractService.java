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
		double basicQuota = contract.getTotalValue() / months;
		
		for (int i =1; i<=months;i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(basicQuota, i);
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			double quota = basicQuota + interest + fee;
			
			contract.getInstallment().add(new Installment(dueDate, quota));
		}
		
	}

	
}
