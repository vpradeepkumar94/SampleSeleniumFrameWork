package com.pageobjects1.java;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoHomePage extends BrowserFactory {

   private  WebDriver driver ;
   
    public DemoHomePage() {
	   this.driver =BrowserFactory.Driver;
	}
    @FindBy(how = How.CSS , using = "input[id='user-message']")
	WebElement textField;
    
    @FindBys( value = { @FindBy(using = "[class='dropdown-menu']")})
      List<WebElement> navBar;

	
    public void openInputFormPage () {
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		WebDriverWait  wait = new WebDriverWait(driver,60);
					   wait.until(ExpectedConditions.visibilityOf(textField));
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	public String currentURL() {
		return driver.getCurrentUrl();
	}
	
}
