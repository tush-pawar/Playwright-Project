//package com.qa.base;
//
//import java.io.File;
//import java.nio.file.Paths;
//import java.util.Base64;
//import java.util.Properties;
//import java.util.Random;
//
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.microsoft.playwright.Page;
//import com.qa.adminPages.AdminLoginPage;
//import com.qa.adminPages.CategoryPage;
//import com.qa.adminPages.CurrenciesPage;
//import com.qa.adminPages.HomePage;
//import com.qa.adminPages.ManufacturersPage;
//import com.qa.adminPages.ProductPage;
//import com.qa.factory.playwrightFactory;
//import com.qa.userPages.UserHomePage;
//import com.qa.userPages.UserLoginPage;
//import com.qa.userPages.UserRegisterPage;
//
//public class BaseTest {
//
//	// playwright
//	protected playwrightFactory pf;
//	protected Page page;
//
//	// properties
//	protected Properties prop;
//
//	// pages
//	protected static AdminLoginPage adminLoginPage;
//	protected static ManufacturersPage manufacturersPage;
//	protected static HomePage homePage;
//	protected static CategoryPage categoryPage;
//	protected static ProductPage productPage;
//	protected static CurrenciesPage currenciesPage;
//	protected static UserHomePage userHomePage;
//	protected static UserLoginPage userLoginPage;
//	protected static UserRegisterPage userRegisterPage;
//
//	// Extent report variables
//	protected static ExtentReports extentReports;
//	protected static ExtentSparkReporter extentSparkReporter;
//	protected ExtentTest extentTest;
//
//	@Parameters({ "browser" })
//	@BeforeClass
//	public void setup(String browser) {
//		pf = new playwrightFactory();
//		prop = pf.init_prop();
//		page = pf.initBrowser(browser);
//
//		try {
//			if (extentTest == null) {
//
//				extentReports = new ExtentReports();
//				extentSparkReporter = new ExtentSparkReporter(
//						System.getProperty("user.dir") + "./TestReport/Report.html");
//				extentSparkReporter.config().setTheme(Theme.DARK);
//				extentReports.setSystemInfo("Operating System: ", System.getProperty("os.name"));
////				extentReports.setSystemInfo("System Name: ", InetAddress.getLocalHost().getHostName());
////				extentReports.setSystemInfo("System Ipv4 addresss: ", InetAddress.getLocalHost().getHostAddress());
//				extentReports.setSystemInfo("Java Version: ", System.getProperty("java.version"));
//				extentReports.attachReporter(extentSparkReporter);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// Extent report
////		extentReports = new ExtentReports();
////		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "./TestReport/Report.html");
////		extentSparkReporter.config().setReportName("GCR SHOP Report");
////		extentSparkReporter.config().setTheme(Theme.DARK);
////		extentReports.attachReporter(extentSparkReporter);
//	}
//
//	@AfterMethod
//	public void tearDown(ITestResult result) {
//		if (!result.isSuccess()) {
//
//			try {
//
//				extentTest.fail(getTestName(result),
//						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(page)).build());
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
////	@AfterTest
////	public void afterTest() {
////		
////	}
//
//	@AfterSuite
//	public void afterSuit() {
//		page.context().browser().close();
//		extentReports.flush();
//	}
//
//	public String screenshot(Page page) {
//		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
//		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
//		String base64Path = Base64.getEncoder().encodeToString(buffer);
//		return base64Path;
//	}
//
//	public Throwable getTestName(ITestResult result) {
//		return result.getThrowable();
//	}
//
//	public int getRandomSixDigitNumber() {
//		return new Random().nextInt(999999);
//
//	}
//
//}