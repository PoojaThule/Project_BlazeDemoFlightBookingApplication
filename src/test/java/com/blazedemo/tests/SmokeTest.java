package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseClass {
	// TC01 Verify homepage loads and dropdowns visible Smoke
	@Test
	public void TC01_verifyHomepageLoads() {
		logger.info("TestCase 1 started");
		Assert.assertTrue(homepage.isDropdownVisible());
		Assert.assertTrue(homepage.getURL());
		Assert.assertTrue(homepage.getTitle());
		Assert.assertEquals(homepage.getHomePageHeader(), "Welcome to the Simple Travel Agency!");
		logger.info("TC01 Pass: home page is loaded and drop-down is visible.");
	}
}
