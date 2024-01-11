package com.qa.userPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UserRegisterPage {

	private Page page;
	private String continueButton = "//span[text()=\"Continue\"]";
	private String male = "input[value=\"m\"]";
	private String female = "input[value=\"f\"]";
	private String firstName = "input[name=\"firstname\"]";
	private String lastName = "input[name=\"lastname\"]";
	private String dob = "input[name=\"dob\"]";
	private String email = "input[name=\"email_address\"]";
	private String streetAddress = "input[name=\"street_address\"]";
	private String suburb = "input[name=\"suburb\"]";
	private String postCode = "input[name=\"postcode\"]";
	private String city = "input[name=\"city\"]";
	private String state = "input[name=\"state\"]";
	private String country = "select[name=\"country\"]";
	private String telephone = "input[name=\"telephone\"]";
	private String password = "input[name=\"password\"]";
	private String confirmPassword = "input[name=\"confirmation\"]";
	private String message = "div.grid_16 h1";

	public UserRegisterPage(Page page) {
		this.page = page;
	}

	public void selectGender(String gender) {
		if ("male".equalsIgnoreCase(gender) || "m".equalsIgnoreCase(gender)) {
			page.click(male);
		} else {
			page.click(female);
		}
	}

	public void enterFirstName(String firstName) {
		page.fill(this.firstName, firstName);
	}

	public void enterLastName(String lastName) {
		page.fill(this.lastName, lastName);
	}

	public void enterDOB(String dob) {
		page.fill(this.dob, dob);
	}

	public void enterEmail(String email) {
		page.fill(this.email, email);
	}

	public void enterStreetAddress(String streetAddress) {
		page.fill(this.streetAddress, streetAddress);
	}

	public void enterSuburb(String suburb) {
		page.fill(this.suburb, suburb);
	}

	public void enterPostCode(String postCode) {
		page.fill(this.postCode, postCode);
	}

	public void enterCity(String city) {
		page.fill(this.city, city);
	}

	public void enterState(String state) {
		page.fill(this.state, state);
	}

	public void selectCountry(String country) {
		page.selectOption(this.country, country);
	}

	public void enterTelephone(String telephone) {
		page.fill(this.telephone, telephone);
	}

	public void enterPassword(String password) {
		page.fill(this.password, password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		page.fill(this.confirmPassword, confirmPassword);
	}

	public void clickOnContinueButton() {
		page.click(continueButton);
	}

	public String accountCreatedMessage() {
		return page.locator(message).textContent();

	}

}
