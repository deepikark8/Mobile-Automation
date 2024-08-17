package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

import java.time.Duration;


import org.openqa.selenium.WebDriver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	
	
//	public AppiumDriverLocalService server;
//	AppiumServiceBuilder service;
	
	AppiumDriverLocalService service;
	
	public void startAppium() {
		
//		server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//		            .usingDriverExecutable(new File("/opt/homebrew/bin/appium"))
//		            .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-webdriver"))
//		            .usingPort(4723).withIPAddress("127.0.0.1"));
//		    server.start();
		
		
//		    service = new AppiumServiceBuilder();
//service.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//.usingPort(4723);
//service.build().start();
//		    
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder ();
        builder.withIPAddress ("127.0.0.1")
            .usingPort (4723)
            .withAppiumJS (
                new File ("/usr/local/lib/node_modules/appium/build/lib/main.js"))
            .usingDriverExecutable (new File ("/opt/homebrew/bin/node"))
            .withArgument (BASEPATH, "/wd/hub")
            .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument (GeneralServerFlag.LOG_LEVEL, "debug");

        
        //[Appium][39m [31m'npm' executable is not found neither in the process working folder (/Users/rahade/workspaceMobileAutomation/Android_IOS_Wdio_Native) nor in any folders specified in the PATH environment variable (/usr/bin:/bin:/usr/sbin:/sbin)
	}
	
//	public void stopAppium() {
//		server.stop();
//	}
//	
	public WebDriver launchApp(String appType) throws MalformedURLException{
		
		System.out.println("launch app");
		UiAutomator2Options options = new UiAutomator2Options();
		XCUITestOptions optionsIOS = new XCUITestOptions();
		
		if(appType.equalsIgnoreCase("Android")) {
		
			
			options.setDeviceName("Pixel 2");
			options.setPlatformName("Android");
			options.setCapability("platformVersion", "12.0");
			options.setApp(System.getProperty("user.dir")+"/BuildFiles/android-wdio-native.apk");
			options.setChromedriverExecutable("/Users/rahade/workspaceMobileAutomation/Android_Wdio_Native/driver/chromedriver");
			
			//Saucelabs
			UiAutomator2Options optionsSauceLab = new UiAutomator2Options();
			optionsSauceLab.setCapability("username", "");
			optionsSauceLab.setCapability("accessKey", "");
			options.setCapability("sauce:options", optionsSauceLab);
			
			//create object for AndroidDriver / IOSDriver
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			 return driver;
		}else {
			optionsIOS.setDeviceName("iPhone 15 Pro");
			optionsIOS.setPlatformName("iOS");
			optionsIOS.setCapability("platformVersion", "17.0");
			optionsIOS.setCapability("bundleId","org.reactjs.native.example.wdiodemoapp");
			//optionsIOS.setChromedriverExecutable("/Users/rahade/workspaceMobileAutomation/Android_Wdio_Native/driver/chromedriver");
			//create object for AndroidDriver / IOSDriver
			IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),optionsIOS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			
			//xcrun simctl list devices
			//xcrun simctl listapps {6F36D0CF-4DF4-410D-8F4C-70EF4E99000D}
			//iPhone 15 Pro (BF7F6D86-E2D2-4ECD-8E6C-FDA022CBD70C) (Shutdown) 
			
			 return driver;
		}
		
			
	}
	
	
}
