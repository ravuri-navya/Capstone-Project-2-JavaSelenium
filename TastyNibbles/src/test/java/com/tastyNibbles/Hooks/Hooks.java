package com.tastyNibbles.Hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tastyNibbles.browser.Browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;


public class Hooks {
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;
	@BeforeAll
	public static void initilizingExtentReports() {
		Browser.init("Extent Report");
	}
	@Before
	public static void creatingExtentTest(Scenario scenario) {
		logger1 = extent.createTest("Testing");
	}
	@After
	public static void closeapplication() {
		Browser.closeBrowser();
		extent.flush();
	}

}
