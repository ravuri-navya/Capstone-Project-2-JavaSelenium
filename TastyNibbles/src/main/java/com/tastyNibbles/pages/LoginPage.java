package com.tastyNibbles.pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.LoginPageObjects;
import com.tastyNibbles.screenshot.Capture;

public class LoginPage extends Browser {

    // Method to enter email into the login form
    public static void inputEmail(String email) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Entering email ");
		logger1.log(Status.INFO,"Entering email  ");
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.email));
            LoginPageObjects.loginEmailField().sendKeys(email);
            logger1.addScreenCaptureFromPath(Capture.screenShot("Login ScreenShot"));
            logger1.log(Status.PASS,"Entered  email successful");
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered  email Unsuccessful");
        }
        extent.flush();
    }

    // Method to enter password into the login form
    public static void inputPassword(String password) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Entering password ");
		logger1.log(Status.INFO,"Entering password ");
        try {
            LoginPageObjects.loginPasswordField().sendKeys(password);
            logger1.log(Status.PASS,"Entered password successful");
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered password Unsuccessful");
        }
        extent.flush();
    }

    // Method to click the Sign In button
    public static void clickSignInButton() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Clicking singin Button ");
		logger1.log(Status.INFO,"Clicking singin Button ");
		
        try {
            LoginPageObjects.signInButton().click();
            logger1.log(Status.PASS,"Cliking singin button Successfully");
        } catch (Exception e) {
            System.out.println("Error while clicking Sign In button: " + e.getMessage());
            logger1.log(Status.FAIL,"Cliking singin button Successfully");
        }
        extent.flush();
    }

    // Method to verify the error message when login fails
    public static void checkSingInErrorMessage(String msg) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Checking error message  ");
		logger1.log(Status.INFO,"Checking error message  ");
		
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.errorMsg));
            Assert.assertEquals(LoginPageObjects.errorText().getText(), msg);
            logger1.log(Status.PASS,"Checking error message successfully ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger1.log(Status.PASS,"Checking error message Unsuccessfully ");
        }
        extent.flush();
    }

    // Method to verify successful login by checking presence of "My Account"
    public static void confirmSingInSuccess(String str) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Confirm singin ");
		logger1.log(Status.INFO,"Confirm singin ");
		
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObjects.myAccountElement));
            Assert.assertEquals(LoginPageObjects.myAccountLabel().getText(), str);
            logger1.log(Status.PASS,"Confirming singin is successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger1.log(Status.PASS,"Confirming singin is Unuccessful");
        }
        extent.flush();
    }
}
