package com.HybridDriven;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TcClickSignUp {
	WebDriver driver;
	BrowserInIt init;

	@BeforeTest
	public void BrowserInitialization() {
		init = new BrowserInIt();
		driver = init.InItBrowser("chrome");
	}

	@Test
	public void clickSignUp() throws InterruptedException {

		init.OpenPage("https://www.amazon.com/");
		PageElements ele = new PageElements(driver);
		ele.GotoSignIn();
		ele.ClickStartHere();
	}

	@AfterTest
	public void tearDown() {

		init.ClosePage();
	}
}
