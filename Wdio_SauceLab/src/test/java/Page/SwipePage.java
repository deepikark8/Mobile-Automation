package Page;


import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.ImmutableMap;

import Base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePage extends BasePage{

	public SwipePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.xpath("//android.view.View[@content-desc=\"Swipe\"]")).click();
	@FindBy(xpath="//android.view.View[@content-desc=\"Swipe\"]")
	RemoteWebElement clickSwipe;
	
	//RemoteWebElement carousel = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Carousel")); 
	@AndroidFindBy(accessibility="Carousel")
	RemoteWebElement carousel;

	public void clickSwipe() {
		clickSwipe.click();
	}
	
	public void swipeGesture(AndroidDriver driver) throws InterruptedException {
		
		
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
	        
	        Thread.sleep(3000);
	    
	}
	public static void swipeLeft(AndroidDriver driver, RemoteWebElement element) {
		driver.executeScript("gesture: swipe", ImmutableMap.of(
			"elementId", element.getId(),
		    "direction", "left",
		    "percentage", 20
		));
	}
}
