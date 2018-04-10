package uiAuto;

import java.util.ArrayList;
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

import edu.emory.mathcs.backport.java.util.Collections;

public class QuickRun {

	public static void main(String[] args) throws InterruptedException {

		WebDriverWait wait = null;
		String url = "http://live.guru99.com/index.php/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		// capabilities.setCapability("chrome.binary", "C:\\Program
		// Files\\Google\\Chrome\\Application\\chrome.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20000);
		Thread.sleep(5000);

		String propMobileLink = "//*[@id='nav']/ol/li[1]/a";
		WebElement elePropMobileLink = driver.findElement(By.xpath(propMobileLink));
		wait.until(ExpectedConditions.visibilityOf(elePropMobileLink));
		elePropMobileLink.click();

		// wait until you see the drop down box
		String propSelectSortBy = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select";
		WebElement eleSelectSortBy = driver.findElement(By.xpath(propSelectSortBy));
		wait.until(ExpectedConditions.visibilityOf(eleSelectSortBy));
		Select lv=new Select(eleSelectSortBy);
		try {
		lv.selectByVisibleText("Position");
		}
		catch(org.openqa.selenium.StaleElementReferenceException e)
		{
			//System.out.println(e.getMessage());
			System.out.println("handeled -- But Element is clicked");			
		}		
		// Get all the elements in list
		WebElement eleParenGrid=driver.findElement(By.className("category-products"));
		List<WebElement> nameOfProducts = eleParenGrid.findElements(By.className("product-name"));		
		
		List<String> namesPhones1=new ArrayList<String>();
		for (WebElement ele : nameOfProducts)
		{
			namesPhones1.add(ele.getText().toString());
		}		
		
		List<String> namesPhones2=new ArrayList<String>();
		for (WebElement ele : nameOfProducts)
		{
			namesPhones2.add(ele.getText().toString());
		}
		Collections.sort(namesPhones2);
		
		if (namesPhones1.toString().equals(namesPhones2.toString()))
		{
			System.out.println("Test case is passed");			
		}
		else
		{
			System.out.println("Test case is failed");
		}
		
		
		System.out.println("Script Over");
	}
}
