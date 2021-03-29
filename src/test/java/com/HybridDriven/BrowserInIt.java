package com.HybridDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserInIt {
	WebDriver driver;

	public WebDriver InItBrowser(String driverName) {
		if (driverName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"//Users//priya//Documents//workspace//testingRequsites//chromedriver");
			driver = new ChromeDriver();
		} else if (driverName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver",
					"//Users//priya//Documents//workspace//testingRequsites//geckodriver");
			driver = new FirefoxDriver();
		} else if (driverName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		return driver;
	}

	public void OpenPage(String pageUrl) throws InterruptedException {
		driver.get(pageUrl);
		Thread.sleep(2000);
	}

	public void ClosePage() {
		driver.close();
	}
}
