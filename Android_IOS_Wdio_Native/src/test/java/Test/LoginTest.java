package Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeMethod;


import Base.BaseTest;
import Page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
import utilities.CommonUtilities;


public class LoginTest extends BaseTest {
	
	public AndroidDriver driver;
	LoginPage loginPage ;
	CommonUtilities utilities;
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		driver = (AndroidDriver) launchApp("Android");
		loginPage = new LoginPage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void login() throws InterruptedException {
		Log.info("Login Page");
		loginPage.clickLogin();
		loginPage.enterUsername();
		loginPage.enterPassword();
		loginPage.clickLoginButton();
		loginPage.readMessage();
		loginPage.clickOk();
		loginPage.clickSignUp();
		loginPage.enterEmailSignUp();
		loginPage.enterPasswordSignUp();
		loginPage.enterReEnterPasswordSignUp();
		loginPage.clickSignUpButton();
		loginPage.clickSignUpMessage();
		loginPage.clickOkBtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		utilities.takeScreenShot(driver);
		driver.quit();
	}

}
