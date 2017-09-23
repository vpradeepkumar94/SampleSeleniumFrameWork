package com.testbase.demoqa;

import org.openqa.selenium.WebDriver;

public interface BrowserConsumables {

	 void initBrowser(String browserName);
	 WebDriver getDriver(String browserName) throws Exception ;
	 void closeAllBrowsers() ;
	 void captureScreenShot(String fileName, WebDriver driver) ;
	
}
