package util;

import org.openqa.selenium.By;

public class UIActionUtils {
	
	public static String getText(By locator) {
		
		return WaitUtil.visibilityOfElementLocated(locator).getText();
		
	}
	
public static void enterText(By locator, String text) {
		
		 WaitUtil.visibilityOfElementLocated(locator).sendKeys(text);
		
	}


public static void click(By locator) {
	
	 WaitUtil.elementToBeClickable(locator).click();
	
}
	

}
