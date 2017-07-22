package com.utilss.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties property = new Properties();
	static OutputStream out = null;
	static FileInputStream fis = null;
	
	public static void  writeToPropertyFile(String FileName,String key ,String value)  {

		try {
			  // create a new Output stream to create new file
			  out = new FileOutputStream(FileName);
	
			  // set the values in properties file
			  property.setProperty(key , value);
	
			  // save the properties file
			  property.store(out,FileName);

		} catch (Exception e) {

			 System.out.println("Error occured while creating Output Stream" + e);
		}
		finally {
	   	    
			// close the output stream connection
			try {
			  	 if(out !=null) {
					out.close();
			     }
			 } catch (IOException e ) {
						System.out.println(e);
			}
		}
	}	
	
	public static String readFromPropertyFile(String fileName,String key) {
		 
		try {
	
			// open the file
			fis = new FileInputStream(fileName);
			
			// load the file in property format
			property.load(fis);
		
		} catch (FileNotFoundException e) {
		
			System.out.println("Unable to access file, " + e);
		} catch (IOException e) {
		
			System.out.println("Error while accessing file " + e);
		}
		
		return  property.getProperty(key, null);
	}
	
   public static void main (String[] args) {
 	 
	   final String fileName = "App.properties";
	   final String key    = "Application URL";
	   final String value  ="http://www.seleniumeasy.com/test/basic-first-form-demo.html";
	   
	   writeToPropertyFile(fileName,key,value);
	   System.out.println(readFromPropertyFile(fileName, key));
	  
   }

}
