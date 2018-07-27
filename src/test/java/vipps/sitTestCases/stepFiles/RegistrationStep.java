package vipps.sitTestCases.stepFiles;

import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vipps.commonObjects.CommonObjects;
import vipps.sitTestCases.testDataModel.RegistrationData;
import vipps.testWorkFlows.RegistrationWorkFlow;

public class RegistrationStep {

	RegistrationWorkFlow registrationWorkFlow;

	public RegistrationStep() {
		registrationWorkFlow = new RegistrationWorkFlow();
	}

	@Given("^Customer Enrollement Data$")
	public void enroll(List<RegistrationData> registrationDataTest) {
		CommonObjects.registrationData = registrationDataTest.get(0);
	}

	@When("^user will perform registration flow$")
	public void perform() throws InterruptedException {
		Assert.assertEquals(registrationWorkFlow.verifyCustomerRegistration(), true, "This test case is failed");
	}
	@Then("close the system")
	public void closeTheSystem() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		} catch (Exception e) {
			System.out.println("Could not close all the processes of chrome driver -- " + e.getMessage());
		}
	}
	


}
