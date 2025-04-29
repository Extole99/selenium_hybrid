package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	public PaymentMethod(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='method-list']//*[@value='Payments.Manual']")
	private WebElement chooseCreditCardBtn;
	
	@FindBy(xpath = "//*[@class='method-list']//*[@value='Payments.PurchaseOrder']")
	private WebElement choosePurchaseOrderBtn;
	
	@FindBy(xpath = "//*[@class='method-list']//*[@value='Payments.CheckMoneyOrder']")
	private WebElement chooseMoneyOrderBtn;
	
	@FindBy(xpath = "(//*[@value='Continue'])[3]")
	private WebElement clickOnContinueBtn;

	public WebElement getChooseCreditCardBtn() {
		return chooseCreditCardBtn;
	}

	public void setChooseCreditCardBtn(WebElement chooseCreditCardBtn) {
		this.chooseCreditCardBtn = chooseCreditCardBtn;
	}

	public WebElement getChoosePurchaseOrderBtn() {
		return choosePurchaseOrderBtn;
	}

	public void setChoosePurchaseOrderBtn(WebElement choosePurchaseOrderBtn) {
		this.choosePurchaseOrderBtn = choosePurchaseOrderBtn;
	}

	public WebElement getChooseMoneyOrderBtn() {
		return chooseMoneyOrderBtn;
	}

	public void setChooseMoneyOrderBtn(WebElement chooseMoneyOrderBtn) {
		this.chooseMoneyOrderBtn = chooseMoneyOrderBtn;
	}

	public WebElement getClickOnContinueBtn() {
		return clickOnContinueBtn;
	}

	public void setClickOnContinueBtn(WebElement clickOnContinueBtn) {
		this.clickOnContinueBtn = clickOnContinueBtn;
	}
	
	
}
