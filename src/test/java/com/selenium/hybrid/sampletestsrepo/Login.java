package com.selenium.hybrid.sampletestsrepo;

import org.testng.annotations.Test;

public class Login {

	@Test(priority = 1,groups= {"sanity"})
	public void loginByFacebook() {
		System.out.println("login with facebook");
	}

	@Test(priority = 2,groups= {"sanity"})
	public void loginByEmail() {
		System.out.println("login with Email");
	}

	@Test(priority = 3,groups= {"sanity"})
	public void loginByTwitter() {
		System.out.println("login with Twitter");
	}
}
