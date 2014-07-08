package com.clh.demo.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	
	public Properties prop = new Properties();
	public InputStream input = null;
	
	
	  public PropertyLoader(String platform) {
		 
			try {
				input = new FileInputStream("./resource/"+platform+"/login.properties");
		 
				// load a properties file
				prop.load(input);
		 
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
	}
	  
	  public PropertyLoader(String platform, String module) {
			 
			try {
				input = new FileInputStream("./resource/"+platform+"/"+module+".properties");
		 
				// load a properties file
				prop.load(input);
		 
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
	}
	  
	  public String locator(String locator) {
		  return prop.getProperty(locator);
	  }

}
