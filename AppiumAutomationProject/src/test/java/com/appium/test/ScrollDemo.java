package com.appium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends Base {
	
	
	 @BeforeMethod
	 public void launch() throws MalformedURLException {
		 configureAppium();
		 
	 }
	 
	 
	 @Test
	 public void scrollDownTest() {
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 
		 //scroll until view an element
		 //scrollToElement("WebView");
		 scrollToElement();
		 
		 
		 //scroll as long as the App has elements
		 scrollToEnd();
		 
		 
	 }
	 
	
	@AfterMethod
		public void tearDown() {
			
			driver.quit();
		}
	

}
