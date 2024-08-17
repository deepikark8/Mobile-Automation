package OS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidSauceLab {

	//private static AppiumDriver driver;
	 AndroidDriver driver;
    private static String sauceUserName = "oauth-deepikark8-98e05";
    private static String sauceAccessKey = "2813ab37-f925-4cbd-93b2-6bc85052a835";
    private static String sauceURL = "https://oauth-deepikark8-98e05:2813ab37-f925-4cbd-93b2-6bc85052a835@ondemand.us-west-1.saucelabs.com:443/wd/hub";//"https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub";


    @BeforeMethod
	public void test() throws MalformedURLException {
		System.out.println("Test Success");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set your Sauce Labs credentials
//        String sauceUsername = System.getenv("SAUCE_USERNAME");
//        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

        // Set the desired capabilities for the test
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Samsung Galaxy S9 WQHD GoogleAPI Emulator");//Samsung Galaxy S9 WQHD GoogleAPI Emulator
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("app", "sauce-storage:android-wdio-native.apk"); // Path to your APK in Sauce Labs storage
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("appWaitActivity", "your.app.package.name.MainActivity");

        DesiredCapabilities sauceCaps = new DesiredCapabilities();
        sauceCaps.setCapability("username", sauceUserName);
        sauceCaps.setCapability("accessKey", sauceAccessKey);
        sauceCaps.setCapability("build", "com.wdiodemoapp");
        sauceCaps.setCapability("name", "Android Wdio 1"); // Set the job name here
        
        capabilities.setCapability("sauce:options", sauceCaps);
        
        // URL to connect to Sauce Labs
        URL url = new URL("https://oauth-deepikark8-98e05:2813ab37-f925-4cbd-93b2-6bc85052a835@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        // Initialize the driver
         driver = new AndroidDriver(url, capabilities);
	}
    
    @Test
    public void webView() throws InterruptedException {
    	Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Webview\"]")).click();
		//driver.getContextHandles();
		//driver.getContext();
		System.out.println("Done");
    }
	
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
}
