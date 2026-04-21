package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {
	
	public void jsClick(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(); ", element);
	
	}
	
	//public void scrollToAnElement(WebElement element) {
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver; 


}
