package uiAuto.testFlows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiAuto.pageObjects.HomePage;


public class SortingLogic {
	
	
	public boolean verifyDay1(WebDriverWait wait, WebDriver driver)
	{
		boolean flag=false;
		HomePage homePage=new HomePage(driver);
		if (homePage.verifyTitleOfHomePage(wait,"THIS IS DEMO SITE FOR"))
		{
			if (homePage.verifyTitleOfMobilePage(wait, "MOBILE"))
			{
				if (homePage.verifySorting(wait, "Name"))
				{
					return true;
				}
			}			
		}
		return flag;
	}
	
}
