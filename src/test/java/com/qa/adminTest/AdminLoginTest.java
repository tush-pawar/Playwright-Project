package com.qa.adminTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.HomePage;
import com.qa.base.BaseTest;

public class AdminLoginTest extends BaseTest {
	
	@BeforeClass
	public void beforeClass() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage=new HomePage(page);
	}

	@Test(priority = 1, description = "Login With Valid Data")
	public void loginTest() {
		
		extentTest = extentReports.createTest("Login With Valid Data").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();
		
		extentTest.info("Enter Admin User Name");
		adminLoginPage.enterUserName(prop.getProperty("username").trim());
		
		extentTest.info("Enter Admin Password");
		adminLoginPage.enterPassword(prop.getProperty("password").trim());
		
		extentTest.info("Click on Login Button");
		adminLoginPage.clickOnLogin();
		
		extentTest.info("Check Admin is Logged in ");
		boolean logOffVisible = homePage.isLogOffVisible();
		Assert.assertTrue(logOffVisible);
		
		extentTest.pass("Admin Login Succesfully");
		
		
//		extentTest.info("Navigate to application",
//				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(page)).build());
	}

	@Test(priority = 2, description = "Login With Invalid Data")
	public void loginWithInvalidData() {
		extentTest = extentReports.createTest("Login With Invalid Data").assignAuthor("GCR Shop Testing");
		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();
		
		extentTest.info("Enter Admin User Name");
		adminLoginPage.enterUserName(prop.getProperty("invalidUsername").trim());
		
		extentTest.info("Enter Admin Password");
		adminLoginPage.enterPassword(prop.getProperty("invalidPassword").trim());
		
		extentTest.info("Click on Login Button");
		adminLoginPage.clickOnLogin();

		extentTest.info("Validate the error message");
		String errorMessage = adminLoginPage.getErrorMessage();
		Assert.assertEquals(errorMessage, " Error: Invalid administrator login attempt.");

		extentTest.pass("Admin NOT Logged in with Invalid Username and Password");

		
	}

}
