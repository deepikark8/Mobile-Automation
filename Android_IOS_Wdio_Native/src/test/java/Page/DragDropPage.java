package Page;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DragDropPage extends BasePage{

	public DragDropPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// driver.findElement(By.xpath("//android.view.View[@content-desc=\"Drag\"]")).click();
	@FindBy(xpath="//android.view.View[@content-desc=\"Drag\"]")
	RemoteWebElement clickDragDrop;
	
	
	//Thread.sleep(5000);
	
	//RemoteWebElement source1 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView")
	RemoteWebElement source1;
	
	//RemoteWebElement destination1 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-l2\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-l2\"]/android.view.ViewGroup")
	RemoteWebElement destination1;
	
	//RemoteWebElement source2 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-r3\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-r3\"]/android.widget.ImageView")
	RemoteWebElement source2;
			
	//RemoteWebElement destination2 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-r3\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-r3\"]/android.view.ViewGroup")
	RemoteWebElement destination2;

	//RemoteWebElement source3 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-r1\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-r1\"]/android.widget.ImageView")
	RemoteWebElement source3;
			
	//RemoteWebElement destination3 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-r1\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-r1\"]/android.view.ViewGroup")
	RemoteWebElement destination3;

	//RemoteWebElement source4 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView")
	RemoteWebElement source4;
	
	//RemoteWebElement destination4 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-c1\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-c1\"]/android.view.ViewGroup")
	RemoteWebElement destination4;

	//RemoteWebElement source5 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c3\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-c3\"]/android.widget.ImageView")
	RemoteWebElement source5;
	
	
	//RemoteWebElement destination5 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-c3\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-c3\"]/android.view.ViewGroup")
	RemoteWebElement destination5 ;

	//RemoteWebElement source6 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-r2\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-r2\"]/android.widget.ImageView")
	RemoteWebElement source6 ;
	
	//RemoteWebElement destination6 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-r2\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-r2\"]/android.view.ViewGroup")
	RemoteWebElement destination6;

	//RemoteWebElement source7 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c2\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-c2\"]/android.widget.ImageView")
	RemoteWebElement source7;
	
	
	//RemoteWebElement destination7 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-c2\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-c2\"]/android.view.ViewGroup")
	RemoteWebElement destination7;
	
	//RemoteWebElement source8 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l1\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-l1\"]/android.widget.ImageView")
	RemoteWebElement source8;
	
	//RemoteWebElement destination8 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-l1\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-l1\"]/android.view.ViewGroup")
	RemoteWebElement destination8;
	
	//RemoteWebElement source9 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l3\"]/android.widget.ImageView"));//AppiumBy.accessibilityId("dragMe")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drag-l3\"]/android.widget.ImageView")
	RemoteWebElement source9 ;
	
	//RemoteWebElement destination9 = (RemoteWebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drop-l3\"]/android.view.ViewGroup"));//AppiumBy.accessibilityId("dropzone")
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"drop-l3\"]/android.view.ViewGroup")
	RemoteWebElement destination9;
	
	
	
	public void clickDragDrop() {
		clickDragDrop.click();
	}
	
	public void dragAndDrop(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		// Perform the first drag-and-drop action
		dragAndDrop_Pointer(driver, source1, destination1);

	    // Perform the second drag-and-drop action
		dragAndDrop_Pointer(driver, source2, destination2);
		
		
		dragAndDrop_Pointer(driver, source3, destination3);
		dragAndDrop_Pointer(driver, source4, destination4);
		dragAndDrop_Pointer(driver, source5, destination5);
	    dragAndDrop_Pointer(driver, source6, destination6);
	    dragAndDrop_Pointer(driver, source7, destination7);
	    dragAndDrop_Pointer(driver, source8, destination8);
	    dragAndDrop_Pointer(driver, source9, destination9);
	    Thread.sleep(2000);
	    System.out.println("Sucessfully drag and dropped");
	}

}
