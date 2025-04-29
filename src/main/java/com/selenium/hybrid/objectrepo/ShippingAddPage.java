package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddPage {
	public ShippingAddPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[@title='Continue'])[2]")
	private WebElement clickOnContinueBtn;

	public WebElement getClickOnContinueBtn() {
		return clickOnContinueBtn;
	}

	public void setClickOnContinueBtn(WebElement clickOnContinueBtn) {
		this.clickOnContinueBtn = clickOnContinueBtn;
	}
	
}
