package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public AppiumDriver<WebElement> driver;
	
	
	public void setup() {
		
		
		
		try {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		String platform = "ios";
		
		if(platform.equalsIgnoreCase("android")) {
			//caps.setCapability("platformName", "ANDROID");
			//caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			//caps.setCapability(MobileCapabilityType.UDID, "");
			//caps.setCapability(MobileCapabilityType.APP, "/Users/rahade/Desktop/DemoApp Build/Android-MyDemoAppRN.1.3.0.build-244.apk");
			
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");				
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 XL");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "");
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			
		}else if(platform.equalsIgnoreCase("ios")) {
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");	
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.7.2");//16.7.2
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Deepika's iPhone");//8
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			//caps.setCapability("showXcodeLog", "true");
			
			caps.setCapability(MobileCapabilityType.UDID, "dc76120d7fd80b0e38503e3be257421db28694ec");
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			
		}
		
		driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		
//		URL url = new URL("https://127.0.0.1/wd/hub");
//		
//		driver = new AppiumDriver<MobileElement>(url,caps);
		//driver = new AndroidDriver<MobileElement>(url,caps);
		//driver = new IOSDriver<MobileElement>(url,caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Application Started....");
		
		}catch(Exception exp) {
		
			System.out.println("Cause is : " +exp.getCause());
			System.out.println("Message is: "+exp.getMessage());
			exp.printStackTrace();
		
		}
	}
	
//	@Test
//	public void sampleTest() {
//		System.out.println("I'm inside sample test");
//		
//	}
	
	
	

}
