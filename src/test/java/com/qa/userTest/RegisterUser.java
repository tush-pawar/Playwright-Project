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
	public void beforeCalss() {
		userHomePage = new UserHomePage(page, prop);
		userLoginPage = new UserLoginPage(page, prop);
		userRegisterPage = new UserRegisterPage(page);
		dd = "" + new Random().nextInt(10, 25);
		mm = "" + new Random().nextInt(10, 12);
		yyyy = "" + new Random().nextInt(1990, 2000);
		dob = mm + "/" + dd + "/" + yyyy;
		email="test"+new Random().nextInt(999)+"@test.com";
	}

	@Test(priority = 1, description = "New user Registration")
	public void ragisterUser() {

		extentTest = extentReports.createTest("New user Registration").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		userHomePage.goToUserPage();

		extentTest.info("Navigate to My Account");
		userHomePage.clickOnMyAccount();

		extentTest.info("Navigate to Registration");
		userRegisterPage.clickOnContinueButton();

		extentTest.info("Select Gender");
		userRegisterPage.selectGender(prop.getProperty("gender").trim());

		extentTest.info("Enter First Name");
		userRegisterPage.enterFirstName(prop.getProperty("firstName").trim());

		extentTest.info("Enter Last Name");
		userRegisterPage.enterLastName(prop.getProperty("lastname").trim());

		extentTest.info("Enter DOB");
		userRegisterPage.enterDOB(dob);

		extentTest.info("Enter Email");
		userRegisterPage.enterEmail(email);

		extentTest.info("Enter Street Address");
		userRegisterPage.enterStreetAddress(prop.getProperty("streetAdderss").trim());

		extentTest.info("Enter Suburb");
		userRegisterPage.enterSuburb(prop.getProperty("suburb").trim());

		extentTest.info("Enter Post Code");
		userRegisterPage.enterPostCode(prop.getProperty("postCode").trim());
		
		extentTest.info("Enter City");
		userRegisterPage.enterCity(prop.getProperty("city").trim());

		extentTest.info("Enter State");
		userRegisterPage.enterState(prop.getProperty("state").trim());

		extentTest.info("Select Country");
		userRegisterPage.selectCountry(prop.getProperty("Country").trim());

		extentTest.info("Enter Telephone");
		userRegisterPage.enterTelephone(prop.getProperty("telephone").trim());

		extentTest.info("Enter Password");
		userRegisterPage.enterPassword(prop.getProperty("newPassword").trim());

		extentTest.info("Enter Confirm Password");
		userRegisterPage.enterConfirmPassword(prop.getProperty("newPassword").trim());

		extentTest.info("Click on Continue Button");
		userRegisterPage.clickOnContinueButton();

		extentTest.info("Check Register Message");
		String accountCreatedMessage = userRegisterPage.accountCreatedMessage();
		Assert.assertEquals(accountCreatedMessage, "Your Account Has Been Created!");

		extentTest.pass("New User Register Successfully");

	}

}
