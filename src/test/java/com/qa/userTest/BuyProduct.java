package com.qa.userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;

public class BuyProduct extends BaseTest {

	@BeforeClass
	public void beforeCalss() {
		userHomePage = new UserHomePage(page, prop);
		userLoginPage = new UserLoginPage(page, prop);
	}

	@Test(priority = 1, description = "Place the order")
	public void buyProduct() {

		extentTest = extentReports.createTest("Place the order").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		userHomePage.goToUserPage();

		extentTest.info("Search the Product");
		userHomePage.searchProduct(prop.getProperty("productName").trim());

		extentTest.info("Click on Product");
		userHomePage.clickOnProduct(prop.getProperty("productName").trim());

		extentTest.info("Add Product to Cart");
		userHomePage.addToCart();

		extentTest.info("Checkout the Product");
		userHomePage.clickOnCheckout();

		extentTest.info("Login the User");
		userLoginPage.loginUser();

		extentTest.info("Click on Continue");
		userHomePage.clickOnContinue();

		extentTest.info("Confirm the order");
		userHomePage.clickOnConfirmOrder();

		extentTest.info("Verify order Successful Message");
		boolean verifyThanksMessageVisible = userHomePage.verifyThanksMessageVisible();
		Assert.assertTrue(verifyThanksMessageVisible);

		extentTest.info("Order placed Successfully");

	}
	

}
