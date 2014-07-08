package com.clh.drivers;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.clh.utils.OSUtils;


public class DriverFactory {
	
	private static RemoteWebDriver driver = null;
	
	public PrepareFireFoxDriver prepareFireFoxDriver = new PrepareFireFoxDriver();
	public PrepareChromeDriver prepareChromeDriver = new PrepareChromeDriver();
	
	public DriverFactory(){}
	
	public RemoteWebDriver getDriver(String browser) {
		
		if(browser.startsWith("firefox")) {
			driver = prepareFireFoxDriver.loadFireFoxDriver(browser);
		}
		else
		if(browser.equalsIgnoreCase("chrome")) {
			driver = prepareChromeDriver.loadChromeDriver(browser);
		}
		else 
		if(browser.startsWith("safari")) {
			if(OSUtils.isMac() || OSUtils.isWindows()){
				driver =  new SafariDriver();
			}
		}		
		
		return driver;
	}

}
