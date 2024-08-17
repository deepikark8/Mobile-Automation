package Base;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	
AppiumDriver driver;
	
	public BasePage(AppiumDriver driver) {
		this.driver = driver;
	      
		try {
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    } catch (Exception e) {

	       System.out.println("exe message "+e.getMessage());
	    }

		
	}

	public void swipeUp_Pointer( RemoteWebElement element) {
		// Assuming 'driver' is your WebDriver instance and 'element' is the WebElement you want to interact with
		//WebElement element = driver.findElement(By.className("android.webkit.WebView")); // Example, adjust as necessary

		int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		int startY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.8);
		int endY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.2);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);

		// Move finger to start position
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		// Press down
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// Move finger to end position over 600ms
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
		// Release finger
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(swipe));
    }
	
	public void swipeDown(RemoteWebElement element) {
		// Calculate the coordinates for the swipe gesture
		int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		int startY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.2);
		int endY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.8);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);

		// Move finger to start position
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		// Press down
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// Move finger to end position over 600ms
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
		// Release finger
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the swipe gesture
		driver.perform(Arrays.asList(swipe));
	}
	
	public void dragAndDrop_Pointer(AndroidDriver driver, RemoteWebElement source, RemoteWebElement target) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger, 0);

        // Start at the center of the source element
        dragAndDrop.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), source.getLocation().getX() + source.getSize().getWidth() / 2, source.getLocation().getY() + source.getSize().getHeight() / 2));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        
        // Move to the center of the target element
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), target.getLocation().getX() + target.getSize().getWidth() / 2, target.getLocation().getY() + target.getSize().getHeight() / 2));
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(dragAndDrop));
        
       
        
    }

	
}
