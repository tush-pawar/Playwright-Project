package com.qa.adminTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.HomePage;
import com.qa.adminPages.ManufacturersPage;
import com.qa.base.BaseTest;

public class ManufacturersTest extends BaseTest {
	String manufacturerName;

	@BeforeClass
	public void beforeClass() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		manufacturersPage = new ManufacturersPage(page, prop);
		manufacturerName = "test_" + new Random().nextInt(999999);
	}

	

	@Test(priority = 1, description = "Add new Manufacture")
	public void add_New_Manufacture() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to manufacturers tab");
		homePage.clickOnCatalog();
		manufacturersPage.clickOnManufacturers();

		test.get().info("Adding new manufacture");
		manufacturersPage.addNewManufacturer(manufacturerName, "", "");

		test.get().info("Checking added new manufacture in the list");
		boolean checkAddedmanufacturer = manufacturersPage.checkAddedManufacturer(manufacturerName);
		Assert.assertTrue(checkAddedmanufacturer);

		test.get().pass("Added new Manufacture successfully");
	}

	@Test(priority = 2, description = "Update Manufacture")
	public void update_Manufacturer() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to manufacturers tab");
		homePage.clickOnCatalog();
		manufacturersPage.clickOnManufacturers();

		test.get().info("Click on manufacturer");
		manufacturersPage.clickOnManufacturer(manufacturerName);

		test.get().info("Update manufacturer name");
		manufacturerName = "test_" + new Random().nextInt(999999);
		manufacturersPage.editManufacturerName(manufacturerName);

		test.get().info("Check updated manufacturer name in the list");
		boolean checkEditedManufacturer = manufacturersPage.checkEditedManufacturer(manufacturerName);
		Assert.assertTrue(checkEditedManufacturer);

		test.get().pass("Manufacturer updated successfully");

	}

	@Test(priority = 3, description = "Delete Manufacture")
	public void delete_Manufacturer() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigating to manufacturers tab");
		homePage.clickOnCatalog();
		manufacturersPage.clickOnManufacturers();

		test.get().info("Click on Manufacturer");
		manufacturersPage.clickOnManufacturer(manufacturerName);

		test.get().info("Delete Manufacturer");
		manufacturersPage.deleteManufacturer();

		test.get().info("Check Manufacturer is deleted");
		boolean checkIsManufacturerIsDelete = manufacturersPage.checkIsManufacturerIsDeleted(manufacturerName);
		Assert.assertTrue(checkIsManufacturerIsDelete);

		test.get().pass("Manufacturer Deleted successfully");

	}

}
