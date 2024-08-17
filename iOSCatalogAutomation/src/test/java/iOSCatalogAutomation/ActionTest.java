package iOSCatalogAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ActionTest {
	
	public AppiumDriver<WebElement> driver;
	
	@BeforeMethod
	public void launchApp() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");	
//		//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.7.2");//16.7.2
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Deepika's iPhone");//8
//		caps.setCapability(MobileCapabilityType.UDID, "dc76120d7fd80b0e38503e3be257421db28694ec");//  6F36D0CF-4DF4-410D-8F4C-70EF4E99000D
//		caps.setCapability("bundleID", "com.deepika.apple-samplecode.UICatalog"); //(MobileCapabilityType.APP, "com.deepika.apple-samplecode.UICatalog");
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");	
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "17.0");//16.7.2
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 15 Pro");//8
		caps.setCapability(MobileCapabilityType.UDID, "6F36D0CF-4DF4-410D-8F4C-70EF4E99000D");//  6F36D0CF-4DF4-410D-8F4C-70EF4E99000D
		caps.setCapability(MobileCapabilityType.APP, "com.deepika.apple-samplecode.UICatalog");//caps.setCapability("bundleID", "com.deepika.apple-samplecode.UICatalog"); 
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		
		driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
	}
	
	
	
	@Test
	public void clickActionSheet() {
		
		driver.findElement(MobileBy.AccessibilityId("Action Sheets")).click();
		driver.findElement(MobileBy.AccessibilityId("Okay / Cancel")).click();
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]")).click();
		driver.navigate().back();
		
	}
	
	
	@Test
	public void clickAlertViews() {
		
		driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"chevron\"])[3]")).click();
		driver.findElement(MobileBy.AccessibilityId("Simple")).click();
		driver.findElement(MobileBy.AccessibilityId("OK")).click();
		
		//Ok/Cancel Btn
		driver.findElementByAccessibilityId("Okay / Cancel").click();
		driver.findElementByAccessibilityId("OK").click();
		
		//Secure Text Entry
		driver.findElement(MobileBy.AccessibilityId("Secure Text Entry")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[2]")).sendKeys("automation");
		driver.switchTo().alert().accept();
		driver.navigate().back();
	}
	
	@Test
	public void clickDatePicker() throws InterruptedException {
		
		driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"chevron\"])[5]")).click();
		//driver.findElementByAccessibilityId("Dec 19, 2023").click();
		List<WebElement> elementsTxt  = driver.findElementsByAccessibilityId("Date and Time Picker");
		for(int i=0; i<elementsTxt.size() ;i++) {
			
			System.out.println(elementsTxt.get(i).getText());
		}
		
		
		/*
		driver.findElementByAccessibilityId("Thursday, December 21").click();
		
		
		Thread.sleep(10000);
		
		//Tap screen to hide the DatePicker
		WebElement element =driver.findElement(By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage"));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> tapObject = new HashMap<String, String>();
        tapObject.put("x", String.valueOf(((RemoteWebElement) element).getSize().getWidth()-50 / 2));
        tapObject.put("y", String.valueOf(((RemoteWebElement) element).getSize().getHeight() -50/ 2));
        tapObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile:tap", tapObject);
		

        driver.findElementByAccessibilityId("4:10 PM").click();
        driver.findElement(By.xpath("//XCUIElementTypePickerWheel[@value=\"4 o’clock\"]")).sendKeys("8");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[@value=\"10 minutes\"]")).sendKeys("30");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[@value=\"PM\"]")).sendKeys("AM");
		*/
	}
	
	
	
	
	private TouchAction TouchAction(AppiumDriver<WebElement> driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void clickPickerView() {
		
		driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
		driver.findElementByAccessibilityId("Green color component value").sendKeys("190");
		driver.findElementByAccessibilityId("Blue color component value").sendKeys("135");
		driver.findElement(By.className("XCUIElementTypeButton")).click();
		
	}
	
	@Test
	public void clickWebView() throws InterruptedException {
		driver.findElementByAccessibilityId("Web View").click();
		driver.findElement(By.className("XCUIElementTypeTextField")).clear();
		driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys("https://www.google.com");
		Thread.sleep(5000);
		driver.navigate().back();
		
	}

}
