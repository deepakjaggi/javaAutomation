package vipps.sitTestCases.executionFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) 
//Hello1

@CucumberOptions(features = "classpath:vipps/sitTestCases/features/Login.feature", glue = "classpath:vipps.sitTestCases.stepFiles")

public class LoginExecution extends AbstractTestNGCucumberTests{

}
