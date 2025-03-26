package com.tastyNibbles.pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.LogOutObjects;
import com.tastyNibbles.screenshot.Capture;

public class LogOutPage extends Browser {
    
    // Method to click the "Log out" link
    public static void performLogoutAction() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            LogOutObjects.logoutOption().click(); // Clicks on the logout button
            logger1.addScreenCaptureFromPath(Capture.screenShot("Logout Screen Shot"));
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in logoutFromApp: " + e.getMessage());
        }
        extent.flush();
    }

    // Method to verify if the user is redirected to the homepage after logout
    public static void confirmUserRedirectionToHome(String url) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Searching for a product ");
		logger1.log(Status.INFO,"Searcing for a product ");
        try {
            // Wait until the homepage verification div is visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LogOutObjects.vefiryDiv));
            
            // Assert that the current URL matches the expected homepage URL
            Assert.assertEquals(LogOutObjects.fetchHomePageURL(), url);
            logger1.log(Status.PASS,"Searching for a product is successful");
        } catch (Exception e) {
            System.out.println("Exception in verifyLogout: " + e.getMessage());
        }
        extent.flush();
    }
}
