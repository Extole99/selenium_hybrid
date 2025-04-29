package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='gender-male' and @type='radio']")
	private WebElement choseeMaleRadioBtn;

	@FindBy(xpath = "//*[@id='gender-female' and @type='radio']")
	private WebElement choseeFeMaleRadioBtn;

	@FindBy(css = "#FirstName")
	private WebElement inputFirstName;

	@FindBy(css = "#LastName")
	private WebElement inputLastName;

	@FindBy(css = "#Email")
	private WebElement inputEmail;

	@FindBy(css = "#Password")
	private WebElement inputPassword;

	@FindBy(css = "#ConfirmPassword")
	private WebElement inputConfirmPassword;

	@FindBy(css = "#register-button")
	private WebElement registerBtn;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMsg;
	
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continueBtn;

	public WebElement getChoseeMaleRadioBtn() {
		return choseeMaleRadioBtn;
	}

	public void setChoseeMaleRadioBtn(WebElement choseeMaleRadioBtn) {
		this.choseeMaleRadioBtn = choseeMaleRadioBtn;
	}

	public WebElement getChoseeFeMaleRadioBtn() {
		return choseeFeMaleRadioBtn;
	}

	public void setChoseeFeMaleRadioBtn(WebElement choseeFeMaleRadioBtn) {
		this.choseeFeMaleRadioBtn = choseeFeMaleRadioBtn;
	}

	public WebElement getInputFirstName() {
		return inputFirstName;
	}

	public void setInputFirstName(WebElement inputFirstName) {
		this.inputFirstName = inputFirstName;
	}

	public WebElement getInputLastName() {
		return inputLastName;
	}

	public void setInputLastName(WebElement inputLastName) {
		this.inputLastName = inputLastName;
	}

	public WebElement getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(WebElement inputEmail) {
		this.inputEmail = inputEmail;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(WebElement inputPassword) {
		this.inputPassword = inputPassword;
	}

	public WebElement getInputConfirmPassword() {
		return inputConfirmPassword;
	}

	public void setInputConfirmPassword(WebElement inputConfirmPassword) {
		this.inputConfirmPassword = inputConfirmPassword;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(WebElement registerBtn) {
		this.registerBtn = registerBtn;
	}

	public WebElement getRegisterSuccessMsg() {
		return registerSuccessMsg;
	}

	public void setRegisterSuccessMsg(WebElement registerSuccessMsg) {
		this.registerSuccessMsg = registerSuccessMsg;
	}

	public void registerThePage(String gender, String fname, String lname, String email, String pwd) throws Exception {
		if(gender.equals("Male")) {
			choseeMaleRadioBtn.click();
		}else {
			choseeFeMaleRadioBtn.click();
		}
		inputFirstName.sendKeys(fname);
		inputLastName.sendKeys(lname);
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(pwd);
		inputConfirmPassword.sendKeys(pwd);
		Thread.sleep(2000);
		registerBtn.click();
		Thread.sleep(2000);
	}
	
	public void verifySuccessMessage() {
		boolean displayed = registerSuccessMsg.isDisplayed();
		if(displayed) {
			System.out.println("success message displaying and the message is: "+registerSuccessMsg.getText());
			Assert.assertTrue(true);
		}else {
			System.out.println("No success message displaying...!!");
			Assert.assertTrue(false);
		}
	}
	
	public void clickOnContinueBtn() {
		continueBtn.click();
	}
	
}
