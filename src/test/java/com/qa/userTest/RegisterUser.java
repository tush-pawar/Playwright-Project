package com.qa.userTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;
import com.qa.userPages.UserRegisterPage;

public class RegisterUser extends BaseTest {

	String dd;
	String mm;
	String yyyy;
	String dob;
	String email;

	@BeforeClass
	public void beforeClass() {
		userHomePage = new UserHomePage(page, prop);
		userLoginPage = new UserLoginPage(page, prop);
		userRegisterPage = new UserRegisterPage(page);
		dd = "" + 25;
		mm = "" + 10;
		yyyy = "" + 1999;
		dob = mm + "/" + dd + "/" + yyyy;
		email = "test" + new Random().nextInt(999) + "@test.com";
	}

	@Test(priority = 1, description = "New user Registration")
	public void ragister_User() {

		test.get().info("Navigate to application");
		userHomePage.goToUserPage();

		test.get().info("Navigate to My Account");
		userHomePage.clickOnMyAccount();

		test.get().info("Navigate to Registration");
		userRegisterPage.clickOnContinueButton();

		test.get().info("Select Gender");
		userRegisterPage.selectGender(prop.getProperty("gender").trim());

		test.get().info("Enter First Name");
		userRegisterPage.enterFirstName(prop.getProperty("firstName").trim());

		test.get().info("Enter Last Name");
		userRegisterPage.enterLastName(prop.getProperty("lastname").trim());

		test.get().info("Enter DOB");
		userRegisterPage.enterDOB(dob);

		test.get().info("Enter Email");
		userRegisterPage.enterEmail(email);

		test.get().info("Enter Street Address");
		userRegisterPage.enterStreetAddress(prop.getProperty("streetAdderss").trim());

		test.get().info("Enter Suburb");
		userRegisterPage.enterSuburb(prop.getProperty("suburb").trim());

		test.get().info("Enter Post Code");
		userRegisterPage.enterPostCode(prop.getProperty("postCode").trim());

		test.get().info("Enter City");
		userRegisterPage.enterCity(prop.getProperty("city").trim());

		test.get().info("Enter State");
		userRegisterPage.enterState(prop.getProperty("state").trim());

		test.get().info("Select Country");
		userRegisterPage.selectCountry(prop.getProperty("Country").trim());

		test.get().info("Enter Telephone");
		userRegisterPage.enterTelephone(prop.getProperty("telephone").trim());

		test.get().info("Enter Password");
		userRegisterPage.enterPassword(prop.getProperty("newPassword").trim());

		test.get().info("Enter Confirm Password");
		userRegisterPage.enterConfirmPassword(prop.getProperty("newPassword").trim());

		test.get().info("Click on Continue Button");
		userRegisterPage.clickOnContinueButton();

		test.get().info("Check Register Message");
		String accountCreatedMessage = userRegisterPage.accountCreatedMessage();
		Assert.assertEquals(accountCreatedMessage, "Your Account Has Been Created!");

		test.get().pass("New User Register Successfully");

	}

}
