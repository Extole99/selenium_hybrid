package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingPage {

	public BillingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#BillingNewAddress_Company")
	private WebElement inputCompany;

	@FindBy(xpath = "//*[@id='BillingNewAddress_CountryId']")
	private WebElement selectCountry;

	@FindBy(css = "#BillingNewAddress_City")
	private WebElement inputCity;

	@FindBy(css = "#BillingNewAddress_Address1")
	private WebElement inutAddress1;

	@FindBy(css = "#BillingNewAddress_Address2")
	private WebElement inutAddress2;

	@FindBy(css = "#BillingNewAddress_ZipPostalCode")
	private WebElement inputZipCode;

	@FindBy(css = "#BillingNewAddress_PhoneNumber")
	private WebElement inputPhoneNum;

	public WebElement getClickOnContinueBtn() {
		return clickOnContinueBtn;
	}

	public void setClickOnContinueBtn(WebElement clickOnContinueBtn) {
		this.clickOnContinueBtn = clickOnContinueBtn;
	}

	@FindBy(xpath = "(//*[@title='Continue'])[1]")
	private WebElement clickOnContinueBtn;

	public WebElement getInputCompany() {
		return inputCompany;
	}

	public void setInputCompany(WebElement inputCompany) {
		this.inputCompany = inputCompany;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public void setSelectCountry(WebElement selectCountry) {
		this.selectCountry = selectCountry;
	}

	public WebElement getInputCity() {
		return inputCity;
	}

	public void setInputCity(WebElement inputCity) {
		this.inputCity = inputCity;
	}

	public WebElement getInutAddress1() {
		return inutAddress1;
	}

	public void setInutAddress1(WebElement inutAddress1) {
		this.inutAddress1 = inutAddress1;
	}

	public WebElement getInutAddress2() {
		return inutAddress2;
	}

	public void setInutAddress2(WebElement inutAddress2) {
		this.inutAddress2 = inutAddress2;
	}

	public WebElement getInputZipCode() {
		return inputZipCode;
	}

	public void setInputZipCode(WebElement inputZipCode) {
		this.inputZipCode = inputZipCode;
	}

	public WebElement getInputPhoneNum() {
		return inputPhoneNum;
	}

	public void setInputPhoneNum(WebElement inputPhoneNum) {
		this.inputPhoneNum = inputPhoneNum;
	}

}
