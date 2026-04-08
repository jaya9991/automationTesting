package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.WebDriver;

public class WelcomeToInternetPage {
	
	WebDriver driver = new ChromeDriver();
	
	By formAuthenticationLink = By.linkText("Form Authentication");
	
	
	
	public void formAuthentication() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.findElement(By.linkText("Form Authentication")).click();
		
	}
	
	public  String getformAuthenticationPageTitle() {

		return driver.getTitle();
		
	
	
	}
	

}
