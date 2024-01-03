package com.qa.userPages;

import java.util.Properties;

import com.microsoft.playwright.Page;

public class UserLoginPage {

	private Page page;
	private Properties prop;
	private String email = "input[name=\"email_address\"]";
	private String password = "input[name=\"password\"]";
	private String signInButton = "//span[text()=\"Sign In\"]";
	private String errorMessage = "td.messageStackError";
	private String myAccountInfo = "div.grid_16 h1";

	public UserLoginPage(Page page, Properties prop) {
		this.page = page;
		this.prop = prop;
	}

	public void loginUser() {
		page.fill(this.email, prop.getProperty("userEmail").trim());
		page.fill(this.password, prop.getProperty("userPassword").trim());
		page.click(signInButton);

	}

	public void enterUserEmail(String email) {
		page.fill(this.email, email);
	}

	public void enterUserPassword(String password) {
		page.fill(this.password, password);
	}

	public void clickOnSignIn() {
		page.click(signInButton);
	}

	public boolean errorMessage() {
		return page.locator(errorMessage).isVisible();
	}

	public String loginMessage() {
		return page.locator(myAccountInfo).textContent();
	}
	

}
