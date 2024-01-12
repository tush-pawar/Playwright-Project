package com.qa.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.CategoryPage;
import com.qa.adminPages.CurrenciesPage;
import com.qa.adminPages.HomePage;
import com.qa.adminPages.ManufacturersPage;
import com.qa.adminPages.ProductPage;
import com.qa.factory.playwrightFactory;
import com.qa.listeners.ExtentReportListener;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;
import com.qa.userPages.UserRegisterPage;

public class BaseTest extends ExtentReportListener {

	// playwright
	protected playwrightFactory pf;
	protected Page page;

	// properties
	protected static Properties prop;

	// pages
	protected static AdminLoginPage adminLoginPage;
	protected static ManufacturersPage manufacturersPage;
	protected static HomePage homePage;
	protected static CategoryPage categoryPage;
	protected static ProductPage productPage;
	protected static CurrenciesPage currenciesPage;
	protected static UserHomePage userHomePage;
	protected static UserLoginPage userLoginPage;
	protected static UserRegisterPage userRegisterPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String browser) {
		pf = new playwrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(browser);

	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}