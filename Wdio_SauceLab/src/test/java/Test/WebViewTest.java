package Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeMethod;


import Base.BaseTest;
import Page.WebViewPage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
/*
 * 
 * appium --use-plugins=gestures --address 127.0.0.1 --port 4723 --base-path /wd/hub --allow-cors --allow-insecure chromedriver_autodownload
 * 
 * appium --use-plugins=gestures --address 127.0.0.1 --port 4723 --base-path /wd/hub --allow-cors
 */
import utilities.CommonUtilities;

public class WebViewTest extends BaseTest{
	
	public AndroidDriver driver;
	WebViewPage webViewPage ;
	CommonUtilities utilities;

	/*
	 * 
	 * appium --use-plugins=gestures --address 127.0.0.1 --port 4723 --base-path /wd/hub --allow-cors --allow-insecure chromedriver_autodownload
	 * 
	 * appium --use-plugins=gestures --address 127.0.0.1 --port 4723 --base-path /wd/hub --allow-cors
	 */
	
	
	@BeforeMethod
	public void before() throws MalformedURLException {
		
		driver = (AndroidDriver) launchApp("Android");
		webViewPage = new WebViewPage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void clickWebView() throws InterruptedException {
		Log.info("WebView Page");
		webViewPage.clickWebView();
		webViewPage.swipeWebView();
		webViewPage.getStarted();
		webViewPage.swipeUp();
		webViewPage.swipeDown();
		webViewPage.clickHome();
		
		
	}
	
	@Test
	public void viewOnGithub() throws InterruptedException {
		webViewPage.clickWebView();
		webViewPage.swipeWebView();
		webViewPage.clickViewOnGithub(driver);
//		webViewPage.clickAboutInWebView();
//		webViewPage.clickNewWebView();
//		webViewPage.enterUrl();
//		webViewPage.clickEnter();
	}
	
	@Test
	public void viewOnGithubInWebView() throws InterruptedException {
		webViewPage.clickWebView();
		webViewPage.swipeWebView();
		webViewPage.clickViewOnGithub(driver);
		webViewPage.enterWebView(driver);
		webViewPage.clickRepo(driver);
		webViewPage.clickWebDriverIO();
		//webViewPage.goBack(driver);
		//back button to go back to the previous screen
		webViewPage.clickBack(driver);
		webViewPage.clickBack(driver);
		webViewPage.clickBack(driver);
		//webViewPage.clickBack(driver);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		utilities.takeScreenShot(driver);
		driver.quit();
	}
	

}
