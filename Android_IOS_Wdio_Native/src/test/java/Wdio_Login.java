import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Wdio_Login {
	
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		launchapp();
		login();
		loginDetails();
		signUp();
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
	}
	
public static void login() {
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
}

public static void loginDetails() {
	driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")).sendKeys("deepika@abc.com");
	driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")).sendKeys("password");
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]")).click();
	String str = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
	System.out.println("Msg :"+str);
	driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
}
public static void signUp() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]")).click();
	driver.findElement(AppiumBy.accessibilityId("input-email")).sendKeys("deepika@123.com");
	driver.findElement(AppiumBy.accessibilityId("input-password")).sendKeys("password");
	driver.findElement(AppiumBy.accessibilityId("input-repeat-password")).sendKeys("password");
	driver.findElement(AppiumBy.accessibilityId("button-SIGN UP")).click();
	String strMsg = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
	System.out.println("Msg : "+strMsg);
	driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
}



}
