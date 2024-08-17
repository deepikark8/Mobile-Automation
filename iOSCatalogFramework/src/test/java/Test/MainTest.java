package Test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Page.MainPage;
import io.appium.java_client.AppiumDriver;


public class MainTest extends BaseTest{
	
	public AppiumDriver driver;
	MainPage mainPage ;

	@BeforeMethod
	public void before() {
		
		driver = launchApp();
		mainPage = new MainPage(driver);
	}
	
	@Test
	public void clickActionSheet() {
		
		mainPage.clickActionSheetAction();
		mainPage.clickOkCancelBtn();
		mainPage.clickCancelBtn();
		driver.navigate().back();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
