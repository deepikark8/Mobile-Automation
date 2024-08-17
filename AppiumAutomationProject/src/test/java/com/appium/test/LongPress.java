package com.appium.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends Base {


	 @BeforeMethod
	 public void launch() throws MalformedURLException {
		 configureAppium();
		 
	 }
	 
	 
	 
	 @Test
	 public void longPressTest() throws InterruptedException {
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		
		 //tagname[@attribute='value'] ---> xpath
		 WebElement longele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		
//		 ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) longele).getId()
//				),"duration", 3000);
		 
		 driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) longele).getId(),"duration",3000
				));
		
		 
		Thread.sleep(2000);
		
		 WebElement smenu = driver.findElement(By.id("android:id/title"));
		 String Peopletext = smenu.getText();
		 AssertJUnit.assertEquals(Peopletext, "Sample menu");
		 
		 
		 boolean display = smenu.isDisplayed();
		 AssertJUnit.assertTrue(display);
		 
		 
	 }
	 
	 
	
	@AfterMethod
		public void tearDown() {
			
			//driver.quit();
		}
}
