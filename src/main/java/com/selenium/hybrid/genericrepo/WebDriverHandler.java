package com.selenium.hybrid.genericrepo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHandler {

	public static WebDriver driver;

	public void select(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void scrollToElement(WebElement element) {
		new Actions(driver).scrollToElement(element).perform();
	}

	public void waitforElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Paths.explictWait));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitforElementToVisibale(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Paths.explictWait));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElemnetContainsText(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Paths.explictWait));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}

	public void switchToWindow() {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);
				String title = driver.getTitle();
				System.out.println(title);
			}
		}
	}
	
	 // Scroll down by pixels
    public static void scrollDown(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    // Scroll up by pixels
    public static void scrollUp(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-" + pixels + ")");
    }

    // Scroll into view of a specific element
    public static void scrollIntoView(WebDriver drvier,WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to the bottom of the page
    public static void scrollToBottom(WebDriver drier) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Scroll to the top of the page
    public static void scrollToTop(WebDriver drier) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }
	
	
}
