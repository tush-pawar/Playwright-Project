package com.qa.adminPages;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CurrenciesPage {

	private Page page;
	private String currenciesTab = "//a[text()=\"Currencies\"]";
	private String newCurrency = "//span[text()=\"New Currency\"]";
	private String title = "input[name=\"title\"]";
	private String code = "input[name=\"code\"]";
	private String symbolLeft = "input[name=\"symbol_left\"]";
	private String symbolRight = "input[name=\"symbol_right\"]";
	private String decimalPoint = "input[name=\"decimal_point\"]";
	private String thousandsPoint = "input[name=\"thousands_point\"]";
	private String decimalPlaces = "input[name=\"decimal_places\"]";
	private String value = "input[name=\"value\"]";
	private String setAsDefault = "input[name=\"default\"]";
	private String saveButton = "//span[text()=\"Save\"]";
	private String currencyName = "td.dataTableContent";
	private String pages = "select[name=\"page\"]";
	private String option = "select option";
	private String edit = "//span[text()=\"Edit\"]";
	private String delete = "//span[text()=\"Delete\"]";
	private String erroeMessage = "td.messageStackError";

	public CurrenciesPage(Page page) {
		this.page = page;
	}

	public void clickOnCurrenciesTab() {
		page.click(currenciesTab);
	}

	public void addNewCurrency(String title, String code, String symbolLeft, String symbolRight, String decimalPoint,
			String thousandsPoint, String decimalPlaces, String value) {

		page.click(newCurrency);
		page.fill(this.title, title);
		page.fill(this.code, code);
		page.fill(this.symbolLeft, symbolLeft);
		page.fill(this.symbolRight, symbolRight);
		page.fill(this.decimalPoint, decimalPoint);
		page.fill(this.thousandsPoint, thousandsPoint);
		page.fill(this.decimalPlaces, decimalPlaces);
		page.fill(this.value, value);
		page.pause();
		page.click(saveButton);

	}

	public boolean checkAddedCurrency(String title) {
		System.out.println(title+"At top");

		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				System.out.println(page.locator(this.currencyName).nth(j).textContent().trim());
				if (page.locator(this.currencyName).nth(j).textContent().trim().equalsIgnoreCase(title)) {
					return true;
				}
			}
		}
		return false;
	}

	public void clickOnCurrency(String title) {
		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		loop: for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				if (page.locator(this.currencyName).nth(j).textContent().trim().equalsIgnoreCase(title)) {
					page.locator(this.currencyName).nth(j).click();
					break loop;
				}
			}
		}

	}

	public void updateCurrencyValue(String title, String value) {
		page.click(edit);
		page.fill(this.title, title);
		page.fill(this.value, value);
		page.click(saveButton);
	}

	public boolean checkUpdatedCurrency(String title) {

		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				if (allManufacturersName.contains(title)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setDefaultCurrency() {
		page.click(edit);
		page.click(setAsDefault);
		page.click(saveButton);
	}

	public boolean checkCurrencySetAsDefault(String title) {

		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				if (allManufacturersName.contains(title + " (default)")) {
					return true;
				}
			}
		}
		return false;
	}

	public void clickOnDefaultCurrency(String title) {

		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		loop: for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				if (page.locator(this.currencyName).nth(j).textContent().trim()
						.equalsIgnoreCase(title + " (default)")) {
					page.locator(this.currencyName).nth(j).click();
					break loop;
				}
			}
		}

	}

	public void deleteCurrency() {
		page.click(delete);
		page.click(delete);
	}

	public String errorMessage() {
		return page.locator(this.erroeMessage).textContent();
	}

	public boolean checkIsDefaultCurrencyDelete(String title) {

		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		System.out.println(title);
		for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				if (allManufacturersName.contains(title + " (default)")) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkIsCurrencyDelete(String title) {

		page.click(pages);
		List<String> options = page.locator(option).allTextContents();
		for (int i = 1; i <= options.size(); i++) {
			page.locator(pages).selectOption(String.valueOf(i));
			List<String> allManufacturersName = page.locator(this.currencyName).allTextContents();
			for (int j = 0; j < allManufacturersName.size(); j++) {
				if (allManufacturersName.contains(title)) {
					return true;
				}
			}
		}
		return true;
	}
}
