package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	// Validate success message.

	private WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	private By confirmMsg = By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]");

	public boolean isConfirmationPageVisible() {
		return driver.getCurrentUrl().contains("confirmation");
	}

	public String getConfirmationMsg() {
		return driver.findElement(confirmMsg).getText();
	}
}
