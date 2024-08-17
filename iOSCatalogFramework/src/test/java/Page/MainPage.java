package Page;


import org.openqa.selenium.WebElement;


import Base.BasePage;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MainPage extends BasePage {

	
	public MainPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"chevron\"])[1]")
	WebElement actionSheets;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Okay / Cancel\"]")
	WebElement okCancelBtn;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
	WebElement okBtn;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\\\"Horizontal scroll bar, 1 page\\\"])[2]")
	WebElement scrollAction;
	
	
	
	
	public void clickActionSheetAction() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionSheets.click();	
	}
	
	public void clickOkCancelBtn() {
		okCancelBtn.click();
	}
	
	public void clickCancelBtn() {
		okBtn.click();
	}
	
	public void clickScrollAction() {
		scrollAction.click();
	}
	
	
	
	
}


