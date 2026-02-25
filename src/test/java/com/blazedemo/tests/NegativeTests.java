package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends BaseClass {
	// TC05 Blank credit card Negative
	@Test
	public void TC05_BlankcreaditcardDetail() {
		logger.info("TestCase 5 started");
		homepage.selectCities("Philadelphia", "Berlin");
		homepage.searchFlights();

		Assert.assertTrue(reservepage.isReservePageVisible());
		reservepage.chooseFlights();

		Assert.assertTrue(purchasepage.isPurchasePageVisible());
		purchasepage.FlightAttendeInfo("Pooja", "17 Shark lane", "Philadelphia", "Philadelphia state", "12345", "visa",
				"", "", "", "");
		purchasepage.purchaseFlight();

		Assert.assertTrue(purchasepage.isPurchasePageVisible(),
				"Defect: System allowed booking with blank credit card!");

	}

	@Test
	// TC06 Invalid credit card characters Negative
	public void TC06_InvalidCreditCardCharacters() {
		logger.info("TestCase 6 started");
		homepage.selectCities("Portland", "Dublin");
		homepage.searchFlights();

		Assert.assertTrue(reservepage.isReservePageVisible());
		reservepage.chooseFlights();

		Assert.assertTrue(purchasepage.isPurchasePageVisible());
		purchasepage.FlightAttendeInfo("Pooja", "17 Shark lane", "Philadelphia", "Philadelphia state", "12345", "visa",
				"123abd@123", "", "", "");
		purchasepage.purchaseFlight();

		Assert.assertTrue(purchasepage.isPurchasePageVisible(), "Defect: System Accepts invalid character");

	}

	@Test
	// TC07 Same departure and destination city Negative
	public void TC07_sameDepartureAndDestinationCity() {
		logger.info("TestCase 7 started");
		homepage.selectCities("Paris", "Paris");
		homepage.searchFlights();
		Assert.assertTrue(homepage.getTitle());

	}

}
