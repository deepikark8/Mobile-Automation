package Page;


import java.util.Set;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WebViewPage extends BasePage{

	public WebViewPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.xpath("//android.view.View[@content-desc=\"Webview\"]")).click();
	@FindBy(xpath="//android.view.View[@content-desc=\"Webview\"]")
	RemoteWebElement webView;
	
	//RemoteWebElement webViewElement = (RemoteWebElement)driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.webkit.WebView"));
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.webkit.WebView")
	RemoteWebElement webViewElement;
	
	//driver.findElement(By.xpath("//android.view.View[@text=\"Get Started\"]")).click();
	@FindBy(xpath="//android.view.View[@content-desc=\"Get Started\"]")
	RemoteWebElement  getStartedElement;
	
	//RemoteWebElement webViewElement = (RemoteWebElement)driver.findElement(By.xpath("//android.view.View[@resource-id=\"__docusaurus_skipToContent_fallback\"]"));
	@FindBy(xpath="//android.view.View[@resource-id=\"__docusaurus_skipToContent_fallback\"]")
	RemoteWebElement webViewElementToSwipe;
	
	//driver.findElement(By.xpath("//android.view.View[@text=\"Home page\"]")).click();
	@FindBy(xpath="//android.view.View[@content-desc=\"Home page\"]")
	RemoteWebElement home;
	
	////android.view.View[@text="View on GitHub"]
	@FindBy(xpath="//android.view.View[@content-desc=\"View on GitHub\"]")
	RemoteWebElement clickBtnViewOnGithub;
	
	////android.widget.ImageButton[@content-desc="About WebView"]
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"About WebView\"]")
	RemoteWebElement clickAboutInWebView;
	
	///android.widget.TextView[@resource-id="android:id/title" and @text="Destroy and create new WebView"]
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"android:id/content\"])[1]")
	RemoteWebElement clickCreateNewWebView;
	
	////android.widget.EditText[@resource-id="org.chromium.webview_shell:id/url_field"]

	@FindBy(xpath="//android.widget.EditText[@resource-id=\"org.chromium.webview_shell:id/url_field\"]")
	RemoteWebElement enterUrlAddress;
	
	////android.widget.ImageButton[@content-desc="Load URL"]
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Load URL\"]")
	RemoteWebElement clickEnterBtn;
	
//	@FindBy(xpath="//android.view.View[@content-desc=\"Repositories 28\"]")
//	RemoteWebElement clickRepoElement;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.android.chrome:id/url_bar\"]")
	RemoteWebElement urlAddressELement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Repositories\"]")
	RemoteWebElement clickRepoElement;
	
	@FindBy(xpath="(//android.widget.TextView[@text=\"webdriverio\"])[2]")
	RemoteWebElement clickExampleRecipesElement;
	
	public void clickWebView() throws InterruptedException {
		Thread.sleep(2000);
		webView.click();
	}

	public void swipeWebView() throws InterruptedException {
		System.out.println("swipeWebView");
		Thread.sleep(10000);
		swipeUp_Pointer(webViewElement);
	}
	
	public void getStarted() throws InterruptedException {
		System.out.println("getStarted");
		Thread.sleep(10000);
		getStartedElement.click();
	}
	public void swipeUp() throws InterruptedException {
		System.out.println("swipeUp");
		Thread.sleep(2000);
		swipeUp_Pointer(webViewElementToSwipe);
	}
	public void swipeDown() throws InterruptedException {
		System.out.println("swipeDown");
		Thread.sleep(2000);
		swipeDown(webViewElementToSwipe);
	}
	public void clickHome() throws InterruptedException {
		System.out.println("clickHome");
		Thread.sleep(2000);
		home.click();
		Thread.sleep(2000);
	}
	public void clickViewOnGithub(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		clickBtnViewOnGithub.click();
		Thread.sleep(5000);
		//driver.navigate().back();
		//Thread.sleep(5000);
	}
	
	public void clickAboutInWebView() {
		clickAboutInWebView.click();
	}
	public void clickNewWebView() throws InterruptedException {
		Thread.sleep(3000);
		clickCreateNewWebView.click();
	}
	public void enterUrl() throws InterruptedException {
		Thread.sleep(3000);
		enterUrlAddress.sendKeys("www.google.com");
		Thread.sleep(8000);
	}
	public void clickEnter() throws InterruptedException {
		Thread.sleep(2000);
		clickEnterBtn.click();
		Thread.sleep(5000);
	}
	
	public void enterWebView(AndroidDriver driver) {
//		AndroidDriver driver = DriverFactory.getWebDriver();
//		// Initialize the driver (example for Android)
//		DriverFactory.initializeDriver("android");

		
//		Set<String> contextNames = driver.getContextHandles();
//        for (String contextName : contextNames) {
//        	System.out.println(contextName);
//            if (contextName.contains("NATIVE_APP"))
//                driver.context("NATIVE_APP");
//        }

		//((AppiumDriver<?>) driver).getContextHandles()
		Set<String> contextHandles  = driver.getContextHandles();
		for(String handles: contextHandles) {
			System.out.println(handles);
		}
		
	}
		

	public void clickRepo(AndroidDriver driver) throws InterruptedException {
		System.out.println("clickRepo");
		Thread.sleep(2000);
		clickRepoElement.click();
	}
	
	public void clickWebDriverIO() throws InterruptedException {
		System.out.println("clickExampleRecipes");
		Thread.sleep(2000);
		clickExampleRecipesElement.click();
		Thread.sleep(10000);
	}
	public void clickBack(AndroidDriver driver) {
		driver.navigate().back();
	}
	public void goBack(AndroidDriver driver) {
	driver.context("NATIVE_APP");
	}
}
