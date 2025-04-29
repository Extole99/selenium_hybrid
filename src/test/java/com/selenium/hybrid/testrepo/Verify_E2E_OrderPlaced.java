package com.selenium.hybrid.testrepo;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.hybrid.genericrepo.BaseClass;
import com.selenium.hybrid.genericrepo.ExcelHandler;
import com.selenium.hybrid.genericrepo.JavaUtils;
import com.selenium.hybrid.genericrepo.Paths;
import com.selenium.hybrid.genericrepo.WebDriverHandler;
import com.selenium.hybrid.objectrepo.BookPage;
import com.selenium.hybrid.objectrepo.BooksPage;
import com.selenium.hybrid.objectrepo.CartPage;
import com.selenium.hybrid.objectrepo.HomePage;
import com.selenium.hybrid.objectrepo.LoginPage;
import com.selenium.hybrid.objectrepo.RegisterPage;

public class Verify_E2E_OrderPlaced extends BaseClass {

	@Test(priority = 1)
	public void registerTheUser() throws Exception {
		HomePage homepage = new HomePage(driver);
		RegisterPage regpage = new RegisterPage(driver);
		JavaUtils ju = new JavaUtils();

		ExcelHandler ex = new ExcelHandler(Paths.excelFilePath);
		String fname = ex.getCellData("sheet1", 1, 0);
		String lname = ex.getCellData("sheet1", 1, 1);
		String email = ju.generateRandomEmail();
		String password = ex.getCellData("sheet1", 1, 3);

		homepage.clickOnRegisterButton();
		regpage.registerThePage("male", fname, lname, email, password);
		regpage.verifySuccessMessage();
		regpage.clickOnContinueBtn();
	}

	@Test(priority = 2)
	public void addProductToCart() throws Exception {
		HomePage homepage = new HomePage(driver);
		BooksPage booksPage = new BooksPage(driver);
		BookPage bookPage = new BookPage(driver);
		CartPage cartPage = new CartPage(driver);

		homepage.clickOnBooksBtn();
		booksPage.clickOnFstProduct();
		String pdtName = bookPage.getProductTitle().getText();
		System.out.println(pdtName);
		String pdtPrice = bookPage.getProductPrice().getText();
		System.out.println(pdtPrice);
		String desc = bookPage.getProductDesc().getText();
		System.out.println(desc);
		WebDriverHandler.scrollDown(driver, 300);
		bookPage.getProductQty().clear();
		bookPage.getProductQty().sendKeys("2");
		bookPage.getAddToCartBtn().click();
		WebDriverHandler.scrollUp(driver, 400);
		Thread.sleep(2000);
		bookPage.getShopCartBtn().click();
		String pdtname = cartPage.getProductName().getText();
		String pricepdt = cartPage.getProductPrice().getText();
		cartPage.selectCountry("India");
		Thread.sleep(2000);
		Assert.assertEquals(pdtName, pdtname);
		WebDriverHandler.scrollDown(driver, 300);
		cartPage.getAgreeCheckBox().click();
		Thread.sleep(1000);
		cartPage.getCheckoutBtn().click();
		Thread.sleep(2000);
		@Nullable
		String pageTitle = driver.getTitle();
		String expTitle = "Demo Web Shop. Login";
		SoftAssert as = new SoftAssert();
		as.assertEquals(pageTitle, expTitle);
		System.out.println("Test passed");
	}

	@Test(priority = 3)
	public void logoutTheUser() throws Exception {

		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		ExcelHandler ex = new ExcelHandler(Paths.excelFilePath);

		String email = ex.getCellData("sheet1", 1, 2);
		String password = ex.getCellData("sheet1", 1, 3);

		homepage.clickOnLoginButton();
		loginpage.loginThePage(email, password);
		loginpage.verifyLoginSuccess(email);

		homepage.clickOnLogoutButton();
	}
}
