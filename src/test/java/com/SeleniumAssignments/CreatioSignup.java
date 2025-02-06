package com.SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatioSignup {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.creatio.com/login/alm");
		driver.manage().window().maximize();

		// Deny Cookie
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonDecline']")).click();
		//click on signup
		WebElement signup_button = driver.findElement(By.xpath("//crt-button[@data-qa='sign-up']"));
		signup_button.click();
		
		Thread.sleep(5000); // will replace all the waits with explicit waits later
		
		driver.findElement(By.xpath("//input[@aria-label='Business email']")).sendKeys("anurags655@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys("Asdfgh@1204");
		driver.findElement(By.xpath("//span[text()=' CONTINUE ']")).click();
		
		Thread.sleep(5000); // will replace all the waits with explicit waits later
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Bob");
		driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("Jackson");
		driver.findElement(By.xpath("//input[@aria-label='Company']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@aria-label='Website']")).sendKeys("https://www.google.co.uk/");
		driver.findElement(By.xpath("//input[@aria-label='Country']")).click();
		driver.findElement(By.xpath("//span[text()='USA']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Phone']")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//span[text()=' SIGN UP ']")).click();
		
		

	}

}
