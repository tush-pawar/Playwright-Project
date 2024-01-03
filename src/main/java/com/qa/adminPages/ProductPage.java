package com.qa.adminPages;

import java.util.List;

import com.microsoft.playwright.Page;

public class ProductPage {

	private Page page;

	private String productsTab = "//a[text()='Categories/Products']";
	private String newProduct = "//span[text()=\"New Product\"]";
	private String inStock = "input[value=\"1\"]";
	private String outOfStock = "input[value=\"0\"]";
	private String productName = "input[name=\"products_name[1]\"]";
	private String date = "input[name=\"products_date_available\"]";
	private String productPrice = "input[name=\"products_price\"]";
	private String productDiscription = "textarea[name=\"products_description[1]\"]";
	private String productQuantity = "input[name=\"products_quantity\"]";
	private String productModel = "input[name=\"products_model\"]";
	private String saveButton = "//span[text()=\"Save\"]";
	private String products = "td[class=\"dataTableContent\"]";

	public ProductPage(Page page) {

		this.page = page;
	}

	public void clickOnProductsTab() {
		page.click(productsTab);
	}

	public void addNewProduct(String date, String productName, String productPrice, String productDiscription,
			String productQuantity, String productModel) {

		page.click(newProduct);
		page.click(inStock);
		page.fill(this.date, date);
		page.fill(this.productName, productName);
		page.fill(this.productPrice, productPrice);
		page.fill(this.productDiscription, productDiscription);
		page.fill(this.productQuantity, productQuantity);
		page.fill(this.productModel, productModel);
		page.click(saveButton);

	}

	public boolean checkAddedProduct(String productName) {

		List<String> allProducts = page.locator(this.products).allTextContents();
		System.out.println(" " + productName);
		for (int i = 0; i < allProducts.size(); i += 3) {
			System.out.println(page.locator(this.products).nth(i).textContent());
			if (page.locator(this.products).nth(i).textContent().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}
}
