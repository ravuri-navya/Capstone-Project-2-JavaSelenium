package com.tastyNibbles.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.feature\\AddingMultipleProducts.feature",
glue= {"com.tastyNibbles.stepDefinition"},
plugin = {"pretty","html:target/cucumberReport/report4.html"})
public class AddingMultipleProductsNG extends AbstractTestNGCucumberTests{
	
}