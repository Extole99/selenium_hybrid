package com.selenium.hybrid.testrepo;

import org.testng.annotations.Test;

import com.selenium.hybrid.genericrepo.BaseClass;
import com.selenium.hybrid.genericrepo.ExcelHandler;
import com.selenium.hybrid.genericrepo.JavaUtils;
import com.selenium.hybrid.genericrepo.Paths;
import com.selenium.hybrid.objectrepo.HomePage;
import com.selenium.hybrid.objectrepo.LoginPage;
import com.selenium.hybrid.objectrepo.RegisterPage;

public class Verify_Login_Page extends BaseClass {
	
	@Test
	public void loginPage() throws Exception {

		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		ExcelHandler ex = new ExcelHandler(Paths.excelFilePath);
		
		String email = ex.getCellData("sheet1", 1, 2);
		String password = ex.getCellData("sheet1", 1, 3);
		
		homepage.clickOnLoginButton();
		loginpage.loginThePage(email, password);
		loginpage.verifyLoginSuccess(email);
		
	}
}
