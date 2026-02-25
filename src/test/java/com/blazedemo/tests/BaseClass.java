package com.blazedemo.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.HomePage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.pages.ReservePage;
import com.blazedemo.utilis.DriverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(com.blazedemo.utilis.TestListener.class)
public class BaseClass {

	public static WebDriver driver;
	public HomePage homepage;
	public ReservePage reservepage;
	public PurchasePage purchasepage;
	public ConfirmationPage confirmationpage;
    public static Logger logger = LogManager.getLogger(BaseClass.class);


	@BeforeMethod
	public void initDriver() {
		driver = DriverUtil.getDriver("Chrome");
		logger.info("Browser is launching");
		driver.get("https://blazedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		homepage = new HomePage(driver);
		reservepage = new ReservePage(driver);
		purchasepage = new PurchasePage(driver);
		confirmationpage = new ConfirmationPage(driver);
	}

	@AfterMethod
	public void CloseBrowser() {
		logger.info("Browser is closing");
		DriverUtil.CloseDriver();
	}

	public static String captureScreenshot(WebDriver driver, String testName) {

		String folderPath = System.getProperty("user.dir") + "/Screenshots";

		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationPath = folderPath + "/" + testName + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationPath;
	}
}
