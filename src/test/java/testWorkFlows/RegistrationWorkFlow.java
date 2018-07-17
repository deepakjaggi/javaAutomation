package testWorkFlows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonObjects.CommonObjects;
import uiAuto.pageObjects.HelpPage;

public class RegistrationWorkFlow {

	private WebDriver webDriver;
	private WebDriverWait wait;
	private HelpPage helpPage;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public boolean verifyCustomerRegistration() throws InterruptedException {
		if (conirmRegistration()) {
			return true;
		}
		return false;
	}

	private boolean conirmRegistration() throws InterruptedException {
		helpPage=new HelpPage(webDriver);
		helpPage.registerUser(CommonObjects.registrationData.getUserName(),
				CommonObjects.registrationData.getPassWord(), CommonObjects.registrationData.getExpectedResult());
		if (helpPage.getValidationMessageForRegistration().equals(CommonObjects.registrationData.getExpectedResult())) {
			return true;	
		}
		return false;
	}

}
