package com.tastyNibbles.stepDefinition;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    // Step definition to enter invalid email during login
    @When("User enters the {string} invalid email")
    public void user_enters_the_invalid_email(String string) {
    	Browser.init("Login report");
    	
        LoginPage.inputEmail(string);
    }

    // Step definition to enter password during login
    @When("User enters the {string} password")
    public void user_enters_the_password(String string) {
        LoginPage.inputPassword(string);
    }

    // Step definition to verify the login error message (e.g., invalid credentials)
    @And("User verifies the {string} error message")
    public void user_verifies_the_error_message(String string) {
        LoginPage.checkSingInErrorMessage(string);
    }

    // Step definition to verify successful login by checking for a specific text (like "My Account")
    @And("User verifies {string} is displayed or not")
    public void user_verifies_is_displayed_or_not(String string) {
        LoginPage.confirmSingInSuccess(string);
    }
}
