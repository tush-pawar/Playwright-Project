package com.qa.userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;

public class BuyProduct extends BaseTest {

	@BeforeClass
	public void beforeClass() {
		userHomePage = new UserHomePage(page, prop);
		userLoginPage = new UserLoginPage(page, prop);
	}

	@Test(priority = 1, description = "Place the order")
	public void buy_Product() {

		test.get().info("Navigate to application");
		userHomePage.goToUserPage();

		test.get().info("Search the Product");
		userHomePage.searchProduct(prop.getProperty("productName").trim());

		test.get().info("Click on Product");
		userHomePage.clickOnProduct(prop.getProperty("productName").trim());

		test.get().info("Add Product to Cart");
		userHomePage.addToCart();

		test.get().info("Checkout the Product");
		userHomePage.clickOnCheckout();

		test.get().info("Login the User");
		userLoginPage.loginUser();

		test.get().info("Click on Continue");
		userHomePage.clickOnContinue();

		test.get().info("Confirm the order");
		userHomePage.clickOnConfirmOrder();

		test.get().info("Verify order Successful Message");
		boolean verifyThanksMessageVisible = userHomePage.verifyThanksMessageVisible();
		Assert.assertTrue(verifyThanksMessageVisible);

		test.get().pass("Order placed Successfully");

	}

}
