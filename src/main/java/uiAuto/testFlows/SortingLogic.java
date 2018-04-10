package uiAuto.testFlows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiAuto.pageObjects.HomePage;
import uiAuto.testBase.TestBase;
import uiAuto.workFlows.WorkFlows;

public class SortingLogic {

	TestBase testBase=new TestBase();
	WebDriver guruDriver;
	WebDriverWait wait;
	HomePage homePage=new HomePage();
	WorkFlows workFlows=new WorkFlows();	
	
	
	public SortingLogic()
	{
		testBase.init("Chrome", "http://live.guru99.com/index.php/");
		guruDriver=testBase.getGuruDriver();
		wait=new WebDriverWait(guruDriver, 20000);
		homePage.setGuru99WebDriver(guruDriver);
	}
	
	public boolean verifySortingByName()
	{
		boolean flag=false;
		homePage.clickOnMobileSection(wait);
		homePage.selectSortBy(wait, "Position");
		if (workFlows.verifySortingDisplay(wait, homePage.getNameOfProducts()))
		{
			flag=true;
		}
		
		return flag;
	}
	
}
