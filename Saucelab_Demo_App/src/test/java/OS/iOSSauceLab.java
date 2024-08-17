package OS;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class iOSSauceLab {

	private AppiumDriver driver;
    private String sauceUserName = "oauth-deepikark8-98e05";
    private String sauceAccessKey = "2813ab37-f925-4cbd-93b2-6bc85052a835";
    private String sauceURL = "https://oauth-deepikark8-98e05:2813ab37-f925-4cbd-93b2-6bc85052a835@ondemand.us-west-1.saucelabs.com:443/wd/hub"; //"https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone Simulator");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", "storage:ios.simulator.wdio.native.app.v1.0.8.zip");
        //caps.setCapability("name", info.);

        DesiredCapabilities sauceCaps = new DesiredCapabilities();
        sauceCaps.setCapability("username", sauceUserName);
        sauceCaps.setCapability("accessKey", sauceAccessKey);
        
        caps.setCapability("sauce:options", sauceCaps);
        
        driver = new AppiumDriver(new URL(sauceURL), caps);
    }

    @Test
    public void sampleTest() {
//        WebElement usernameField = driver.findElementByAccessibilityId("username");
//        usernameField.sendKeys("testuser");
//
//        RemoteWebElement passwordField = (RemoteWebElement) driver.findElementByAccessibilityId("password");
//        passwordField.sendKeys("password");
//
//        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("login_button");
//        loginButton.click();

        // Add more assertions and test steps as needed
    }

    @AfterClass
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
	
	
}

/*
 * private AppiumDriver<MobileElement> driver;
    private String sauceUserName = "YOUR_SAUCE_USERNAME";
    private String sauceAccessKey = "YOUR_SAUCE_ACCESS_KEY";
    private String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S9 WQHD GoogleAPI Emulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        caps.setCapability(MobileCapabilityType.APP, "https://path-to-your-app.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("name", "Sample Test - Android");

        driver = new AppiumDriver<>(new URL(sauceURL), caps);
    }

    @Test
    public void sampleTest() {
        MobileElement usernameField = (MobileElement) driver.findElementByAccessibilityId("username");
        usernameField.sendKeys("testuser");

        MobileElement passwordField = (MobileElement) driver.findElementByAccessibilityId("password");
        passwordField.sendKeys("password");

        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("login_button");
        loginButton.click();

        // Add more assertions and test steps as needed
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
 */
