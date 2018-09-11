package vipps.testWorkFlows;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import uiAuto.pageObjects.HelpPage;
import vipps.commonObjects.CommonObjects;

public class RegistrationWorkFlow {
	private HelpPage helpPage;	

	public RegistrationWorkFlow(WebDriver vippsWebDriver) {
		helpPage = new HelpPage(vippsWebDriver);
	}

	public boolean verifyCustomerRegistration(ExtentTest test) throws InterruptedException {
		if (conirmRegistration(test)) {
			return true;
		}
		return false;
	}

	private boolean conirmRegistration(ExtentTest test) throws InterruptedException {
		helpPage.registerUser(CommonObjects.registrationData.getUserName(),
				CommonObjects.registrationData.getPassWord(), CommonObjects.registrationData.getPassWord(),test);
		if (helpPage.getValidationMessageForRegistration().equals(CommonObjects.registrationData.getExpectedResult())) {
			return true;
		}
		return false;
	}

}
