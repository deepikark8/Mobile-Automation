
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


//https://www.youtube.com/watch?v=4Gds5fq0YdY&t=637s
//https://www.youtube.com/watch?v=CgR9IWAlcLw 
//https://codeload.github.com/prachicodestudio/AppiumTutorial/zip/refs/heads/master
//https://github.com/prachicodestudio?tab=repositories

/*
 * 
 * adb shell getprop ro.build.version.release ---> to get version
 * 
 * adb shell dumpsys window windows | grep mFocusedApp ---> to get App package and App activity
 * 
 * appium --use-plugins=gestures --address 127.0.0.1 --port 4723 --base-path /wd/hub --allow-cors
 * 
 */

public class Wdio_Swipe {
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		launchapp();
		homepage();
		swipe();
		//swipeW3c();
		//swipe_TouchAction();

	}

	public static void launchapp() throws MalformedURLException {
	
		String apkPath = System.getProperty("user.dir")+"/BuildFiles/android-wdio-native.apk";
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setDeviceName("Pixel 3 XL")
			.setPlatformName("Android")
			.setPlatformVersion("9.0")//setCapability("platformVersion", "9.0")
			.setAppActivity(".MainActivity")
			.setAppPackage("com.wdiodemoapp")
			.setApp(apkPath)
			.setNoReset(false);//true : will not install app if its already present 
		
		//create object for AndroidDriver / IOSDriver
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
	}
	
	public static void homepage() throws InterruptedException {
		String strText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]")).getText();
		System.out.println("Title : "+strText);

		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Swipe\"]")).click();

		
	}
	public static void swipe() throws InterruptedException {
		
		Thread.sleep(2000);
		
	RemoteWebElement carousel = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Carousel")); 
//		driver.executeScript("gesture: swipe", ImmutableMap.of(
// 				"elementId", carousel.getId(),
// 			    "direction", "left",
// 			    "percentage", 20
// 			));	
		
	try {
        Thread.sleep(2000);
		String previousPageSource = "";
        boolean reachedEnd = false;

        while (!reachedEnd) {
            String currentPageSource = driver.getPageSource();

            if (currentPageSource.equals(previousPageSource)) {
                reachedEnd = true;
                System.out.println("Reached the end of the carousel.");
            } else {
                swipeLeft(driver, carousel);
                previousPageSource = currentPageSource;
            }
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        driver.quit();
    }
					
	}


public static void swipeLeft(AndroidDriver driver, RemoteWebElement element) {
	driver.executeScript("gesture: swipe", ImmutableMap.of(
		"elementId", element.getId(),
	    "direction", "left",
	    "percentage", 20
	));	
	
	//perform swipe action
//	 driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//			"elementId", ((RemoteWebElement) firstImage).getId(),
//		    "direction", "left",
//		    "percentage", 50
//		));	
}
	
	public static void swipeW3c() throws InterruptedException {
		 try {
	            Thread.sleep(2000);
	            RemoteWebElement carousel = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Carousel")); 
	            String previousPageSource = "";
	            boolean reachedEnd = false;

	            while (!reachedEnd) {
	                String currentPageSource = driver.getPageSource();

	                if (currentPageSource.equals(previousPageSource)) {
	                    reachedEnd = true;
	                    System.out.println("Reached the end of the carousel.");
	                } else {
	                	swipeLeft_w3c(driver, carousel);
	                    previousPageSource = currentPageSource;
	                }
	            }
	        } finally {
	            driver.quit();
	        }
	}
	
	public static void swipeLeft_w3c(AndroidDriver driver, RemoteWebElement element) {
		 int startX = (int) (element.getSize().width * 0.9);
	        int endX = (int) (element.getSize().width * 0.1);
	        int y = element.getLocation().y + (element.getSize().height / 2);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1);
	        
	        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        
	        driver.perform(Arrays.asList(swipe));
	}
	
	public static void swipe_TouchAction() throws InterruptedException {
		 try {
	            Thread.sleep(2000);
	            RemoteWebElement carousel = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Carousel")); 
	            String previousPageSource = "";
	            boolean reachedEnd = false;

	            while (!reachedEnd) {
	                String currentPageSource = driver.getPageSource();

	                if (currentPageSource.equals(previousPageSource)) {
	                    reachedEnd = true;
	                    System.out.println("Reached the end of the carousel.");
	                } else {
	                	swipeLeft_w3c(driver, carousel);
	                    previousPageSource = currentPageSource;
	                }
	            }
	        } finally {
	            driver.quit();
	        }
	}
	
	public static void swipeLeft_TouchACtion(AndroidDriver driver, RemoteWebElement element) {
		int startX = (int) (element.getSize().width * 0.9);
        int endX = (int) (element.getSize().width * 0.1);
        int y = element.getLocation().y + (element.getSize().height / 2);

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, y))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                   .moveTo(PointOption.point(endX, y))
                   .release()
                   .perform();
	}
}
