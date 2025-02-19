package com.SeleniumInterviewAssignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Student_Registration_form {

	public static void main(String[] args) {

		// 1. Launch browser window(Chrome)
		WebDriver driver = new ChromeDriver();
		// 2. Maximize the browser window
		driver.manage().window().maximize();
		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();
		// 4. Enter URL and Launch the application
		// (https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php)
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		
		// 5. Wait for Page-load
		String title = driver.getTitle();
		System.out.println(title);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Student Registration Form"));


	}

}
