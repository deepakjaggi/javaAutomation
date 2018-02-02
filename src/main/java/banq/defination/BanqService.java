package banq.defination;

import java.util.List;

import banq.models.LoanType;
import banq.models.Payment;

public interface BanqService {
	public List<Payment> ReturnPayment(int numOfPayments, double amount, double interest, double total);
	public double GetInterest(int LoanType);
	public List<LoanType> GetLoanTypes();
}
