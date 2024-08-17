package Test;

import java.net.MalformedURLException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Page.DragDropPage;
import Page.FormsPage;
import Page.HomePage;
import Page.LoginPage;
import Page.SwipePage;
import Page.WebViewPage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
import utilities.CommonUtilities;

public class MainTest extends BaseTest{
	
	AndroidDriver driver;
	HomePage homePage ;
	LoginPage loginPage;
	FormsPage formPage;
	SwipePage swipePage;
	DragDropPage dragDropPage;
	CommonUtilities utilities;
	WebViewPage webViewPage;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		driver=(AndroidDriver)launchApp("Android");
		homePage= new HomePage(driver);
		webViewPage = new WebViewPage(driver);
		loginPage = new LoginPage(driver);
		formPage = new FormsPage(driver);
		swipePage = new SwipePage(driver);
		dragDropPage = new DragDropPage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test(priority = 1)
	public void home() {
		Log.info("Title of the Page is displayed");
		homePage.home();
		Log.info("Home page");
	}
	
	@Test(priority = 2)
	public void webView() throws InterruptedException {
		webViewPage.clickWebView();
//		webViewPage.swipeWebView();
//		webViewPage.clickViewOnGithub(driver);
//		webViewPage.enterWebView(driver);
//		webViewPage.clickRepo(driver);
//		webViewPage.clickWebDriverIO();
//		//webViewPage.goBack(driver);
//		//back button to go back to the previous screen
//		webViewPage.clickBack(driver);
//		webViewPage.clickBack(driver);
//		webViewPage.clickBack(driver);
		//webViewPage.clickBack(driver);
		
	}
	
	@Test(priority = 3)
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
	
	@Test(priority = 4 )
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
	
	@Test(priority = 5)
	public void swipe() throws InterruptedException {
		Log.info("Swipe page");
		swipePage.clickSwipe();
		swipePage.swipeGesture(driver);
	}
	
	@Test(priority = 6)
	public void dragDrop() throws InterruptedException {
		Log.info("Drag and Drop Page");
		dragDropPage.clickDragDrop();
		dragDropPage.dragAndDrop(driver);
	}
	@AfterMethod
	public void aferMethod() {
		utilities.takeScreenShot(driver);
	}
	
	@AfterClass
	public void aferClass() {
		
		//driver.quit();
	}
}
