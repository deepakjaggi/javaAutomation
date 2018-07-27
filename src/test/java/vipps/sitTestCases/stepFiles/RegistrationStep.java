package vipps.sitTestCases.stepFiles;

import java.util.List;

import org.testng.Assert;

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
		Assert.assertEquals(new RegistrationWorkFlow(TestBase.webDriver).verifyCustomerRegistration(), true, "This test case is failed");
		System.out.println("TCP - REG");
	}		
}
