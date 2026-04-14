package internetHerokuappTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.LoginPage;
import pageClasses.SecureAreaPage;
import pageClasses.WelcomeToInternetPage;

public class FormAuthentication extends BaseTest {
	
	
	@Test
	public void loginTest() throws NumberFormatException, IOException {
	
	WelcomeToInternetPage wlcObj = new WelcomeToInternetPage();
	wlcObj.formAuthentication();
	
	LoginPage lpPage = new LoginPage();
	
	lpPage.enterUsername("tomsmith");
	lpPage.enterPassword("SuperSecretPassword!");
	lpPage.clickOnLogin();
	
	SecureAreaPage sap = new SecureAreaPage();
	String text = sap.getSuccessMessage();
	//Assert.assertTrue(text.contains(" Secure Area"));
	
	
	}


}
