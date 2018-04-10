package uiAuto.pageObjects;

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

	public WebDriver getGuru99WebDriver() {
		return guru99WebDriver;
	}

	public void setGuru99WebDriver(WebDriver guru99WebDriver) {
		this.guru99WebDriver = guru99WebDriver;
	}

	@FindBy(xpath = "//*[@id='nav']/ol/li[1]/a")
	WebElement lnkMobile;

	@FindBy(xpath = "//*[@id=\\\"top\\\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement selectSortBy;

	@FindBy(className = "category-products")
	WebElement eleParenGrid;

	@FindBy(className = "product-name")
	List<WebElement> nameOfProducts;
	
	public WebElement getLnkMobile() {
		return lnkMobile;
	}

	public void setLnkMobile(WebElement lnkMobile) {
		this.lnkMobile = lnkMobile;
	}

	public WebElement getSelectSortBy() {
		return selectSortBy;
	}

	public void setSelectSortBy(WebElement selectSortBy) {
		this.selectSortBy = selectSortBy;
	}

	public WebElement getEleParenGrid() {
		return eleParenGrid;
	}

	public void setEleParenGrid(WebElement eleParenGrid) {
		this.eleParenGrid = eleParenGrid;
	}

	public List<WebElement> getNameOfProducts() {
		return nameOfProducts;
	}

	public void setNameOfProducts(List<WebElement> nameOfProducts) {
		this.nameOfProducts = nameOfProducts;
	}	

	public HomePage() {
		PageFactory.initElements(guru99WebDriver, this);
	}

	// Actions
	public void clickOnMobileSection(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(lnkMobile));
		lnkMobile.click();
	}

	public void selectSortBy(WebDriverWait wait, String value) {
		wait.until(ExpectedConditions.visibilityOf(selectSortBy));
		Select lv = new Select(selectSortBy);
		try {
			lv.selectByVisibleText(value);
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			// System.out.println(e.getMessage());
			System.out.println("handeled -- Element is clicked");
		}
	}

	
}
