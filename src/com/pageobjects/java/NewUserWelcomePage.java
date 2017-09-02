package com.pageobjects.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.testbase.demoqa.BrowserFactory;

public class NewUserWelcomePage extends BrowserFactory {

	@FindBy(how = How.ID, using = "q")
	private WebElement txtSuccessMessage;

	@FindBy(how = How.LINK_TEXT, using = "click here")
	private WebElement lnkaccountConfirm;
	
	@FindBy(how = How.LINK_TEXT, using = "click here")
	private WebElement welcomeLink;

	public boolean isWelComeUserMessageDisplayed() {
		return txtSuccessMessage.isDisplayed();
	}

	public boolean isLoginPageNavigated() {
		return txtSuccessMessage.isDisplayed();
	}
	
	public void navigateToLoginPage() {
		lnkaccountConfirm.click();
	}

	public void navigateToWelcomePage() {
		welcomeLink.click();
	}

}
