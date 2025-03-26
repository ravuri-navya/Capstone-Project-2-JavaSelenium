package com.tastyNibbles.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tastyNibbles.browser.Browser;

public class RegistrationObjects extends Browser {

    // Locators for registration form fields
    public static By firstName = By.xpath("//input[@name='customer[first_name]']");
    public static By createAccountLink = By.linkText("Create account");
    public static By lastName = By.xpath("//input[@name='customer[last_name]']");
    public static By email = By.xpath("//input[@name='customer[email]']");
    public static By password = By.xpath("//input[@name='customer[password]']");
    public static By createButton = By.xpath("//input[@class='btn btn--full']");
    public static By logoutElement = By.linkText("Log out");
    public static By errorDiv = By.xpath("//div[@class='errors']");

    // Locators for modal popup and account navigation
    public static By closeButton = By.xpath("//span[@class='engt_modal_close-btn']");
    public static By accountLink = By.linkText("ACCOUNT");

    // WebElement methods to interact with elements

    // Returns the "Create account" link WebElement
    public static WebElement openCreateAccount() {
        return driver.findElement(createAccountLink);
    }

    // Returns the "First Name" input field WebElement
    public static WebElement firstNameField() {
        return driver.findElement(firstName);
    }

    // Returns the "Last Name" input field WebElement
    public static WebElement lastNameField() {
        return driver.findElement(lastName);
    }

    // Returns the "Email" input field WebElement
    public static WebElement emailField() {
        return driver.findElement(email);
    }

    // Returns the "Password" input field WebElement
    public static WebElement passwordField() {
        return driver.findElement(password);
    }

    // Returns the "Create" button WebElement
    public static WebElement clickCreateAccountBtn() {
        return driver.findElement(createButton);
    }

    // Returns the "Log out" text WebElement for validation
    public static WebElement getLogoutLabel() {
        return driver.findElement(logoutElement);
    }

    // Returns the error message WebElement (e.g., email already exists)
    public static WebElement getErrorMessageBox() {
        return driver.findElement(errorDiv);
    }

    // Returns the close button WebElement on the modal popup
    public static WebElement closeButton() {
        return driver.findElement(closeButton);
    }

    // Returns the "ACCOUNT" link WebElement in header
    public static WebElement headerAccountLink() {
        return driver.findElement(accountLink);
    }
}
