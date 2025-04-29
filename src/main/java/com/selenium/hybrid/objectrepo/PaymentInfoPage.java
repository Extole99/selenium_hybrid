package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInfoPage {

	public PaymentInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@value='Continue'])[last()]")
	private WebElement chooseCreditCardBtn;

	public WebElement getChooseCreditCardBtn() {
		return chooseCreditCardBtn;
	}

	public void setChooseCreditCardBtn(WebElement chooseCreditCardBtn) {
		this.chooseCreditCardBtn = chooseCreditCardBtn;
	}
	
	
}
