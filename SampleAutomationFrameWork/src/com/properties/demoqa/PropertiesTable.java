package com.properties.demoqa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTable {

	// global Property Object
	private final static Properties property = new Properties();

	/**
	 *  Used to retrieve value from Properties file based on the key
	 * @param filePath properties file path
	 * @param key key for which the value has to be found
	 * @return Value for the specified  key
	 */
	public static String getValue(String filePath, String key) {

		String value = "";
		try (FileReader reader = new FileReader(filePath)) {

			property.load(reader);
			value = property.getProperty(key, "No such key  found");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	 /**
	  * Used to set  value in the  Properties file for the specified key
	  * @param filePath   filePath properties file path
	  * @param key 	key for which the value has to be found
	  * @param value
	  */
	public static void putValue(String filePath, String key, Object value) {

		try (FileWriter writer = new FileWriter(filePath)) {

			property.setProperty(key, value.toString());
			property.store(writer, "Successfully Added");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
