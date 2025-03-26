package com.tastyNibbles.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tastyNibbles.browser.Browser;

public class LoginPageObjects extends Browser {

    // Locator for the email input field
    public static By email = By.xpath("//input[@name=\"customer[email]\"]");

    // Locator for the password input field
    public static By password = By.xpath("//input[@name=\"customer[password]\"]");

    // Locator for the sign-in button
    public static By signInButoon = By.xpath("//button[@class=\"btn btn--full\"]");

    // Locator for the error message (if login fails)
    public static By errorMsg = By.xpath("//div[@class=\"errors\"]/ul/li");

    // Locator for "My Account" element after successful login
    public static By myAccountElement = By.xpath("//h1[@class=\"section-header__title\"]");

    // Returns the email WebElement
    public static WebElement loginEmailField() {
        return driver.findElement(email);
    }

    // Returns the password WebElement
    public static WebElement loginPasswordField() {
        return driver.findElement(password);
    }

    // Returns the sign-in button WebElement
    public static WebElement signInButton() {
        return driver.findElement(signInButoon);
    }

    // Returns the error message WebElement
    public static WebElement errorText() {
        return driver.findElement(errorMsg);
    }

    // Returns the "My Account" WebElement
    public static WebElement myAccountLabel() {
        return driver.findElement(myAccountElement);
    }
}
