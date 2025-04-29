package com.selenium.hybrid.genericrepo;

import java.util.Random;

public class JavaUtils {
	
	public String generateRandomEmail() {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String domain = "@test.com";
		Random random = new Random();
		StringBuilder username = new StringBuilder();
		
		// Add random letters (5 to 10 characters)
		int length = random.nextInt(6) + 5; // length between 5 and 10
		for (int i = 0; i < length; i++) {
			username.append(characters.charAt(random.nextInt(characters.length())));
		}

		// Optionally add some random numbers
		int numberLength = random.nextInt(3); // up to 2 random digits
		for (int i = 0; i < numberLength; i++) {
			username.append(numbers.charAt(random.nextInt(numbers.length())));
		}
		return username.toString() + domain;
	}
}
