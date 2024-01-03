package com.qa.adminPages;

import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Page;

public class CategoryPage {

	private Page page;
	private Properties prop;
	private String categoriesTab = "//a[text()='Categories/Products']";
	private String newCategory = "//span[text()=\"New Category\"]";
	private String categoryName = "input[name=\"categories_name[1]\"]";
	private String sortOrder = "input[name=\"sort_order\"]";
	private String saveButton = "//span[text()=\"Save\"]";
	private String categories = "td.dataTableContent strong";
	private String categoriesRow = "tr";
	private String edit = "//span[text()=\"Edit\"]";
	private String delete = "//span[text()=\"Delete\"]";

	public CategoryPage(Page page, Properties prop) {
		this.page = page;
		this.prop = prop;
	}

	public void clickOnCategoriesTab() {
		page.click(categoriesTab);
	}

	public void addNewCategory(String categoryName, String sortOrder) {
		page.click(newCategory);
		page.fill(this.categoryName, categoryName);
		page.fill(this.sortOrder, sortOrder);
		page.click(saveButton);
	}

	public boolean checkAddedCategory(String categoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (allCategories.contains(categoryName)) {
				return true;
			}
		}
		return false;
	}

	public void clickOnCategory(String categoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (page.locator(this.categories).nth(i).textContent().trim().equalsIgnoreCase(categoryName.trim())) {
				page.locator(this.categories).nth(i).click();
				break;
			}
		}
	}

	public void editCategory(String categoryName, String sortOrder) {
		page.click(edit);
		page.fill(this.categoryName, categoryName);
		page.fill(this.sortOrder, sortOrder);
		page.click(saveButton);

	}

	public boolean checkUpdatedCategory(String categoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (allCategories.contains(categoryName)) {
				return true;
			}
		}
		return false;
	}

	public void deleteCategory(String categoryName) {
		page.click(delete);
		page.click(delete);
	}

	public boolean checkDeletedCategory(String categoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (allCategories.contains(categoryName)) {
				return false;
			}
		}
		return true;
	}

	public void navigateToCategory(String categoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (page.locator(this.categories).nth(i).textContent().trim().equalsIgnoreCase(categoryName.trim())) {
				page.locator(this.categories).nth(i - 1).click();
				page.locator(this.categories).nth(i).click();
				page.locator(this.categories).nth(i).click();
				break;
			}
		}
	}
	public boolean checkUpdatedSubcategory(String subcategoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (allCategories.contains(subcategoryName)) {
				return true;
			}
		}
		return false;
	}
	public void deleteSubcategory(String subcategoryName) {
		page.click(delete);
		page.click(delete);
	}
	public boolean checkDeletedSubcategory(String subcategoryName) {
		List<String> allCategories = page.locator(this.categories).allTextContents();
		for (int i = 0; i < allCategories.size(); i++) {
			if (allCategories.contains(subcategoryName)) {
				return false;
			}
		}
		return true;
	}

}
