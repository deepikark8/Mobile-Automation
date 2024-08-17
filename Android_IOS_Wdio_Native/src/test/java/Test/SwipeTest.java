package Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeMethod;


import Base.BaseTest;
import Page.SwipePage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
import utilities.CommonUtilities;


public class SwipeTest extends BaseTest {

	AndroidDriver driver;
	SwipePage swipePage;
	CommonUtilities utilities;
	
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		driver = (AndroidDriver) launchApp("Android");
		swipePage = new SwipePage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void swipe() throws InterruptedException {
		Log.info("Swipe page");
		swipePage.clickSwipe();
		swipePage.swipeGesture(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		utilities.takeScreenShot(driver);
		driver.quit();
	}
	
}
