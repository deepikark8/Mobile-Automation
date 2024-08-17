package Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


import org.testng.annotations.BeforeMethod;


import Base.BaseTest;
import Page.DragDropPage;
import io.appium.java_client.android.AndroidDriver;
import log.Log;
import utilities.CommonUtilities;

public class DragDropTest extends BaseTest {
	
	AndroidDriver driver;
	DragDropPage dragDropPage;
	CommonUtilities utilities;
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		
		driver = (AndroidDriver) launchApp("Android");
		dragDropPage = new DragDropPage(driver);
		utilities = new CommonUtilities();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test
	public void dragDrop() throws InterruptedException {
		Log.info("Drag and Drop Page");
		dragDropPage.clickDragDrop();
		dragDropPage.dragAndDrop(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		utilities.takeScreenShot(driver);
		driver.quit();
	}

}
