package vipps.sitTestCases.stepFiles;

import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import uiAuto.testBase.TestBase;
import vipps.commonObjects.CommonObjects;
import vipps.sitTestCases.testDataModel.RegistrationData;
import vipps.testWorkFlows.RegistrationWorkFlow;

public class RegistrationStep {	
	@Given("^Customer Enrollement Data$")
	public void enroll(List<RegistrationData> registrationDataTest) {
		CommonObjects.registrationData = registrationDataTest.get(0);		
	}
	@When("^user will perform registration flow$")
	public void perform() throws InterruptedException {
		CommonObjects.test= CommonObjects.extentReports.startTest("TCID -- " + CommonObjects.registrationData.gettC());
		if (new RegistrationWorkFlow(TestBase.webDriver).verifyCustomerRegistration(CommonObjects.test))
		{
			CommonObjects.test.log(LogStatus.PASS, "Success for TC ID : " + CommonObjects.registrationData.gettC());
		}
		else
		{
			CommonObjects.test.log(LogStatus.FAIL, "Success for TC ID : " + CommonObjects.registrationData.gettC());
		}		
	}		
}
