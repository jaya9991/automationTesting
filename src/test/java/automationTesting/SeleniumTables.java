package automationTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTables {

	@Test
	public void filterByLanguage() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement selectLangButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Java']")));

		selectLangButton.click();

		// for(:)

	}

	@Test
	public void filterByLevel() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement deselectIntermediateButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Intermediate']")));

		deselectIntermediateButton.click();

		WebElement deselectAdvancedButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Advanced']")));

		deselectAdvancedButton.click();

	}

	@Test

	public void verifyMinEnrollments() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement enrollment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown']")));
		
		enrollment.click();

		WebElement enrollmentSelect = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='dropdown']/child::ul/li[text()='10,000+']")));

		enrollmentSelect.click();

	}

	
	@Test
	public void combinedFilters() {
		
		
		
	}
}
