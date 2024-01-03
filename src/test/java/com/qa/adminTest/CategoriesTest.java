package com.qa.adminTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.CategoryPage;
import com.qa.adminPages.HomePage;
import com.qa.base.BaseTest;

public class CategoriesTest extends BaseTest {
	String categoryName;
	String order;
	String subcategoryName;

	@BeforeClass
	public void beforeCalss() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		categoryPage = new CategoryPage(page, prop);
		categoryName = "category_" + new Random().nextInt(999);
		subcategoryName = "subcategory_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
	}

	@Test(priority = 1, description = "Add new Category")
	public void createNewCategory() {
		extentTest = extentReports.createTest("Add new Category").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Adding new category");
		categoryPage.addNewCategory(categoryName, order);

		extentTest.info("Checking added new category in the list");
		boolean checkAddedCategory = categoryPage.checkAddedCategory(categoryName);
		Assert.assertTrue(checkAddedCategory);

		extentTest.pass("Added new Cateogry successfully");

	}

	@Test(priority = 2, description = "Update added category")
	public void updateCategory() {

		extentTest = extentReports.createTest("Update added category").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Click on category");
		categoryPage.clickOnCategory(categoryName);

		extentTest.info("Update category");
		categoryName = "category_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
		categoryPage.editCategory(categoryName, order);

		extentTest.info("Check updated category name in the list");
		categoryPage.checkUpdatedCategory(categoryName);

		extentTest.pass("Cateogry updated successfully");

	}

	@Test(priority = 3, description = "Delete category")
	public void deleteCategory() {

		extentTest = extentReports.createTest("Delete category").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Click on category");
		categoryPage.clickOnCategory(categoryName);

		extentTest.info("Delete the category");
		categoryPage.deleteCategory(categoryName);

		extentTest.info("Check Category is deleted");
		boolean checkDeletedCategory = categoryPage.checkDeletedCategory(categoryName);
		Assert.assertTrue(checkDeletedCategory);

		extentTest.pass("Category Deleted successfully");

	}

	@Test(priority = 4, description = "Add new subcategory in category")
	public void addSubcategoryInCategory() {

		extentTest = extentReports.createTest("Add new subcategory in category").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Adding new Category");
		categoryPage.addNewCategory(categoryName, order);

		extentTest.info("Checking added new Category in the list");
		boolean checkAddedCategory = categoryPage.checkAddedCategory(categoryName);
		Assert.assertTrue(checkAddedCategory);

		extentTest.info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		extentTest.info("Adding new Subcategory in Category");
		categoryPage.addNewCategory(subcategoryName, order);

		extentTest.info("Checking added new Subcategory in the Category list");
		boolean checkAddedSubcategory = categoryPage.checkAddedCategory(subcategoryName);
		Assert.assertTrue(checkAddedSubcategory);

		extentTest.pass("Added new Subcateogry in the Category successfully");

	}

	@Test(priority = 5, description = "Update subcategory")
	public void updateSubcategory() {

		extentTest = extentReports.createTest("Update subcategory").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		extentTest.info("Update Subcategory");
		subcategoryName = "subcategory_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
		categoryPage.editCategory(subcategoryName, order);

		extentTest.info("Check updated Subcategory in the list");
		boolean checkupdatedSubcategory = categoryPage.checkUpdatedSubcategory(subcategoryName);
		Assert.assertTrue(checkupdatedSubcategory);

		extentTest.pass("Updated Subcategory in the Category successfully");
	}

	@Test(priority = 6, description = "Delete Category and Subcategory")
	public void deleteSubcategory() {
		extentTest = extentReports.createTest("Delete Category and Subcategory").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to Categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Navigate to Subcategory");
		categoryPage.navigateToCategory(categoryName);

		extentTest.info("Delete the Subcategory");
		categoryPage.deleteSubcategory(subcategoryName);

		extentTest.info("Check Subategory is deleted");
		boolean checkDeletedSubategory = categoryPage.checkDeletedSubcategory(subcategoryName);
		Assert.assertTrue(checkDeletedSubategory);

		extentTest.info("Navigate to Category");
		categoryPage.clickOnCategoriesTab();

		extentTest.info("Click on Category");
		categoryPage.clickOnCategory(categoryName);

		extentTest.info("Delete the Category");
		categoryPage.deleteCategory(categoryName);

		extentTest.info("Check Category is deleted");
		boolean checkDeletedCategory = categoryPage.checkDeletedCategory(categoryName);
		Assert.assertTrue(checkDeletedCategory);

		extentTest.pass("Category and Subcategory Deleted successfully");

	}

}
