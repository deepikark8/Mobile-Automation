package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseClass{
	
	@BeforeMethod
	public void launchApp() {
		setup();
	}
	
	@Test
	public void testOne() {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Hi Google");
		
		System.out.println("Completed Test One...");
		
	}
	
	@Test
	public void testTwo() {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("Completed Test Two");
		
	}
	
	@Test
	public void testThree() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
//	@AfterMethod
//	@AfterTest
//	public void tearDown() {
////		driver.close();
////		driver.quit();
//		
//	}
	

}
