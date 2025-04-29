package com.selenium.hybrid.genericrepo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShotHandler {

	public WebDriver driver;

	public String takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sorucefile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilepath = System.getProperty("user.dir") + "\\Screenshots\\" + filename + ".jpg";
		File destination = new File(targetFilepath);
		sorucefile.renameTo(destination);
		return targetFilepath;
	}

	// ELement screenshot :
	public void captureScreenShotOf(WebElement el, WebDriver driver, String filename) {
		File newImg = el.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(newImg, new File("./screenshot" + filename + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Full Page screenshot :

	// Firefox Browser Alone :
	public void captureFullPageShot_FireFox(String filename) {
		File newImg = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(newImg, new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// All browsers
	public static void captureFullPageShot_AnyBrowser(WebDriver driver, String filename) {
		// Capture full-page screenshot using AShot
		ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			// Save the screenshot to a file
			ImageIO.write(screenshot.getImage(), "PNG", new File("./screenshot" + filename + " FullPageShot_Any.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
