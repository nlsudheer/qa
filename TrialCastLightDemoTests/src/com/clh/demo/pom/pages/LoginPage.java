package com.clh.demo.pom.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clh.core.constants.TestConstants;
import com.clh.core.master.WebMasterTests;
import com.clh.demo.properties.PropertyLoader;

public class LoginPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public PropertyLoader p;
	public WebMasterTests masterTest;
	public String platform = "web";
	public String screenPath = "./build/screenshots/";
	
	public LoginPage() {
	}
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		p = new PropertyLoader(platform, "login");
		
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForLoginPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(p.locator("CREATE_NEW_ACC_LINK"))));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(p.locator("FORGOT_PWD_LINK"))));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(p.locator("SIGN_IN_XPATH"))));
		try {
			File screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenPath + "login.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterEmailId(String email_id) {
		WebElement email_textbox	=	driver.findElement(By.name(p.locator("EMAIL_NAME")));
		email_textbox.clear();
		email_textbox.sendKeys(email_id);
	}
	
	public void enterPassword(String pwd) {
		WebElement pwd_textbox	=	driver.findElement(By.name(p.locator("PASSWORD_NAME")));
		pwd_textbox.clear();
		pwd_textbox.sendKeys(pwd);
	}
	
	public void clickSignInButton() {
		driver.findElement(By.xpath(p.locator("SIGN_IN_XPATH"))).click();
	}

}
