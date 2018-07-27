package vipps.testWorkFlows;

import org.openqa.selenium.WebDriver;

import uiAuto.pageObjects.HelpPage;
import vipps.commonObjects.CommonObjects;

public class RegistrationWorkFlow {
	private HelpPage helpPage;

	public RegistrationWorkFlow(WebDriver vippsWebDriver) {
		helpPage = new HelpPage(vippsWebDriver);
	}

	public boolean verifyCustomerRegistration() throws InterruptedException {
		if (conirmRegistration()) {
			return true;
		}
		return false;
	}

	private boolean conirmRegistration() throws InterruptedException {
		helpPage.registerUser(CommonObjects.registrationData.getUserName(),
				CommonObjects.registrationData.getPassWord(), CommonObjects.registrationData.getPassWord());
		if (helpPage.getValidationMessageForRegistration().equals(CommonObjects.registrationData.getExpectedResult())) {
			return true;
		}
		return false;
	}

}
