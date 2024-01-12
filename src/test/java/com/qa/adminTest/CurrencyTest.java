package com.qa.adminTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.adminPages.AdminLoginPage;
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
	public void beforeClass() {
		adminLoginPage = new AdminLoginPage(page, prop);
		homePage = new HomePage(page);
		currenciesPage = new CurrenciesPage(page);
		currencyTitle = "currency_" + new Random().nextInt(999);
		currencyCode = "#" + 99;
		decimalPoint = "" + 2;
		thousandsPoint = "" + 1;
		decimalPlaces = "" + 1;
		decimalPlaces = "" +1;
		value = "" + new Random().nextInt(999);
		symbolLeft = "";
		symbolRight = "RS";
	}
	
	
	@Test(priority = 1, description = "Add new Currency")
	public void add_New_Currency() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		test.get().info("Add new Currency");
		currenciesPage.addNewCurrency(currencyTitle, currencyCode, symbolLeft, symbolRight, decimalPoint,
				thousandsPoint, decimalPlaces, value);

		test.get().info("Check added currency");
		boolean checkAddedCurrency = currenciesPage.checkAddedCurrency(currencyTitle);
		Assert.assertTrue(checkAddedCurrency);

		test.get().pass("Added new Currency successfully");

	}

	@Test(priority = 2, description = "Update Currency")
	public void update_Currency() {

		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		test.get().info("Click on Currency");
		currenciesPage.clickOnCurrency(currencyTitle);

		test.get().info("Click on Currency");
		currencyTitle = "currency_" + new Random().nextInt(999);
		value = "" + new Random().nextInt(999);
		currenciesPage.updateCurrencyValue(currencyTitle, value);

		test.get().info("Check updated currency");
		boolean checkUpdatedCurrency = currenciesPage.checkUpdatedCurrency(currencyTitle);
		Assert.assertTrue(checkUpdatedCurrency);

		test.get().pass("Currency updated successfully");

	}

	@Test(priority = 3, description = "Set as Default Currency")
	public void set_As_Default_Currency() {


		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		test.get().info("Click on Currency");
		currenciesPage.clickOnCurrency(currencyTitle);

		test.get().info("Set Currency as a default");
		currenciesPage.setDefaultCurrency();

		test.get().info("Check currency set as Default");
		boolean checkCurrencySetAsDefault = currenciesPage.checkCurrencySetAsDefault(currencyTitle);
		Assert.assertTrue(checkCurrencySetAsDefault);

		test.get().pass("Currency set as Default successfully");

	}

	@Test(priority = 4, description = "Delete Currency")
	public void delete_Currency() {


		test.get().info("Navigate to application");
		adminLoginPage.goToAdminLoginPage();

		test.get().info("Login to application");
		adminLoginPage.loginAdmin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

		test.get().info("Navigate to categories tab");
		homePage.clickOnLocalization();
		currenciesPage.clickOnCurrenciesTab();

		test.get().info("Add new Currency");
		currencyTitle = "currency_" + new Random().nextInt(9999);
		value = "" + new Random().nextInt(999);
		currenciesPage.addNewCurrency(currencyTitle, currencyCode, symbolLeft, symbolRight, decimalPoint,
				thousandsPoint, decimalPlaces, value);

		test.get().info("Check added currency");
		boolean checkAddedCurrency = currenciesPage.checkAddedCurrency(currencyTitle);
		Assert.assertTrue(checkAddedCurrency);

		test.get().info("Click on Currency");
		currenciesPage.clickOnCurrency(currencyTitle);

		test.get().info("Delete Currency");
		currenciesPage.deleteCurrency();

		test.get().info("Check Currency is deleted");
		boolean checkIsCurrencyDelete = currenciesPage.checkIsCurrencyDelete(currencyTitle);
		Assert.assertTrue(checkIsCurrencyDelete);

		test.get().pass("Currency Deleted successfully");

	}

}
