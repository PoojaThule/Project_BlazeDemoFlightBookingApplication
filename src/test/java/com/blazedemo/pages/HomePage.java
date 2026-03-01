package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.tests.BaseClass;

public class HomePage extends BaseClass {
//Select cities, click “Find Flights”.

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By HomePageHeader = By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");
	private By departureCity = By.xpath("//select[@name='fromPort']");
	private By destinationCity = By.xpath("//select[@name='toPort']");
	private By FindFlights = By.xpath("//input[@value='Find Flights']");

	public boolean getTitle() {
		return driver.getTitle().trim().equals("BlazeDemo");
	}

	public boolean getURL() {
		return driver.getCurrentUrl().equals("https://blazedemo.com/");
	}

	public String getHomePageHeader() {
		String Header = driver.findElement(HomePageHeader).getText();
		System.out.println("Home page header is: " + Header);
		return Header;
	}

	public boolean isDropdownVisible() {
		return driver.findElement(departureCity).isDisplayed() && driver.findElement(destinationCity).isDisplayed();
	}

	public void selectCities(String depC, String DestC) {
		new Select(driver.findElement(departureCity)).selectByVisibleText(depC);
		new Select(driver.findElement(destinationCity)).selectByVisibleText(DestC);
	}

	public void searchFlights() {
		driver.findElement(FindFlights).click();
	}

	public boolean isDeparturCityAvailable(String city) {
		return new Select(driver.findElement(departureCity)).getOptions().stream()
				.anyMatch(option -> option.getText().equalsIgnoreCase(city));
	}

	public boolean isDestinationCityAvailable(String city) {
		return new Select(driver.findElement(destinationCity)).getOptions().stream()
				.anyMatch(option -> option.getText().equalsIgnoreCase(city));
	}

}
