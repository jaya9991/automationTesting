package automationTesting;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LearnSelenium {
	
	@Test
	public void verifyEnableButton() {

		WebDriver driver = new ChromeDriver();

		// loads the website

		driver.get("https://the-internet.herokuapp.com");

		// finds and returns the webelement Dynamic controls

		WebElement dynamicCtrlsele = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));

		dynamicCtrlsele.click();

		// wait till the textfield appears

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement textFieldEnable = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input")));

		// click on enable button

		WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));

		enableButton.click();

		// wait till the enable button diappears.

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Enable']")));

		// check diable button appears and is clickable

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Disable']")));

		// check if message becomes visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));
		
		driver.quit();

	}
	
	
	@Test 
	
	public void removeButton() {
		
		WebDriver driver = new ChromeDriver();

		// loads the website

		driver.get("https://the-internet.herokuapp.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// finds and returns the webelement Dynamic controls

		WebElement dynamicCtrlsele = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));

		dynamicCtrlsele.click();

		
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Remove']")));
		
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"checkbox\"]")));
		
		checkbox.click();
		
		button.click();
		
		
		
		
		
		
		
	}
	

}
	
	
	
