package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='header-links']//*[@class='ico-register']")
	private WebElement registerBtn;

	@FindBy(xpath = "//*[@class='header-links']//*[@class='ico-login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//*[@class='header-links']//*[@class='ico-cart']")
	private WebElement cartBtn;

	@FindBy(xpath = "//*[@class='header-links']//*[@class='ico-wishlist']")
	private WebElement wishlistBtn;
	
	@FindBy(xpath = "//*[@class='top-menu']//*[@href='/books']")
	private WebElement booksBtn;
	
	@FindBy(xpath = "//*[@class='header-links']//*[@class='ico-logout']")
	private WebElement logoutBtn;

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(WebElement registerBtn) {
		this.registerBtn = registerBtn;
	}

	public WebElement getBooksBtn() {
		return booksBtn;
	}

	public void setBooksBtn(WebElement booksBtn) {
		this.booksBtn = booksBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void setLogoutBtn(WebElement logoutBtn) {
		this.logoutBtn = logoutBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public void setCartBtn(WebElement cartBtn) {
		this.cartBtn = cartBtn;
	}

	public WebElement getWishlistBtn() {
		return wishlistBtn;
	}

	public void setWishlistBtn(WebElement wishlistBtn) {
		this.wishlistBtn = wishlistBtn;
	}

	public void clickOnRegisterButton() {
		registerBtn.click();
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}

	public void clickOnLogoutButton() {
		logoutBtn.click();
	}
	
	public void clickOnCartButton() {
		cartBtn.click();
	}

	public void clickOnWishlistButton() {
		wishlistBtn.click();
	}
	
	public void clickOnBooksBtn() {
		booksBtn.click();
	}

}
