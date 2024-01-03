package com.qa.adminTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.CategoryPage;
import com.qa.adminPages.CurrenciesPage;
import com.qa.adminPages.HomePage;
import com.qa.base.BaseTest;

public class CurrencyTest extends BaseTest {

	String currencyTitle;
	String currencyCode;
	String symbolLeft;
	String symbolRight;
	String decimalPoint;
	String thousandsPoint;
	String decimalPlaces;
	String value;

	@BeforeClass
	public void beforeCalss() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		currenciesPage = new CurrenciesPage(page);
		currencyTitle = "currency_" + new Random().nextInt(999);
		currencyCode = "#" + new Random().nextInt(99);
		decimalPoint = "" + new Random().nextInt(0,2);
		thousandsPoint = "" + new Random().nextInt(0,1);
		decimalPlaces = "" + new Random().nextInt(0,2);
		decimalPlaces = "" + new Random().nextInt(0,2);
		value = "" + new Random().nextInt(999);
		symbolLeft = "";
		symbolRight = "RS";
	}

	@Test(priority = 1, description = "Add new Currency")
	public void addNewCurrency() {
		extentTest = extentReports.createTest("Add new Currency").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		extentTest.info("Add new Currency");
		currenciesPage.addNewCurrency(currencyTitle, currencyCode, symbolLeft, symbolRight, decimalPoint,
				thousandsPoint, decimalPlaces, value);

		extentTest.info("Check added currency");
		boolean checkAddedCurrency = currenciesPage.checkAddedCurrency(currencyTitle);
		Assert.assertTrue(checkAddedCurrency);

		extentTest.pass("Added new Currency successfully");

	}

	@Test(priority = 2, description = "Update Currency")
	public void updateCurrency() {
		extentTest = extentReports.createTest("Add new Currency").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		extentTest.info("Click on Currency");
		currenciesPage.clickOnCurrency(currencyTitle);

		extentTest.info("Click on Currency");
		currencyTitle = "currency_" + new Random().nextInt(999);
		value = "" + new Random().nextInt(999);
		currenciesPage.updateCurrencyValue(currencyTitle, value);

		extentTest.info("Check updated currency");
		boolean checkUpdatedCurrency = currenciesPage.checkUpdatedCurrency(currencyTitle);
		Assert.assertTrue(checkUpdatedCurrency);

		extentTest.pass("Currency updated successfully");

	}

	@Test(priority = 3, description = "Set as Default Currency")
	public void setAsDefault() {

		extentTest = extentReports.createTest("Set as Default Currency").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		extentTest.info("Click on Currency");
		currenciesPage.clickOnCurrency(currencyTitle);

		extentTest.info("Set Currency as a default");
		currenciesPage.setDefaultCurrency();

		extentTest.info("Check currency set as Default");
		boolean checkCurrencySetAsDefault = currenciesPage.checkCurrencySetAsDefault(currencyTitle);
		Assert.assertTrue(checkCurrencySetAsDefault);

		extentTest.info("Currency set as Default successfully");

	}

	@Test(priority = 4, description = "Delete Currency")
	public void deleteCurrency() {

		extentTest = extentReports.createTest("Delete Currency").assignAuthor("GCR Shop Testing");

		extentTest.info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		extentTest.info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		extentTest.info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		extentTest.info("Add new Currency");
		System.out.println(currencyTitle);
		currencyTitle = "currency_" + new Random().nextInt(9999);
		System.out.println(currencyTitle);
		value = "" + new Random().nextInt(999);
		currenciesPage.addNewCurrency(currencyTitle, currencyCode, symbolLeft, symbolRight, decimalPoint,
				thousandsPoint, decimalPlaces, value);

		extentTest.info("Check added currency");
		boolean checkAddedCurrency = currenciesPage.checkAddedCurrency(currencyTitle);
		Assert.assertTrue(checkAddedCurrency);

		extentTest.info("Click on Currency");
		currenciesPage.clickOnCurrency(currencyTitle);

		extentTest.info("Delete Currency");
		currenciesPage.deleteCurrency();

		extentTest.info("Check Currency is deleted");
		boolean checkIsCurrencyDelete = currenciesPage.checkIsCurrencyDelete(currencyTitle);
		Assert.assertTrue(checkIsCurrencyDelete);

		extentTest.pass("Currency Deleted successfully");

	}

}
