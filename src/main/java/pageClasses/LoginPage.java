package pageClasses;

import java.io.IOException;

import org.openqa.selenium.By;

import util.UIActionUtils;

public class LoginPage {

	By loginButton = By.className("radius");
	By username = By.id("username");
	By passwordenter = By.id("password");
	
	public void enterUsername(String username) {
		
		UIActionUtils.enterText(loginButton, username);
		
		
		
		
	}
	
	
	public void enterPassword(String password) {
		
		UIActionUtils.enterText(passwordenter, password);
		
		
	}
	
	
	public void clickOnLogin() throws IOException {
		
		UIActionUtils.click(loginButton); 
	}
}
