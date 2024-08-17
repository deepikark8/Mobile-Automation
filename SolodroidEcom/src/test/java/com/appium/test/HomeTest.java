package com.appium.test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.Base;

import io.appium.java_client.AppiumBy;

public class HomeTest extends Base{
	
	@BeforeMethod
	public void launchApp() throws MalformedURLException {
		setup();
	}
	
	@Test
	public void addItem() throws InterruptedException {
		
		
		Thread.sleep(2000);
		//Scientific Calculator - Doraemon 350 MS
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"Samsung Galaxy S10 - Black\"]")).click();
	
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Scientific Calculator - Doraemon 350 MS\").instance(0))")).click();

		
		
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Scientific Calculator - Doraemon 350 MS\"));")).click();;
//		WebElement elementToScroll = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"SKMEI Children Sport Rubber LED Watch DG1100 - Black\"]"));
//		Actions action = new Actions(driver);
//		action.moveToElement(elementToScroll);// clickAndHold(e2).moveToElement();
//		action.perform();
		
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.id("com.solodroid.solomerce:id/userInputDialog")).sendKeys("1");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.solodroid.solomerce:id/cart")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("com.solodroid.solomerce:id/lyt_checkout")).click();
		driver.findElement(By.id("com.solodroid.solomerce:id/edt_name")).sendKeys("Deepika");
		driver.findElement(By.id("com.solodroid.solomerce:id/edt_email")).sendKeys("Deepika@tekarch.com");
		driver.findElement(By.id("com.solodroid.solomerce:id/edt_address")).sendKeys("123 ABC St");
		driver.findElement(By.id("com.solodroid.solomerce:id/spinner")).click();
		
		//Hide Keyboard
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"UPS\"]")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Comment\"));")).sendKeys("Its a good product");
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("android:id/message"), "Thank you for ordering, your order will be review soon, invoice detail will be sent to your email when the order is ready."));   
		
		String expectedText = "Thank you for ordering, your order will be review soon, invoice detail will be sent to your email when the order is ready.";
		String actualText = driver.findElement(By.id("android:id/message")).getText();
		
		Assert.assertEquals(actualText, expectedText);
		
		driver.findElement(By.id("android:id/button1")).click();
		
		
	}
	
	@Test
	public void category() throws InterruptedException {
		
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.solodroid.solomerce:id/icon\"])[2]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/category_name\" and @text=\"Electronics & Gadgets\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
		driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("Samsung Galaxy S10 - Black");
		driver.findElement(By.id("com.solodroid.solomerce:id/product_name")).click();
		//driver.findElement(By.id("com.solodroid.solomerce:id/btn_add_cart")).click();
		driver.findElement(By.id("com.solodroid.solomerce:id/share")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		
		driver.findElement(By.id("com.solodroid.solomerce:id/share")).click();
		
		//Upload photos
		//driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"android:id/icon\"])[5]")).click();
		
		//Gmail
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"android:id/icon\"])[2]")).click();
		driver.findElement(By.id("com.google.android.gm:id/welcome_tour_skip")).click();
		driver.findElement(By.id("com.google.android.gm:id/setup_addresses_add_another")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_setup_label\" and @text=\"Google\"]")).click();
		
		Thread.sleep(5000);
		
		Set<String>s = driver.getContextHandles();
        for (String contextName: s){
        	Thread.sleep(2000);
       	 System.out.println(contextName); //Will print the name of both Native and WebView ContextId
       	 if(contextName.equalsIgnoreCase("WEBVIEW_com.solodroid.solomerce")) {
       		 driver.findElement(By.xpath("//input[@type='email']")).sendKeys("deepikark8@gmail.com");
       		 
       	 }
 
        }
        /*
         * 	NATIVE_APP
			WEBVIEW_com.solodroid.solomerce
			WEBVIEW_com.google.android.gm
			WEBVIEW_com.google.android.gms.ui
         * 
         */
       // Thread.sleep(8000);
        driver.context("WEBVIEW_com.solodroid.solomerce");
        Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("deepikark8@gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
        driver.context("NATIVE_APP"); //pass the Native App Name
        driver.navigate().back();
       
	}
	
	@Test
	public void help() {
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.solodroid.solomerce:id/icon\"])[3]")).click();
	}
	
	@Test
	public void profile() {
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/smallLabel\" and @text=\"Profile\"]")).click();
	}

}
