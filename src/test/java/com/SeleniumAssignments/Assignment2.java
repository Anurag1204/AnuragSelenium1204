package com.SeleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	// 1. Launch browser window(Chrome)
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

//      2. Maximize the browser window
		driver.manage().window().maximize();

//      3. Delete all the cookies
		driver.manage().deleteAllCookies();

//      4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
		driver.get("https://demoqa.com/automation-practice-form");

//      5. Wait for Page-load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Practice Form']")));

//      6. Enter First name and Last name
		WebElement firstname = driver.findElement(By.id("firstName"));
		WebElement lastname = driver.findElement(By.id("lastName"));
		firstname.clear();
		lastname.clear();
		firstname.sendKeys("Vishakha");
		lastname.sendKeys("Singh");

//      7. Enter Email
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		email.clear();
		email.sendKeys("anurag@gmail.com");

//      8. Select Gender (Female)

		selectGender("Female");

//      9. Enter mobile number

		WebElement number = driver.findElement(By.xpath("//input[@id='userNumber']"));
		number.sendKeys("123456789");

//      10.Select DOB (1-Feb-1991)
		getDOB("1", "February", "1991");

//      11.Search and Select Computer Science
		selectSubject("Computer Science");

//      12.Select Hobbies as Sports and Reading

		String[] hobbies = { "Sports", "Reading" };
		selectHobby(hobbies);

//      13.Upload photo

		WebElement picupload = driver.findElement(By.id("uploadPicture"));
		picupload.sendKeys(System.getProperty("user.dir") + "\\Files\\Anurag_pic.jpg");

//      14. Wait till window open to upload the file
		

//      15. Upload file

//      16. Wait till file upload
		Thread.sleep(5000);

//      17.enter current address
		driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("Delhi");
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		submit.click();
		
//      18. Close browser window
		driver.close();

	}

	public static void selectSubject(String subjectName) {
		WebElement subjects = driver.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__value')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", subjects);
		
		Actions action = new Actions(driver);
		action.sendKeys(subjects,subjectName).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[text()='"+subjectName+"' and contains(@class,'option')]"), 0));
		
		WebElement suggestion = driver.findElement(By.xpath("//div[text()='"+subjectName+"' and contains(@class,'option')]"));
		suggestion.click();
	}

	public static void selectGender(String gender) {

		WebElement genderLocator = driver.findElement(By.xpath("//label[text()='" + gender + "']"));
		genderLocator.click();
	}

	public static void getDOB(String date, String month, String year) {
		WebElement DOB = driver.findElement(By.id("dateOfBirthInput"));
		DOB.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[contains(@class,'month')]"), 0));

		WebElement monthdropdown = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
		Select selectmonth = new Select(monthdropdown);
		selectmonth.selectByVisibleText(month);

		WebElement yeardropdown = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
		Select selectyear = new Select(yeardropdown);
		selectyear.selectByVisibleText(year);

		WebElement datepicker = driver
				.findElement(By.xpath("//div[contains(@aria-label,'" + month + "') and text()='" + date + "']"));
		datepicker.click();

	}

	public static void selectHobby(String[] options) {

		for (String option : options) {
			WebElement hobbies = driver.findElement(By.xpath("//label[text()='" + option + "']"));
			hobbies.click();

		}
	}

}
