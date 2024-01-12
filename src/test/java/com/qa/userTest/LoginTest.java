package com.qa.userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;

public class LoginTest extends BaseTest {

	@BeforeClass
	public void beforeClass() {
		userHomePage = new UserHomePage(page, prop);
		userLoginPage = new UserLoginPage(page, prop);
	}

	@Test(priority = 1, description = "Login with valid Username and Password")
	public void login_Test1() {

		test.get().info("Navigate to application");
		userHomePage.goToUserPage();

		test.get().info("Navigate to My Account");
		userHomePage.clickOnMyAccount();

		test.get().info("Enter Valid E-Mail");
		userLoginPage.enterUserEmail(prop.getProperty("userEmail"));

		test.get().info("Enter Valid Password");
		userLoginPage.enterUserPassword(prop.getProperty("userPassword"));

		test.get().info("Click on Sign In");
		userLoginPage.clickOnSignIn();

		test.get().info("Verify User is Logged in");
		String loginMessage = userLoginPage.loginMessage();
		Assert.assertEquals(loginMessage, "My Account Information");

		test.get().pass("User Logged in Successfully");

	}

//	@Test(priority = 2, description = "Login with valid Username and Invalid Password")
	public void login_Test2() {

		test.get().info("Navigate to application");
		userHomePage.goToUserPage();

		test.get().info("Navigate to My Account");
		userHomePage.clickOnMyAccount();

		test.get().info("Enter Valid E-Mail");
		userLoginPage.enterUserEmail(prop.getProperty("userEmail"));

		test.get().info("Enter Valid Password");
		userLoginPage.enterUserPassword(prop.getProperty("invalidUserPassword"));

		test.get().info("Click on Sign In");
		userLoginPage.clickOnSignIn();

		test.get().info("Verify User is NOT Logged in");
		boolean errorMessage = userLoginPage.errorMessage();
		Assert.assertTrue(errorMessage);

		test.get().pass("User is NOT Logged in");

	}

}
