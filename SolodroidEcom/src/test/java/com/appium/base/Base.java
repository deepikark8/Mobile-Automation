package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Base {
	
	public AndroidDriver driver;
	
	
	public void setup() throws MalformedURLException {
		//create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3 XL");
		options.setPlatformName("Android");
		options.setPlatformVersion("9.0");
		//options.setApp(System.getProperty("user.dir")+"/buildFiles/Solodroid_E-CommerceApp Demo_3.2.0.apk");
//		options.setCapability("appPackage", "com.solodroid.solomerce");
//		options.setCapability("appActivity", "com.solodroid.solomerce.activities.MainActivity");
		options.setAppActivity("com.solodroid.solomerce.activities.MainActivity");
		options.setAppPackage("com.solodroid.solomerce");
		
				
		//create object for AndroidDriver / IOSDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
	}
	
	
	

}
