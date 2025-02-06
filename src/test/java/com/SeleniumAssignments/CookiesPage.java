package com.SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesPage {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.creatio.com/login/alm");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonDecline']"));
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowallSelection']"));
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
		
		// show details
		driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyEdgeMoreDetailsLink']"));
		// Preferences Checkbox
		driver.findElement(By.xpath("CybotCookiebotDialogBodyLevelButtonPreferences"));
		// Statistics
		driver.findElement(By.xpath("//input[@id='CybotCookiebotDialogBodyLevelButtonStatistics']"));
		// Marketing
		driver.findElement(By.xpath("//input[@id='//input[@id='CybotCookiebotDialogBodyLevelButtonMarketing']']"));
		
		

	}

}
