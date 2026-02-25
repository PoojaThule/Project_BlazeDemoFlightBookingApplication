package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {
	
	private WebDriver driver;

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}

	private By name = By.id("inputName");
	private By addredss = By.id("address");
	private By city = By.id("city");
	private By state = By.id("state");
	private By zipCode = By.id("zipCode");
	private By CardType = By.id("cardType");
	private By creditCardNumber = By.id("creditCardNumber");
	private By creditCardMonth = By.id("creditCardMonth");
	private By creditCardYear = By.id("creditCardYear");
	private By nameOnCard = By.id("nameOnCard");
	private By PurchaseFlight = By.xpath("//input[@value='Purchase Flight']");

	public boolean isPurchasePageVisible() {
		return driver.getCurrentUrl().contains("purchase");
	}

	public void FlightAttendeInfo(String fname, String add, String ct, String st, String zipcode, String cdtype, String crdnum,
			String crdmnt, String crdyr, String nmcrd) {
		driver.findElement(name).sendKeys(fname);
		driver.findElement(addredss).sendKeys(add);
		driver.findElement(city).sendKeys(ct);
		driver.findElement(state).sendKeys(st);
		driver.findElement(zipCode).sendKeys(zipcode);
		new Select(driver.findElement(CardType)).selectByValue(cdtype);
		driver.findElement(creditCardNumber).sendKeys(crdnum);
		driver.findElement(creditCardMonth).sendKeys(crdmnt);
		driver.findElement(creditCardYear).sendKeys(crdyr);
		driver.findElement(nameOnCard).sendKeys(nmcrd);
	}
	
	public void purchaseFlight() {
		driver.findElement(PurchaseFlight).click();
	}

}
