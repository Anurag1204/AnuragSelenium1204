package com.SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatioLoginPage {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.creatio.com/login/alm");
		driver.manage().window().maximize();

		// Deny Cookie
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonDecline']")).click();

		// login via social media
		driver.findElement(By.xpath("//img[@alt='LinkedIn icon']"));
		driver.findElement(By.xpath("//img[@alt='Google icon']"));
		driver.findElement(By.xpath("//img[@alt='Facebook icon']"));

		// Login through username and password
		driver.findElement(By.xpath("//input[@aria-label='Business email']")).sendKeys("anurags655@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys("Asdfgh@1204");
		driver.findElement(By.xpath("//span[text()=' LOG IN ']")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		System.out.println("Login successfully");

	}

}
