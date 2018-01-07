package com.ServicesAutomation.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ServicesAutomation.login.LoginWorkFlow;

import servicesAutomation.models.LoginModel;
import uiAutomation.testBase.TestBase;

public class TC001_LoginTestCases extends TestBase 
{
	LoginWorkFlow loginWorkFlow;
	@DataProvider
	public Object[][] ValidDataProvider() {
		return new Object[][] { { "Y", "SUCCESS_LOGIN","92511830", "1234","SUCCESS","9000" }, { "Y", "BLANK_MOBILE_NUMBER","", "1234","mobile Number not valid","9002" }};
	}

	@BeforeMethod
	public void setUP() {
		// Load Property File connection
		loginWorkFlow=new LoginWorkFlow();

	}

	@Test(dataProvider = "ValidDataProvider")
	public void testLogin(String executionStatus, String useCase, String mobileNumber, String pin, String errorMessage, String errorCode) {
		if (executionStatus.equalsIgnoreCase("Y")) {
			LoginModel loginModelTestData=new LoginModel();
			loginModelTestData.setMobileNumber(mobileNumber);
			loginModelTestData.setPin(pin);
			loginModelTestData.setUseCase(useCase.toUpperCase());
			loginModelTestData.setErrorCode(errorCode);
			loginModelTestData.setErrorMessage(errorMessage.toUpperCase());
			System.out.println("*******************************************************************");
			loginWorkFlow.verifyDOPayment(loginModelTestData);
			System.out.println("*******************************************************************");
			
		}

	}

	@AfterMethod
	public void endTest() {
		// Close Property File connection
	}

}
