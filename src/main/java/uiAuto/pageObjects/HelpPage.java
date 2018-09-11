package uiAuto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HelpPage
{

	WebDriver driver;

	@FindBy(id = "Text1")
	WebElement txtUserName;

	@FindBy(id = "Text2")
	WebElement txtPwd;

	@FindBy(id = "Text3")
	WebElement txtCpwd;
	
	@FindBy(id = "Confirm Registration")
	WebElement btnConfirmRegistration;

	@FindBy(id = "lblText")
	WebElement eleValidationMessage;
	
	
	public HelpPage(WebDriver webDriver)
	{
		driver=webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void registerUser(String username, String pwd, String cpwd, ExtentTest test) throws InterruptedException
	{
		txtUserName.sendKeys(username);
		test.log(LogStatus.INFO, "Entered User Name");
		txtPwd.sendKeys(pwd);
		test.log(LogStatus.INFO, "Entered pwd");
		txtCpwd.clear();
		txtCpwd.sendKeys(cpwd);
		test.log(LogStatus.INFO, "Entered cpwd");
		btnConfirmRegistration.click();
		test.log(LogStatus.INFO, "Clicked on Registration");
		Thread.sleep(1000);		
	}

	public String getValidationMessageForRegistration()
	{
		return eleValidationMessage.getText();
	}
	
}