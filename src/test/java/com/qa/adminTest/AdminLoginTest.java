package com.qa.adminTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	public void login_Test() {
		

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();
		
		test.get().info("Enter Admin User Name");
		adminLoginPage.enterUserName(prop.getProperty("username").trim());
		
		test.get().info("Enter Admin Password");
		adminLoginPage.enterPassword(prop.getProperty("password").trim());
		
		test.get().info("Click on Login Button");
		adminLoginPage.clickOnLogin();
		
		test.get().info("Check Admin is Logged in ");
		boolean logOffVisible = homePage.isLogOffVisible();
		Assert.assertTrue(logOffVisible);
		
		test.get().pass("Admin Login Succesfully");
		
		
//		extentTest.info("Navigate to application",
//				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(page)).build());
	}

	@Test(priority = 2, description = "Login With Invalid Data")
	public void login_With_Invalid_Data() {
		
		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();
		
		test.get().info("Enter Admin User Name");
		adminLoginPage.enterUserName(prop.getProperty("invalidUsername").trim());
		
		test.get().info("Enter Admin Password");
		adminLoginPage.enterPassword(prop.getProperty("invalidPassword").trim());
		
		test.get().info("Click on Login Button");
		adminLoginPage.clickOnLogin();

		test.get().info("Validate the error message");
		String errorMessage = adminLoginPage.getErrorMessage();
		Assert.assertEquals(errorMessage, " Error: Invalid administrator login attempt.");

		test.get().pass("Admin NOT Logged in with Invalid Username and Password");

		
	}

}
