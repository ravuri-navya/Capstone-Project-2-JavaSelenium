package com.tastyNibbles.stepDefinition;

import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.pages.LogOutPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LogOutSteps {

    // Step definition for logging out the user by clicking the logout button
    @And("User selects Logout option")
    public void user_selects_logout_option() {
    	Browser.init("Logout report");
        LogOutPage.performLogoutAction(); // Calls method to perform logout
    }

    // Step definition to verify that the session has ended and user is redirected to homepage
    @Then("User Verify that the session ends and the user is redirected to the {string} homepage.")
    public void user_verify_that_the_session_ends_and_the_user_is_redirected_to_the_homepage(String string) {
        LogOutPage.confirmUserRedirectionToHome(string); // Verifies the redirection after logout
    }
}
