package com.qa.adminPages;
import java.util.Properties;
import com.microsoft.playwright.Page;

public class AdminLoginPage {
	private Page page;
	private Properties prop;
	private String username="[name=\"username\"]";
	private String password="[type=\"password\"]";
	private String loginButton="button[type=\"submit\"]";
	private String errorMessage="td[class=\"messageStackError\"]";
	
//	private String manufacturers="//a[text()=\"Manufacturers\"]";


	 
	
	public AdminLoginPage(Page page,Properties prop) {
		this.page=page;
		this.prop=prop;
	}
	
	public void goToAdminLoginPage() {
	page.navigate(prop.getProperty("Admin_Page_url").trim());	
	}
	
	public void loginAdmin(String username,String password) {
		page.fill(this.username, username);
		page.fill(this.password, password);
		page.click(loginButton);	
	}
	
	public void loginForInvalid(String username,String password) {
		page.fill(this.username, username);
		page.fill(this.password, password);
		page.click(loginButton);
	}
	
	public String getErrorMessage() {
		return page.locator(errorMessage).textContent();
	}
	
	public void enterUserName(String username) {
		page.fill(this.username, username);
	}
	
	public void enterPassword(String password) {
		page.fill(this.password, password);
	}
	
	public void clickOnLogin() {
		page.click(loginButton);
	}
	

}
