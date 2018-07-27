package vipps.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiAuto.testBase.TestBase;

public class JunitRunnerHelper {
	protected TestBase testBase;
	protected WebDriver helpDriver;
	protected WebDriverWait wait;

	protected JunitRunnerHelper() {
		testBase = new TestBase();
		testBase.init("Chrome", System.getProperty("user.dir") + "/testData/help.html");
		helpDriver = testBase.getDriver();
		wait = new WebDriverWait(helpDriver, 20000);
	}
}
