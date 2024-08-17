package com.appium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;

import io.appium.java_client.AppiumBy;

public class DropDown_logs extends Base{
	
	@BeforeMethod
	 public void launch() throws MalformedURLException {
		 configureAppium();
		
		 
	 }
	
	@Test(enabled = true)
	public void dropDownTest() throws InterruptedException {
		
		//Scroll and select Canada from dropDown
//		driver.findElement(By.id("android:id/text1")).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
		
		Thread.sleep(10000);
		
		//Type your name
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		
		
		
		//Hide Keyboard
		driver.hideKeyboard();
		
		//Radio btn
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
	
	@Test
	public void toastMsg() {
		
		//Scroll and select Canada from dropDown
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Deepika");
		
		//Hide Keyboard
		driver.hideKeyboard();
		
		//Radio btn
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
				
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//spy toast message and get the text
		//String  toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//AssertJUnit.assertEquals(toastMsg, "Please enter your name");
					
	}
	
	
	@AfterMethod
	public void tearDown() {
		// Collect Appium Driver Logs
		 LogEntries logEntries = driver.manage().logs().get("logcat"); // For Android
	        // LogEntries logEntries = driver.manage().logs().get("syslog"); // For iOS

	        for (LogEntry logEntry : logEntries) {
	            System.out.println(logEntry.getMessage());
	        }
	        
	        

		driver.quit();
	}

}
