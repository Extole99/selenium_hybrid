package com.selenium.hybrid.sampletestsrepo;

import org.testng.annotations.Test;

public class Singup {
	@Test(priority = 1, groups = { "regression" })
	public void signUpByFacebook() {
		System.out.println("signUp with Twitter");
	}

	@Test(priority = 2, groups = { "regression" })
	public void signUpByEmail() {
		System.out.println("signUp with Email");
	}

	@Test(priority = 3, groups = { "regression" })
	public void signUpByTwitter() {
		System.out.println("signUp with Twitter");
	}

}
