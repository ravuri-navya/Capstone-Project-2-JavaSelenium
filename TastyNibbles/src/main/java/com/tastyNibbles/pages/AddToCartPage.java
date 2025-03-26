package com.tastyNibbles.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tastyNibbles.CustomizedExceptions.CustomizedExceptions;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.locators.AddToCartObjects;
import com.tastyNibbles.screenshot.Capture;

public class AddToCartPage extends Browser {

    // Method to enter the product name in the search box and press ENTER
    public static void searchProduct(String product) throws CustomizedExceptions {
        extent.attachReporter(reporter);
        logger1 = extent.createTest("Searching for a product");
        logger1.log(Status.INFO, "Searching for a product");

        try {
            // Wait for search box to be visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartObjects.searchBox));

            // Send product name to search box with ENTER
            AddToCartObjects.searchElement().sendKeys(product, Keys.ENTER);
            logger1.log(Status.PASS, "Searching for a product is successful");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Searching for a product is unsuccessful");
            throw new CustomizedExceptions("Error in searching product: " + e.getMessage());
        }
        extent.flush();
    }

    // Method to select a product from the search results
    public static void selectProduct(String item) throws CustomizedExceptions {
        extent.attachReporter(reporter);
        logger1 = extent.createTest("Selecting product");
        logger1.log(Status.INFO, "Selecting product");

        try {
           
            Thread.sleep(9000); 

            // Wait for result container to be visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartObjects.resultContainer));

            // Loop through results and click on the matching product
            List<WebElement> list = AddToCartObjects.resultItems();
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getText().contains(item)) {
                    list.get(i).click();
                    break;
                }
            }

            logger1.log(Status.PASS, "Selecting product is successful");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Selecting product is unsuccessful");
            throw new CustomizedExceptions("Error in selecting product: " + e.getMessage());
        }
        extent.flush();
    }

    // Method to add the selected product to the cart
    public static void addItemToCart() throws CustomizedExceptions {
        extent.attachReporter(reporter);
        logger1 = extent.createTest("Adding product to cart");
        logger1.log(Status.INFO, "Adding product to cart");

        try {
            // Wait for the "Add to Cart" button to be visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartObjects.addToCartButton));

            // Click on Add to Cart button
            AddToCartObjects.addToCart().click();

            logger1.log(Status.PASS, "Adding product to cart is successful");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Adding product to cart is unsuccessful");
            throw new CustomizedExceptions("Error in adding Item to cart: " + e.getMessage());
        }
        extent.flush();
    }

    // Method to verify if the expected product is present in the cart
    public static void verifyCart(String item) throws CustomizedExceptions {
        extent.attachReporter(reporter);
        logger1 = extent.createTest("Verifying item in cart");
        logger1.log(Status.INFO, "Verifying item in cart");

        try {
            // Wait until the cart items container is visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartObjects.cartDiv));

            // Get the list of items from cart
            List<WebElement> list = AddToCartObjects.cartItems();

            if (list.isEmpty()) {
                // Log and throw custom exception if no items found
                logger1.log(Status.FAIL, "Cart is empty, item not found");
                throw new CustomizedExceptions("Cart is empty, item verification failed");
            }

            // Check if expected item is in the cart
            boolean itemFound = false;
            for (WebElement element : list) {
                if (element.getText().equals(item)) {
                    Assert.assertEquals(element.getText(), item);
                    System.out.println(element.getText());
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                logger1.log(Status.FAIL, "Item not found in the cart");
                throw new CustomizedExceptions("Item '" + item + "' not found in cart");
            }
            logger1.addScreenCaptureFromPath(Capture.screenShot("AddToCart_1"));

            logger1.log(Status.PASS, "Verifying item in cart is successful");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Verifying item in cart is unsuccessful");
            throw new CustomizedExceptions("Error in verifying cart: " + e.getMessage());
        } finally {
            extent.flush(); // Always flush extent reports at the end
        }
    }
}
