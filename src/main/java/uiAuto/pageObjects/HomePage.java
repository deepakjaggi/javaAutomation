package uiAuto.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver guru99WebDriver;

	@FindBy(xpath = "//*[@class='page-title']")
	WebElement eleHomePageTitle;

	@FindBy(xpath = "//*[@class='level0 nav-1 first']")
	WebElement eleMobileLink;

	@FindBy(xpath = "//*[@class='page-title category-title']")
	WebElement eleMobilePageTitle;

	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement eleSortByDropDown;

	@FindBy(className = "category-products")
	WebElement eleParenGrid;

	@FindBy(className = "product-name")
	List<WebElement> nameOfProducts;

	public HomePage(WebDriver driver) {
		guru99WebDriver = driver;
		PageFactory.initElements(guru99WebDriver, this);
	}

	public boolean verifyTitleOfHomePage(WebDriverWait wait, String expectedText) {
		boolean flag = false;
		wait.until(ExpectedConditions.visibilityOf(eleHomePageTitle));
		if (eleHomePageTitle.getText().toString().trim().toUpperCase().equals(expectedText)) {
			return true;
		}
		return flag;
	}

	public boolean verifyTitleOfMobilePage(WebDriverWait wait, String expectedText) {
		boolean flag = false;
		wait.until(ExpectedConditions.visibilityOf(eleMobileLink));
		eleMobileLink.click();
		wait.until(ExpectedConditions.visibilityOf(eleMobilePageTitle));
		if (eleMobilePageTitle.getText().toString().trim().toUpperCase().equals(expectedText)) {
			return true;
		}
		return flag;
	}

	public boolean verifySorting(WebDriverWait wait, String textToSelect) {
		boolean flag = false;
		wait.until(ExpectedConditions.visibilityOf(eleSortByDropDown));
		eleSortByDropDown.click();
		Select lv = new Select(eleSortByDropDown);
		try {
			lv.selectByVisibleText(textToSelect);
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			System.out.println("handeled -- But Element is clicked");
			System.out.println("Step 3-2 -- OK ");
		}
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
			flag=true;
		}
		return flag;
	}

}
