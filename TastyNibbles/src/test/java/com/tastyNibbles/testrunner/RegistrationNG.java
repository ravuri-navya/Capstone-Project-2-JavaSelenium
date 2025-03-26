package com.tastyNibbles.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\resources\\com.TastyNibbles.feature\\Registration.feature",
glue = {"com.tastyNibbles.stepDefinition"},
plugin = {"pretty","html:target/cucumberReport/report1.html"})
//tags = ("@SmokeTest or @SystemTest"),
//monochrome=true)
public class RegistrationNG extends AbstractTestNGCucumberTests {

}
 