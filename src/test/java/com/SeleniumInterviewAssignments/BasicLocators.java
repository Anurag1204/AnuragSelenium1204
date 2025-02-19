package com.SeleniumInterviewAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {

	public static void main(String[] args) {
		
		// 1. Launch the Browser window (Browser = Chrome)
		WebDriver driver = new ChromeDriver();
		// 2. Maximize the browser window
		driver.manage().window().maximize();
		// 3. Delete all browser cookies
		driver.manage().deleteAllCookies();
		// 4. Enter URL and Launch the Application (https://www.google.co.in/)
		driver.get("https://www.google.co.in/");
		// 5. Locate google search textbox using 'id' locator
		WebElement search_box_id = driver.findElement(By.id("APjFqb"));
		// 6. Locate google search textbox using 'name' locator
		WebElement search_box_name = driver.findElement(By.name("q"));
		// 7. Locate google search textbox using 'className' locator
		WebElement search_box_class = driver.findElement(By.className("gLFyf"));
		// 8. Locate google search textbox using 'tagName' locator
		driver.findElement(By.tagName("textarea"));
		// 9.Locate safe link using 'linkText' locator
		
		// 10. Locate safe link using 'linkText' locator
		driver.findElement(By.linkText(" How Search works "));
		// 11. Locate safe link using 'partialLinkText' locator
		driver.findElement(By.partialLinkText("How Search"));

	}

}
