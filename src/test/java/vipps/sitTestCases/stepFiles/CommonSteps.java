package vipps.sitTestCases.stepFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uiAuto.reports.ExtentManager;
import uiAuto.testBase.TestBase;
import vipps.commonObjects.CommonObjects;

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
	
	@Given("^StartReporting$")
	public void startReporting()
	{
		CommonObjects.extentReports= ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "Res.html");
	}
	
	@Then("^CloseReporting$")
	public void CloseReporting()
	{
		CommonObjects.extentReports.endTest(CommonObjects.test);
		CommonObjects.extentReports.flush();
	}

}
