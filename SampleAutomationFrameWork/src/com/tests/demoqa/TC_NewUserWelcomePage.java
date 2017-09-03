package com.tests.demoqa;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pagegenerator.demoqa.Page;
import com.testbase.demoqa.BrowserFactory;
import com.utils.demoqa.Utils;

public class TC_NewUserWelcomePage extends BrowserFactory {

	private final Logger Log = Utils.getLogger(TC_NewUserWelcomePage.class);

	@Test(description = "User should be navigated to welcome page from registration page")
	public void TC001_NavigateToWelcomePage() {

		Page.newUserWelcomePage.navigateToWelcomePage();

		Assert.assertTrue(Page.newUserWelcomePage
				.isWelComeUserMessageDisplayed());
	}

	@Test(description = "Verifies whether user is taken to welcome page")
	public void TC002_VerifyWelcomePageDisplayed() {

		Page.newUserWelcomePage.navigateToWelcomePage();

		Assert.assertTrue(Page.newUserWelcomePage
				.isWelComeUserMessageDisplayed());
	}

	@Test(description = "Verifies whether user is taken to Login page")
	public void TC003_shouldBeNavigatedToLoginPage() {

		Page.newUserWelcomePage.navigateToLoginPage();

		Assert.assertTrue(Page.newUserWelcomePage.isLoginPageNavigated());
		Log.info("New user created Successfully");
	}
}
