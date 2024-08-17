package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class Base {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	public void configureAppium() throws MalformedURLException {
		
		//run appium server automatically
//	    service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
//		service.start();
		
		//create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3 XL");
		options.setPlatformName("Android");
		options.setCapability("platformVersion", "9.0");
		//options.setCapability("appPackage", "");
		//options.setCapability("appActivity", "");
		
		options.setApp(System.getProperty("user.dir")+"/BuildFiles/ApiDemos-debug.apk");
		//options.setApp(System.getProperty("user.dir")+"/BuildFiles/General-Store.apk");
		//options.setChromedriverExecutableDir("/Users/rahade/node_modules/chromedriver/lib/chromedriver/chromedriver");
		
		
		//create object for AndroidDriver / IOSDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		
		
	}
	
	public void scrollToEnd() {
		 boolean canScrollMore;
		 do{
			  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	 			    "left", 100, "top", 100, "width", 200, "height", 200,
	 			    "direction", "down",
	 			    "percent", 3.0
	 			));
	 		
		 }while(canScrollMore);
	}
	
	//public void scrollToElement(String ele) {
	public void scrollToElement() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}
	
	public void swipeAction(WebElement ele, String swipeDirection) {
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
 				"elementId", ((RemoteWebElement) ele).getId(),
 			    "direction", swipeDirection,
 			    "percent", 0.75
 			));	
	}

}

