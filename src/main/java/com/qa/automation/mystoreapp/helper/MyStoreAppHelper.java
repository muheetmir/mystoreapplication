package com.qa.automation.mystoreapp.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;


public class MyStoreAppHelper {
	Browser browser;
	Properties prop = new Properties();
	String propertyFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+"pages"+File.separator+"locators.properties";

	 public static Properties loadProperties(String propertyFilePath ) { 
		 File file=new File(propertyFilePath);
		 FileInputStream fileInput=null; 
		 try {
			 fileInput=new FileInputStream(file);
		 }catch(FileNotFoundException e) { 
		e.printStackTrace(); } 
		Properties prop=new 
		Properties(); 
		try { 
			prop.load(fileInput); 
		}catch(IOException e) {
			e.printStackTrace();
			}
		return prop; 
	  }
	 
}
