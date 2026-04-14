package pageClasses;

import org.openqa.selenium.By;

import util.UIActionUtils;

public class SecureAreaPage {
	
	
	By headingEle = By.tagName("h2");
	
	
	public String getSuccessMessage() {
		
		return UIActionUtils.getText(headingEle);
		
	}

}
