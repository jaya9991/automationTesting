package internetHerokuappTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;

	WebDriverWait wait;

	@BeforeMethod

	public void preReq() {

		System.out.println("I am in before method");

		String browser = "Chrome";

		switch (browser.toLowerCase()) {

		case "Chrome":
			driver = new ChromeDriver();
			break;

		case "Edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("browser not supported");
			break;

		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterMethod

	public void closing() {

		System.out.println("I am in after method");
		driver.quit();
	}
}
