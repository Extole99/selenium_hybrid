package com.selenium.hybrid.sampletestsrepo;

import org.testng.annotations.Test;

public class Payment {

	@Test(priority = 1, groups = { "regression", "sanity" })
	public void paymentByRuppes() {
		System.out.println("Payment with rupees");
	}

	@Test(priority = 2, groups = { "regression", "sanity" })
	public void paymentBydollrs() {
		System.out.println("Payment with dollors");
	}
}
