package guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import uiAuto.testBase.TestBase;
import uiAuto.testFlows.SortingLogic;

public class TC001_SortingTestCases {

	SortingLogic sortingLogic;
	TestBase testBase;
	WebDriver guruDriver;
	WebDriverWait wait;	


	@BeforeTest
	public void setUP() {
		sortingLogic = new SortingLogic();
		testBase = new TestBase();
		testBase.init("Chrome", "http://live.guru99.com/index.php/");
		guruDriver = testBase.getGuruDriver();
		wait = new WebDriverWait(guruDriver, 20000);				
	}

	@Test()
	public void day1Verification() throws InterruptedException {
		Assert.assertEquals(sortingLogic.verifyDay1(wait, guruDriver), true, "This test case is failed");
	}

	@AfterTest
	public void endTest() {

	}
}
