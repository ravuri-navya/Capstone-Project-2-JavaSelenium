package com.tastyNibbles.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.RegistrationObjects;
import com.tastyNibbles.screenshot.Capture;

public class RegistrationPage extends Browser {

    // Clicks on the "Create account" link
    public static void clickCreateAccountLink_Reg() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            RegistrationObjects.openCreateAccount().click();
        } catch (Exception e) {
            System.out.println("Exception in clickOnCreateAccount: " + e.getMessage());
        }
        extent.flush();
    }

    // Enters the First Name into the input field
    public static void inputFirstName_Reg(String firstName) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObjects.firstName));
            RegistrationObjects.firstNameField().sendKeys(firstName);
            logger1.addScreenCaptureFromPath(Capture.screenShot("Registration ScreenShot"));
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in enterFirstName: " + e.getMessage());
        }
        extent.flush();
    }

    // Enters the Last Name into the input field
    public static void inputLastName_Reg(String lastName) {
        try {
            RegistrationObjects.lastNameField().sendKeys(lastName);
           
        } catch (Exception e) {
            System.out.println("Exception in enterLastName: " + e.getMessage());
        }
    }

    // Enters the Email into the input field
    public static void inputEmail_Reg(String email) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            RegistrationObjects.emailField().sendKeys(email);
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in enterEmail: " + e.getMessage());
        }
        extent.flush();
    }

    // Enters the Password into the input field
    public static void inputPassword_Reg(String password) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            RegistrationObjects.passwordField().sendKeys(password);
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in enterPassword: " + e.getMessage());
        }
        extent.flush();
    }

    // Clicks the "Create" button to submit the registration form
    public static void submitCreateAccount_Reg() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            RegistrationObjects.clickCreateAccountBtn().click();
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in clickCreate: " + e.getMessage());
        }
        extent.flush();
    }

    // Verifies if the error message is displayed (e.g., missing field or email already exists)
    public static void verifyRegErrorMessage() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObjects.errorDiv));
            Assert.assertTrue(RegistrationObjects.getErrorMessageBox().isDisplayed());
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in verifyErrorMsg: " + e.getMessage());
        }
        extent.flush();
    }

    // Verifies if the registration was successful by checking for the "Log out" element
    public static void verifySuccessfulRegMessage() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            RegistrationObjects.headerAccountLink().click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObjects.logoutElement));
            Assert.assertEquals(RegistrationObjects.getLogoutLabel().getText(), "Log out");
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in verifySuccessfullRegistrationMsg: " + e.getMessage());
        }
        extent.flush();
    }

    // Closes the browser after test completion
    public static void closeBrowserAfterReg() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            Browser.closeBrowser();
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in closeBrowser: " + e.getMessage());
        }
        extent.flush();
    }

    // Closes the popup modal and clicks the "ACCOUNT" link
    public static void clickAccountLink_Reg() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationObjects.closeButton));
            RegistrationObjects.closeButton().click();
            RegistrationObjects.headerAccountLink().click();
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in clickOnAccount: " + e.getMessage());
        }
        extent.flush();
    }
}
