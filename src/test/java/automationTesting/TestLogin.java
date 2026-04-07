package automationTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLogin {

	@Test
	public void tryLogin() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-login/");

		WebElement usernameField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));

		usernameField.sendKeys("student");

		WebElement passwordField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));

		passwordField.sendKeys("Password123");
		
		
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));

		
		submitButton.click();
		
		String message = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']")).getText();
		
		Assert.assertEquals(message, "Logged In Successfully");
		
		System.out.println(message);

	}

}
