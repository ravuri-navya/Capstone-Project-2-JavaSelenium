package com.tastyNibbles.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tastyNibbles.CustomizedExceptions.CustomizedExceptions;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.AddToCartObjects;
import com.tastyNibbles.locators.AddingMultipleProductsObjects;
import com.tastyNibbles.screenshot.Capture;

public class AddingMultipleProductsPage extends Browser {

    /**
     * Method to navigate to the cart page.
     * It waits for the cart container to appear, then refreshes the page and clicks the cart icon.
     */
    public static void navigateToCart() throws InterruptedException {
        extent.attachReporter(reporter);
        logger1 = extent.createTest("Navigating to cart");
        logger1.log(Status.INFO, "Navigating to cart ");

        try {
            // Wait until the cart container is visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartObjects.cartDiv));

            // Refresh and click the cart icon
            driver.navigate().refresh();
            AddToCartObjects.cart().click();
            logger1.addScreenCaptureFromPath(Capture.screenShot("Adding multiple products screen shot"));

            logger1.log(Status.PASS, "Navigating is successful");
        } catch (Exception e) {
            System.out.println("Exception in navigating to cart" + e.getMessage());
            logger1.log(Status.FAIL, "Navigating is unsuccessful");
        }
        extent.flush();
    }

    /**
     * Method to verify that the total price displayed in the cart is equal
     * to the sum of individual product prices listed.
     */
    public static void verifyPrices() throws CustomizedExceptions {
        double priceOfAllItems = 0;

        extent.attachReporter(reporter);
        logger1 = extent.createTest("Vefiying prices of all added items and total price");
        logger1.log(Status.INFO, "Vefiying prices of all added items and total price ");

        try {
            // Wait until the cart is visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartObjects.cartDiv));

            // Get all price elements from the cart
            List<WebElement> list = AddingMultipleProductsObjects.prices();
            ArrayList<String> prices = new ArrayList<>();

            // Clean up the prices (remove ₹ and split whitespace) and add to list
            for (WebElement element : list) {
                String[] splitPrices = element.getText().replace("₹", "").trim().split("\\s+");
                for (String price : splitPrices) {
                    prices.add(price);
                }
            }

            // Calculate total price from parsed individual product prices
            for (int i = 1; i < prices.size(); i += 2) {
                priceOfAllItems += Double.parseDouble(prices.get(i));
            }

            System.out.println(priceOfAllItems + "  prices");

            // Get the total price displayed on the cart
            WebElement totalElement = AddingMultipleProductsObjects.totalPrice();
            String totalText = totalElement.getText().trim();

            // Remove any non-numeric characters and trailing decimals
            totalText = totalText.replaceAll("[^0-9]", "").trim();
            if (totalText.length() > 2) {
                totalText = totalText.substring(0, totalText.length() - 2);
            }

            double totalPrice = Double.parseDouble(totalText);

            // Validate that calculated sum equals displayed total
            Assert.assertEquals(totalPrice, priceOfAllItems);

            logger1.log(Status.PASS, "Verification of prices is successful");

        } catch (Exception e) {
            logger1.log(Status.FAIL, "Verification is unsuccessful");
            throw new CustomizedExceptions("Error in verifying price: " + e.getMessage());
        }

        extent.flush();
    }
}
