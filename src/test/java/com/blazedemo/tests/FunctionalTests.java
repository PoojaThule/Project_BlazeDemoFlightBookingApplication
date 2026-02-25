package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests extends BaseClass {
	// TC02 Search flights with valid cities
	@Test
	public void TC02_SearchFlights() {
		logger.info("TestCase 2 started");
		homepage.selectCities("Mexico City", "New York");
		homepage.searchFlights();
		Assert.assertTrue(reservepage.isReservePageVisible());
		logger.info("TC02 Pass:: ReservePage is visible");
	}

	// TC03 Complete a flight booking Functional
	@Test
	public void TC03_completeFlightBooking() {
		logger.info("TestCase 3 started");
		homepage.selectCities("Philadelphia", "Berlin");
		homepage.searchFlights();

		Assert.assertTrue(reservepage.isReservePageVisible());
		reservepage.chooseFlights();

		Assert.assertTrue(purchasepage.isPurchasePageVisible());
		purchasepage.FlightAttendeInfo("Pooja", "17 Shark lane", "Philadelphia", "Philadelphia state", "12345", "amex",
				"12345678", "12", "2025", "Pooja Thule");
		purchasepage.purchaseFlight();

		Assert.assertTrue(confirmationpage.isConfirmationPageVisible());
		Assert.assertEquals(confirmationpage.getConfirmationMsg(), "Thank you for your purchase today!",
				"Test Fail: Confirmation message is not visible");
		logger.info("TC03 Pass: Booking is confirmed for Pooja");
	}

}
