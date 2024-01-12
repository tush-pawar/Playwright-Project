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
	public void beforeClass() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		categoryPage = new CategoryPage(page, prop);
		categoryName = "category_" + new Random().nextInt(999);
		subcategoryName = "subcategory_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
	}

	@Test(priority = 1, description = "Add new Category")
	public void create_New_Category() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		test.get().info("Adding new category");
		categoryPage.addNewCategory(categoryName, order);

		test.get().info("Checking added new category in the list");
		boolean checkAddedCategory = categoryPage.checkAddedCategory(categoryName);
		Assert.assertTrue(checkAddedCategory);

		test.get().pass("Added new Cateogry successfully");

	}

	@Test(priority = 2, description = "Update added category")
	public void update_Category() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		test.get().info("Click on category");
		categoryPage.clickOnCategory(categoryName);

		test.get().info("Update category");
		categoryName = "category_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
		categoryPage.editCategory(categoryName, order);

		test.get().info("Check updated category name in the list");
		categoryPage.checkUpdatedCategory(categoryName);

		test.get().pass("Cateogry updated successfully");

	}

	@Test(priority = 3, description = "Delete category")
	public void delete_Category() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		test.get().info("Click on category");
		categoryPage.clickOnCategory(categoryName);

		test.get().info("Delete the category");
		categoryPage.deleteCategory(categoryName);

		test.get().info("Check Category is deleted");
		boolean checkDeletedCategory = categoryPage.checkDeletedCategory(categoryName);
		Assert.assertTrue(checkDeletedCategory);

		test.get().pass("Category Deleted successfully");

	}

	@Test(priority = 4, description = "Add new subcategory in category")
	public void add_Subcategory_In_Category() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		test.get().info("Adding new Category");
		categoryPage.addNewCategory(categoryName, order);

		test.get().info("Checking added new Category in the list");
		boolean checkAddedCategory = categoryPage.checkAddedCategory(categoryName);
		Assert.assertTrue(checkAddedCategory);

		test.get().info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		test.get().info("Adding new Subcategory in Category");
		categoryPage.addNewCategory(subcategoryName, order);

		test.get().info("Checking added new Subcategory in the Category list");
		boolean checkAddedSubcategory = categoryPage.checkAddedCategory(subcategoryName);
		Assert.assertTrue(checkAddedSubcategory);

		test.get().pass("Added new Subcateogry in the Category successfully");

	}

	@Test(priority = 5, description = "Update subcategory")
	public void update_Subcategory() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		test.get().info("Navigate to Category");
		categoryPage.navigateToCategory(categoryName);

		test.get().info("Update Subcategory");
		subcategoryName = "subcategory_" + new Random().nextInt(999);
		order = "" + new Random().nextInt(99);
		categoryPage.editCategory(subcategoryName, order);

		test.get().info("Check updated Subcategory in the list");
		boolean checkupdatedSubcategory = categoryPage.checkUpdatedSubcategory(subcategoryName);
		Assert.assertTrue(checkupdatedSubcategory);

		test.get().pass("Updated Subcategory in the Category successfully");
	}

	@Test(priority = 6, description = "Delete Category and Subcategory")
	public void delete_Subcategory() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to Categories tab");
		homePage.clickOnCatalog();
		categoryPage.clickOnCategoriesTab();

		test.get().info("Navigate to Subcategory");
		categoryPage.navigateToCategory(categoryName);

		test.get().info("Delete the Subcategory");
		categoryPage.deleteSubcategory(subcategoryName);

		test.get().info("Check Subategory is deleted");
		boolean checkDeletedSubategory = categoryPage.checkDeletedSubcategory(subcategoryName);
		Assert.assertTrue(checkDeletedSubategory);

		test.get().info("Navigate to Category");
		categoryPage.clickOnCategoriesTab();

		test.get().info("Click on Category");
		categoryPage.clickOnCategory(categoryName);

		test.get().info("Delete the Category");
		categoryPage.deleteCategory(categoryName);

		test.get().info("Check Category is deleted");
		boolean checkDeletedCategory = categoryPage.checkDeletedCategory(categoryName);
		Assert.assertTrue(checkDeletedCategory);

		test.get().pass("Category and Subcategory Deleted successfully");

	}

}
