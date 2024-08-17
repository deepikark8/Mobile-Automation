import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
	
	AppiumDriverLocalService serviceBuilder;
	RemoteWebDriver driver;
	
	@Test
	public void configuration() throws MalformedURLException {
	        // Create an AppiumServiceBuilder object // /usr/local/lib/node_modules/appium/build/lib/main.js
		///opt/homebrew/lib/node_modules/appium/build/lib/main.js
		 serviceBuilder = new AppiumServiceBuilder()
				//.usingDriverExecutable(new File("/opt/homebrew/bin/node"))
		 		.withAppiumJS(new File("/opt/homebrew/bin/appium"))
				.usingDriverExecutable(new File("/opt/homebrew/bin/node"))
				 .withIPAddress("127.0.0.1")//127.0.0.1
				 .usingPort(4723)//4723
				 .withTimeout(Duration.ofSeconds(300))
				 .build();

	        
	        serviceBuilder.start();

	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setDeviceName("Pixel 2");
			options.setPlatformName("Android");
			options.setCapability("platformVersion", "12.0");
			options.setApp(System.getProperty("user.dir")+"/BuildFiles/android-wdio-native.apk");
			//options.setChromedriverExecutable("/Users/rahade/workspaceMobileAutomation/AppiumServer_Programmatically/driver/chromedriver");
			
			
			//options.setChromedriverExecutable("/Users/rahade/workspaceMobileAutomation/Android_Wdio_Native/driver/chromedriver");
			//create object for AndroidDriver / IOSDriver
			driver = new RemoteWebDriver(serviceBuilder.getUrl(),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			  System.out.println("Appium server started successfully!");
			//driver.quit();
			//serviceBuilder.stop();
	        
			

			//.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				 //.withAppiumJS(new File("/Users/rahade/node_modules/appium/build/lib/main.js"))
				// .usingDriverExecutable(new File("/Users/rahade/.nvm/versions/node/v21.2.0/bin/node"))
		        
		        // Set the Appium server port number
		        //serviceBuilder.usingPort(4723);// withPort(4723);

		        // Set the Appium server node path
//		        serviceBuilder;
//		        serviceBuilder.withIPAddress("http://127.0.0.1");
//		        serviceBuilder.usingPort(4723);// withPort(4723);
//		        serviceBuilder.build();
	        
	        
	        
//	        // Build the Appium service
//	        AppiumDriverLocalService service = serviceBuilder.build();
//
//	        // Start the Appium service
//	        service.start();
//
//	        // Wait for the Appium server to start
////	        service.se .waitForServerReady();

	        // Print a message to the console
	      
	    }
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
//		serviceBuilder.stop();
	}
}
