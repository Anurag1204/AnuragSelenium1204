package com.SeleniumInterviewAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tutorialspoint_element {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");

		WebElement Full_name = driver.findElement(By.xpath("//input[@id='fullname']"));
		Full_name.clear();
		Full_name.sendKeys("Anurag Singh");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Using actions class
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		Actions action = new Actions(driver);
		action.sendKeys(email, "asdf@gmail.com").build().perform();

		// Type of hidden / disabled textboxes
		WebElement textbox = driver.findElement(By.xpath("//textarea[@id='address']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Delhi'", textbox);
		
		WebElement pwd = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		pwd.clear();
		pwd.sendKeys("1234");
		
		// submit button
		WebElement submit_button = driver.findElement(By.cssSelector("input[type='submit']"));
		submit_button.click();

	}

}
