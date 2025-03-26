package com.tastyNibbles.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\resources\\com.tastyNibbles.feature\\LogOut.feature",
glue = {"com.tastyNibbles.stepDefinition"},
plugin = {"pretty","html:target/cucumberReport/report.html"})
//tags = ("@SmokeTest or @Syste  mTest"),
//monochrome=true)
public class LogOutNG extends AbstractTestNGCucumberTests {

}
