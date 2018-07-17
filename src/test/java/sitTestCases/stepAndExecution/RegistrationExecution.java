package sitTestCases.stepAndExecution;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/sitTestCases/features/Registration.feature")

public class RegistrationExecution extends AbstractTestNGCucumberTests {

}
