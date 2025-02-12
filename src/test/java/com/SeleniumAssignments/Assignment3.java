package com.SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v130.performance.Performance;
import org.openqa.selenium.interactions.Actions;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		// 1. Launch browser window(Chrome)
		WebDriver driver = new ChromeDriver();
		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application (https://demoqa.com/buttons)
		driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");

		// 5. Collect button elements ( https://demoqa.com/buttons)
		WebElement doubleclickbtn = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
		WebElement rightclickbutton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		WebElement clickmebutton = driver.findElement(By.xpath("//button[text()='Click Me']"));

		// 6. Perform double click action
		Actions action = new Actions(driver);
		action.doubleClick(doubleclickbtn).perform();

		// 7. Perform Right Click Action
		action.contextClick(rightclickbutton).perform();

		// 8. Perform Mouse hover action on 'click me' button
		action.moveToElement(clickmebutton).perform();

		// 9. Navigate to drag and drop elements page(https://demoqa.com/droppable)

		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/droppable.php");
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

		action.moveToElement(source);
		action.moveToElement(target);

		action.dragAndDrop(source, target).perform();

		System.out.println("success");
		
		// 11. Navigate to google page(https://www.google.co.in/)
		driver.navigate().to("https://www.google.co.in/");
		WebElement googlesearchbox = driver.findElement(By.xpath("//textarea[@title='Search']"));
		action.sendKeys(googlesearchbox,"Selenium" + Keys.ENTER).perform();
		Thread.sleep(3000);
		
		//12. Select all search results and paste it in the search box (Keyboard actions)
		
		action.keyDown(Keys.CONTROL).sendKeys("a").perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").perform();
		action.click().perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").perform();
		
		// 14. Close browser window
		driver.quit();
		

	}

}
