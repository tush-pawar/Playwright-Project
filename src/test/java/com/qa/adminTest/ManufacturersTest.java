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
	public void beforeCalss() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage=new HomePage(page);
		manufacturersPage = new ManufacturersPage(page, prop);
		manufacturerName = "test_" + new Random().nextInt(999999);
	}

	@Test(priority = 1, description = "Add new Manufacture")
	public void addNewManufacture() {
		extentTest = extentReports.createTest("Add new Manufacture").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to manufacturers tab");
		homePage.clickOnCatalog();
		manufacturersPage.clickOnManufacturers();

		extentTest.info("Adding new manufacture");
		manufacturersPage.addNewManufacturer(manufacturerName, "", "");

		extentTest.info("Checking added new manufacture in the list");
		boolean checkAddedmanufacturer = manufacturersPage.checkAddedManufacturer(manufacturerName);
		Assert.assertTrue(checkAddedmanufacturer);

		extentTest.pass("Added new Manufacture successfully");
	}

	@Test(priority = 2, description = "Update Manufacture")
	public void updateManufacturer() {
		extentTest = extentReports.createTest("Update Manufacture").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to manufacturers tab");
		homePage.clickOnCatalog();
		manufacturersPage.clickOnManufacturers();

		extentTest.info("Click on manufacturer");
		manufacturersPage.clickOnManufacturer(manufacturerName);
		
		extentTest.info("Update manufacturer name");
		manufacturerName = "test_" + new Random().nextInt(999999);
		manufacturersPage.editManufacturerName(manufacturerName);

		extentTest.info("Check updated manufacturer name in the list");
		boolean checkEditedManufacturer = manufacturersPage.checkEditedManufacturer(manufacturerName);
		Assert.assertTrue(checkEditedManufacturer);

		extentTest.pass("Manufacturer updated successfully");

	}
	@Test(priority = 3, description = "Delete Manufacture")
	public void deleteManufacturer() {
		
		extentTest = extentReports.createTest("Delete Manufacture").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigating to manufacturers tab");
		homePage.clickOnCatalog();
		manufacturersPage.clickOnManufacturers();

		extentTest.info("Click on Manufacturer");
		manufacturersPage.clickOnManufacturer(manufacturerName);
		
		extentTest.info("Delete Manufacturer");
		manufacturersPage.deleteManufacturer();
		
		extentTest.info("Check Manufacturer is deleted");
		boolean checkIsManufacturerIsDelete = manufacturersPage.checkIsManufacturerIsDeleted(manufacturerName);
		Assert.assertTrue(checkIsManufacturerIsDelete);
		
		extentTest.pass("Manufacturer Deleted successfully");

	}

}
