package com.HybridDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageElements {
	WebDriver driver;
	By bySignIn = By.xpath("//span[contains(text(),' Sign in')]");
	By byStartHere = By.xpath("(//a[contains(text(),'Start here.')])[1]");
	By byName = By.xpath("//input[@name='customerName']");
	By byEmail = By.xpath("//input[@name='email']");
	By byPassword = By.xpath("//input[@name='password']");
	By byPasswordCheck = By.xpath("//input[@name='passwordCheck']");
	By byCreateAccount = By.xpath("//input[@id='continue']");

	public PageElements(WebDriver driver) {
		this.driver = driver;
	}

	public void GotoSignIn() throws InterruptedException {
		Actions objAction = new Actions(driver);
		WebElement eleSignIn = driver.findElement(bySignIn);
		Thread.sleep(2000);
		objAction.moveToElement(eleSignIn).build().perform();
		Thread.sleep(3000);
	}

	public void ClickStartHere() throws InterruptedException {
		driver.findElement(byStartHere).click();
		Thread.sleep(2000);
	}

	public void enter_UserName(String tdName) throws InterruptedException {
		driver.findElement(byName).sendKeys(tdName);
		Thread.sleep(2000);
	}

	public void enter_Email(String tdEmail) throws InterruptedException {
		driver.findElement(byEmail).sendKeys(tdEmail);
		Thread.sleep(2000);
	}

	public void enter_Password(String tdPass) throws InterruptedException {
		driver.findElement(byPassword).sendKeys(tdPass);
		Thread.sleep(2000);
	}

	public void enter_PasswordCheck(String tdConfirmPass) throws InterruptedException {
		driver.findElement(byPasswordCheck).sendKeys(tdConfirmPass);
		Thread.sleep(2000);
	}

	public void ClickCreateAccount() throws InterruptedException {
		driver.findElement(byCreateAccount).click();
		Thread.sleep(2000);
	}
}