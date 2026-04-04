package automationTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

	WebDriver driver;
	WebDriverWait wait;
	

	@BeforeMethod
	public void doBefore() {

		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}

	@AfterMethod

	public void doAfter() {

		driver.quit();

	}

}
