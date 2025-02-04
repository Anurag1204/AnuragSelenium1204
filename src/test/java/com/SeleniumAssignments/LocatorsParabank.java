package com.SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsParabank {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		//1. Capturing the Para bank Logo
		driver.findElement(By.className("logo"));
		driver.findElement(By.className("caption"));
		
		//2. Capturing the login panel
		driver.findElement(By.name("username"));
		driver.findElement(By.name("password"));
		
		driver.findElement(By.cssSelector("input.button"));
		// forgot login info anchor tag
		driver.findElement(By.linkText("Forgot login info?"));
		// Register
		driver.findElement(By.linkText("Register"));
		
		// 3. Locating Header Panel
		driver.findElement(By.linkText("home")); // home
		driver.findElement(By.linkText("about")); // about us
		driver.findElement(By.linkText("contact")); // contact
		
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(1)")); // Solutions
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(2) > a")); // About us
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(3) > a")); // Services
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(4) > a")); // Products
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(5) > a")); // Locations
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(6) > a")); // Admin Page
		
		// 4. ATM services
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(1)"));
		
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(2) > a")); // withdraw funds
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(2) > a")); // transfer funds
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(2) > a")); // check balances
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(2) > a")); // make deposits
		
		// Online Services
		
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(2) > a")); // Bill Pay
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(3) > a")); // Account History
		driver.findElement(By.cssSelector("ul[class='services'] > li:nth-child(4) > a")); // Transfer Funds
		driver.findElement(By.cssSelector("div[id='rightPanel'] > p[class='more'] > a[href='services.htm']")); // Read More
		
		driver.findElement(By.cssSelector("ul[class='events'] > li:nth-child(2) > a"));// parabank is now reopened
		driver.findElement(By.cssSelector("ul[class='events'] > li:nth-child(3) > a"));// New! Online Bill Pay
		driver.findElement(By.cssSelector("ul[class='events'] > li:nth-child(4) > a"));// New! Online Account Transfers
		
		// footer panel
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
