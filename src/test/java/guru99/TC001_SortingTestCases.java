package guru99;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiAuto.reports.ExtentManager;
import uiAuto.testFlows.SortingLogic;
import uiAuto.utility.ExcelReader;

public class TC001_SortingTestCases {

	ExtentReports extentReports;
	ExtentTest test;
	SortingLogic sortingLogic;

	ExcelReader excelReader;

	@BeforeTest
	public void setUP() {
		sortingLogic = new SortingLogic();
		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "Res.html");
	}

	@Test()
	public void verifySortingForPositionSelection() throws InterruptedException {

		test = extentReports.startTest("TCID 001");
		test.log(LogStatus.INFO, "testing for : " + "Sorting Logic Position");
		if (sortingLogic.verifySortingByName()) {
			test.log(LogStatus.PASS, "Success for TC ID 001");
		} else {
			test.log(LogStatus.FAIL, "Fail for TC ID 001");
		}
		extentReports.endTest(test);
		extentReports.flush();
		// it will generate the report1.
	}

	@AfterTest
	public void endTest() {
		
	}
}
