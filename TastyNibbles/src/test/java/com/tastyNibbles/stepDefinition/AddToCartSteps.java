package com.tastyNibbles.stepDefinition;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tastyNibbles.CustomizedExceptions.CustomizedExceptions;
import com.tastyNibbles.browser.Browser;
import com.tastyNibbles.pages.AddToCartPage;
import com.tastyNibbles.pages.LoginPage;



public class AddToCartSteps {
	
	@When("User enters the login credentials")
	public void user_enters_the_login_credentials(DataTable dataTable) throws Exception {
	Browser.init("AddToCart");
		List<List<String>> credentials = credentials(
				"C:\\Users\\hemar\\eclipse-workspace\\TastyNibbles\\src\\test\\resources\\TestData.xlsx");
		dataTable = DataTable.create(credentials);
		LoginPage.inputEmail(dataTable.cell(0, 0));
		LoginPage.inputPassword(dataTable.cell(0, 1));
		System.out.println(dataTable.cell(0, 0));
		System.out.println(dataTable.cell(0, 1));
	}
	public static List<List<String>> credentials(String excelFilePath) throws Exception {
		List<List<String>> credentials = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			List<String> rowData = new ArrayList<>();
			if(row!=null) {
				for(int j=0;j<row.getLastCellNum();j++) {
					Cell cell=row.getCell(j);
					if(cell!=null) {
						rowData.add(cell.getStringCellValue());
					}else {
						rowData.add("");
					}
				}
			}
		credentials.add(rowData);
		}
	workbook.close();
	return credentials;
	}

	@And("User clicks on signIn button")
	public void user_clicks_on_sign_in_button() throws Exception{
	   LoginPage.clickSignInButton();
	}

	@Then("User Search {string} for a product")
	public void user_search_for_a_product(String string) throws CustomizedExceptions {
	    AddToCartPage.searchProduct(string);
	}

	@And("User selects {string} the product")
	public void user_selects_the_product(String string) throws CustomizedExceptions {
		AddToCartPage.selectProduct(string);

	}

	@Then("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() throws CustomizedExceptions{
		AddToCartPage.addItemToCart();
	}

	@And("User Verifies the product {string} in cart")
	public void user_verifies_the_product_in_cart(String string) throws CustomizedExceptions {
		AddToCartPage.verifyCart(string);
	}
	@And("User closes the browser")
	public void user_closes_the_browser() {
	   
	}
}