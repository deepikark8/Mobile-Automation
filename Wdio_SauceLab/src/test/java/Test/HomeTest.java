package Test;

import java.net.MalformedURLException;


import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Page.HomePage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
import utilities.CommonUtilities;


public class HomeTest extends BaseTest {
	
	AndroidDriver driver;
	HomePage homePage;
	CommonUtilities utilities;
	
//	@BeforeClass
//	public void beforeClass() {
//		startAppium();
//	}
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		//startAppium();
		driver = (AndroidDriver) launchApp("Android");
		homePage= new HomePage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void home(){
		Log.info("Title of the Page is displayed");
		homePage.home();
		Log.info("Home page");
	}
	
	@AfterMethod
	public void tearDown() {
		utilities.takeScreenShot(driver);
		driver.quit();
	}
	
//	@AfterClass
//	public void afterClass() {
//		stopAppium();
//	}
}
