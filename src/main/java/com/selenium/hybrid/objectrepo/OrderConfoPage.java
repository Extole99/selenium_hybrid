package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfoPage {
	public OrderConfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	

	@FindBy(css = ".title")
	private WebElement orderSuccessMessage;
	
	@FindBy(css = ".details")
	private WebElement orderDetails;
	
	@FindBy(xpath = "//*[contains(@href,'/orderdetails')]")
	private WebElement clickOrderDetailsLink;
	
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continueBtn;

	public WebElement getOrderSuccessMessage() {
		return orderSuccessMessage;
	}

	public void setOrderSuccessMessage(WebElement orderSuccessMessage) {
		this.orderSuccessMessage = orderSuccessMessage;
	}

	public WebElement getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(WebElement orderDetails) {
		this.orderDetails = orderDetails;
	}

	public WebElement getClickOrderDetailsLink() {
		return clickOrderDetailsLink;
	}

	public void setClickOrderDetailsLink(WebElement clickOrderDetailsLink) {
		this.clickOrderDetailsLink = clickOrderDetailsLink;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void setContinueBtn(WebElement continueBtn) {
		this.continueBtn = continueBtn;
	}
	
	
}
