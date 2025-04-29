package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {
	public BookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='product-essential']//*[@class='product-name']")
	private WebElement productTitle;

	@FindBy(xpath = "//*[@class='product-essential']//*[@class='short-description']")
	private WebElement productDesc;
	
	@FindBy(xpath = "//*[@class='product-essential']//*[@class='product-price']")
	private WebElement productPrice;
	
	@FindBy(xpath = "//*[@class='product-essential']//*[@class='qty-input']")
	private WebElement productQty;
	
	@FindBy(xpath = "//*[@class='product-essential']//*[@value='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@class='header-links']//*[@class='ico-cart']")
	private WebElement shopCartBtn;

	public WebElement getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(WebElement productTitle) {
		this.productTitle = productTitle;
	}

	public WebElement getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(WebElement productDesc) {
		this.productDesc = productDesc;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(WebElement productPrice) {
		this.productPrice = productPrice;
	}

	public WebElement getProductQty() {
		return productQty;
	}

	public void setProductQty(WebElement productQty) {
		this.productQty = productQty;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public void setAddToCartBtn(WebElement addToCartBtn) {
		this.addToCartBtn = addToCartBtn;
	}

	public WebElement getShopCartBtn() {
		return shopCartBtn;
	}

	public void setShopCartBtn(WebElement shopCartBtn) {
		this.shopCartBtn = shopCartBtn;
	}
	
	
	
}
