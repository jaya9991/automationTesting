package automationTesting;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowHandles extends Base {

	@Test
	public void switchNewTab() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://demoqa.com/browser-windows");

		WebElement newTabButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New Tab']")));

		newTabButton.click();

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("parent window handle is :" + parentWindowHandle);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			if (!handle.equals(parentWindowHandle)) {

				driver.switchTo().window(handle);
				System.out.println("current window handle is :" + handle);

			}
		}

	}

	@Test

	public void switchToanyWindow() {
		
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://demoqa.com/browser-windows");

		WebElement newTabButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New Tab']")));
		
		
		
		WebElement newWindowButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New Window']")));
		
		
		WebElement newWindowMessageButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New Window Message']")));
		
		newTabButton.click();
		newWindowButton.click();
		newWindowMessageButton.click();
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("parent window handle is :" + parentWindowHandle);

		
		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			if (!handle.equals(parentWindowHandle)) {

				driver.switchTo().window(handle);
				System.out.println("current window handle is :" + handle);

			}
		}
		
		
		
	}

}
