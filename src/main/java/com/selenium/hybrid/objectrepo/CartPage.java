package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.hybrid.genericrepo.WebDriverHandler;

public class CartPage {

	WebDriverHandler wb= new WebDriverHandler();
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='cart-item-row']//*[@class='product-name']")
	private WebElement productName;

	@FindBy(xpath = "//*[@class='cart-item-row']//*[@class='product-unit-price']")
	private WebElement productPrice;

	@FindBy(xpath = "//*[@class='country-input']")
	private WebElement selectCountry;

	@FindBy(xpath = "//*[@class='terms-of-service']//*[@type='checkbox']")
	private WebElement agreeCheckBox;

	@FindBy(xpath = "//*[@id='checkout']")
	private WebElement checkoutBtn;

	public WebElement getProductName() {
		return productName;
	}

	public void setProductName(WebElement productName) {
		this.productName = productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(WebElement productPrice) {
		this.productPrice = productPrice;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public void setSelectCountry(WebElement selectCountry) {
		this.selectCountry = selectCountry;
	}

	public WebElement getAgreeCheckBox() {
		return agreeCheckBox;
	}

	public void setAgreeCheckBox(WebElement agreeCheckBox) {
		this.agreeCheckBox = agreeCheckBox;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public void setCheckoutBtn(WebElement checkoutBtn) {
		this.checkoutBtn = checkoutBtn;
	}

	public void selectCountry(String country) {
		wb.select(selectCountry, country);
	}
	
}
