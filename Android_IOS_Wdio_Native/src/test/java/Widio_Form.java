import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Widio_Form {
	
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		launchapp();
		form();
		enterdetails();
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
	
	public static void form() throws InterruptedException {
		Thread.sleep(3000);
	driver.findElement(By.xpath("//android.widget.TextView[@text=\"Forms\"]")).click();	
		
	}
	
	public static void enterdetails() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"text-input\"]")).sendKeys("Test");
		Thread.sleep(2000);
		String str = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"input-text-result\"]")).getText();
		System.out.println(str);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"switch\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text_input\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"webdriver.io is awesome\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		
		/* List<WebElement> options= driver.findElements(By.className("android.widget.ListView"));
	       
	        System.out.println("Total number of options available in dropdown:"+options.size());
		Thread.sleep(2000);
		
		 for(WebElement e:options)
	        {
	            String val=e.getText();
	            System.out.println("text : "+val);
	           
	            if(val.equalsIgnoreCase("Appium is awesome"))
	            {
	                e.click();
	                //break;
	            }
	        }
		
		*/
	}
}
