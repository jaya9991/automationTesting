package automationTesting;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumAlerts {

	@Test
	public void learnAlerts() {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// go to the website

		driver.get("https://the-internet.herokuapp.com/");

		// explicit wait to find the element on the page

		WebElement jsAlertButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']")));

		// click the element
		jsAlertButton.click();

		// find the first alert button on the page

		WebElement firstAlertButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));

		// click the alert button
		firstAlertButton.click();

		// switch to the alert window
		Alert alert = driver.switchTo().alert();

		// click ok on the alert
		alert.accept();

		// wait till the message appears
		WebElement textConfirmation = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[text()='You successfully clicked an alert']")));

		// get text of the element
		String result = textConfirmation.getText();

		// check if the message displayed is correct

		Assert.assertEquals("You successfully clicked an alert", result);

		// go to the prompt element

		WebElement promptAlert = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']")));

		// click the button
		promptAlert.click();

		// I am jsprompt text is displayed
		String alertText = alert.getText();

		System.out.println(alertText);

		// send string to the prompt

		alert.sendKeys("My name is Jaya");

		// click ok
		alert.accept();
		
		driver.quit();

	}

}
