package com.SeleniumInterviewAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");

		clickRadioButton("option3");

	}

	public static void clickRadioButton(String option) {
		WebElement radiobutton = driver.findElement(By.xpath("//input[@value='" + option + "']"));
		if (radiobutton.isEnabled()) {
			radiobutton.click();
		}
		System.out.println("Element is disabled");
	}

}
