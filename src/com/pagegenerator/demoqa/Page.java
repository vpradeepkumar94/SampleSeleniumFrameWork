package com.pagegenerator.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageobjects.java.HomePage;
import com.pageobjects.java.NewUserWelcomePage;
import com.pageobjects.java.RegistrationPage;
import com.testbase.demoqa.BrowserFactory;

public class Page extends BrowserFactory {

	private static  WebDriver driver =  BrowserFactory.driver;
	
	/**
 	 * Specify all the Page Objects Classes here
 	 */
	public static HomePage  homePage ;
 	public static RegistrationPage registrationPage; 
 	public static NewUserWelcomePage newUserWelcomePage;
 	/**
 	 * Get the instances for Page object class here
 	 */
 	 static {
		homePage = getPageInstance(HomePage.class);
		registrationPage = getPageInstance(RegistrationPage.class);
		newUserWelcomePage = getPageInstance(NewUserWelcomePage.class);
	}
 	
 	/**
 	* Returns the Page Object intance After initialising the  Web Elements
 	 * @param clazz Page Object Class 
 	 * @return Instance of Page Object class with Drivers initialized
 	 */
	private static <T> T getPageInstance(Class<T> clazz) {
		T  instance =  PageFactory.initElements(driver, clazz);
		return instance;
	}

}
