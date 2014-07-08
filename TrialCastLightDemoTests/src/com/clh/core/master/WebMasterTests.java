package com.clh.core.master;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.clh.demo.pom.pages.LoginPage;
import com.clh.drivers.DriverFactory;

public class WebMasterTests {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public DriverFactory driverFactory = new DriverFactory();
	
	public LoginPage loginPage;
	private String platform = "web";
	
	private String browser = "firefox:profile-castlight";
	private String testURL = "https://predemo.castlighthealth.com/";
	
//	private String browser = "firefox:profile-mobile_browser";
//	private String testURL = "https://m.predemo.castlighthealth.com/";
	
	private String email = "john_20june14_cdhp@predemo.com";
	private String pwd = "zebra123";
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		driver = driverFactory.getDriver(browser);
		wait = new WebDriverWait(driver, 120);
		driver.get(testURL);
		login();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("q")));
	}
	
	public void login() {
		loginPage = new LoginPage(driver, wait);
		loginPage.waitForLoginPage();
		
		loginPage.enterEmailId(email);
		loginPage.enterPassword(pwd);
		loginPage.clickSignInButton();
	}
	
	@AfterClass
	public void tearDown(){
		driver.findElement(By.id("full_name")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Log Out")));
		driver.findElement(By.linkText("Log Out")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div[1]/div/form/fieldset/div[3]/p/input")));
        
        driver.close();
        driver.quit();
	}	
	

}
