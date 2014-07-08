package com.clh.utils;

public class ConsoleReader {
	
	public static String platform = "none";
	public static String browser = "none";
	public static String url = "none";
	
	public static String mobile_browser = "none";
	public static String mobile_version = "none";
	public static String mobile_os = "none";
	public static String mobile_device = "none";
	
	
	public static String getPlatformSystenProperty() {
        System.out.println( "Property name of " + System.getProperty("test.platform"));
        
        return System.getProperty("test.platform");
	}
	
	public static String getBrowserSystenProperty() {
        System.out.println( "Property name of " + System.getProperty("test.browser"));
        
        return System.getProperty("test.browser");
	}
	
	public static String getURLSystenProperty() {
        System.out.println( "Property name of " + System.getProperty("test.url"));
        
        return System.getProperty("test.url");
	}
	
	public static void validatePlatform() {
		platform = System.getProperty("test.platform");
		if(platform.equalsIgnoreCase("web")){
			setSystemPropertiesForWeb();
		}
		else if(platform.equalsIgnoreCase("mobile")) {
			System.out.println("Platform settings done");
			setSystemPropertiesForMobile();
			
		}
	}
	
	public static void setSystemPropertiesForMobile() {
		mobile_os = System.getProperty("test.mobile_os");
		mobile_browser = System.getProperty("test.mobile_browser");
		mobile_version = System.getProperty("test.mobile_version");
		mobile_device = System.getProperty("test.mobile_device");
		System.out.println("os = " + mobile_os);
        System.out.println("browser_name = " + mobile_browser);
        System.out.println("version = " + mobile_version);
        System.out.println("device = " + mobile_device);
	}
	
	public static void setSystemPropertiesForWeb() {
		platform = System.getProperty("test.platform");
		browser = System.getProperty("test.browser");
		url = System.getProperty("test.url");
		System.out.println("Platform = " + platform);
        System.out.println("Browser = " + browser);
        System.out.println("URL = " + url);
	}
	
	
	
    public static void main( String[] args ) {
        System.out.println("Platform = " + ConsoleReader.platform);
        System.out.println("Browser = " + ConsoleReader.browser);
        System.out.println("URL = " + ConsoleReader.url);
    }

}
