package vipps.testWorkFlows;

import org.openqa.selenium.WebDriver;

import uiAuto.pageObjects.LoginPage;
import vipps.commonObjects.CommonObjects;

public class LoginWorkFlow{
	LoginPage loginPage;
	public LoginWorkFlow(WebDriver vippsWebDriver)
	{	
		loginPage=new LoginPage(vippsWebDriver);
	}
	public boolean verifyLoginOperation() throws InterruptedException {
		if (confirmLogin()) {
			return true;
		}
		return false;
	}
	private boolean confirmLogin(){
		if (loginPage.enterLoginInformation(CommonObjects.registrationData.getUserName(), CommonObjects.registrationData.getPassWord()))
		{
			return true;
		}
		return false;		
	}
	
}
