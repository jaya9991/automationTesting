package automationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	WebDriver driver;

	@BeforeMethod
	public void doBefore() {

		driver = new ChromeDriver();

	}

	@AfterMethod

	public void doAfter() {

		driver.quit();

	}

}
