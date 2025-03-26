package com.tastyNibbles.stepDefinition;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.pages.RegistrationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

    // Step to open the browser
    @Given("User opens the Browser")
    public void user_opens_the_browser() throws Exception {
    	Browser.init("Registration report");
        Browser.openBrowser();
    }

    // Step to navigate to the specified URL
    @And("User navigate to the {string} web page")
    public void user_navigate_to_the_web_page(String string) throws Exception {
        Browser.navigateToUrl(string);
    }

    // Step to click on the "ACCOUNT" link from homepage
    @When("User clicks on Account link")
    public void user_clicks_on_account_link() {
        RegistrationPage.clickAccountLink_Reg();
    }

    // Step to click on the "Create account" link
    @When("user clicks on Create account link")
    public void user_clicks_on_create_account_link() {
        RegistrationPage.clickCreateAccountLink_Reg();
    }

    // Step to enter first name into the form
    @When("User enters {string} in FirstName")
    public void user_enters_in_first_name(String string) {
        RegistrationPage.inputFirstName_Reg(string);
    }

    // Step to enter last name into the form
    @And("User enters  {string} in LastName")
    public void user_enters_in_last_name(String string) {
        RegistrationPage.inputLastName_Reg(string);
    }

    // Step to enter email address into the form
    @And("User enters {string} in email")
    public void user_enters_in_email(String string) {
        RegistrationPage.inputEmail_Reg(string);
    }

    // Step to enter password into the form
    @And("User enters  {string} in password")
    public void user_enters_in_password(String string) {
        RegistrationPage.inputPassword_Reg(string);
    }

    // Step to click the "Create" button to submit the form
    @And("User clicks on Create button")
    public void user_clicks_on_create_button() {
        RegistrationPage.submitCreateAccount_Reg();
    }

    // Step to verify an error message (e.g., missing fields or invalid input)
    @Then("User verifies the error message")
    public void user_verifies_the_error_message() {
        RegistrationPage.verifyRegErrorMessage();
    }

    // Step to verify that the user has been registered successfully
    @Then("User verifies  registered successfully")
    public void user_verifies_registered_successfully() {
        RegistrationPage.verifySuccessfulRegMessage();
    }

    // Step to close the browser after test is completed
    @And("User closes the Browser")
    public void user_closes_the_browser() {
        RegistrationPage.closeBrowserAfterReg();
    }
}
