package vipps.sitTestCases.stepFiles;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.When;
import uiAuto.testBase.TestBase;
import vipps.commonObjects.CommonObjects;
import vipps.testWorkFlows.LoginWorkFlow;
import vipps.testWorkFlows.RegistrationWorkFlow;

public class LoginStep {

	@When("^user will perform registration flow$")
	public void performRegisration() throws InterruptedException {
		CommonObjects.test = CommonObjects.extentReports.startTest("TCID -- " + CommonObjects.registrationData.gettC());
		if (new RegistrationWorkFlow(TestBase.webDriver).verifyCustomerRegistration(CommonObjects.test)) {
			CommonObjects.test.log(LogStatus.PASS, "Success for TC ID : " + CommonObjects.registrationData.gettC());
		} else {
			CommonObjects.test.log(LogStatus.FAIL, "Success for TC ID : " + CommonObjects.registrationData.gettC());
		}
	}

	@When("^user will login into the system, verify that Login is success$")
	public void performLogin() throws InterruptedException {

		Assert.assertEquals(new LoginWorkFlow(TestBase.webDriver).verifyLoginOperation(), true,
				"This test case is failed");
	}
}
