package com.appium.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;

import io.appium.java_client.AppiumBy;

public class SetWifi extends Base{
	
	@BeforeMethod
	public void launch() throws MalformedURLException {
		configureAppium();
	}

	@Test
	public void setWifiTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Windchimes");
		
		driver.findElement(By.id("android:id/button1")).click();
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		//driver.quit();
	}
	
}

