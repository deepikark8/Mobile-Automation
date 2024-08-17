package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;

public class CommonUtilities {

public void takeScreenShot(AppiumDriver driver) {
		
		//Take screen interface is used to take screenshot by passing the driver
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
	
		//we need convert screenshot object convert into file so we convert it into source file but we don't know where it will store
		//It will be in the memory to bring it into physical file we need another destination file
		
		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot captured.");
		
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(currentDate);
		
		
		String filePath = "/Users/rahade/workspaceMobileAutomation/Android_Wdio_Native/Screenshot/"+timeStamp+".jpeg";
		
		//I'll create destination file to store screenshot object
		File desFile = new File(filePath);
		System.out.println("Destination file path: " + desFile.getAbsolutePath());

		
		//Then using file utilties copy file ... convert the file object to a physical file
		try {
			FileUtils.copyFile(srcFile, desFile);
			System.out.println("Screenshot saved successfully at: " + filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	
}
