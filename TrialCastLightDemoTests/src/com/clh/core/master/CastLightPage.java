package com.clh.core.master;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.clh.utils.DateUtil;

/**
 * BasePage is the class that all other page classes should extend for web-based
 * UI testing.<br>
 * The actual usage of this class methods will be on test project.
 * 
 */

public class CastLightPage extends RemoteWebDriver{

	public static RemoteWebDriver castlight = null;
	private Alert alert = null;
	
	private static String timeout = "300000";

	private static Logger log = Logger.getLogger(CastLightPage.class);

	/***********************************************************************
	 * The default timeout is set to 50 seconds
	 * *********************************************************************/
	private static String timeoutMilliSeconds = "50000"; // time in milliseconds
	private static long timeoutSeconds = 50; // time in seconds

	static {
		setTimeout();
	}

//	public castlightPage() {
//		if (castlight == null) {
//			castlight = PlatformFactory.getDriver();
//			windowMaximize();
//		}
//	}

	public CastLightPage(URL url, Capabilities capabilities) {
		if (castlight == null) {
			try {
				castlight = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Gets the instance of the current castlight class
	 * 
	 * @return
	 */
	public static RemoteWebDriver getDriver() {
		return CastLightPage.castlight;
	}

	/**
	 * Resets the current castlight object to null
	 */
	public void resetDriver() {
		CastLightPage.castlight = null;
	}

	/**
	 * Navigates the page to the given URL
	 * 
	 * @param url
	 */
	public void openUrl(String url) {
		log.info("Openning the url '" + url + "' in the browser...");
		castlight.navigate().to(url);
	}

//	/**
//	 * Starts the test by opening the browser
//	 */
//	protected void init() {
//		openUrl(ConsoleReader.url);
//	}

	/**
	 * Maximizes the current browser window
	 */
	protected void windowMaximize() {
		log.info("Maximizing the browser window.");
		castlight.manage().window().maximize();
	}

	/**
	 * Returns the default timeout defined in <code>timeoutMilliSeconds</code>
	 * in the <code>BasePage.java</code>. This value changes if we define
	 * <code>timeout</code> property in the
	 * <code>config/config.properties</code> file
	 * 
	 * @return
	 */
	public String getTimeOutInMilliSeconds() {
		return timeoutMilliSeconds;
	}

	/**
	 * Returns the default timeout defined in <code>timeoutSeconds</code> in the
	 * <code>BasePage.java</code>. This value changes if we define
	 * <code>timeout</code> property in the
	 * <code>config/config.properties</code> file
	 * 
	 * @return
	 */
	public long getTimeOutInSeconds() {
		return timeoutSeconds;
	}

	/**
	 * Sets the waiting time to the specified timeout value in the
	 * <code>config/config.properties</code>, if not mentioned the default
	 * timeout value is the timeout defined in <code>BasePage.java</code>
	 */
	public static void setTimeout() {
		if ((timeout != null) && (!"".equals(timeout))) {
			timeoutMilliSeconds = timeout;
			timeoutSeconds = Integer.parseInt(timeout) / 1000;
			log.info("The timeout value is set to " + timeoutSeconds
					+ " seconds.");
		}
	}

	/***********************************************************************
	 * START - Enter text into an input filed by its locator
	 * *********************************************************************/

	/**
	 * Enter text into an input filed by its <code>xpath</code> locator
	 * 
	 * @param xpath
	 * @param text
	 */
	public void typeByXpath(String xpath, String text) {
		log.info("Entering text '" + text
				+ "' to the element specified by xpath '" + xpath + "'");
		castlight.findElement(By.xpath(xpath)).sendKeys(text);
	}

	/**
	 * Enter text into an input filed by its <code>css</code> locator
	 * 
	 * @param css
	 * @param text
	 */
	public void typeByCSS(String css, String text) {
		log.info("Entering text '" + text
				+ "' to the element specified by css '" + css + "'");
		castlight.findElement(By.cssSelector(css)).sendKeys(text);
	}

	/**
	 * Enter text into an input filed by its <code>id</code> locator
	 * 
	 * @param id
	 * @param text
	 */
	public void typeByID(String id, String text) {
		log.info("Entering text '" + text
				+ "' to the element specified by id '" + id + "'");
		castlight.findElement(By.id(id)).sendKeys(text);
	}

	/**
	 * Enter text into an input filed by its <code>name</code> locator
	 * 
	 * @param name
	 * @param text
	 */
	public void typeByName(String name, String text) {
		log.info("Entering text '" + text
				+ "' to the element specified by name '" + name + "'");
		castlight.findElement(By.name(name)).sendKeys(text);
	}

	/**
	 * Enter text into an input filed by its <code>className</code> locator
	 * 
	 * @param className
	 * @param text
	 */
	public void typeByClassName(String className, String text) {
		log.info("Entering text '" + text
				+ "' to the element specified by className '" + className + "'");
		castlight.findElement(By.className(className)).sendKeys(text);
	}

	/***********************************************************************
	 * END - Enter text into an input filed by its locator
	 * *********************************************************************/

	/***********************************************************************
	 * START - Click on the element by its locator
	 * *********************************************************************/

	/**
	 * Click on the element by its <code>xpath</code> locator
	 * 
	 * @param xpath
	 */
	public void clickByXpath(String xpath) {
		log.info("Clicking on the element specified by xpath '" + xpath + "'");
		castlight.findElement(By.xpath(xpath)).click();
	}

	/**
	 * Click on the element by its <code>css</code> locator
	 * 
	 * @param css
	 */
	public void clickByCSS(String css) {
		log.info("Clicking on the element specified by css '" + css + "'");
		castlight.findElement(By.cssSelector(css));
	}

	/**
	 * Click on the element by its <code>id</code> locator
	 * 
	 * @param id
	 */
	public void clickByID(String id) {
		log.info("Clicking on the element specified by id '" + id + "'");
		castlight.findElement(By.id(id)).click();
	}

	/**
	 * Click on the element by its <code>name</code> locator
	 * 
	 * @param name
	 */
	public void clickByName(String name) {
		log.info("Clicking on the element specified by name '" + name + "'");
		castlight.findElement(By.name(name)).click();
	}

	/**
	 * Click on the element by its <code>className</code> locator
	 * 
	 * @param className
	 */
	public void clickByClassName(String className) {
		log.info("Clicking on the element specified by className '" + className
				+ "'");
		castlight.findElement(By.className(className)).click();
	}

	/**
	 * Click on the link by its link text
	 * 
	 * @param linkText
	 */
	public void clickByLinkText(String linkText) {
		log.info("Clicking on the link specified by linkText '" + linkText
				+ "'");
		castlight.findElement(By.linkText(linkText)).click();
	}

	/**
	 * Click on the link by partial of the link text
	 * 
	 * @param partialLinkText
	 */
	public void clickByPartialLinkText(String partialLinkText) {
		log.info("Clicking on the link specified by partialLinkText '"
				+ partialLinkText + "'");
		castlight.findElement(By.partialLinkText(partialLinkText));
	}

	/***********************************************************************
	 * END - Click on the element by its locator
	 * *********************************************************************/

	/***********************************************************************
	 * START - Get the element by its locator
	 * *********************************************************************/

	/**
	 * Get the element by its <code>xpath</code> locator
	 * 
	 * @param xpath
	 * @return
	 */
	public WebElement getElementByXpath(String xpath) {
		log.info("Getting the Webelement specified by xpath '" + xpath + "'");
		return castlight.findElement(By.xpath(xpath));
	}

	/**
	 * Get the element by its <code>css</code> locator
	 * 
	 * @param css
	 * @return
	 */
	public WebElement getElementByCSS(String css) {
		log.info("Getting the Webelement specified by css '" + css + "'");
		return castlight.findElement(By.cssSelector(css));
	}

	/**
	 * Get the element by its <code>id</code> locator
	 * 
	 * @param id
	 * @return
	 */
	public WebElement getElementByID(String id) {
		log.info("Getting the Webelement specified by id '" + id + "'");
		return castlight.findElement(By.id(id));
	}

	/**
	 * Get the element by its <code>name</code> locator
	 * 
	 * @param name
	 * @return
	 */
	public WebElement getElementByName(String name) {
		log.info("Getting the Webelement specified by name '" + name + "'");
		return castlight.findElement(By.name(name));
	}

	/**
	 * Get the element by its <code>className</code> locator
	 * 
	 * @param className
	 * @return
	 */
	public WebElement getElementByClassName(String className) {
		log.info("Getting the Webelement specified by className '" + className
				+ "'");
		return castlight.findElement(By.className(className));
	}

	/***********************************************************************
	 * END - Get the element by its locator
	 * *********************************************************************/

	/***********************************************************************
	 * START - Get the elements by its locator
	 * *********************************************************************/

	/**
	 * Gets all the elements by their <code>xpath</code> locator
	 * 
	 * @param xpath
	 * @return
	 */
	public List<WebElement> getElementsByXpath(String xpath) {
		log.info("Getting the Webelements specified by xpath '" + xpath + "'");
		return castlight.findElements(By.xpath(xpath));
	}

	/**
	 * Get the element by its <code>css</code> locator
	 * 
	 * @param css
	 * @return
	 */
	public List<WebElement> getElementsByCSS(String css) {
		log.info("Getting the Webelements specified by css '" + css + "'");
		return castlight.findElements(By.cssSelector(css));
	}

	/**
	 * Get the element by its <code>id</code> locator
	 * 
	 * @param id
	 * @return
	 */
	public List<WebElement> getElementsByID(String id) {
		log.info("Getting the Webelements specified by id '" + id + "'");
		return castlight.findElements(By.id(id));
	}

	/**
	 * Get the element by its <code>name</code> locator
	 * 
	 * @param name
	 * @return
	 */
	public List<WebElement> getElementsByName(String name) {
		log.info("Getting the Webelements specified by name '" + name + "'");
		return castlight.findElements(By.name(name));
	}

	/**
	 * Get the element by its <code>className</code> locator
	 * 
	 * @param className
	 * @return
	 */
	public List<WebElement> getElementsByClassName(String className) {
		log.info("Getting the Webelements specified by className '" + className
				+ "'");
		return castlight.findElements(By.className(className));
	}

	/***********************************************************************
	 * END - Get the elements by its locator
	 * *********************************************************************/

	/**
	 * Gets the coordinates of the element location by its <code>xpath</code>
	 * locator
	 * 
	 * @param xpath
	 * @return
	 */
	public Point getLocationByXpath(String xpath) {
		log.info("Getting the coordinates of the element location by its xpath '"
				+ xpath + "'");
		return castlight.findElement(By.xpath(xpath)).getLocation();
	}

	/**
	 * Gets the coordinates of the locator by its <code>css</code> locator
	 * 
	 * @param css
	 * @return
	 */
	public Point getLocationByCSS(String css) {
		log.info("Getting the coordinates of the element location by its css '"
				+ css + "'");
		return castlight.findElement(By.cssSelector(css)).getLocation();
	}

	/***********************************************************************
	 * START - Is element present specified by its locator
	 * *********************************************************************/

	/**
	 * Check whether the element specified by its <code>xpath</code> is
	 * displayed
	 * 
	 * @param xpath
	 * @return
	 */
	public boolean isElementDisplayedByXpath(String xpath) {
		log.info("Checking whether the element specified by its xpath '"
				+ xpath + "' is displayed on the page");
		return castlight.findElement(By.xpath(xpath)).isDisplayed();
	}

	/**
	 * Check whether the element specified by its <code>css</code> is displayed
	 * 
	 * @param css
	 * @return
	 */
	public boolean isElementDisplayedByCSS(String css) {
		log.info("Checking whether the element specified by its css '" + css
				+ "' is displayed on the page");
		return castlight.findElement(By.cssSelector(css)).isDisplayed();
	}

	/**
	 * Check whether the element specified by its <code>id</code> is displayed
	 * 
	 * @param id
	 * @return
	 */
	public boolean isElementDisplayedByID(String id) {
		log.info("Checking whether the element specified by its id '" + id
				+ "' is displayed on the page");
		return castlight.findElement(By.id(id)).isDisplayed();
	}

	/**
	 * Check whether the element specified by its <code>name</code> is displayed
	 * 
	 * @param name
	 * @return
	 */
	public boolean isElementDisplayedByName(String name) {
		log.info("Checking whether the element specified by its name '" + name
				+ "' is displayed on the page");
		return castlight.findElement(By.name(name)).isDisplayed();
	}

	/**
	 * Check whether the element specified by its <code>className</code> is
	 * displayed
	 * 
	 * @param className
	 * @return
	 */
	public boolean isElementDisplayedByClassName(String className) {
		log.info("Checking whether the element specified by its className '"
				+ className + "' is displayed on the page");
		return castlight.findElement(By.className(className)).isDisplayed();
	}

	/**
	 * Check whether the element specified by its <code>linkText</code> is
	 * displayed
	 * 
	 * @param linkText
	 * @return
	 */
	public boolean isElementDisplayedByLinkText(String linkText) {
		log.info("Checking whether the element specified by its linkText '"
				+ linkText + "' is displayed on the page");
		return castlight.findElement(By.linkText(linkText)).isDisplayed();
	}

	/***********************************************************************
	 * END - Is element present specified by its locator
	 * *********************************************************************/

	/**
	 * Takes screen shot with the specified <code>fileName</code>. This creates
	 * a screenshot of the browser window only.
	 * 
	 * @param fileName
	 *            The name of the file to save the screen shot
	 */
	public void takeScreenshot(String fileName) {
		log.info("Taking screen shot for the test '" + fileName + "'");
		try {
			File srcFile = ((TakesScreenshot) castlight)
					.getScreenshotAs(OutputType.FILE);

			String imgLoc = new File(".").getCanonicalPath() + File.separator
					+ "screenshots" + File.separator + fileName
					+ DateUtil.getTimeStamp() + ".png";

			FileUtils.copyFile(srcFile, new File(imgLoc));

			log.info("Screen shot has been captured '" + imgLoc + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closes the current browser instance
	 */
	public void closeBrowser() {
//		log.info("Closing the current instance of the browser '" + ConsoleReader.browser + "'");
		castlight.close();
	}

	/**
	 * Closes all the instances of the browser
	 */
	public void quitBrowser() {
//		log.info("Closing all the instances of the browser '" + ConsoleReader.browser + "'");
		castlight.quit();
	}

	/**
	 * Pauses the flow of execution(thread) up to the given milliseconds
	 * 
	 * @param miliSeconds
	 */
	public void sleep(long miliSeconds) {
		try {
			log.info("Paused the thread for " + miliSeconds + " seconds");
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/***********************************************************************
	 * START - Get text of the element specified by its locator
	 * *********************************************************************/

	/**
	 * Gets the text of the element specified by its <code>xpath</code> locator
	 * 
	 * @param xpath
	 * @return
	 */
	public String getTextByXpath(String xpath) {
		log.info("Getting text of the element specified by its xpath '" + xpath
				+ "'");
		return castlight.findElement(By.xpath(xpath)).getText();
	}

	/**
	 * Gets the text of the element specified by its <code>css</code> locator
	 * 
	 * @param css
	 * @return
	 */
	public String getTextByCSS(String css) {
		log.info("Getting text of the element specified by its css '" + css
				+ "'");
		return castlight.findElement(By.cssSelector(css)).getText();
	}

	/**
	 * Gets the text of the element specified by its <code>id</code> locator
	 * 
	 * @param id
	 * @return
	 */
	public String getTextByID(String id) {
		log.info("Getting text of the element specified by its id '" + id + "'");
		return castlight.findElement(By.id(id)).getText();
	}

	/**
	 * Gets the text of the element specified by its <code>name</code> locator
	 * 
	 * @param name
	 * @return
	 */
	public String getTextByName(String name) {
		log.info("Getting text of the element specified by its name '" + name
				+ "'");
		return castlight.findElement(By.name(name)).getText();
	}

	/**
	 * Gets the text of the element specified by its <code>className</code>
	 * locator
	 * 
	 * @param className
	 * @return
	 */
	public String getTextByClassName(String className) {
		log.info("Getting text of the element specified by its className '"
				+ className + "'");
		return castlight.findElement(By.className(className)).getText();
	}

	/***********************************************************************
	 * END - Get text of the element specified by its locator
	 * *********************************************************************/

	/***********************************************************************
	 * START - Clear text of the element specified by its locator
	 * *********************************************************************/

	/**
	 * Clears text of the input field by its <code>xpath</code> locator
	 * 
	 * @param xpath
	 */
	public void clearTextByXpath(String xpath) {
		log.info("Clearing the text of the element specified by its xpath '"
				+ xpath + "'");
		castlight.findElement(By.xpath(xpath)).clear();
	}

	/**
	 * Clears text of the input field by its <code>css</code> locator
	 * 
	 * @param css
	 */
	public void clearTextByCSS(String css) {
		log.info("Clearing the text of the element specified by its css '"
				+ css + "'");
		castlight.findElement(By.cssSelector(css)).clear();
	}

	/**
	 * Clears text of the input field by its <code>id</code> locator
	 * 
	 * @param id
	 */
	public void clearTextByID(String id) {
		log.info("Clearing the text of the element specified by its id '" + id
				+ "'");
		castlight.findElement(By.id(id)).clear();
	}

	/**
	 * Clears text of the input field by its <code>name</code> locator
	 * 
	 * @param name
	 */
	public void clearTextByName(String name) {
		log.info("Clearing the text of the element specified by its name '"
				+ name + "'");
		castlight.findElement(By.name(name)).clear();
	}

	/**
	 * Clears text of the input field by its <code>className</code> locator
	 * 
	 * @param className
	 */
	public void clearTextByClassName(String className) {
		log.info("Clearing the text of the element specified by its className '"
				+ className + "'");
		castlight.findElement(By.className(className)).clear();
	}

	/***********************************************************************
	 * END - Clear text of the element specified by its locator
	 * *********************************************************************/

	/***********************************************************************
	 * START - Deal with Alert
	 * *********************************************************************/

	/**
	 * Waits for the alert to appear
	 * 
	 * @param timeOutInSeconds
	 */
	public void waitForAlert(long timeOutInSeconds) {
		log.info("Waiting for alert...");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.alertIsPresent());
	}

	/**
	 * Switches to the Alert window from current window
	 * 
	 * @return
	 */
	public Alert switchToAlert() {
		log.info("Switching to the alert...");
		return alert = castlight.switchTo().alert();
	}

	/**
	 * Accepts the current alert
	 */
	public void acceptAlert() {
		if (alert == null)
			switchToAlert();
		log.info("Accepting the alert...");
		alert.accept();
	}

	/**
	 * Dismisses the current alert
	 */
	public void dismissAlert() {
		if (alert == null)
			switchToAlert();
		log.info("Dismissing the alert...");
		alert.dismiss();
	}

	/**
	 * Gets text from the alert shown in the current page
	 */
	public String getTextFromAlert() {
		if (alert == null)
			switchToAlert();
		log.info("Getting text from the alert");
		return alert.getText();
	}

	/***********************************************************************
	 * END - Deal with Alert
	 * *********************************************************************/

	/**
	 * Switches to the default content window from other window(e.g. Alert
	 * window)
	 */
	public void swtichToDefaultContent() {
		log.info("Switching to the Default Content window...");
		castlight.switchTo().defaultContent();
	}

	/**
	 * Checks whether the specified <code>text</code> is present in the page
	 * 
	 * @param text
	 * @return
	 */
	public boolean isTextPresent(String text) {
		log.info("Checking for the text '" + text + "' in the page");
		return castlight.getPageSource().contains(text);
	}

	/**
	 * Assert a title equals exactly a string specified by <code>title</code>.
	 * 
	 * @param title
	 *            The title of current page
	 */
	protected void assertTitle(String title) {
		String actualTitle = castlight.getTitle();
		Assert.assertEquals(title, actualTitle, "Expect HTML title '" + title
				+ "' but got '" + actualTitle + "'.");

	}

	/**
	 * Assert that text specified in <code>text</code> exists in the current
	 * page.
	 * 
	 * @param text
	 *            The text that should be present
	 */
	protected void assertText(String text) {
		Assert.assertTrue(isTextPresent(text), "Expected text '" + text
				+ "' in the page not found.");

	}

	/***********************************************************************
	 * START - Wait for element by its locator
	 * *********************************************************************/

	/**
	 * Waits for the element specified by its <code>xpath</code> locator
	 * 
	 * @param xpath
	 * @param timeOutInSeconds
	 */
	public void waitForElementLocatedByXpath(String xpath, long timeOutInSeconds) {
		log.info("Waiting for the element specified by xpath '" + xpath + "'");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * Waits for the element specified by its <code>css</code> locator
	 * 
	 * @param css
	 * @param timeOutInSeconds
	 */
	public void waitForElementLocatedByCSS(String css, long timeOutInSeconds) {
		log.info("Waiting for the element specified by css '" + css + "'");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector(css)));
	}

	/**
	 * Waits for the element specified by its <code>id</code> locator
	 * 
	 * @param id
	 * @param timeOutInSeconds
	 */
	public void waitForElementLocatedByID(String id, long timeOutInSeconds) {
		log.info("Waiting for the element specified by id '" + id + "'");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.presenceOfElementLocated(By.id(id)));
	}

	/**
	 * Waits for the element specified by its <code>name</code> locator
	 * 
	 * @param name
	 * @param timeOutInSeconds
	 */
	public void waitForElementLocatedByName(String name, long timeOutInSeconds) {
		log.info("Waiting for the element specified by name '" + name + "'");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.presenceOfElementLocated(By.name(name)));
	}

	/**
	 * Waits for the element specified by its <code>className</code> locator
	 * 
	 * @param className
	 * @param timeOutInSeconds
	 */
	public void waitForElementLocatedByClassName(String className,
			long timeOutInSeconds) {
		log.info("Waiting for the element specified by className '" + className
				+ "'");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.presenceOfElementLocated(By.className(className)));
	}

	/**
	 * Waits for the element specified by its <code>linkText</code> locator
	 * 
	 * @param linkText
	 * @param timeOutInSeconds
	 */
	public void waitForElementLocatedByLinkText(String linkText,
			long timeOutInSeconds) {
		log.info("Waiting for the element specified by linkText '" + linkText
				+ "'");
		new WebDriverWait(castlight, timeOutInSeconds).until(ExpectedConditions
				.presenceOfElementLocated(By.linkText(linkText)));
	}

	/***********************************************************************
	 * END - Wait for element by its locator
	 * *********************************************************************/

	/**
	 * Switch to the window specified by the <code>arg0</code> target locator
	 * 
	 * @param arg0
	 */
	public void switchToWindow(String arg0) {
		castlight.switchTo().window(arg0);
	}

	/**
	 * Switch to the frame specified by the <code>arg0</code> target locator
	 * 
	 * @param arg0
	 */
	public void switchToFrame(String arg0) {
		castlight.switchTo().frame(arg0);
	}

	/**
	 * Waits until there are no more active ajax connection and until the
	 * specified <code>timeoutInSeconds</code> is timeout
	 * 
	 * @param timeoutInSeconds
	 */
	public void waitForAjax(long timeoutInSeconds) {
		log.info("Checking active ajax calls by calling jquery.active");
		try {
			if (castlight instanceof JavascriptExecutor) {
				JavascriptExecutor jsDriver = (JavascriptExecutor) castlight;

				for (int i = 0; i < timeoutInSeconds; i++) {
					Object numberOfAjaxConnections = jsDriver
							.executeScript("return jQuery.active");
					// return should be a number
					if (numberOfAjaxConnections instanceof Long) {
						Long n = (Long) numberOfAjaxConnections;
						log.info("Number of active jquery ajax calls: " + n);
						if (n.longValue() == 0L)
							break;
					}
					Thread.sleep(1000);// 1 second sleep
				}
			} else {
				log.error("Web castlight: " + castlight
						+ " cannot execute javascript");
			}
		} catch (Exception e) {
			log.error("Failed to wait for ajax response: " + e);
		}
	}

	/**
	 * Waits for a page to load for <code>timeOutInSeconds</code> number of
	 * seconds.
	 * 
	 * @param timeOutInSeconds
	 */
	public void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver castlight) {
				return ((JavascriptExecutor) castlight).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		try {
			log.info("Waiting for page to load...");
			new WebDriverWait(castlight, timeOutInSeconds).until(expectation);
		} catch (Throwable error) {
			log.error("Timeout waiting for Page Load Request to complete after "
					+ timeOutInSeconds + " seconds");
			Assert.assertFalse(true,
					"Timeout waiting for Page Load Request to complete.");
		}
	}
}
