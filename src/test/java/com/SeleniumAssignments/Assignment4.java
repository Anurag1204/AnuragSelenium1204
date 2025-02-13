package com.SeleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {

		// 1.Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

		// 2.Maximize the browser window
		driver.manage().window().maximize();

		// 3.delete all cookies
		driver.manage().deleteAllCookies();

		// 4. launch the url
		driver.get("https://demoqa.com/alerts");

		// 5.Locate Alert buttons
		WebElement alertbutton = driver.findElement(By.xpath("//button[text()='Alert']"));
		WebElement alert_appear_button = driver.findElement(By.xpath("//button[@onclick='myMessage()']"));
		WebElement confirm_box = driver.findElement(By.xpath("//button[@onclick='myDesk()']"));
		WebElement prompt_box = driver.findElement(By.xpath("//button[@onclick='myPromp()']"));

		// 6. Launch Information alert
		alertbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert infoalert = driver.switchTo().alert();

		// 7.Print Alert message
		System.out.println(infoalert.getText());

		// 8.Click on OK button
		infoalert.accept();

		// 9. Launch confirmation alert
		confirm_box.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert confirmalert = driver.switchTo().alert();
		
		// 10 Print alert message
		System.out.println(confirmalert.getText());
		
		// 11. Click on Cancel button
		confirmalert.dismiss();
		
		// 12.Launch prompt alert with dialog box alert
		
		prompt_box.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert prompt_alert = driver.switchTo().alert();
		
		// 13. Print message
		System.out.println(prompt_alert.getText());
		
		// 14. Enter Text in Alert
		prompt_alert.sendKeys("asdf");
		
		// 15.Click on OK button
		prompt_alert.accept();

	}

}
