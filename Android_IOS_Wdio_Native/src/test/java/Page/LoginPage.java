package Page;


import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage{

	public LoginPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
	@FindBy(xpath="//android.view.View[@content-desc=\"Login\"]")
	RemoteWebElement loginElement;
	
	//driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")).sendKeys("deepika@abc.com");
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"input-email\"]")
	RemoteWebElement enterUsername; 
	
	//driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")).sendKeys("password");
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"input-password\"]")
	RemoteWebElement enterPassword;
	
	//driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]")).click();
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]")
	RemoteWebElement clickLogin;
	
	//driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"))
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/message\"]")
	RemoteWebElement message;
	
	//driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	RemoteWebElement clickOkButton;
	
	//driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]")).click();
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]")
	RemoteWebElement clcikSignUpButton;
	
	//driver.findElement(AppiumBy.accessibilityId("input-email")).sendKeys("deepika@123.com");
	@AndroidFindBy(accessibility = "input-email")
	RemoteWebElement enterEmail;
	
	//driver.findElement(AppiumBy.accessibilityId("input-password")).sendKeys("password");
	@AndroidFindBy(accessibility="input-password")
	RemoteWebElement enterPasswordSignUp;
	
	//driver.findElement(AppiumBy.accessibilityId("input-repeat-password")).sendKeys("password");
	@AndroidFindBy(accessibility="input-repeat-password")
	RemoteWebElement enterReEnterPasswordSignUp;
	
	//driver.findElement(AppiumBy.accessibilityId("button-SIGN UP")).click();
	@FindBy(xpath="//android.widget.TextView[@text=\"SIGN UP\"]")
	RemoteWebElement clickSignUpButton;
	
	//driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/message\"]")
	RemoteWebElement signUpMessage;
	
	//driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	RemoteWebElement clickOk;
	
	public void clickLogin() {
		loginElement.click();
	}
	
	public void enterUsername() {
		enterUsername.sendKeys("deepika@abc.com");
	}
	public void clickLoginButton() {
		clickLogin.click();
	}
	
	public void enterPassword() {
		enterPassword.sendKeys("password");
	}
	public void readMessage() {
		String str = message.getText();
		System.out.println(str);
	}
	public void clickOk() {
		clickOkButton.click();
	}
	
	public void clickSignUp() throws InterruptedException {
		Thread.sleep(3000);
		clcikSignUpButton.click();
	}
	
	public void enterEmailSignUp() {
		enterEmail.sendKeys("deepika@123.com");
	}
	
	public void enterPasswordSignUp() {
		enterPasswordSignUp.sendKeys("password");
	}
	public void enterReEnterPasswordSignUp() {
		enterReEnterPasswordSignUp.sendKeys("password");
	}
	public void clickSignUpButton() {
		clickSignUpButton.click();
		System.out.println("Btn clicked");
	}
	public void clickSignUpMessage() throws InterruptedException {
		System.out.println("Msg");
		Thread.sleep(5000);
		String sMsg = signUpMessage.getText();
		System.out.println(sMsg);
	}
	public void clickOkBtn() throws InterruptedException {
		clickOk.click();
		Thread.sleep(3000);
	}
	
}
