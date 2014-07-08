package com.clh.drivers;

import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PrepareFireFoxDriver {

	private Logger log = Logger.getLogger(PrepareFireFoxDriver.class);
	private RemoteWebDriver driver = null;
	
	public PrepareFireFoxDriver() {
	}
	
	public RemoteWebDriver loadFireFoxDriver(String browser) {
		if(browser.contains("profile-")){
			System.out.println(" entered into profile");
			String[] trim = browser.split(":");
			getFireFoxDriverByProfileName(getKeyValue("profile-", trim));
		}
		
		return driver;
	}
	
	public void getFireFoxDriverByProfileName(String profileName) {

		log.info("Initializing 'firefox' driver...");
		
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile(profileName);
		profile.setEnableNativeEvents(true);
	 
		DesiredCapabilities dc = DesiredCapabilities.firefox();
	    dc.setCapability(FirefoxDriver.PROFILE, profile);
	    dc.setJavascriptEnabled(true);
	 
	    driver = new FirefoxDriver(dc);
	}
	
	public static String getKeyValue(String key, String[] trim) {
		String profile = null;
		for(int i=0;i<trim.length;i++){
			if(trim[i].startsWith(key)){
				String temp[] = trim[i].split("-");
				profile = temp[1];
				break;
			}
		}
		System.out.println("Profile = "+profile);
		
		return profile;
	}
	
}
