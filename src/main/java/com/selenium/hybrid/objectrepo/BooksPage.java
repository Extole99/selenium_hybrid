package com.selenium.hybrid.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	public BooksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[@class='product-grid']//*[@class='product-item'])[1]")
	private WebElement fstProductBtn;

	public WebElement getFstProductBtn() {
		return fstProductBtn;
	}

	public void setFstProductBtn(WebElement fstProductBtn) {
		this.fstProductBtn = fstProductBtn;
	}

	public void clickOnFstProduct() {
		fstProductBtn.click();
	}
}
