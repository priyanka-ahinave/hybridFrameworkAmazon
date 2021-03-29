package com.HybridDriven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TcRegistrationPage {
	WebDriver driver;
	BrowserInIt init;

	@Test(dataProvider = "readExcel", dataProviderClass = ReadTestDataFromExcel.class)
	public void CompleteRegistration(String sName, String sEmail, String sPass, String sConfirmPass)
			throws InterruptedException, IOException {
		init = new BrowserInIt();
		driver = init.InItBrowser("chrome");
		init.OpenPage("https://www.amazon.com/");
		PageElements ele = new PageElements(driver);
		ele.GotoSignIn();
		ele.ClickStartHere();
		ele.enter_UserName(sName);
		ele.enter_Email(sEmail);
		ele.enter_Password(sPass);
		ele.enter_PasswordCheck(sConfirmPass);
		ele.ClickCreateAccount();

	}

	@AfterMethod
	public void getTestResult() throws InterruptedException {

		String expectedURL = "https://www.amazon.com/ap/cvf/";
		String actualURL = driver.getCurrentUrl();
		Thread.sleep(2000);
		if (actualURL.contains(expectedURL)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}

	@AfterTest
	public void tearDown() {
		init.ClosePage();
	}

}
