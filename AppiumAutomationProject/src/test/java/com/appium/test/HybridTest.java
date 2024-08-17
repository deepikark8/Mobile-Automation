package com.appium.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.nativekey.AndroidKey;


public class HybridTest extends Base{
	
	
	
	@BeforeMethod
	 public void launch() throws MalformedURLException {
		 configureAppium();
		 
	 }
	
	@Test
	public void hybridAppTest() throws InterruptedException, IOException {
		
		//Scroll and select Canada from dropDown
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba']")).click();
		
		//Type your name
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Deepika");
		
		//Hide Keyboard
		driver.hideKeyboard();
		
		//Radio btn
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		//let's shop 
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//scroll until Air Jorden 9
		Thread.sleep(3000);
		
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
		
		//select Air Jorden 9 
		List<WebElement> count = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		
		for(WebElement productName: count) {
			
			if(productName.getText().equalsIgnoreCase("Air Jordan 9 Retro")) {
				driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();	
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		
		
		
		Set<String>s = driver.getContextHandles();
        for (String ContextName: s){
       	 System.out.println(ContextName); //Will print the name of both Native and WebView ContextId 
 
        }
         driver.context("WEBVIEW_com.androidsample.generalstore");
         Thread.sleep(6000);
         driver.findElement(By.name("q")).sendKeys("Automation");
         driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         
         driver.context("NATIVE_APP"); //pass the Native App Name
         driver.navigate().back();
       
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		//driver.quit();
	}

}
