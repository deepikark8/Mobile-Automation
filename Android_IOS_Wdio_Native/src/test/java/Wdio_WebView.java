import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;


import org.openqa.selenium.By;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Wdio_WebView {
	
	static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		launchapp();
		webView();
		swipe();
		getStarted();
		
	}
	
	public static void launchapp() throws MalformedURLException {
		
		String apkPath = System.getProperty("user.dir")+"/BuildFiles/android-wdio-native.apk";
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setDeviceName("Pixel 3 XL")
			.setPlatformName("Android")
			.setPlatformVersion("9.0")//setCapability("platformVersion", "9.0")
			.setAppActivity(".MainActivity")
			.setAppPackage("com.wdiodemoapp")
			.setApp(apkPath)
			.setNoReset(false);//true : will not install app if its already present 
		
		//create object for AndroidDriver / IOSDriver
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
	}
	
	public static void webView() throws InterruptedException {
		

		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Webview\"]")).click();
		System.out.println("Done");
		
		
	}
	
	public static void swipe() throws InterruptedException {
	
		Thread.sleep(10000);
        RemoteWebElement webViewElement = (RemoteWebElement)driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.webkit.WebView"));
        		//driver.findElement(By.className("android.webkit.WebView"));
        		//driver.findElement(By.cssSelector("body"));
        		

        // Perform swipe up action
        swipeUp_Pointer(driver, webViewElement);
       
	}
	
	private static void swipeUp_Pointer(AndroidDriver driver, RemoteWebElement element) {
		// Assuming 'driver' is your WebDriver instance and 'element' is the WebElement you want to interact with
		//WebElement element = driver.findElement(By.className("android.webkit.WebView")); // Example, adjust as necessary

		int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		int startY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.8);
		int endY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.2);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);

		// Move finger to start position
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		// Press down
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// Move finger to end position over 600ms
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
		// Release finger
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(swipe));
    }

	
	public static void swipeUp(AndroidDriver driver, RemoteWebElement element) throws InterruptedException {
		driver.executeScript("gesture: swipe", ImmutableMap.of(
			"elementId", element.getId(),
		    "direction", "up",
		    "percentage", 100
		));
	}
	public static void getStarted() throws InterruptedException {
		driver.findElement(By.xpath("//android.view.View[@text=\"Get Started\"]")).click();
		Thread.sleep(2000);
		 RemoteWebElement webViewElement = (RemoteWebElement)driver.findElement(By.xpath("//android.view.View[@resource-id=\"__docusaurus_skipToContent_fallback\"]"));
		 swipeUp_Pointer(driver, webViewElement);
		 Thread.sleep(2000);
		 swipeDown(driver,webViewElement);
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@text=\"Home page\"]")).click();
	}
	
	public static void swipeDown(AndroidDriver driver, RemoteWebElement element) {
		// Calculate the coordinates for the swipe gesture
		int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		int startY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.2);
		int endY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.8);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);

		// Move finger to start position
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		// Press down
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// Move finger to end position over 600ms
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
		// Release finger
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the swipe gesture
		driver.perform(Arrays.asList(swipe));
	}
}
