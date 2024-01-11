package com.qa.adminTest;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.CategoryPage;
import com.qa.adminPages.HomePage;
import com.qa.adminPages.ProductPage;
import com.qa.base.BaseTest;

public class ProductTest extends BaseTest {

	String productDiscription;
	String date;
	String categoryName = "category_" + new Random().nextInt(999999);
	String order = "" + new Random().nextInt(999999);
	String productName = "product_" + new Random().nextInt(999999);
	String productPrice = "" + new Random().nextInt(999999);
	String productQuantity = "" + new Random().nextInt(99);
	String productModel = "" + new Random().nextInt(9999);
	String dd = "22" ;
	String mm = "02" ;
	String yyyy = "2022" ;

	@BeforeClass
	public void beforeClass() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		categoryPage = new CategoryPage(page, prop);
		productPage = new ProductPage(page);

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

	@Test(priority = 2, description = "Update Product")
	public void updateProduct() {

		extentTest = extentReports.createTest("Update Product").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		extentTest.info("Click on Product");
		System.out.println("name of Product: " + productName);
		productPage.clickOnProduct(productName);

		extentTest.info("Update the Product");
		productName = "product_" + new Random().nextInt(999);
		productQuantity = "" + new Random().nextInt(99);
		productPage.updateProduct(productName, productQuantity);

		extentTest.info("Check updated Product in the list");
		boolean checkUpdatedProduct = productPage.checkUpdatedProduct(productName);
		Assert.assertTrue(checkUpdatedProduct);

		extentTest.pass("Product updated successfully");

	}

	@Test(priority = 3, description = "Delete Product")
	public void deleteProduct() {
		extentTest = extentReports.createTest("Delete Product").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		extentTest.info("Click on Product");
		productPage.clickOnProduct(productName);

		extentTest.info("Delete the Product");
		productPage.deleteProduct(productName);

		extentTest.info("Check is Product Delete");
		boolean checkDeleteProduct = productPage.checkDeleteProduct(productName);
		Assert.assertTrue(checkDeleteProduct);

		extentTest.pass("Product Deleted successfully");
	}

	@Test(priority = 4, description = "Add new Product in Category")
	public void addProductUnderCatgory() {

		extentTest = extentReports.createTest("Add new Product in Category").assignAuthor("GCR Shop Testing");

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
		
		extentTest.pass("Product Added in Category successfully");

	}

	@Test(priority = 5, description = "Update Product")
	public void updateProductInategory() {

		extentTest = extentReports.createTest("Update Product").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		extentTest.info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		extentTest.info("Click on Product");
		productPage.clickOnProduct(productName);

		extentTest.info("Update the Product");
		productName = "product_" + new Random().nextInt(999);
		productQuantity = "" + new Random().nextInt(99);
		productPage.updateProduct(productName, productQuantity);

		extentTest.info("Check updated Product in the list");
		boolean checkUpdatedProduct = productPage.checkUpdatedProduct(productName);
		Assert.assertTrue(checkUpdatedProduct);

		extentTest.pass("Product updated in category successfully");

	}

//	@Test(priority = 6, description = "Delete Peoduct and Category")
	public void deleteProductAndCategory() {
		extentTest = extentReports.createTest("Delete Peoduct and Category").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		extentTest.info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		extentTest.info("Click on Product");
		System.out.println("name of Product: " + productName);
		productPage.clickOnProduct(productName);

		extentTest.info("Delete the Product");
		productPage.deleteProduct(productName);

		extentTest.info("Check is Product Delete");
		boolean checkDeleteProduct = productPage.checkDeleteProduct(productName);
		Assert.assertTrue(checkDeleteProduct);

		extentTest.info("Delete the Category");
		categoryPage.deleteCategory(categoryName);

		extentTest.info("Check Category is deleted");
		boolean checkDeletedCategory = categoryPage.checkDeletedCategory(categoryName);
		Assert.assertTrue(checkDeletedCategory);

		extentTest.pass("Product and Category Deleted successfully");

	}
}
