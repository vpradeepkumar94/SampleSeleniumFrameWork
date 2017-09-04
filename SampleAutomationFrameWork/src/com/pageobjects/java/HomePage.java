package com.pageobjects.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.testbase.demoqa.BrowserFactory;

public class HomePage extends BrowserFactory {

	 private final WebDriver driver = super.driver;
	
	@FindBy(how=How.ID ,using ="q")  private WebElement txtSearchBox;
	@FindBy(how=How.CSS,using="css") private WebElement sample;
	
	public  void launchURL(String URL) {
		driver.get(URL);
 	}
 
	public String getPageTitle() {
		return driver.getTitle();
	}
	
}
