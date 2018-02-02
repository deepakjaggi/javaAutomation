package banq.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import banq.defination.BanqService;
import banq.models.LoanType;


public class TestPaymentCaluclations 
{
	BanqService banqService;
	
	@Before
	public void Setup()
	{
		banqService=mock(BanqService.class);
	}
	
	
	@Test
	public void verifyGetLoanTypes()
	{
		when(banqService.GetLoanTypes()).thenReturn(getAllLoansList());
		System.out.println(banqService.GetLoanTypes().get(0).getLoanType());
		System.out.println(banqService.GetLoanTypes().get(0).getLoanText());
		System.out.println(banqService.GetLoanTypes().get(1).getLoanType());
		System.out.println(banqService.GetLoanTypes().get(1).getLoanText());
		
	}
	
	public List<LoanType> getAllLoansList()
	{
		List<LoanType> listLoanType=new ArrayList<LoanType>();
		LoanType l=new LoanType();
		l.setLoanText("HomeLoan");
		l.setLoanType(1);
		listLoanType.add(l);
		l=null;
		l=new LoanType();
		l.setLoanText("Car Loan");
		l.setLoanType(2);
		listLoanType.add(l);
		return listLoanType;
	}
}

