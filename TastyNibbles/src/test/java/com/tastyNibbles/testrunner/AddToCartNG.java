package com.tastyNibbles.testrunner;

import com.tastyNibbles.browser.Browser;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.feature\\AddToCart.feature",
glue= {"com.tastyNibbles.stepDefinition"},
plugin = {"pretty","html:target/cucumberReport/report2.html"})
public class AddToCartNG extends AbstractTestNGCucumberTests{
	
	
}