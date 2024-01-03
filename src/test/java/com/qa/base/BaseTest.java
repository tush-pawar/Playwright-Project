package com.qa.base;

import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import com.qa.adminPages.AdminLoginPage;
import com.qa.adminPages.CategoryPage;
import com.qa.adminPages.CurrenciesPage;
import com.qa.adminPages.HomePage;
import com.qa.adminPages.ManufacturersPage;
import com.qa.adminPages.ProductPage;
import com.qa.factory.playwrightFactory;
import com.qa.userPages.UserHomePage;
import com.qa.userPages.UserLoginPage;
import com.qa.userPages.UserRegisterPage;

public class BaseTest {

	// playwright
	protected playwrightFactory pf;
	protected Page page;

	// properties
	protected Properties prop;

	// pages
	protected AdminLoginPage adminLoginPage;
	protected ManufacturersPage manufacturersPage;
	protected HomePage homePage;
	protected CategoryPage categoryPage;
	protected ProductPage productPage;
	protected CurrenciesPage currenciesPage;
	protected UserHomePage userHomePage;
	protected UserLoginPage userLoginPage;
	protected UserRegisterPage userRegisterPage;
	

	// Extent report variables
	protected static ExtentReports extentReports;
	protected static ExtentSparkReporter extentSparkReporter;
	protected ExtentTest extentTest;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browser) {
		pf = new playwrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(browser);

		// Extent report
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "./TestReport/Report.html");
		extentSparkReporter.config().setReportName("GCR SHOP Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentReports.attachReporter(extentSparkReporter);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (!result.isSuccess()) {

			try {

				extentTest.fail(getTestName(result),
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(page)).build());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@AfterTest
	public void afterTest() {
		page.context().browser().close();
	}

	@AfterSuite
	public void afterSuit() {
		extentReports.flush();
	}

	public String screenshot(Page page) {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		return base64Path;
	}

	private Throwable getTestName(ITestResult result) {
		return result.getThrowable();
	}

}
