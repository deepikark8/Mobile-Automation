package com.appium.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;

import io.appium.java_client.AppiumBy;

public class ViewText extends Base{
	
	 @BeforeMethod
	 public void launch() throws MalformedURLException {
		 configureAppium();
		 
	 }
	 
	 @Test
	 public void textTest() {
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 driver.findElement(AppiumBy.accessibilityId("Buttons")).click();
		 String normalBtn = driver.findElement(By.id("io.appium.android.apis:id/button_normal")).getText();
		 AssertJUnit.assertEquals(normalBtn,"NORMAL");
	 }
	 
	 
	@AfterMethod
		public void tearDown() {
			
			//driver.quit();
		}

}
