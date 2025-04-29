package com.selenium.hybrid.testrepo;

import org.testng.annotations.Test;

import com.selenium.hybrid.genericrepo.BaseClass;
import com.selenium.hybrid.genericrepo.ExcelHandler;
import com.selenium.hybrid.genericrepo.JavaUtils;
import com.selenium.hybrid.genericrepo.Paths;
import com.selenium.hybrid.objectrepo.HomePage;
import com.selenium.hybrid.objectrepo.RegisterPage;

public class Verify_Register_Page extends BaseClass {

	@Test
	public void newRegisterPage() throws Exception {
		try {
			logger.info("************** Running Register Page Test ***************");
			HomePage homepage = new HomePage(driver);
			RegisterPage regpage = new RegisterPage(driver);
			JavaUtils ju = new JavaUtils();

			ExcelHandler ex = new ExcelHandler(Paths.excelFilePath);
			String fname = ex.getCellData("sheet1", 1, 0);
			String lname = ex.getCellData("sheet1", 1, 1);
			String email = ju.generateRandomEmail();
			String password = ex.getCellData("sheet1", 1, 3);

			homepage.clickOnRegisterButton();
			regpage.registerThePage("mal", fname, lname, email, password);
			regpage.verifySuccessMessage();
			regpage.clickOnContinueBtn();
			logger.info("************** Test Passed ***************");
		} catch (Exception e) {
			logger.error("Test failed................");
			logger.debug("Debug logs.................");
		}
	}
}
