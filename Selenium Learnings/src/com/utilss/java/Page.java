package com.utilss.java;

import org.openqa.selenium.support.PageFactory;

import com.pageobjects1.java.BrowserFactory;
import com.pageobjects1.java.DemoHomePage;
import com.pageobjects1.java.InputFormPage;

 public class Page {
 	
	/**
	 * Specify the list of Page Object classes here
	*/
	public static DemoHomePage demoHomePage;
	public static InputFormPage inputFormPage;
	
	/**
	 * Gets the Object reference here
	 */
	static 
	{
	  demoHomePage = getInstance(DemoHomePage.class);
	  inputFormPage = getInstance(InputFormPage.class);
 	}
	
	/**
	 * 
	 * @param Clazz Page Object Class 
	 * @return instance - Page Object class Reference
	 */
	public static <T> T getInstance(Class<T> Clazz) {
	   T  instance = PageFactory.initElements(BrowserFactory.Driver,Clazz);
	   return  instance;
	}
 }


