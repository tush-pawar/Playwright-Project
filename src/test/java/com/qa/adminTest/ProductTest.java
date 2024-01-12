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

	String productDiscription;
	String date;
	String categoryName = "category_" + new Random().nextInt(999999);
	String order = "" + new Random().nextInt(999999);
	String productName = "product_" + new Random().nextInt(999999);
	String productPrice = "" + new Random().nextInt(999999);
	String productQuantity = "" + new Random().nextInt(99);
	String productModel = "" + new Random().nextInt(9999);
	String dd = "22";
	String mm = "02";
	String yyyy = "2022";

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
	public void add_New_Product() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		test.get().info("Add new Product ");
		productPage.addNewProduct(date, productName, productPrice, productDiscription, productQuantity, productModel);

		test.get().info("Check added product in the list");
		boolean checkAddedProduct = productPage.checkAddedProduct(productName);
		Assert.assertTrue(checkAddedProduct);

		test.get().pass("Added new Product successfully");

	}

	@Test(priority = 2, description = "Update Product")
	public void update_Product() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		test.get().info("Click on Product");
		productPage.clickOnProduct(productName);

		test.get().info("Update the Product");
		productName = "product_" + new Random().nextInt(999);
		productQuantity = "" + new Random().nextInt(99);
		productPage.updateProduct(productName, productQuantity);

		test.get().info("Check updated Product in the list");
		boolean checkUpdatedProduct = productPage.checkUpdatedProduct(productName);
		Assert.assertTrue(checkUpdatedProduct);

		test.get().pass("Product updated successfully");

	}

	@Test(priority = 3, description = "Delete Product")
	public void delete_Product() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		test.get().info("Click on Product");
		productPage.clickOnProduct(productName);

		test.get().info("Delete the Product");
		productPage.deleteProduct(productName);

		test.get().info("Check is Product Delete");
		boolean checkDeleteProduct = productPage.checkDeleteProduct(productName);
		Assert.assertTrue(checkDeleteProduct);

		test.get().pass("Product Deleted successfully");
	}

	@Test(priority = 4, description = "Add new Product in Category")
	public void add_Product_Under_Catgory() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		test.get().info("Adding new Category");
		categoryPage.addNewCategory(categoryName, order);

		test.get().info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		test.get().info("Add new Product ");
		productPage.addNewProduct(date, productName, productPrice, productDiscription, productQuantity, productModel);

		test.get().info("Check added product in the list");
		boolean checkAddedProduct = productPage.checkAddedProduct(productName);
		Assert.assertTrue(checkAddedProduct);

		test.get().pass("Product Added in Category successfully");

	}

	@Test(priority = 5, description = "Update Product")
	public void update_Product_In_Category() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		test.get().info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		test.get().info("Click on Product");
		productPage.clickOnCategoryProduct(productName);

		test.get().info("Update the Product");
		productName = "product_" + new Random().nextInt(999);
		productQuantity = "" + new Random().nextInt(99);
		productPage.updateProduct(productName, productQuantity);

		test.get().info("Check updated Product in the list");
		boolean checkUpdatedProduct = productPage.checkUpdatedProduct(productName);
		Assert.assertTrue(checkUpdatedProduct);

		test.get().pass("Product updated in category successfully");

	}

//	@Test(priority = 6, description = "Delete Peoduct and Category")
	public void delete_Product_And_Category() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Products tab");
		homePage.clickOnCatalog();
		productPage.clickOnProductsTab();

		test.get().info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		test.get().info("Click on Product");
		System.out.println("name of Product: " + productName);
		productPage.clickOnProduct(productName);

		test.get().info("Delete the Product");
		productPage.deleteProduct(productName);

		test.get().info("Check is Product Delete");
		boolean checkDeleteProduct = productPage.checkDeleteProduct(productName);
		Assert.assertTrue(checkDeleteProduct);

		test.get().info("Delete the Category");
		categoryPage.deleteCategory(categoryName);

		test.get().info("Check Category is deleted");
		boolean checkDeletedCategory = categoryPage.checkDeletedCategory(categoryName);
		Assert.assertTrue(checkDeletedCategory);

		test.get().pass("Product and Category Deleted successfully");

	}
}
