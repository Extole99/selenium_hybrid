package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#Email")
	private WebElement inputEmail;

	@FindBy(css = "#Password")
	private WebElement inputPassword;

	@FindBy(xpath = "//*[@value='Log in']")
	private WebElement loginBtn;

	@FindBy(xpath = "//*[@class='header-links']//*[@class='account']")
	private WebElement userEmail;
	
	
	public WebElement getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(WebElement userEmail) {
		this.userEmail = userEmail;
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

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	public void loginThePage(String email, String pwd) throws Exception {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(2000);
	}

	public void verifyLoginSuccess(String email) {
		String actualEmailId = userEmail.getText();
		if(userEmail.isDisplayed() && actualEmailId.contains(email)) {
			Assert.assertTrue(true);
			System.out.println("User login successfully.... !!");
		}else {
			System.out.println("User not login successfully.... !!");
			Assert.assertTrue(false);
		}
	}
}
