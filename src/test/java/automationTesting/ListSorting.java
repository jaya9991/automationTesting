package automationTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ListSorting {
	
	
	
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
			Collections.sort(newlist);
		
	
		}

		
		System.out.println(newlist);
		
		if(list.size() == newlist.size()) {
			
			System.out.println("size of both the lists are the same");
		}
		
		driver.quit();

}
}
