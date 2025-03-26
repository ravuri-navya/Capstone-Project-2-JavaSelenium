package com.tastyNibbles.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tastyNibbles.browser.Browser;

public class LogOutObjects extends Browser {

    // Locator for the "Log out" link
    public static By logoutButton = By.linkText("Log out");

    // Locator for the "ACCOUNT" link (typically used to open the account dropdown)
    public static By accountLink = By.linkText("ACCOUNT");

    // Locator for a specific div used to verify that the user is on the homepage
    public static By vefiryDiv = By.xpath("//div[@class=\"hero__animation-contents\"]");

    // Returns the WebElement for the "ACCOUNT" link
    public static WebElement accountSectionLink() {
        return driver.findElement(accountLink);
    }

    // Returns the WebElement for the "Log out" button
    public static WebElement logoutOption() {
        return driver.findElement(logoutButton);
    }

    // Returns the current URL of the page (used to verify redirection to homepage)
    public static String fetchHomePageURL() {
        return driver.getCurrentUrl();
    }
}
