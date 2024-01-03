package com.qa.adminTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.CategoryPage;
import com.qa.adminPages.HomePage;
import com.qa.adminPages.ProductPage;
import com.qa.base.BaseTest;

public class ProductTest extends BaseTest {
	String productName;
	String productPrice;
	String productQuantity;
	String productModel;
	String productDiscription;
	String categoryName;
	String order;
	String dd;
	String mm;
	String yyyy;
	String date;

	@BeforeClass
	public void beforeCalss() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		categoryPage = new CategoryPage(page, prop);
		productPage = new ProductPage(page);
		categoryName = "category_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
		productName = "product_" + new Random().nextInt(1, 999);
		productPrice = "" + new Random().nextInt(999);
		productQuantity = "" + new Random().nextInt(99);
		productModel = "" + new Random().nextInt(9999);
		dd = "" + new Random().nextInt(1, 25);
		mm = "" + new Random().nextInt(1, 12);
		yyyy = "" + new Random().nextInt(2022, 2023);
		date = yyyy + "-" + mm + "-" + dd;
		productDiscription = "Name : " + productName + ". Product Price : " + productPrice + ". Product Quantity : "
				+ productQuantity;
	}

	@Test(priority = 1, description = "Add new Product")
	public void addNewProduct() {

		extentTest = extentReports.createTest("Add new Product").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		extentTest.info("Add new Product ");
		productPage.addNewProduct(date, productName, productPrice, productDiscription, productQuantity, productModel);

		extentTest.info("Check added product in the list");
		boolean checkAddedProduct = productPage.checkAddedProduct(productName);
		Assert.assertTrue(checkAddedProduct);

		extentTest.pass("Added new Product successfully");

	}

	@Test(priority = 2, description = "Add new Product in Category")
	public void addProductUnderCatgory() {

		extentTest = extentReports.createTest("Add new Product Category").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		extentTest.info("Adding new Category");
		categoryPage.addNewCategory(categoryName, order);

		extentTest.info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		extentTest.info("Add new Product ");
		productPage.addNewProduct(date, productName, productPrice, productDiscription, productQuantity, productModel);

		extentTest.info("Check added product in the list");
		boolean checkAddedProduct = productPage.checkAddedProduct(productName);
		Assert.assertTrue(checkAddedProduct);

	}

}
