package com.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1_LoginWithEmptyPassword extends TC2_LoginApp{

	public static void main(String[] args) {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tekarch-b7-dev-ed.develop.my.salesforce.com");
		driver.manage().window().maximize();
		//Enter user name and an empty password 
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("pw"));
		username.sendKeys("padmaja@samangipudi.com");
		password.clear();	
		//Click on Login Button
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginBtn.click();
		//Get the actual text and assert it with expected text
		String actualText = driver.findElement(By.id("error")).getText();
		System.out.println("Error message is : " + actualText);
		String expectedText = "Please enter your password.";
		Assert.assertEquals(actualText, expectedText);		
		//Close the browser
		closeBrowser(driver);		
	}
}
