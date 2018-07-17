package sitTestCases;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/sitTestCases/Registration.feature")

public class RegistrationExecution extends AbstractTestNGCucumberTests {

}
