//package com.ServicesAutomation.TestCases;
//
//import java.io.IOException;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.ServicesAutomation.login.LoginWorkFlow;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import reports.ExtentManager;
//import servicesAutomation.models.LoginModel;
//import uiAutomation.testBase.TestBase;
//import utility.UtilityClass;
//
//public class TC001_LoginTestCases extends TestBase {
//	ExtentReports extentReports;
//	ExtentTest test;
//	LoginWorkFlow loginWorkFlow;
//
//	@DataProvider
//	public Object[][] ValidDataProvider() {
//		return new Object[][] { { "Y", "SUCCESS_LOGIN", "92511830", "1234", "SUCCESS", "9000" },
//				{ "Y", "BLANK_MOBILE_NUMBER", "", "1234", "mobile Number not valid", "9002" } };
//	}
//
//	@BeforeTest
//	public void setUP() {
//		// Load Property File connection
//		loginWorkFlow = new LoginWorkFlow();
//		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "RES_LOGIN.html");
//	}
//
//	@Test(dataProvider = "ValidDataProvider")
//	public void testLogin(String executionStatus, String useCase, String mobileNumber, String pin, String errorMessage,
//			String errorCode) throws IOException {
//		UtilityClass util = new UtilityClass();
//		String senderMobileNumber = util.getPropertyValue("senderMobileNumber");
//		System.out.println(senderMobileNumber);
//		if (executionStatus.equalsIgnoreCase("Y")) {
//			test = extentReports.startTest("TCID -- " + useCase);
//			LoginModel loginModelTestData = new LoginModel();
//			loginModelTestData.setMobileNumber(senderMobileNumber);
//			loginModelTestData.setPin(pin);
//			loginModelTestData.setUseCase(useCase.toUpperCase());
//			loginModelTestData.setErrorCode(errorCode);
//			loginModelTestData.setErrorMessage(errorMessage.toUpperCase());
//			if (loginWorkFlow.verifyLogin(loginModelTestData, test)) {
//				test.log(LogStatus.PASS, "Success for use case : " + useCase);
//			} else {
//				test.log(LogStatus.FAIL, "Failed for use case : " + useCase);
//			}
//			extentReports.endTest(test);
//			extentReports.flush();
//		}
//	}
//
//	@AfterTest
//	public void endTest() {
//	}
//}
