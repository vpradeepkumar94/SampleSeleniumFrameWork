package com.testbase.demoqa;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.utils.demoqa.Utils;

  public  class BrowserFactory extends Base implements BrowserConsumables  {

	 protected  static  WebDriver driver;
	
	 private final Logger Log = Utils.getLogger(BrowserFactory.class);
	 
 	 private static final  Map<String,WebDriver> browsers = new HashMap<String,WebDriver>();

	@Override
	 public  void initBrowser(String browserName) {
		// TODO Auto-generated method stub
		
		browserName = browserName.toLowerCase(); 
		
		switch(browserName) {
		
		case "firefox":
			            try {
			            	  System.setProperty("webdriver.gecko.driver","pathToGeckoDriver");
						      driver = new FirefoxDriver();
						      browsers.put(browserName, driver);
			            } catch (Exception e) {
			            	  System.out.println("Unable to initialise browser,Please see log report for more detailed information");
			            	  Log.error("Error occured while creating browser Instance " + e);
			            }
			 		    break;
		
		case "internetexplorer":
						 try {
			            	  System.setProperty("webdriver.ie.driver","pathToIEDriver");
						      driver = new InternetExplorerDriver();
						      browsers.put(browserName, driver);
			            } catch (Exception e) {
			            	  System.out.println("Unable to initialise browser,Please see log report for more detailed information");
			            	  Log.error("Error occured while creating browser Instance " + e);
			            }
						break;
		default: 
	     				 try {
		 	            	  System.setProperty("webdriver.gecko.driver","pathToChromeDriver");
						      driver = new ChromeDriver();
						      browsers.put(browserName, driver);
			            } catch (Exception e) {
			            	  System.out.println("Unable to initialise browser,Please see log report for more detailed information");
			            	  Log.error("Error occured while creating browser Instance " + e);
			            }
 		                break;
		}
		
	}

	@Override
	 public  void closeAllBrowsers() {
		for( Map.Entry<String, WebDriver> driver :browsers.entrySet()) {
			try {
			      browsers.get(driver.getKey()).close();
			      browsers.get(driver.getKey()).quit();
			} catch (Exception e) {
				 System.out.println("unable to terminate the browser Instance "+ driver.getKey() + 
						 " Please see log report "	+ "for more details ");
				 Log.error("Error occured while closing instance of browser "+ e);
			} finally {
				if(browsers != null) {
				    browsers.clear();
				}
			}
		}
	}

	@Override
	 public WebDriver getDriver(String browserName) throws Exception  {
		 
		 if(driver == null) {
			throw new Exception("Browser is not initialized,Please initialise browser by calling init browser");
		 }
		return browsers.get(browserName.toLowerCase());
	 }

	@Override
	 public void captureScreenShot(String fileName,WebDriver driver) {
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("ScreenShots/" + Utils.getDate() + fileName+".png");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
			   System.out.println(e);
			}
		}
		
	}
	

