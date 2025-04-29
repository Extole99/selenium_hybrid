package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethod {
	public ShippingMethod(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@value='Next Day Air___Shipping.FixedRate']")
	private WebElement chooseNxtDayRadioBtn;
	
	@FindBy(xpath = "//*[@value='2nd Day Air___Shipping.FixedRate']")
	private WebElement choose2DayRadioBtn;
	
	@FindBy(xpath = "(//*[@value='Continue'])[3]")
	private WebElement clickOnContinueBtn;

	public WebElement getChooseNxtDayRadioBtn() {
		return chooseNxtDayRadioBtn;
	}

	public void setChooseNxtDayRadioBtn(WebElement chooseNxtDayRadioBtn) {
		this.chooseNxtDayRadioBtn = chooseNxtDayRadioBtn;
	}

	public WebElement getChoose2DayRadioBtn() {
		return choose2DayRadioBtn;
	}

	public void setChoose2DayRadioBtn(WebElement choose2DayRadioBtn) {
		this.choose2DayRadioBtn = choose2DayRadioBtn;
	}

	public WebElement getClickOnContinueBtn() {
		return clickOnContinueBtn;
	}

	public void setClickOnContinueBtn(WebElement clickOnContinueBtn) {
		this.clickOnContinueBtn = clickOnContinueBtn;
	}
	
	
}
