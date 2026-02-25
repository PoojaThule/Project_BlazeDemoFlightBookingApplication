package com.blazedemo.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {

	static WebDriver driver = null;

	public static WebDriver getDriver(String browername) {

		if (driver == null) {
			if (browername.contentEquals("Chrome")) {
				driver = new ChromeDriver();
			} else if (browername.contentEquals("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browername.contentEquals("Edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.print("Please provide the correct browser name");
			}
		}
		return driver;
	}
	
	public static void CloseDriver() {
		if (driver!=null) {
			driver.quit();
			driver = null;
		}
	}
}
