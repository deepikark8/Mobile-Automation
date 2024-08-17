package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Tests extends BaseClass{

	@Test
	public void testOne() {
	driver.get("https://www.google.com");
	driver.findElement(By.name("q")).sendKeys("Automation");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	System.out.println("complete test one...");
	
	}
	
}
