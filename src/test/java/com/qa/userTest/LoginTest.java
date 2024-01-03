package com.qa.userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;

public class LoginTest extends BaseTest {

	@BeforeClass
	public void beforeCalss() {
		userHomePage = new UserHomePage(page, prop);
		userLoginPage = new UserLoginPage(page, prop);
	}

	@Test(priority = 1, description = "Login with valid Username and Password")
	public void loginTest1() {

		extentTest = extentReports.createTest("Login with valid Username and Password")
				.assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		userHomePage.goToUserPage();

		extentTest.info("Navigate to My Account");
		userHomePage.clickOnMyAccount();

		extentTest.info("Enter Valid E-Mail");
		userLoginPage.enterUserEmail(prop.getProperty("userEmail"));

		extentTest.info("Enter Valid Password");
		userLoginPage.enterUserPassword(prop.getProperty("userPassword"));

		extentTest.info("Click on Sign In");
		userLoginPage.clickOnSignIn();

		extentTest.info("Verify User is Logged in");
		String loginMessage = userLoginPage.loginMessage();
		Assert.assertEquals(loginMessage, "My Account Information");

		extentTest.pass("User Logged in Successfully");

	}

	@Test(priority = 2, description = "Login with valid Username and Invalid Password")
	public void loginTest2() {

		extentTest = extentReports.createTest("Login with valid Username and Invalid Password")
				.assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		userHomePage.goToUserPage();

		extentTest.info("Navigate to My Account");
		userHomePage.clickOnMyAccount();

		extentTest.info("Enter Valid E-Mail");
		userLoginPage.enterUserEmail(prop.getProperty("userEmail"));

		extentTest.info("Enter Valid Password");
		userLoginPage.enterUserPassword(prop.getProperty("invalidUserPassword"));

		extentTest.info("Click on Sign In");
		userLoginPage.clickOnSignIn();

		extentTest.info("Verify User is NOT Logged in");
		boolean errorMessage = userLoginPage.errorMessage();
		Assert.assertTrue(errorMessage);

		extentTest.pass("User is NOT Logged in");

	}

}
