package com.qa.adminPages;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import com.microsoft.playwright.Page;

public class ManufacturersPage {

	private Page page;
	private Properties prop;
	private String manufacturers = "//a[text()='Manufacturers']";
	private String insert = "//span[text()='Insert']";
	private String manufacturerName = "[name=\"manufacturers_name\"]";
	private String manufacturerImage = "[name=\"manufacturers_image\"]";
	private String manufacturerURL = "[name=\"manufacturers_url[1]\"]";
	private String saveButton = "//span[text()='Save']";
	private String manufacturersName = "td[class=\"dataTableContent\"]";
	private String pages = "select[name=\"page\"]";
	private String option = "select option";
	private String edit = "//span[text()='Edit']";
	private String delete = "//span[text()='Delete']";

	public ManufacturersPage(Page page, Properties prop) {
		this.page = page;
		this.prop = prop;
	}

	public void clickOnManufacturers() {
		page.click(manufacturers);
	}

	public void addNewManufacturer(String manufacturersName, String manufacturersImage, String manufacturersURL) {
		page.click(insert);

		page.fill(this.manufacturerName, manufacturersName);
//		page.setInputFiles(this.manufacturerImage, Paths.get("C:\\Users\\DELL\\OneDrive\\Desktop"));
		page.fill(this.manufacturerURL, "https://en.wikipedia.org/wiki/Camera");
		page.click(saveButton);
	}

	public boolean checkAddedManufacturer(String manufacturerName) {

		page.click(pages);

		List<String> options = page.locator(option).allTextContents();

		for (int i = 1; i <= options.size(); i++) {

			page.locator(pages).selectOption(String.valueOf(i));

			List<String> allManufacturersName = page.locator(this.manufacturersName).allTextContents();

			for (int j = 0; j < allManufacturersName.size(); j++) {

				if (allManufacturersName.contains(manufacturerName)) {

					return true;
				}
			}
		}
		return false;
	}

	public void clickOnManufacturer(String manufacturerName) {
		page.click(pages);
		List<String> options = page.locator(option).allTextContents();

		loop: for (int i = 1; i <= options.size(); i++) {

			page.locator(pages).selectOption(String.valueOf(i));

			List<String> allManufacturersName = page.locator(this.manufacturersName).allTextContents();

			for (int j = 0; j < allManufacturersName.size(); j++) {

				if (page.locator(this.manufacturersName).nth(j).textContent().trim()

						.equalsIgnoreCase(manufacturerName.trim())) {

					page.locator(this.manufacturersName).nth(j).click();

					break loop;
				}
			}
		}
	}

	public void editManufacturerName(String manufacturerName) {

		page.click(edit);
		page.fill(this.manufacturerName, manufacturerName);
		page.click(saveButton);

	}

	public boolean checkEditedManufacturer(String manufacturerName) {

		page.click(pages);

		List<String> options = page.locator(option).allTextContents();

		for (int i = 1; i <= options.size(); i++) {

			page.locator(pages).selectOption(String.valueOf(i));

			List<String> allManufacturersName = page.locator(this.manufacturersName).allTextContents();

			for (int j = 0; j < allManufacturersName.size(); j++) {

				if (allManufacturersName.contains(manufacturerName)) {

					return true;
				}
			}
		}
		return false;
	}

	public void deleteManufacturer() {
		page.click(delete);
		page.click(delete);
	}

	public boolean checkIsManufacturerIsDeleted(String manufacturerName) {
		page.click(pages);

		List<String> options = page.locator(option).allTextContents();

		for (int i = 1; i <= options.size(); i++) {

			page.locator(pages).selectOption(String.valueOf(i));

			List<String> allManufacturersName = page.locator(this.manufacturersName).allTextContents();

			for (int j = 0; j < allManufacturersName.size(); j++) {

				if (allManufacturersName.contains(manufacturerName)) {

					return false;
				}
			}
		}
		return true;
	}
}
