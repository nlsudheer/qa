package com.clh.demo.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clh.core.master.WebMasterTests;

public class LoginTests extends WebMasterTests {
	
	@Test(description="This is description")
	public void testTabTests() throws InterruptedException{
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("find care")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='common_services']/div/h2")));
		Assert.assertTrue(driver.findElement(By.linkText("Primary care for adults")).isDisplayed(), "Fail:Unable to load 'find care'");
		
		driver.findElement(By.linkText("past care")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='past_care_filter_picker']/div/div/h2")));
		Assert.assertTrue(driver.findElement(By.linkText("request a change")).isDisplayed(),"Refine Your View");
		
		driver.findElement(By.linkText("your plan")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='my_insurance']/div[1]/div[1]/h1")));
		Assert.assertTrue(driver.findElement(By.linkText("Well Baby Exams")).isDisplayed(),"Well Baby Exams");
	}

}