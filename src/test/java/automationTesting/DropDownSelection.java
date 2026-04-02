package automationTesting;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownSelection extends Base{

	@Test
	public void dropDown() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dropdown");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='dropdown']")));

		// menu.click();

		// select class is given in selenium for dropdowns.
		Select dropdown = new Select(menu);

		// selectbybisible text
		dropdown.selectByVisibleText("Option 1");

		// select by the option value
		dropdown.selectByValue("1");

	}

	@Test
	public void selectcategory() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://testpages.eviltester.com/pages/forms/html-form/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.name("dropdown")));

		Select dropdown = new Select(menu);

		dropdown.selectByIndex(3);

	}
	
	
	@Test 
	
	public void selectCountry() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/auth/register");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	//	WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.className("form-select ng-pristine ng-invalid ng-touched")));
		
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-select ng-pristine ng-invalid ng-touched']")));
		
		
		
		ele.click();
		
	}
	

	@Test
	
	public void browseDropDown() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.guru99.com/xpath-selenium.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.className("drawer-sub-toggle")));
		
		menu.click();
		
	}

}
