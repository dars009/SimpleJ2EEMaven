package com.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// first way to load propertie file
		Properties props = new Properties();
		props.load(new FileInputStream("src/main/resources/config.properties"));
		System.out.println(props.get("dbuser"));

		// second way to load propertie file
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties prop = new Properties();
		InputStream resourceStream = loader.getResourceAsStream("config.properties");
		prop.load(resourceStream);
		System.out.println(prop.getProperty("dbpassword"));
		
		// third way to load propertie file
		Properties prop1 = new Properties();
		InputStream input = null;
		try {
		    input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
		    prop1.load(input);
		    System.out.println(prop.getProperty("dbpassword"));

		} catch (IOException io) {
		    io.printStackTrace();
		}
		
	}
}
