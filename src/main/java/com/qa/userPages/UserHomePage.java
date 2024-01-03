package com.qa.userPages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Page;

public class UserHomePage {

	private Page page;
	private Properties prop;
	private String search = "input[name=\"keywords\"]";
	private String searchIcon = "input[type=\"image\"]";
	private String productName = "td a";
	private String addToCart = "//span[text()=\"Add to Cart\"]";
	private String checkout = "//span[text()=\"Checkout\"]";
	private String myAccount = "//span[text()=\"My Account\"]";
	private String continueButton = "//span[text()=\"Continue\"]";
	private String confirmOrder = "//span[text()=\"Confirm Order\"]";
	private String logOff = "//span[text()=\"Log Off\"]";
	private String thanksMessage = "div.grid_16 h1";
	private String advancedSearch = "a strong";
	private String searchBox = "div.contentText input[name=\"keywords\"]";
	private String searchButton = "//span[text()=\"Search\"]";
	private String priceFrom = "input[name=\"pfrom\"]";
	private String priceTo = "input[name=\"pto\"]";

	public UserHomePage(Page page, Properties prop) {

		this.page = page;
		this.prop = prop;
	}

	public void goToUserPage() {
		page.navigate(prop.getProperty("User_Page_url").trim());
	}

	public void searchProduct(String productName) {
		page.fill(this.search, productName);
		page.click(searchIcon);
	}

	public void clickOnProduct(String productName) {
		List<String> allProducts = page.locator(this.productName).allTextContents();
		for (int i = 0; i < allProducts.size(); i++) {
			if (page.locator(this.productName).nth(i).textContent().trim().equalsIgnoreCase(productName)) {
				page.locator(this.productName).nth(i).click();
				break;
			}
		}
	}

	public void addToCart() {
		page.click(addToCart);
	}

	public void clickOnCheckout() {
		page.locator(checkout).last().click();
		;
	}

	public void clickOnMyAccount() {
		page.click(myAccount);

	}

	public void clickOnContinue() {
		page.click(continueButton);
		page.click(continueButton);
	}

	public void clickOnConfirmOrder() {
		page.click(confirmOrder);
	}

	public boolean verifyThanksMessageVisible() {
		return page.locator(thanksMessage).isVisible();
	}

	public void advanceSearch(String priceFrom,String priceTo) {
		
		page.fill(this.priceFrom, priceFrom);
		page.fill(this.priceTo, priceTo);
		page.click(searchButton);

	}

}
