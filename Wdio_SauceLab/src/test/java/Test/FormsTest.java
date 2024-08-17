package Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;


import Base.BaseTest;
import Page.FormsPage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
import utilities.CommonUtilities;


public class FormsTest extends BaseTest{
	
	AndroidDriver driver;
	FormsPage formPage;
	CommonUtilities utilities;
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		driver = (AndroidDriver) launchApp("Android");
		formPage = new FormsPage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void forms() throws InterruptedException {
		Log.info("Forms page");
		formPage.clickForms();
		formPage.enterInputField();
		formPage.toggleSwtich();
		formPage.clickInput();
		formPage.selectFromDropDown();
		formPage.swipePage();
		formPage.clickActiveBtn();
		formPage.clickBtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		utilities.takeScreenShot(driver);
		driver.quit();
	}

}
