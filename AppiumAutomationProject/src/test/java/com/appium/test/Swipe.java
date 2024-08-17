package com.appium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebElement;
import com.appium.base.Base;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe extends Base{

	@BeforeMethod
	 public void launch() throws MalformedURLException {
		 configureAppium();
		 
	 }

	
	@Test
	public void swipeTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		//driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		
		
		
		WebElement firstImage=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		//swipe(20,20,100,100,10);
		
		
		
		//Before perform the swipe
		String firstTimeValue=firstImage.getAttribute("focusable");
		Assert.assertEquals("true",firstTimeValue);
		
		//perform swipe action
//		 driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
// 				"elementId", ((RemoteWebElement) firstImage).getId(),
// 			    "direction", "left",
// 			    "percent", 0.75
// 			));	
		 
		
		swipeAction(firstImage, "left");
		
		//After perform the swipe
		String secondTimeValue=firstImage.getAttribute("focusable");
		Assert.assertEquals("false",secondTimeValue);
		
		

		
		
	}
	
	 public void swipe(int startX, int startY, int endX, int endY, int duration) {
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1)
	                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	                .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endX, endY))
	                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        
	        driver.perform(Arrays.asList(swipe));
	    }

	    public void swipeLeft(int duration) {
	        int height = driver.manage().window().getSize().getHeight();
	        int width = driver.manage().window().getSize().getWidth();
	        swipe(width * 3 / 4, height / 2, width / 4, height / 2, duration);
	    }

	    public void swipeRight(int duration) {
	        int height = driver.manage().window().getSize().getHeight();
	        int width = driver.manage().window().getSize().getWidth();
	        swipe(width / 4, height / 2, width * 3 / 4, height / 2, duration);
	    }

	
	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}
	
}
