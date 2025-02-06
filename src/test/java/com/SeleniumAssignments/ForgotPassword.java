package com.SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.creatio.com/login/alm");
		driver.manage().window().maximize();

		// Deny Cookie
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonDecline']")).click();
		
		driver.findElement(By.xpath("//input[@aria-label='Business email']")).sendKeys("anurags655@gmail.com");
		driver.findElement(By.xpath("//a[@data-qa='forgot-password']")).click();
		Thread.sleep(3000);
		String gen_msg = driver.findElement(By.xpath("//crt-label[@class='description-label']")).getText();
		String user = driver.findElement(By.xpath("//crt-label[@data-qa='email-confirmation']")).getText();
		
		System.out.println(gen_msg + " " +user);

	}

}
