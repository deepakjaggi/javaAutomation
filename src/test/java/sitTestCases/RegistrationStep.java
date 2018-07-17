package sitTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonObjects.CommonObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testWorkFlows.RegistrationWorkFlow;
import uiAuto.testBase.TestBase;

public class RegistrationStep {
	TestBase testBase;
	WebDriver helpDriver;
	WebDriverWait wait;
	RegistrationWorkFlow registrationWorkFlow;

	
	public RegistrationStep() {		
		testBase = new TestBase();
		registrationWorkFlow=new RegistrationWorkFlow();
		testBase.init("Chrome", System.getProperty("user.dir") + "/testData/help.html");
		helpDriver = testBase.getDriver();
		wait = new WebDriverWait(helpDriver, 20000);
		registrationWorkFlow.setWebDriver(helpDriver);
		registrationWorkFlow.setWait(wait);				
	}

	@Given("^Customer Enrollement Data$")
	public void enroll(List<RegistrationData> registrationDataTest) {
		CommonObjects.registrationData = registrationDataTest.get(0);
	}

	@When("^user will perform registration flow$")
	public void perform() throws InterruptedException {
		Assert.assertEquals(registrationWorkFlow.verifyCustomerRegistration(), true, "This test case is failed");
	}
}
