package com.SeleniumInterviewAssignments;

import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserActionsPractice {

	public static void main(String[] args) {

		// 1. Launch the Browser window (Browser = Chrome)
		WebDriver driver = new ChromeDriver();

		// 2. Minimize browser window
		driver.manage().window().minimize();

		// 3. Maximize to iPhone 14 Pro Max resolution
		driver.manage().window().setSize(new Dimension(2796, 1290));

		// 4. Maximize the browser window
		driver.manage().window().maximize();

		// 5. Delete all browser cookies
		driver.manage().deleteAllCookies();

		// 6. Enter URL and Launch the Application
		driver.get("https:www.google.co.in/");

		// 7. Verify the application title (Google)
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
		System.out.println("done");

		// 8. Navigate to Different application (https:www.selenium.dev/)
		driver.navigate().to("https:www.selenium.dev/");

		// 9. Go back to previous application
		driver.navigate().back();

		// 10. Move forward to next application
		driver.navigate().forward();

		// 11. Refresh the application
		driver.navigate().refresh();

		// 12. Collect the main window handle id
		String window_handle = driver.getWindowHandle();
		System.out.println(window_handle);

		// 13. Launch new tab and Launch the application in new tab
		// (https:in.search.yahoo.com/)
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https:in.search.yahoo.com/");

		// 14. Switch back to the main window
		driver.switchTo().window(window_handle);

		// 15. Launch new window and Launch the application in new window
		// (https:parabank.parasoft.com/parabank/index.htm)
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https:parabank.parasoft.com/parabank/index.htm");

		// 16. Switch back to main window
		driver.switchTo().window(window_handle);
		
		// collect all the windows id
		Set<String> window_handles = driver.getWindowHandles();
		System.out.println(window_handles.size());

		// 17. Print browser window URL
		String url = driver.getCurrentUrl();
		System.out.println(url);

		// 18. Get the Size of window
		int height = driver.manage().window().getSize().height;
		int width = driver.manage().window().getSize().width;
		System.out.println(" Height and width of window: " + height + "x" + width);
		
		// 19. Close Current Window 
		driver.close();
		
		// 20. Close all remaining windows
		driver.quit();

	}

}
