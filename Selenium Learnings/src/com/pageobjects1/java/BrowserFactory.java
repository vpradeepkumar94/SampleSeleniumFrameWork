package com.pageobjects1.java;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	  public static  HashMap<String,WebDriver> Drivers = new HashMap<String,WebDriver>();
      
      public static  WebDriver Driver;
	  
      public static WebDriver getDriver() throws Exception {
    	  if(Driver == null) {
              throw new Exception("The WebDriver browser instance was not initialized. You should first call the method InitBrowser.");
    	  }
    	  else {
    		 return Driver;
    	  }
	  }

      public static void initBrowser(String browserName)
      {          
    	  switch (browserName.toLowerCase())
          {
              case "firefox":
                  if (Driver == null)
                  { 
                // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriverold.exe");
            		Driver = new FirefoxDriver();
                	Drivers.put("firefox",Driver);
                  }
                  break;

              case "IE":
                  if (Driver == null)
                  {
                      Driver = new InternetExplorerDriver();
                      Drivers.put("IE",Driver);
                  }
                  break;

              case "chrome":
                  if (Driver == null)
                  {
                	  try  {
						 	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver2.30.exe");
						 	 Driver = new ChromeDriver();
						 	Drivers.put("Chrome", Driver);
					 }catch (Exception e) {
							System.out.println("Unable to create Driver Instance for Browser "+ browserName + e);
					 }
                  }
                  break;
          default:
					System.out.println("Unable to create Driver Instance for Browser "+ browserName );
			 }            
      }

      public static void LoadApplication(String url)
      {
          // Driver.Url = url;
      }

      public static void CloseAllDrivers()
      {
          for(Map.Entry<String,WebDriver> entry: Drivers.entrySet() ) {
        	 Drivers.get(entry.getKey()).close();
        	 Drivers.get(entry.getKey()).quit();
          }
   }

}
