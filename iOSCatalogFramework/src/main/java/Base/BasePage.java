package Base;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
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

	
}
