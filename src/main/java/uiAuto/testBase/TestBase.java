package uiAuto.testBase;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	private WebDriver guruDriver;
	private String chromeDriverPath;

	public void init(String browser, String url) {
		selectBrowser(browser.toUpperCase());
		getURL(url);
		guruDriver.manage().window().maximize();
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("CHROME")) {
			if (SystemUtils.IS_OS_WINDOWS) {
				chromeDriverPath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
			} else if (SystemUtils.IS_OS_MAC) {
				chromeDriverPath = "/Users/usha/Desktop/chromedriver";
			}
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			guruDriver = new ChromeDriver();
		}
	}

	public void getURL(String url) {
		guruDriver.get(url);
	}

	public void closeBrowser() {
		guruDriver.close();
	}

	public WebDriver getGuruDriver() {
		return guruDriver;
	}

	public void setGuruDriver(WebDriver guruDriver) {
		this.guruDriver = guruDriver;
	}

	public String getChromeDriverPath() {
		return chromeDriverPath;
	}

	public void setChromeDriverPath(String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}

}
