package uiAuto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;

	public LoginPage(WebDriver webDriver)
	{
		driver=webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public boolean enterLoginInformation(String userName, String pwd)
	{		
		try
		{
			this.username.sendKeys(userName);
			this.password.sendKeys(pwd);			
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}		
		return false;
	}
}

