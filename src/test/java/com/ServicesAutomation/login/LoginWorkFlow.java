package com.ServicesAutomation.login;

import org.apache.log4j.Logger;

import servicesAutomation.models.LoginModel;

public class LoginWorkFlow {
	final static Logger logger = Logger.getLogger(LoginWorkFlow.class);
	private Login login;
	private LoginModel loginResponse;

	public LoginWorkFlow() {
		this.login = new Login();
		this.loginResponse = new LoginModel();
	}

	public boolean verifyDOPayment(LoginModel loginModelTestData)

	{
		int errorCnt = 0;
		boolean flag = false;
		String useCase = loginModelTestData.getUseCase();

		System.out.println("Executing use case : " + useCase.toUpperCase());
		switch (useCase) {
		case "SUCCESS_LOGIN":
		case "BLANK_MOBILE_NUMBER":
			loginResponse = login.executeLoginService(loginModelTestData, "http://localhost:8080/demo/business/login");
			String expectedErrorCode = loginModelTestData.getErrorCode();
			String actualErrorCode = loginResponse.getErrorCode();
			String expectedErrorMessage = loginModelTestData.getErrorMessage().trim().toUpperCase();
			String actualErrorMessage = loginResponse.getErrorMessage().trim().toUpperCase();
			System.out.println("-----------");
			System.out.println(expectedErrorCode);
			System.out.println(actualErrorCode);
			System.out.println("-----------");
			System.out.println(expectedErrorMessage);
			System.out.println(actualErrorMessage);
			System.out.println("-----------");
			if (!expectedErrorCode.equals(actualErrorCode)) {
				errorCnt = errorCnt + 1;
				System.out.println("Error Code is not matching");

			}
			if (!expectedErrorMessage.equals(actualErrorMessage)) {
				errorCnt = errorCnt + 1;
				System.out.println("Error message is not matching");
			}

			if (errorCnt != 0) {
				return false;

			} else {
				return true;
			}
		default:
			System.out.println("No Matching condition is found to validate");
			break;
		}

		return flag;

	}
}