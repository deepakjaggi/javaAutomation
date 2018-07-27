package vipps.testWorkFlows;

import uiAuto.pageObjects.HelpPage;
import vipps.commonObjects.CommonObjects;
import vipps.driver.JunitRunnerHelper;

public class RegistrationWorkFlow extends JunitRunnerHelper{

	public RegistrationWorkFlow() {
		super();		
	}

	private HelpPage helpPage;

	public boolean verifyCustomerRegistration() throws InterruptedException {
		if (conirmRegistration()) {
			return true;
		}
		return false;
	}

	private boolean conirmRegistration() throws InterruptedException {
		helpPage=new HelpPage(helpDriver);
		helpPage.registerUser(CommonObjects.registrationData.getUserName(),
				CommonObjects.registrationData.getPassWord(), CommonObjects.registrationData.getPassWord());
		if (helpPage.getValidationMessageForRegistration().equals(CommonObjects.registrationData.getExpectedResult())) {
			return true;	
		}
		return false;
	}

}
