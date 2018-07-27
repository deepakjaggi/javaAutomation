package vipps.sitTestCases.stepFiles;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uiAuto.testBase.TestBase;

public class CommonSteps {

	@Then("CloseSystem")
	public void closeTheSystem() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
			System.out.println("System shutdown");
		} catch (Exception e) {
			System.out.println("Could not close all the processes of chrome driver -- " + e.getMessage());
		}
	}	
	@When("^OpenBrowser$")
	public void openBrowser() {
		new TestBase().init("Chrome", System.getProperty("user.dir") + "/testData/help.html");
	}
	@Then("^CloseBrowser$")
	public void closeBrowser() {
		TestBase.webDriver.close();
	}

}
