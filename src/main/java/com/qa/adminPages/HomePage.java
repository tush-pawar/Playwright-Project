package com.qa.adminPages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	private String catalog = "//a[text()=\"Catalog\"]";
	private String localization = "//a[text()=\"Localization\"]";
	private String logOff = "//a[text()=\"Logoff\"]";

	public HomePage(Page page) {
		this.page = page;
	}

	public void clickOnCatalog() {
		page.click(catalog);
	}

	public void clickOnLocalization() {
		page.click(localization);
	}

	public boolean isLogOffVisible() {
		return page.locator(logOff).isVisible();
	}

}
