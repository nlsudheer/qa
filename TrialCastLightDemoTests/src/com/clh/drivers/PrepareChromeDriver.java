package com.clh.drivers;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.clh.utils.ConsoleReader;
import com.clh.utils.OSUtils;

public class PrepareChromeDriver {

	private static Logger log = Logger.getLogger(PrepareChromeDriver.class);
	
	private RemoteWebDriver driver = null;
	private static String mac = "/mac/";
	private static String windows = "/windows/";
	private static String linux = "/linux/";
	
	public PrepareChromeDriver() {
	}
	
	public RemoteWebDriver loadChromeDriver(String browser) {
		String chromePath = "none";
		
		log.info("Identifying platform ...");
		if(OSUtils.isMac()){
			if(ConsoleReader.browser.equalsIgnoreCase("chrome32"))
				System.setProperty("webdriver.chrome.driver", 
						"CoreDriver"+mac+"chromedriver32");
				chromePath = "CoreDriver"+mac+"chromedriver32";
		}
		else if(OSUtils.isWindows()){
			if(ConsoleReader.browser.equalsIgnoreCase("chrome32")) {
				System.setProperty("webdriver.chrome.driver", 
						"CoreDriver" + windows + "chromedriver32.exe");
				chromePath = "CoreDriver" + windows + "chromedriver32.exe";
			}
		}
		else if(OSUtils.isLinux()){
			if(OSUtils.isLinux()) {
				System.setProperty("webdriver.chrome.driver", 
						"CoreDriver" + linux + "chromedriver32");
				chromePath = "CoreDriver" + linux + "chromedriver32";
			}
			if(OSUtils.isLinux()) {
				System.setProperty("webdriver.chrome.driver", 
						"CoreDriver" + linux + "chromedriver64");
				chromePath = "CoreDriver" + linux + "chromedriver64";
			}
		}
		
		return getChromeDriver(chromePath);
	}
	
	public RemoteWebDriver getChromeDriver(String chromePath) {
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("test-type='start-maximized'");
		
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability("chrome.binary", chromePath);
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		log.info("Initializing 'chrome' driver...");
		
		driver = new ChromeDriver(capabilities);
		
		return driver;
	}

}
