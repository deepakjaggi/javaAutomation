package vipps.sitTestCases.stepFiles;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.When;
import uiAuto.testBase.TestBase;
import vipps.testWorkFlows.LoginWorkFlow;

public class LoginStep {
	
	@When("^user will login into the system, verify that Login is success$")
	public void perform() throws InterruptedException {				
		
		Assert.assertEquals(new LoginWorkFlow(TestBase.webDriver).verifyLoginOperation(), true, "This test case is failed");
	}
}
