package com.blazedemo.utilis;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name = "bookingInfo")
	public Object[][] bookingInfo() {
		return new Object[][] {
				{ "PoojaT", "17 Shark lane", "Paris", "Paris state", "12345", "amex", "12345678", "12", "2025",
						"Pooja Thule", "Rome" },
				{ "Neeraj", "16 DDG lane", "Boston", "Boston state", "1244", "dinersclub", "12345678", "05",
						"2025", "Neeraj Thule", "Berlin" },
				{ "Supriya", "89 Mexico City", "Mexico City", "Mexico City state", "12432", "visa", "12345678", "09",
						"2026", "Supriya Thule", "London" } };
	}

}
