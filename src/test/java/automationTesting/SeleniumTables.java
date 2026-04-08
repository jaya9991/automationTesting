package automationTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='courses_table']//td[text()='Java']"));

		for (WebElement text : ele) {

			Assert.assertTrue(text.getText().equals("Java"), "Not the desired result");

		}

		driver.quit();
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

		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='courses_table']//td[text()='Beginner']"));

		for (WebElement text : ele) {

			Assert.assertTrue(text.getText().equals("Beginner"), "Not the desired result");

		}

		driver.quit();

	}

	@Test

	public void verifyMinEnrollments() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement enrollment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown']")));

		enrollment.click();

		WebElement enrollmentSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[text()='10,000+']")));

		enrollmentSelect.click();

		List<WebElement> ele = driver
				.findElements(By.xpath("//table//tr[not(contains(@style,'display:none'))]//td[5]"));

		for (WebElement result : ele) {

			String enroll = result.getText();

			Integer newlist = Integer.valueOf(enroll);

			Assert.assertTrue(newlist >= 10000);

		}

		driver.quit();
	}

	@Test
	public void combinedFilters() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement selectLangButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Python']")));

		selectLangButton.click();

		WebElement deselectIntermediateButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Intermediate']")));

		deselectIntermediateButton.click();

		WebElement deselectAdvancedButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Advanced']")));

		deselectAdvancedButton.click();

		WebElement enrollment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown']")));

		enrollment.click();

		WebElement enrollmentSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[text()='10,000+']")));

		enrollmentSelect.click();

		WebElement lang = driver.findElement(By.xpath("//table//td[@headers='col_lang']"));

		String selectionLanguage = lang.getText();

		Assert.assertTrue(selectionLanguage.equals("Python"));

		WebElement level = driver.findElement(By.xpath("//table//td[@headers='col_level']"));

		String selectionLevel = level.getText();

		Assert.assertTrue(selectionLevel.equals("Beginner"));

		WebElement enrollments = driver.findElement(By.xpath("//table//td[@headers='col_enroll']"));

		String selectionEnroll = enrollments.getText();

		Integer value = Integer.valueOf(selectionEnroll);

		Assert.assertTrue(value >= 10000);

		driver.quit();

	}

	@Test
	public void noResultState() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement selectLangButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Python']")));

		selectLangButton.click();

		WebElement deselectIntermediateButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Intermediate']")));

		deselectIntermediateButton.click();

		WebElement deselectBeginnerButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Beginner']")));

		deselectBeginnerButton.click();

		WebElement enrollment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown']")));

		enrollment.click();

		WebElement enrollmentSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[text()='10,000+']")));

		enrollmentSelect.click();

		String message = driver.findElement(By.xpath("//div[@id='noData']")).getText();

		Assert.assertEquals(message, "No matching courses.");

		driver.quit();
	}

	@Test
	public void resetButtonBehaviour() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement selectLangButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Java']")));

		selectLangButton.click();

		WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("resetFilters")));

		resetButton.click();

		WebElement langButton = driver.findElement(By.xpath("//input[@value='Any']"));

		WebElement intermediateButton = driver.findElement(By.xpath("//input[@value='Intermediate']"));

		WebElement beginnerButton = driver.findElement(By.xpath("//input[@value='Beginner']"));

		WebElement advancedButton = driver.findElement(By.xpath("//input[@value='Advanced']"));

		Assert.assertTrue(langButton.isSelected());

		Assert.assertTrue(intermediateButton.isSelected());
		Assert.assertTrue(beginnerButton.isSelected());
		Assert.assertTrue(advancedButton.isSelected());

		Assert.assertTrue(!resetButton.isDisplayed());

		driver.quit();

	}

	@Test
	public void sortByEnrollments() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='sortBy']")));

		Select dropdown = new Select(menu);

		dropdown.selectByVisibleText("Enrollments");

		List<WebElement> list = driver.findElements(By.xpath("//table//td[@headers='col_enroll']"));

		List<Integer> newlist = new ArrayList<>();

		for (WebElement ele : list) {

			String sort = ele.getText();

			Integer value = Integer.valueOf(sort);

			newlist.add(value);

		}

		for (int i = 0; i < newlist.size() - 1; i++) {

			Assert.assertTrue(newlist.get(i) < newlist.get(i + 1));

		}

		driver.quit();

	}

	@Test
	public void sortByCourseName() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-table/");

		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='sortBy']")));

		Select dropdown = new Select(menu);

		dropdown.selectByVisibleText("Course Name");

		List<WebElement> list = driver.findElements(By.xpath("//table//td[@headers='col_course']"));

		List<String> newlist = new ArrayList<>();

		for (WebElement ele : list) {

			newlist.add(ele.getText());
		}

		for (int i = 0; i < newlist.size() - 1; i++) {

			// Assert.assertTrue
		}

		driver.quit();

	}

}
