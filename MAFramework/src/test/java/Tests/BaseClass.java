package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.Test;

public class BaseClass {
	
	static IOSDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//Using MobileCapabilityType gives you all the options to choose from - Enum.
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");	
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "17.0");//16.7.2
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 15 Pro");//8
		caps.setCapability(MobileCapabilityType.UDID, "6F36D0CF-4DF4-410D-8F4C-70EF4E99000D");//  6F36D0CF-4DF4-410D-8F4C-70EF4E99000D
		//caps.setCapability(MobileCapabilityType.APP, "com.deepika.apple-samplecode.UICatalog");//caps.setCapability("bundleID", "com.deepika.apple-samplecode.UICatalog"); 
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		 try {
			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		} catch (MalformedURLException exp) {
			// TODO Auto-generated catch block
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());;
			exp.printStackTrace();
		}
		
	}
	
	@Test
	public void sampleTest() {
		System.out.println("sampel test");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
