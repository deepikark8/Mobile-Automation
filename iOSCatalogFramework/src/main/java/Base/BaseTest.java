package Base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;


public class BaseTest {
	
	public AppiumDriver driver;
	
public AppiumDriver launchApp(){
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "17.0");
		caps.setCapability("deviceName","iPhone 15 Pro");
		caps.setCapability("bundleId", "com.deepika.apple-samplecode.UICatalog");
		caps.setCapability("automationName", "XCUItest");
		caps.setCapability("udid", "6F36D0CF-4DF4-410D-8F4C-70EF4E99000D");
		
		//Using MobileCapabilityType gives you all the options to choose from - Enum.
//		caps.setCapability(CapabilityType.PLATFORM_NAME, "iOS");	
//		caps.setCapability(CapabilityType., "17.0");//16.7.2
//		caps.setCapability(CapabilityType.DEVICE_NAME, "iPhone 15 Pro");//8
//		caps.setCapability(MobileCapabilityType.UDID, "6F36D0CF-4DF4-410D-8F4C-70EF4E99000D");//  6F36D0CF-4DF4-410D-8F4C-70EF4E99000D
//		caps.setCapability(MobileCapabilityType.APP, "com.deepika.apple-samplecode.UICatalog");//caps.setCapability("bundleID", "com.deepika.apple-samplecode.UICatalog"); 
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		try {
			 driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
