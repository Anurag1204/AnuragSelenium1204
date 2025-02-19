package com.SeleniumAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {

//      1.Launch Chrome Browser

		WebDriver driver = new ChromeDriver();

//      2.Maximize the browser window
		driver.manage().window().maximize();

//      3.Launch the application
		driver.get("https://demoqa.com/frames");

//      4.Locate elements

//      5.Print frame element text

//      6.Print main window element text

//      7.Close browser window

	}

}
