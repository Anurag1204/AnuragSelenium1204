package com.SeleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumAssignment1 {

	public static void main(String[] args) {

		// 1. Launch browser window(Chrome)
		WebDriver driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application
		// (https:parabank.parasoft.com/parabank/index.htm)
		driver.get("https:parabank.parasoft.com/parabank/index.htm");

		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String title = driver.getTitle();
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking");

		// 6. Verify application logo
		driver.findElement(By.xpath("//img[@title='ParaBank']")).isDisplayed();

		// 7. Verify application caption (Experience the difference)
		String caption = driver.findElement(By.xpath("//p[text()='Experience the difference']")).getText();
		Assert.assertEquals(caption, "Experience the difference");

		// 8. Enter Invalid credentials in Username and Password textboxes
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("asdf@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Asdfgh@1204");

		// 9. Verify button label (LOG IN) and Click on Login Button
		WebElement login_button = driver.findElement(By.cssSelector("input[value='Log In']"));
		login_button.isDisplayed();
		login_button.click();

		// 10. verify error message is coming
		driver.findElement(By.cssSelector("p.error")).isDisplayed();

		// 11. Click on Admin page link
		driver.findElement(By.linkText("Admin Page")).click();

		// 12. Wait for admin page
		boolean result = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.titleContains("ParaBank"));

		// 13. Select Data access mode as ' SOAP'
		driver.findElement(By.cssSelector("input#accessMode1")).click();

		// 14. Scroll-down till Loan provider
		WebElement w = driver.findElement(By.id("loanProvider"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", w);

		// 15. Select Loan provider as 'Web Service'
		WebElement dropdown = driver.findElement(By.cssSelector("select#loanProvider"));
		Select s = new Select(dropdown);
		s.selectByIndex(1);

		// 16.Click on Submit button
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		// 17. wait for Successful submission message
		WebElement text = driver.findElement(By.cssSelector("div[id='rightPanel'] > p"));
		boolean result1 = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.textToBePresentInElement(text, "Settings saved successfully."));

		// 18. Click on Services Link
		driver.findElement(By.linkText("Services")).click();

		// 19. Wait for Services page
		boolean result2 = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.titleContains("Services"));

		// 20. Scroll-down till Bookstore services
		WebElement y = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", y);

		// 21. Get total rows, columns in the bookstore service table
		// *[@id="rightPanel"]/table[2]
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"rightPanel\"]/table[2]/tbody/tr"));
		int rowCount = rows.size();
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"rightPanel\"]/table[2]/tbody/tr[1]//td"));
		int columnsCount = columns.size();
		System.out.println(rowCount);
		System.out.println(rowCount);

		System.out.println("done");

		driver.close();
	}

}
