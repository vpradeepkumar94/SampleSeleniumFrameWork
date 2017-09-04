package com.tests.demoqa;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pagegenerator.demoqa.Page;
import com.properties.demoqa.PropertiesTable;
import com.testbase.demoqa.BrowserFactory;
import com.utils.demoqa.Utils;

public class TC_HomePage extends BrowserFactory{

	@SuppressWarnings("unused")
	private  WebDriver driver = null;
	private final Logger Log = Utils.getLogger(TC_HomePage.class);
	private String fileName;
	
	@Parameters({"browserName,fileName"})
	@BeforeClass (description = "Initialise the browser  passed from suite file and store in it local variable")
	public void  setup(String browserName,String fileName) {
		
		this.fileName = fileName;
		super.initBrowser(browserName);
	   
		try {
			driver = super.getDriver(browserName);
		} catch (Exception e) {
			System.out.println("Error occured while retriving the browser Instance,Please see log report for more details");
			Log.error("Unable to get Browser Instance " + e);
		}
	}
	
	@AfterSuite (description = "Perform clean up activities before terminating the session")
	public void  tearDown() {
		super.closeAllBrowsers();
	}
	
	@Test (description = "Launches the AUT and asserts the title")
	public void TC001_launchApplicationUrl() {
		
	   final String appURL = PropertiesTable.getValue(fileName, "APPURL");
	   final String appTitile = PropertiesTable.getValue(fileName, "PageTitle");
	   
	   Page.homePage.launchURL(appURL);
	   String actualPageTitile = Page.homePage.getPageTitle();
	 
	   Assert.assertEquals(actualPageTitile, appTitile);
	   
	}
	
}
