package com.pageobjects1.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class InputFormPage extends BrowserFactory {

   private  WebDriver driver ;
   
    public InputFormPage() {
	   this.driver =BrowserFactory.Driver;
	}
	
	@FindBy(how = How.CSS , using = "input[id='user-message']")
	WebElement textField;
	
	@FindBy(how = How.CSS , using ="button[onclick*='showInput()']")
	WebElement showMessageButton;
	
	@FindBy(how =How.CSS , using ="span[id='display']")
	WebElement displayMessage;
	
	public void openInputFormPage () {
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		WebDriverWait  wait = new WebDriverWait(driver,60);
					   wait.until(ExpectedConditions.visibilityOf(textField));
	}
	
	public void enterMessage(String message) {
		textField.sendKeys(message);
	}
	
	public  String getMessageDisplayed() {
		showMessageButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(displayMessage));
		return displayMessage.getText();
	}
  
    

}

