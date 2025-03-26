package com.tastyNibbles.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tastyNibbles.browser.Browser;

public class AddToCartObjects extends Browser {
	public static By searchBox=By.xpath("//input[@name=\"q\"]");
	public static By resultContainer=By.xpath("//div[@class=\"new-grid search-grid\"]");
	public static By addToCartButton=By.xpath("//button[@name=\"add\"]");
	public static By cartButton =By.xpath("//a[@id=\"HeaderCartTrigger\"]");
	public static By cartDiv=By.xpath("//div[@class=\"cart__items\"]");
	public static By closeCart =By.xpath("//button[@class=\"site-nav_link site-nav_link--icon js-close-header-cart\"]");
	
	//method to get all the search items and returns as a list
	public static  List<WebElement> resultItems() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"new-grid search-grid\"]/div"));
        return list;
	}
	//method to get all the cartItems and returns as a list
	public static  List<WebElement> cartItems() {
        List<WebElement> list = driver.findElements(By.xpath("//a[@class=\"cart__item-name\"]"));
        return list;
	}
	//method to find searchElement and returns it
	public static WebElement searchElement() {
		return driver.findElement(searchBox);
	}
	//method to find add to cart button and return it
	public static WebElement addToCart() {
		return driver.findElement(addToCartButton);
	}
	//method to find cart button and returns it
	public static WebElement cart() {
		return driver.findElement(cartButton);
	}
	//method to find close button element and returns it
	public static WebElement closeCart() {
		return driver.findElement(closeCart);
	}

}