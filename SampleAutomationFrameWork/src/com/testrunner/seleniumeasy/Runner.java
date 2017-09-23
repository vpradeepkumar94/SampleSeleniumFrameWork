package com.testrunner.seleniumeasy;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Runner {

	public static void main(String[] args) {
	
		TestNG runner = new TestNG();
		
		List<String> xmlSuites = new ArrayList<>();
		
		xmlSuites.add(System.getProperty("user.dir") + "/testng.xml" );
		
		runner.setTestSuites(xmlSuites);
		
		runner.run();
	}

}
