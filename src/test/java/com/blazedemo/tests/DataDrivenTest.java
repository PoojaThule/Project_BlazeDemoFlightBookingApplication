package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazedemo.utilis.TestDataProvider;

public class DataDrivenTest extends BaseClass {

	// TC04 - Multiple bookings with different data sets

	@Test(dataProvider = "bookingInfo", dataProviderClass = TestDataProvider.class)
	public void TC04_multipleBookings(String fname, String add, String ct, String st, String zipcode, String cdtype,
			String crdnum, String crdmnt, String crdyr, String nmcrd, String deptct) {
		logger.info("TestCase 4 started");
		homepage.selectCities(ct, deptct);
		homepage.searchFlights();

		Assert.assertTrue(reservepage.isReservePageVisible());
		reservepage.chooseFlights();

		Assert.assertTrue(purchasepage.isPurchasePageVisible());
		purchasepage.FlightAttendeInfo(fname, add, ct, st, zipcode, cdtype, crdnum, crdmnt, crdyr, nmcrd);
		purchasepage.purchaseFlight();

		Assert.assertTrue(confirmationpage.isConfirmationPageVisible());
		Assert.assertEquals(confirmationpage.getConfirmationMsg(), "Thank you for your purchase today!",
				"Test Fail: Confirmation message is not visible");
		logger.info("TC04 Pass: Booking is confirmed for " + fname);
	}
}
