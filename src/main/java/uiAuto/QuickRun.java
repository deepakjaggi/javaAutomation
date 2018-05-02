package uiAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickRun {

	public static void main(String[] args) throws InterruptedException {

		WebDriverWait wait = null;
		String url = "http://live.guru99.com/index.php/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20000);
		Thread.sleep(5000);

		/*
		 * Day1: Step1: Launch home page and verify the title of the page is : *This is
		 * a Demo site* Step2: Click on the Mobile menu and verify the title of the page
		 * is : *MOBILE* Step3: SortBy name, and verify that all the products are sorted
		 * by name
		 */
		// Step1:
		String propTitleXpath = "//*[@class='page-title']";
		WebElement elePropTitleXpath = driver.findElement(By.xpath(propTitleXpath));
		wait.until(ExpectedConditions.visibilityOf(elePropTitleXpath));
		if (elePropTitleXpath.getText().toString().trim().toUpperCase().equals("THIS IS DEMO SITE FOR")) {
			System.out.println("Step 1 -- OK ");
		}
		// Step2: Click on Mobile Link
		String propMobileLinkXpath = "//*[@class='level0 nav-1 first']";
		WebElement elePropMobileLink = driver.findElement(By.xpath(propMobileLinkXpath));
		wait.until(ExpectedConditions.visibilityOf(elePropMobileLink));
		elePropMobileLink.click();
		System.out.println("Step 2-1 -- OK ");
		// Step2: verify Title
		String propMobilePageTitleXPath = "//*[@class='page-title category-title']";
		WebElement elePropMobilePageTitleXPath = driver.findElement(By.xpath(propMobilePageTitleXPath));
		if (elePropMobilePageTitleXPath.getText().toString().trim().toUpperCase().equals("MOBILE")) {
			System.out.println("Step 2-2 -- OK ");
		}
		// Step3: Click on SORT BY
		String propSortByDropDown = "//select[@title='Sort By']";
		WebElement elePropSortByDropDown = driver.findElement(By.xpath(propSortByDropDown));
		wait.until(ExpectedConditions.visibilityOf(elePropSortByDropDown));
		elePropSortByDropDown.click();
		System.out.println("Step 3-1 -- OK ");

		// Step3: SORT by NAME
		Select lv = new Select(elePropSortByDropDown);
		try {
			lv.selectByVisibleText("Name");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			System.out.println("handeled -- But Element is clicked");
			System.out.println("Step 3-2 -- OK ");
		}

		// Step 3-3 : get the list of names of all the phones and verify that they are
		// displayed in sorted order or not ?
		WebElement eleParenGrid = driver.findElement(By.className("category-products"));
		List<WebElement> nameOfProducts = eleParenGrid.findElements(By.className("product-name"));
		List<String> namesPhones1 = new ArrayList<String>();
		for (WebElement ele : nameOfProducts) {
			namesPhones1.add(ele.getText().toString());
		}
		List<String> namesPhones2 = new ArrayList<String>();
		for (WebElement ele : nameOfProducts) {
			namesPhones2.add(ele.getText().toString());
		}
		Collections.sort(namesPhones2);
		if (namesPhones1.toString().equals(namesPhones2.toString())) {
			System.out.println("Collection is Sorted");
		}
		System.out.println("Day 1 Test case is over");

	}
}
