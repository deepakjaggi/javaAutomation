package com.ServicesAutomation.login;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import servicesAutomation.models.LoginModel;

public class LoginWorkFlow {
	final static Logger logger = Logger.getLogger(LoginWorkFlow.class);
	private Login login;
	private LoginModel loginResponse;

	public LoginWorkFlow() {
		this.login = new Login();
		this.loginResponse = new LoginModel();
	}

	public boolean verifyDOPayment(LoginModel loginModelTestData, ExtentTest test)

	{
		int errorCnt = 0;
		boolean flag = false;
		String useCase = loginModelTestData.getUseCase();
		switch (useCase) {
		case "SUCCESS_LOGIN":
		case "BLANK_MOBILE_NUMBER":
			loginResponse = login.executeLoginService(loginModelTestData, "http://localhost:8080/demo/business/login");
			String expectedErrorCode = loginModelTestData.getErrorCode();
			String actualErrorCode = loginResponse.getErrorCode();
			String expectedErrorMessage = loginModelTestData.getErrorMessage().trim().toUpperCase();
			String actualErrorMessage = loginResponse.getErrorMessage().trim().toUpperCase();
			test.log(LogStatus.INFO, "Expected Error Code : " + expectedErrorCode);
			test.log(LogStatus.INFO, "Actual Error Code : " + actualErrorCode);
			test.log(LogStatus.INFO, "Expected Error message: " + expectedErrorMessage);
			test.log(LogStatus.INFO, "Actual Error message: " + actualErrorMessage);
			System.out.println("-----------");
			if (!expectedErrorCode.equals(actualErrorCode)) {
				errorCnt = errorCnt + 1;
				test.log(LogStatus.INFO, "Error Code is not matching");

			}
			if (!expectedErrorMessage.equals(actualErrorMessage)) {
				errorCnt = errorCnt + 1;
				test.log(LogStatus.INFO, "Error message is not matching");
			}

			if (errorCnt != 0) {
				return false;

			} else {
				return true;
			}
		default:
			test.log(LogStatus.INFO, "No Matching condition is found to validate");
			break;
		}

		return flag;

	}
}