package automationTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {

	@Test
	public void learnActions() {

		WebDriver driver = new ChromeDriver();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// load the page
		driver.get("https://the-internet.herokuapp.com/login");

		// find the username input field
		WebElement usernameField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"username\"]")));

		// click in it
		usernameField.click();

		// give username
		usernameField.sendKeys("tomsmith");

		Actions action = new Actions(driver);

		// perform the CTRL+A action
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

		// action.keyDown(Keys.CONTROL).sendKeys("f").keyUp(Keys.CONTROL).perform();

		driver.quit();

	}

	@Test

	public void dragAndDrop() {

		WebDriver driver = new ChromeDriver();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// load the page
		driver.get("https://the-internet.herokuapp.com/");

		// find the drag and drop button
		WebElement draganddropButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Drag and Drop']")));

		// click in it

		draganddropButton.click();

//wait till the box A is loaded
		WebElement A = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"column-a\"]")));

		// wait till the box B is loaded

		WebElement B = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"column-b\"]")));

		Actions action = new Actions(driver);

		// perform drag and drop action
		action.dragAndDrop(B, A).perform();

		driver.quit();

	}

	@Test

	public void checkAccelerator() {

		WebDriver driver = new ChromeDriver();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// load the page
		driver.get("https://github.com/testsmith-io/practice-software-testing");

		Actions action = new Actions(driver);

		// find the open source element
		WebElement openSourceButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open Source']")));

		// hover over the element
		action.moveToElement(openSourceButton);

		// wait till the drop down appears and Accelerator becomes visible
		WebElement dropDown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Accelerator']")));

		// click on accelerator
		dropDown.click();

		// find the element thatis the text
		WebElement textMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Powering AI advancements in the open']")));

		// get the text and store in a string
		String result = textMessage.getText();

		// assert to validate that the resulting message is as expected
		Assert.assertEquals("Powering AI advancements in the open", result);

		driver.quit();

	}

}
