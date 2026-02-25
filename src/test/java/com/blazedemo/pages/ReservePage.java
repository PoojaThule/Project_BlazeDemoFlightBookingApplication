package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {
	// Choose a flight.

	private WebDriver driver;

	public ReservePage(WebDriver driver) {
		this.driver = driver;
	}

	private By ChooseFlight = By.xpath("//input[@value='Choose This Flight']");

	public boolean isReservePageVisible() {
		return driver.getCurrentUrl().contains("reserve");
	}

	public void chooseFlights() {
		driver.findElement(ChooseFlight).click();
	}
}
