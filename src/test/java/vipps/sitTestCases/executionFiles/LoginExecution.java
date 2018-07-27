package vipps.sitTestCases.executionFiles;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "classpath:vipps/sitTestCases/features/Login.feature", glue = "classpath:vipps.sitTestCases.stepFiles")

public class LoginExecution {

}
