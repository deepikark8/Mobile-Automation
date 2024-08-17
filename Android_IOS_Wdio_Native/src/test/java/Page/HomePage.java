package Page;


import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.xpath("//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]")).getText();
	@FindBy(xpath="//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]")
	RemoteWebElement clickHomePage;
	
public void home() {
	String strText = clickHomePage.getText();
	System.out.println("Title : "+strText);

	
}

}
