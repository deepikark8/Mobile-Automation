package Page;


import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;

public class FormsPage extends BasePage{

	public FormsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.xpath("//android.widget.TextView[@text=\"Forms\"]")).click();	
	@FindBy(xpath="//android.widget.TextView[@text=\"Forms\"]")
	RemoteWebElement clickForms;
	
	//driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"text-input\"]")).sendKeys("Test");
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"text-input\"]")
	RemoteWebElement enterInputField;
	
	//String str = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"input-text-result\"]")).getText();
	//System.out.println(str);
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"input-text-result\"]")
	RemoteWebElement checkTheText;
	
	//driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"switch\"]")).click();
	@FindBy(xpath="//android.widget.Switch[@content-desc=\"switch\"]")
	RemoteWebElement clickSwtich;
	
	//driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text_input\"]")).click();
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"text_input\"]")
	RemoteWebElement clickTextInput;
	
	//driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"webdriver.io is awesome\"]")).click();
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"webdriver.io is awesome\"]")
	RemoteWebElement clickWDAwesome;
	
	//driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]")).click();
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"button-Active\"]")
	RemoteWebElement clickActiveBtn;
	
	//driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	RemoteWebElement clickBtn;
	
	@FindBy(xpath="//android.widget.ScrollView[@content-desc=\"Forms-screen\"]")
	RemoteWebElement scrollDown;
	
	public void clickForms() {
		clickForms.click();
	}
	
	public void enterInputField() throws InterruptedException {
		enterInputField.sendKeys("Test");
		Thread.sleep(2000);
		String str = checkTheText.getText();
		System.out.println(str);
	}
	
	public void toggleSwtich() {
		clickSwtich.click();
	}
	
	public void clickInput() {
		clickTextInput.click();
	}
	public void selectFromDropDown() {
		clickWDAwesome.click();
	}
	public void swipePage() {
		swipeUp_Pointer(scrollDown);
	}
	public void clickActiveBtn() {
		clickActiveBtn.click();
	}
	public void clickBtn() {
		clickBtn.click();
	}
	
	
/*
 * Thread.sleep(4000);
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
 * 
 * 
 */

}
