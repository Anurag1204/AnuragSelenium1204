package com.SeleniumInterviewAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebActionsAssignments {

	static WebDriver driver;

	public static void main(String[] args) {

		// 1. Launch browser window(Chrome)

		driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application
		// (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String actual_title = driver.getTitle();
		String expected_title = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actual_title, expected_title);

		// 6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@title='ParaBank']"));
		Assert.assertTrue(logo.isDisplayed());

		// 7. Verify application caption (Experience the difference)
		WebElement caption = driver.findElement(By.xpath("//p[text()='Experience the difference']"));
		String Actual_caption = caption.getText();
		String Expected_caption = "Experience the difference";
		Assert.assertEquals(Actual_caption, Expected_caption);

		// 8. Enter Invalid credentials in Username and Password textboxes(Actions
		// class)
		WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
		Actions action = new Actions(driver);
		action.sendKeys(username, "anurag").build().perform();
		action.sendKeys(password, "1234").build().perform();

//		// 9. Verify button label (LOG IN) and Click on Login Button
//		WebElement login_button = driver.findElement(By.xpath("//input[@value='Log In']"));
//		login_button.isDisplayed();
//		login_button.isEnabled();
//		action.click(login_button).build().perform();

//		// 10. Verify error message is coming
//		WebElement error = driver.findElement(By.xpath("//p[@class='error']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.textToBePresentInElement(error, "Please enter a username and password."));

		// 11. Click on Admin page link
		WebElement admin_page = driver.findElement(By.linkText("Admin Page"));
		action.click(admin_page).build().perform();

		// 12. Wait for admin page
		wait.until(ExpectedConditions.urlContains("admin"));

		// 13. Select Data access mode as 'SOAP'
		clickDataaccessMode("jdbc");

		// 14. Scroll-down till Loan provider
		WebElement element = driver.findElement(By.xpath("//b[text()='Loan Provider:']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);

		// 15. Select Loan provider as 'Web Service'
		selectLoanProvider("Web Service");

		// 16. Click on Submit button
		WebElement submit_button = driver.findElement(By.xpath("//input[@value='Submit']"));
		action.click(submit_button).build().perform();

		// 17. Wait for Successful submission message
		WebElement msg = driver.findElement(By.xpath("//b[text()='Settings saved successfully.']"));
		wait.until(ExpectedConditions.visibilityOf(msg));

		// 18. Click on Services Link
		WebElement services_button = driver.findElement(By.linkText("Services"));
		action.click(services_button).build().perform();

		// 19. Wait for Services page
		wait.until(ExpectedConditions.urlContains("services"));

		// 20. Scroll-down till Bookstore services
		WebElement bs = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
		js.executeScript("arguments[0].scrollIntoView", bs);

		// 21. Get total rows, columns in the bookstore service table
		List<WebElement> rows = driver.findElements(By.xpath("//table[2]//tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[2]//tbody/tr[1]/td"));
		System.out.println(rows.size());
		System.out.println(columns.size());

		// 22. Get Column headers of bookstore services table

		for (WebElement option : columns) {
			System.out.println(option.getText());
		}

		// 23. Get all the data from bookstore service table

		for (int r = 1; r <= rows.size(); r++) {
			for (int c = 1; c <= columns.size(); c++) {
				cell(r, c);

			}
		}

		// 24. Close browser window
		driver.close();

	}

	public static void clickDataaccessMode(String option) {
		WebElement select_dataacess = driver.findElement(By.xpath("//input[@value='" + option + "']"));
		select_dataacess.click();
	}

	public static void selectLoanProvider(String option) {
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='loanProvider']"));
		Select loanproviderdropdown = new Select(dropdown);
		loanproviderdropdown.selectByVisibleText(option);

	}

	public static void cell(int rows, int columns) {
		WebElement cellelement = driver.findElement(By.xpath("//table[2]//tbody/tr[" + rows + "]/td[" + columns + "]"));
		System.out.println(cellelement.getText());
	}

}
