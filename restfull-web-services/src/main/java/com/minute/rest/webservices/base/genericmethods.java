package com.minute.rest.webservices.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.minute.rest.webservices.callers.ConfigCaller;
import com.minute.rest.webservices.configurations.VpnConfig;
import com.minute.rest.webservices.utilities.MyLogger;
import com.minute.rest.webservices.utilities.SystemUtility;
import com.minute.rest.webservices.utilities.UseLogger;

public class genericmethods {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected WebDriver gmDriver;

	public genericmethods(WebDriver wd) {
		gmDriver = wd;
	}

	/**
	 * adding screenshot Auth: Grace T
	 */
	public void screenShot() {

		File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			// FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
			FileUtils.copyFile(scrFile, new File("/usr/recordedpict"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Take screenshot on failure Auth: Grace T
	 */

	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		try {
			String path;
			if (testResult.getStatus() == ITestResult.FAILURE) {
				File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
				path = "./screenshoots/failures/errorScreenshots" + SystemUtility.getCurrentDateTimeWithDat()
						+ testResult.getName() + "-" + Arrays.toString(testResult.getParameters()) + ".jpg";
				FileUtils.copyFile(scrFile, new File(path));
				// if (defaulfplatform().equals(windows())){
				// String timeStamp;
				// File screenShotName;
				// //The below method will save the screen shot in d drive with
				// name "screenshot.png"
				// timeStamp = new
				// SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				// screenShotName = new
				// File("D:\\TestingDen\\Screenshots\\"+timeStamp+".png");
				// FileUtils.copyFile(scrFile, screenShotName);
				//
				// String filePath = screenShotName.toString();
				// String paths = "<img src=\"file://" + filePath + "\"
				// alt=\"\"/>";
				// Reporter.log(paths);
				// }//TODO:: implement mac screenshot report

				// try{
				// if (defaulfplatform().equals(windows())){
				// File theDir = new File("C:\\MyTest\\FailedScreenshots\\");
				// // if the directory does not exist, create it
				// if (!theDir.exists()) {
				// System.out.println("creating directory: " +
				// theDir.getName());
				// LOGGER.info("creating directory: " + theDir.getName());
				// boolean result = false;
				//
				// try{
				// theDir.mkdir();
				// result = true;
				// }
				// catch(SecurityException se){
				// //handle it
				// }
				// if(result) {
				// System.out.println("DIR created");
				// LOGGER.info("DIR created");
				// }
				// }
				// FileUtils.copyFile(scrFile, new
				// File("C:\\MyTest\\FailedScreenshots\\"+SystemUtility.getCurrentDateTimeWithDat()+testResult.getName()
				// + "-"
				// + Arrays.toString(testResult.getParameters()) + ".jpg"));
				//
				// }else if (defaulfplatform().equals(mac())){
				// File theDir = new File("Users/Shared/Failed/Screenshots/");
				// // if the directory does not exist, create it
				// if (!theDir.exists()) {
				// System.out.println("creating directory: " +
				// theDir.getName());
				// boolean result = false;
				//
				// try{
				// theDir.mkdir();
				// result = true;
				// }
				// catch(SecurityException se){
				// //handle it
				// }
				// if(result) {
				// System.out.println("DIR created");
				// }
				// }
				// FileUtils.copyFile(scrFile, new
				// File("Users/Shared/SuccessScreenshots/"+SystemUtility.getCurrentDateTimeWithDat()+testResult.getName()
				// + "-"
				// + Arrays.toString(testResult.getParameters()) + ".jpg"));
				// }
				// }catch(IOException e){
				// LOGGER.severe("Couln't write file to server directory");
				// }

			} else if (testResult.getStatus() == ITestResult.SUCCESS) {
				File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
				path = "./screenshoots/success/successScreenshots" + SystemUtility.getCurrentDateTimeWithDat()
						+ testResult.getName() + "-" + Arrays.toString(testResult.getParameters()) + ".jpg";
				FileUtils.copyFile(scrFile, new File(path));
				// if (defaulfplatform().equals(windows())){
				// String timeStamp;
				// File screenShotName;
				// //The below method will save the screen shot in d drive with
				// name "screenshot.png"
				// timeStamp = new
				// SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				// screenShotName = new
				// File("D:\\TestingDen\\Screenshots\\"+timeStamp+".png");
				// FileUtils.copyFile(scrFile, screenShotName);
				//
				// String filePath = screenShotName.toString();
				// String paths = "<img src=\"file://" + filePath + "\"
				// alt=\"\"/>";
				// Reporter.log(paths);
				// }//TODO:: implement mac screenshot report
				// try{
				// if (defaulfplatform().equals(windows())){
				// File theDir = new File("C:\\MyTest\\SuccessScreenshots\\");
				// // if the directory does not exist, create it
				// if (!theDir.exists()) {
				// System.out.println("creating directory: " +
				// theDir.getName());
				// LOGGER.info("creating directory: " + theDir.getName());
				// boolean result = false;
				//
				// try{
				// theDir.mkdir();
				// result = true;
				// }
				// catch(SecurityException se){
				// //handle it
				// }
				// if(result) {
				// System.out.println("DIR created");
				// LOGGER.info("DIR created");
				// }
				// }
				// FileUtils.copyFile(scrFile, new
				// File("C:\\MyTest\\SuccessScreenshots\\"+SystemUtility.getCurrentDateTimeWithDat()+testResult.getName()
				// + "-"
				// + Arrays.toString(testResult.getParameters()) + ".jpg"));
				//
				// }else if (defaulfplatform().equals(mac())){
				// File theDir = new File("Users/Shared/");
				// // if the directory does not exist, create it
				// if (!theDir.exists()) {
				// System.out.println("creating directory: " +
				// theDir.getName());
				// boolean result = false;
				//
				// try{
				// theDir.mkdir();
				// result = true;
				// }
				// catch(SecurityException se){
				// //handle it
				// }
				// if(result) {
				// System.out.println("DIR created");
				// }
				// }
				// FileUtils.copyFile(scrFile, new
				// File("Users/Shared/SuccessScreenshots/"+SystemUtility.getCurrentDateTimeWithDat()+testResult.getName()
				// + "-"
				// + Arrays.toString(testResult.getParameters()) + ".jpg"));
				//
				// }
				// }catch(IOException e){
				// LOGGER.severe("Couln't write file to server directory");
				// }
			}

			gmDriver.close();
		} catch (IOException e) {
			String path = "Failed to capture screenshot: " + e.getMessage();
			LOGGER.severe(path);
		}

	}

	public void takeScreenShotOnSuccess(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots" + SystemUtility.getCurrentDateTimeWithDat() + "\\"
					+ testResult.getName() + "-" + Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
		// Drivers.tearDown();

	}

	public void takeScreenShot(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			if (deviceName == null) {
				deviceName = "ChomeWebBrowser";
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String methodName = testResult.getName();
				if (!testResult.isSuccess()) {
					File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
					try {
						String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
								+ "/target/surefire-reports";
						File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
								+ formater.format(calendar.getTime()) + ".png");
						FileUtils.copyFile(scrFile, destFile);
						Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='"
								+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (!deviceName.isEmpty()) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String methodName = testResult.getName();
				if (!testResult.isSuccess()) {
					File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
					try {
						String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
								+ "/target/surefire-reports";
						File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
								+ formater.format(calendar.getTime()) + ".png");
						FileUtils.copyFile(scrFile, destFile);
						Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='"
								+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

		} else if (testResult.getStatus() == ITestResult.FAILURE) {

			if (deviceName.isEmpty()) {
				deviceName = "ChomeWebBrowser";
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String methodName = testResult.getName();
				if (!testResult.isSuccess()) {
					File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
					try {
						String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
								+ "/target/surefire-reports";
						File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
								+ formater.format(calendar.getTime()) + ".png");
						FileUtils.copyFile(scrFile, destFile);
						Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='"
								+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

			if (!deviceName.isEmpty()) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String methodName = testResult.getName();
				if (!testResult.isSuccess()) {
					File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
					try {
						String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
								+ "/target/surefire-reports";
						File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
								+ formater.format(calendar.getTime()) + ".png");
						FileUtils.copyFile(scrFile, destFile);
						Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='"
								+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		gmDriver.close();
	}

	public void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot) gmDriver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		screenShotName = new File("D:\\TestingDen\\Screenshots\\" + timeStamp + ".png");
		FileUtils.copyFile(scrFile, screenShotName);

		String filePath = screenShotName.toString();
		String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
		Reporter.log(path);

	}

	/**
	 * click using element Auth: Grace T Make Sure you are VPN_ENABLED under VPN
	 * when you work from home
	 */

	public void click_Xpath(String xpathValue) {

		if (VpnConfig.VPN_CONFIG.equalsIgnoreCase(VpnConfig.DISABLED)) {
			LOGGER.info("start finding xpathValue: " + xpathValue);
			WebElement element = gmDriver.findElement(By.xpath(xpathValue));
			LOGGER.info("start clicking xpathValue: " + xpathValue);
			element.click();
		} else if (VpnConfig.VPN_CONFIG.equalsIgnoreCase(VpnConfig.ENABLED)) {
			LOGGER.info("start finding xpathValue: " + xpathValue);
			WebElement element = gmDriver.findElement(By.xpath(xpathValue));
			LOGGER.info("start clicking xpathValue: " + xpathValue);
			element.click();
		}
	}

	public void click_Id(String IdValue) {
		if (VpnConfig.VPN_CONFIG.equalsIgnoreCase(VpnConfig.DISABLED)) {
			LOGGER.info("start finding Id: " + IdValue);
			WebElement element = gmDriver.findElement(By.id(IdValue));
			LOGGER.info("start clicking xpathValue: " + IdValue);
			element.click();
		} else if (VpnConfig.VPN_CONFIG.equalsIgnoreCase(VpnConfig.ENABLED)) {
			LOGGER.info("start finding Id: " + IdValue);
			WebElement element = gmDriver.findElement(By.id(IdValue));
			LOGGER.info("start clicking xpathValue: " + IdValue);
			element.click();
		}
	}
	
	public void click_Class(String classValue) {

		if (VpnConfig.VPN_CONFIG.equalsIgnoreCase(VpnConfig.DISABLED)) {
			LOGGER.info("start finding xpathValue: " + classValue);
			WebElement element = gmDriver.findElement(By.className(classValue));
			LOGGER.info("start clicking xpathValue: " + classValue);
			element.click();
		} else if (VpnConfig.VPN_CONFIG.equalsIgnoreCase(VpnConfig.ENABLED)) {
			LOGGER.info("start finding xpathValue: " + classValue);
			WebElement element = gmDriver.findElement(By.className(classValue));
			LOGGER.info("start clicking xpathValue: " + classValue);
			element.click();
		}
	}

	public void click_Css(String cssValue) {
		// wait for angular load
		LOGGER.info("start finding cssValue: " + cssValue);

		WebElement element = gmDriver.findElement(By.cssSelector(cssValue));
		LOGGER.info("start clicking cssValue: " + cssValue);
		element.click();
	}

	/**
	 * write in field using element Auth: Grace T
	 */

	public void write_Xpath(String xpathValue, String message) {

		LOGGER.info("start finding xpathValue: " + xpathValue);
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		LOGGER.info("start writing xpathValue: " + xpathValue);
		element.clear();
		element.sendKeys(message);

	}

	public void write_Css(String cssValue, String message) {
		LOGGER.info("start finding cssValue: " + cssValue);
		WebElement element = gmDriver.findElement(By.cssSelector(cssValue));
		LOGGER.info("start writing cssValue: " + cssValue);
		element.clear();
		element.sendKeys(message);

	}

	public void write_Id(String idValue, String message) {
		LOGGER.info("start finding idValue: " + idValue);
		WebElement element = gmDriver.findElement(By.id(idValue));
		LOGGER.info("start writing idValue: " + idValue);
		element.clear();
		element.sendKeys(message);
	}

	/**
	 * return text using element Auth: Grace T
	 */
	public String txt_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		String myText = element.getText();
		LOGGER.info("returning text " + myText);
		return myText;
	}

	public String txt_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		WebElement element = gmDriver.findElement(By.cssSelector(cssValue));
		String myText = element.getText();
		LOGGER.info("returning text " + myText);
		return myText;

	}

	public String txt_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		WebElement element = gmDriver.findElement(By.id(idValue));
		String myText = element.getText();
		LOGGER.info("returning text " + myText);
		return myText;
	}

	/**
	 * get text using element Auth: Grace T
	 */
	public void get_txt_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		LOGGER.info("returning text " + element);

	}

	public void get_txt_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		String element = gmDriver.findElement(By.cssSelector(cssValue)).getText();
		LOGGER.info("returning text " + element);

	}

	public void get_txt_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		String element = gmDriver.findElement(By.id(idValue)).getText();
		LOGGER.info("returning text " + element);
	}

	/**
	 * click using Key ENTER Auth: Grace T
	 */

	public void click_key_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		LOGGER.info("start clicking xpathValue: " + xpathValue);
		element.sendKeys(Keys.ENTER);

	}

	public void click_key_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		WebElement element = gmDriver.findElement(By.cssSelector(cssValue));
		LOGGER.info("start clicking cssValue: " + cssValue);
		element.sendKeys(Keys.ENTER);

	}

	public void click_key_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		WebElement element = gmDriver.findElement(By.id(idValue));
		LOGGER.info("start clicking idValue: " + idValue);
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * write in field using element and sending Key ENTER Auth: Grace T
	 */

	public void write_Key_Xpath(String xpathValue, String message) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		LOGGER.info("start writing xpathValue: " + xpathValue);
		element.clear();
		element.sendKeys(Keys.ENTER);

	}

	public void write_Key_Css(String cssValue, String message) {
		LOGGER.info("start finding cssValue: " + cssValue);
		WebElement element = gmDriver.findElement(By.cssSelector(cssValue));
		LOGGER.info("start writing cssValue: " + cssValue);
		element.clear();
		element.sendKeys(Keys.ENTER);

	}

	public void write_Key_Id(String idValue, String message) {
		LOGGER.info("start finding idValue: " + idValue);
		WebElement element = gmDriver.findElement(By.id(idValue));
		LOGGER.info("start writing idValue: " + idValue);
		element.clear();
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * Verify checkbox is checked or unchecked Auth: Grace T
	 * 
	 * @return
	 */
	// Actually used only as component method for generic method
	// Do not use for any other class unless reviewed and approved
	// Aggreed with dev team that each mackService checkbox must be checked by
	// default
	// Kept in comment functionalities to enable verify checkbox is checked in case
	// future changes..

	public void unCheck(String xpath) {
		// try {
		// boolean isChecked =
		// !gmDriver.findElement(By.xpath(xpath)).isSelected();
		// if (isChecked = true) {
		// System.out.println("true");

		click_Xpath(xpath);
		// return true;
		//
		// } else if (isChecked = false) {
		// System.out.println("check box not checked ! false");
		// }
		//
		// }catch(RuntimeException r) {
		//
		// }
		// return false;
	}

	/**
	 * Switching Driver to popup window, Selecting checkbox Auth: Grace T
	 */

	public void uncheck_Service(String xpath) {

		String parentWindowHandler = gmDriver.getWindowHandle(); // Stores parent window
		String subWindowHandler = null;

		Set<String> handles = gmDriver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		gmDriver.switchTo().window(subWindowHandler); // switch to popup window

		// Now you are in the popup window, perform necessary actions here
		unCheck(xpath);

		gmDriver.switchTo().window(parentWindowHandler); // switch back to parent window

	}

	/**
	 * Verify presence of element Auth: Grace T
	 */

	@SuppressWarnings("unused")
	public boolean is_Element_Present_id(String id) {
		try {
			gmDriver.findElement(By.id(id));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	public boolean is_Element_Present_Xpath(String xpath) {
		try {
			gmDriver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			LOGGER.warning("selenium wasn't able to see element: " + xpath);
			return false;
		}
		LOGGER.info("selenium was able to see element: " + xpath);
		return true;
	}

	@SuppressWarnings("unused")
	public boolean is_Element_Present_css(String css) {
		try {
			gmDriver.findElement(By.cssSelector(css));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public boolean is_Element_Checked_id(String id) {
		boolean isChecked;
		try {
			isChecked = gmDriver.findElement(By.id(id)).isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}
		return isChecked;
	}

	/**
	 * Verify presence of element Auth: Grace T
	 */

	@SuppressWarnings("unused")
	public boolean is_Element_Visible_id(String id) {// KWR reworked to determine if an element is displayed
		boolean isDisplayed = false;
		try {
			isDisplayed = gmDriver.findElement(By.id(id)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return isDisplayed;
	}

	@SuppressWarnings("unused")
	public boolean is_Element_Visible_Xpath(String xpath) {
		try {
			gmDriver.findElement(By.xpath(xpath)).isDisplayed();
		} catch (NoSuchElementException e) {
			LOGGER.warning("selenium wasn't able to see element: " + xpath);
			return false;
		}
		LOGGER.info("selenium was able to see element: " + xpath);
		return true;
	}

	@SuppressWarnings("unused")
	public boolean is_Element_Visible_css(String css) {
		boolean isDisplayed = false;
		try {
			isDisplayed = gmDriver.findElement(By.cssSelector(css)).isDisplayed();
		} catch (Exception e) {
			// returning false so want to kill the exception here and hence
			// assigned it a name that java won't recognize as needing raised
			LOGGER.warning("selenium wasn't able to see element: " + css);
			// return false;
			isDisplayed = false;
		}
		LOGGER.info("selenium was able to see element: " + css);
		return isDisplayed;
	}

	public boolean element_Not_Visible_css(String css) {
		try {
			gmDriver.findElement(By.cssSelector(css)).isDisplayed();
		} catch (Exception e) {
			// LOGGER.warning("selenium wasn't able to see element: " + css);
			return true;
		}
		// LOGGER.info("selenium was able to see element: " + css);
		return false;
	}

	/**
	 * soft and hard assertion Aut: Grace T
	 */

	private Assertion hardAssert = new Assertion();
	private SoftAssert softAssert = new SoftAssert();

	/**
	 * get text using element Auth: Grace T
	 */

	public String return_Txt_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		String element = gmDriver.findElement(By.xpath(xpathValue)).getText();
		LOGGER.info("end getting text through xpathValue: " + xpathValue);
		return element;

	}

	public String get_Page_Title() {

		return gmDriver.getTitle();

	}

	public CharSequence get_CharSeq_Txt_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		String element = gmDriver.findElement(By.xpath(xpathValue)).getText();
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + xpathValue);
		return element;

	}

	public CharSequence get_CharSeq_Txt_Id(String idValue) {
		// use fluentWait to allow angular to finish
		// WebDriverWait wait = new WebDriverWait(gmDriver, 30, 500);
		// wait.until(ExpectedConditions.elementToBeClickable(By.id(idValue)));
		LOGGER.info("start finding xpathValue: " + idValue);
		String element = gmDriver.findElement(By.id(idValue)).getText();
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + idValue);
		return element;

	}

	public void get_Txt_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		String element = gmDriver.findElement(By.xpath(xpathValue)).getText();
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + xpathValue);

	}

	public String return_Txt_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		String element = gmDriver.findElement(By.cssSelector(cssValue)).getText();
		LOGGER.info("end getting text through cssValue: " + cssValue);
		return element;

	}

	public void get_Txt_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		String element = gmDriver.findElement(By.cssSelector(cssValue)).getText();
		LOGGER.info("end getting text through cssValue: " + element);

	}

	public String return_Txt_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		String element = gmDriver.findElement(By.id(idValue)).getText();
		LOGGER.info("end getting text through idValue: " + idValue);
		return element;
	}

	public void get_Txt_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		String element = gmDriver.findElement(By.id(idValue)).getText();
		LOGGER.info("end getting text through idValue: " + element);

	}

	public void get_Tbl_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		String element = gmDriver.findElement(By.xpath(xpathValue)).getText();
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + xpathValue);

	}

	public List<WebElement> return_WebElements_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		List<WebElement> element = gmDriver.findElements(By.xpath(xpathValue));
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + xpathValue);
		return element;
	}

	public WebElement return_WebElement_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + xpathValue);
		return element;
	}

	public List<WebElement> return_WebElements_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		List<WebElement> element = gmDriver.findElements(By.cssSelector(cssValue));
		LOGGER.info("end getting text through cssValue: " + cssValue);
		return element;

	}

	public WebElement return_WebElement_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		WebElement element = gmDriver.findElement(By.cssSelector(cssValue));
		LOGGER.info("end getting text through cssValue: " + cssValue);
		return element;

	}

	public WebElement return_WebElement_Id(String idValue) {
		// WebDriverWait wait = new WebDriverWait(gmDriver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idValue)));
		LOGGER.info("Find element by Id: " + idValue);
		WebElement element = gmDriver.findElement(By.id(idValue));
		LOGGER.info("Return element foudn with Id= " + idValue);
		return element;

	}

	public void get_Tbl_Css(String cssValue) {
		LOGGER.info("start finding cssValue: " + cssValue);
		String element = gmDriver.findElement(By.cssSelector(cssValue)).getText();
		LOGGER.info("end getting text through cssValue: " + element);

	}

	public List<WebElement> return_WebElements_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		List<WebElement> element = gmDriver.findElements(By.id(idValue));
		LOGGER.info("end getting text through idValue: " + idValue);
		return element;
	}

	public void get_Tbl_Id(String idValue) {
		LOGGER.info("start finding idValue: " + idValue);
		String element = gmDriver.findElement(By.id(idValue)).getText();
		LOGGER.info("end getting text through idValue: " + element);

	}

	/**
	 * verify text contains element Auth: Grace T
	 * 
	 * @return
	 */

	public boolean contains(String element, String txt) {

		if (txt.contains(get_CharSeq_Txt_Xpath(element))) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * sleep Auth: Grace T
	 * 
	 * @return
	 */
	public void sleepAsecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("System die while sleeping");
			e.printStackTrace();
		}
	}

	public void sleepMillis(Integer sm) {
		try {
			Thread.sleep(sm);
		} catch (InterruptedException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("System die while sleeping");
			e.printStackTrace();
		}
	}

	public void sleep3second() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("System die while sleeping");
			e.printStackTrace();
		}
	}

	public void sleep5second() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("System die while sleeping");
			e.printStackTrace();
		}
	}

	public void sleep10second() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("System die while sleeping");
			e.printStackTrace();
		}
	}

	public void waitForJavascript(int maxWaitMillis, int pollDelimiter, String prevState) {
		LOGGER.setLevel(Level.INFO);
		double startTime = System.currentTimeMillis();
		double millisCount = 0;
		// LOGGER.info("Wait time in millis: "+millisCount);
		while (System.currentTimeMillis() < startTime + maxWaitMillis) {
			try {
				Thread.sleep(pollDelimiter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				LOGGER.severe("System die while sleeping");
				e.printStackTrace();
			}
			if (waitForPageLoad()) {// KWR reworked to used wait for page load 01/09/2018
				// LOGGER.info("Millis waited: "+millisCount);
				return;
			}
			millisCount++;
		}
	}

	public boolean waitForPageLoad() {
		LOGGER.setLevel(Level.INFO);
		return "complete".equals(((JavascriptExecutor) gmDriver).executeScript("return document.readyState"));
	}

	/**
	 * selecting random emulator from an array Auth: Grace T
	 */

	public String[] arr = {};
	public String deviceName;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setLaptoparray(String[] laptoparray) {
		arr = laptoparray;
	}

	public String[] getLaptoparray() {
		return arr;
	}

	public String select_Random_From_Array(String[] items) {
		setLaptoparray(items);

		int arrayFound = new Random().nextInt(arr.length);
		String a = Arrays.toString(getLaptoparray());
		List<String> myList = new ArrayList<String>(Arrays.asList(a.split(",")));
		System.out.println("Executing script using: " + myList.get(arrayFound));
		LOGGER.info("Found " + myList.get(arrayFound));

		// system should not select the same index for two different runs

		if (myList.get(arrayFound).equals(deviceName)) {

			if (arrayFound >= 1) {
				arrayFound--;
				String a1 = Arrays.toString(getLaptoparray());
				List<String> myList1 = new ArrayList<String>(Arrays.asList(a1.split(",")));
				System.out.println("Executing script using: " + myList1.get(arrayFound));
				LOGGER.info("Found " + myList1.get(arrayFound));
				setDeviceName(myList1.get(arrayFound));
			}

			if (arrayFound < 1) {

				arrayFound++;
				;
				String a1 = Arrays.toString(getLaptoparray());
				List<String> myList1 = new ArrayList<String>(Arrays.asList(a1.split(",")));
				System.out.println("Executing script using: " + myList1.get(arrayFound));
				LOGGER.info("Found " + myList1.get(arrayFound));
				setDeviceName(myList1.get(arrayFound));

			}

		} else {
			setDeviceName(myList.get(arrayFound));
		}

		return arr[new Random().nextInt(arr.length)];
	}

	public void scroll_TO_Element_To_Be_Visible_Or_Clickable_id(String idValue) {
		WebElement element = gmDriver.findElement(By.id(idValue));

		Actions actions = new Actions(gmDriver);

		actions.moveToElement(element).click().perform();
	}

	/**
	 * A. if u want to scroll to the bottom of the page | Auth: Grace T
	 */

	public void scrool_To_Bottom_Of_Page() {
		((JavascriptExecutor) gmDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * B. if u want to scroll to a specific element then try this | Auth: Grace T
	 * make sure you keep the argument as 0
	 */

	public void scrool_To_Element_Xpath(String xpathValue) {
		WebElement element = gmDriver.findElement(By.xpath(xpathValue));
		((JavascriptExecutor) gmDriver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrool_To_Element_id(String id) {
		WebElement element = gmDriver.findElement(By.id(id));
		((JavascriptExecutor) gmDriver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrool_To_Element_css(String selector) {
		WebElement element = gmDriver.findElement(By.cssSelector(selector));
		((JavascriptExecutor) gmDriver).executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * C. if u wan to scroll on the basis of coordinates then try this | Auth: Grace
	 * T make sure you copy this code and do not use the bellow as the javascript
	 * couldn't be param for now. Or please params this method and notify the team
	 */
	public void scrool_To_Element_Using_Cordinate_Xpath() {
		((JavascriptExecutor) gmDriver).executeScript("window.scrollBy(0,500)");
	}

	/**
	 * D. Case where you want to click on a element that is not in view of the page
	 * (without scrolling) try below | Auth: Grace couldn't be param for window
	 * cordinate. Or please params this method and notify the team
	 */

	public void scrool_To_Element_And_Click_Using_Xpath(String xpath, String text) {
		// Take everything on the page in list first .
		List<WebElement> completecalContent = gmDriver.findElements(By.xpath(xpath));
		System.out.println(completecalContent.size());
		// printing all elements
		for (int i = 0; i < completecalContent.size(); i++) {
			System.out.println("Print complete Content : " + completecalContent.get(i).getText());
			if (completecalContent.get(i).getText().equals("Apple iPhone 5S (Space Grey, 16 GB)")) {
				// move to a specific element
				((JavascriptExecutor) gmDriver).executeScript("arguments[0].scrollIntoView();",
						completecalContent.get(completecalContent.size() - 1));
				// move slightly up as blue header comes in the picture
				((JavascriptExecutor) gmDriver).executeScript("window.scrollBy(0,-100)");
				// then click on the element
				completecalContent.get(i).click();
			}
		}
	}

	public void scrool_To_Element_And_Click_Using_id(String id, String text) {
		// Take everything on the page in list first .
		List<WebElement> completecalContent = gmDriver.findElements(By.id(id));
		System.out.println(completecalContent.size());
		// printing all elements
		for (int i = 0; i < completecalContent.size(); i++) {
			System.out.println("Print complete Content : " + completecalContent.get(i).getText());
			if (completecalContent.get(i).getText().equals("Apple iPhone 5S (Space Grey, 16 GB)")) {
				// move to a specific element
				((JavascriptExecutor) gmDriver).executeScript("arguments[0].scrollIntoView();",
						completecalContent.get(completecalContent.size() - 1));
				// move slightly up as blue header comes in the picture
				((JavascriptExecutor) gmDriver).executeScript("window.scrollBy(0,-100)");
				// then click on the element
				completecalContent.get(i).click();
			}
		}
	}

	public boolean is_Element_Checked_Xpath(String element) {
		boolean checked = gmDriver.findElement(By.xpath(element)).isSelected();
		if (checked == true) {
			System.out.println("it's true");
			return true;
		} else {
			return false;
		}
	}

	public void check_element_box_xpath(String element) {
		boolean checked = gmDriver.findElement(By.xpath(element)).isSelected();
		if (checked == true) {
			LOGGER.info("this element is already checked");

		} else {
			click_Xpath(element);
		}
	}

	public void uncheck_element_box_xpath(String element) {
		boolean checked = gmDriver.findElement(By.xpath(element)).isSelected();
		if (checked == true) {
			click_Xpath(element);
		} else {
			LOGGER.info("this element is was not checked");

		}
	}

	public void uncheck_element_box_id(String element) {
		boolean checked = gmDriver.findElement(By.id(element)).isSelected();
		if (checked == true) {
			click_Id(element);
		} else {
			LOGGER.info("this element is was not checked");

		}
	}

	/**
	 * Function: getXYCoordinatesOfElement
	 * 
	 * @author Prashant Nayak
	 * 
	 * @param intXY
	 *            = Pass int value 1 for getting X co-ordinates & 2 for getting Y
	 *            co-ordinates
	 * @param intBy
	 *            = Pass int value 1 for getting co-ordinates by ID, 2 for getting
	 *            co-ordinates by XPath
	 * @param strElement
	 *            = if intBy value passed is 1, then pass ID of the element & if
	 *            intBy value is 2, then pass xPath of the element
	 * @return Function will return X or Y co-ordinates based on the the parameters
	 *         sent
	 */
	public int getXYCoordinatesOfElement(int intXY, int intBy, String strElement) {
		int intCoordinate;
		Point pointXY = null;
		switch (intBy) {
		case 1: // byID
			pointXY = gmDriver.findElement(By.id(strElement)).getLocation();
			break;
		case 2: // byXPath
			pointXY = gmDriver.findElement(By.xpath(strElement)).getLocation();
			break;
		}

		if (intXY == 1) {
			// return x coordinate
			intCoordinate = pointXY.getX();
		} else {
			// return Y coordinate
			intCoordinate = pointXY.getY();
		}

		return intCoordinate;

	}

	/**
	 * Function: getTagAttributeByIdentifier
	 * 
	 * Auth: Prashant Nayak
	 * 
	 * @param intOptions
	 *            = value can be 1 for byID, 2 for by XPath
	 * @param strIndentifier
	 *            = if value 1 is passed in intOptions, then we will have to pass ID
	 *            of the HTML tag as a parameter. If value of intOptions is 2, then
	 *            we will have to pass xPath of the HTML tag
	 * 
	 * @param strAttributeName
	 *            = the value that needs to be returned. If we want the value of
	 *            attribute class then pass the string"class"
	 * @return Function will return the value of the specified tag attribute
	 */
	public String getTagAttributeByIdentifier(int intOptions, String strIndentifier, String strAttributeName) {

		LOGGER.info("getTagAattributeByIdentifier() - start finding value of " + strAttributeName + " "
				+ "for identifier : " + strIndentifier + ", intOptions passed - " + intOptions);

		String strAttrValue = "";
		switch (intOptions) {
		case 1:
			strAttrValue = gmDriver.findElement(By.id(strIndentifier)).getAttribute(strAttributeName);
		case 2:
			strAttrValue = gmDriver.findElement(By.xpath(strIndentifier)).getAttribute(strAttributeName);
		}

		LOGGER.info("End of getTagAattributeByIdentifier() function");
		return strAttrValue;

	}

	public void uncheck_element_box_css(String element) {
		boolean checked = gmDriver.findElement(By.cssSelector(element)).isSelected();
		if (checked == true) {
			click_Css(element);
		} else {
			LOGGER.info("this element is was not checked");

		}
	}

	public void uncheck_or_check_element_box_xpath(String element, String uncheck_or_checkbox) {
		if (uncheck_or_checkbox.equalsIgnoreCase("check")) {
			check_element_box_xpath(element);
		} else if (uncheck_or_checkbox.equalsIgnoreCase("uncheck")) {
			uncheck_element_box_xpath(element);
		} else {
			System.out.println("parameter can only be check or unckecked");
		}
	}

	/**
	 * Replace with ocurence Auth: Grace T
	 */

	public String replaceNthOcurrence(String str, String toFind, String toReplace, int ocurrence) {
		Pattern p = Pattern.compile(Pattern.quote(toFind));
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer(str);
		int i = 0;
		while (m.find()) {
			if (++i == ocurrence) {
				sb.replace(m.start(), m.end(), toReplace);
				break;
			}
		}
		return sb.toString();
	}
	/*
	 * How to use the replaceNthOcurrence String original = "10100"; String toFind =
	 * "10"; String toReplace = "01"; int ocurrence = 2; String replaced =
	 * replaceNthOcurrence(original, toFind, toReplace, ocurrence);
	 * System.out.println(replaced); // Output: "10010"
	 * 
	 * original = "This and This and This"; toFind = "This"; toReplace = "That";
	 * ocurrence = 3; replaced = replaceNthOcurrence(original, toFind, toReplace,
	 * ocurrence); System.out.println(replaced); // Output: "This and This and That"
	 */

	public void get_page_source() {
		gmDriver.getPageSource();
	}

	public void check_element_box_css(String element) { // added on 12/28 to support automation ids
		// WebDriverWait wait = new WebDriverWait(gmDriver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
		boolean checked = gmDriver.findElement(By.cssSelector(element)).isSelected();
		if (checked == true) {
			LOGGER.info("this element is already checked");

		} else {
			click_Css(element);
		}
	}

	public void check_element_box_id(String element) { // added on 12/28 to support automation ids
		boolean checked = gmDriver.findElement(By.id(element)).isSelected();
		if (checked == true) {
			LOGGER.info("this element is already checked");

		} else {
			click_Id(element);
		}
	}



	public void pageWait(String value, String type) { // added on 12/28 to support automation ids
		WebDriverWait wait = new WebDriverWait(gmDriver, 20, 500);
		if (type.equals("id")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
		} else if (type.equals("css")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
		}

	}

	public void select_From_Dropdown_Xpath_Txt(String xpathValue, String textToSelect) {
		Select droplist = new Select(gmDriver.findElement(By.xpath(xpathValue)));
		droplist.selectByVisibleText(textToSelect);
	}

	public void select_From_Dropdown_Id_Txt(String idValue, String textToSelect) {
		Select droplist = new Select(gmDriver.findElement(By.id(idValue)));
		droplist.selectByVisibleText(textToSelect);
	}

	public void select_From_Dropdown_Xpath_Txt_Action(String xpathValue, String value, String FocusPath) {

		WebElement g = gmDriver.findElement(By.xpath(xpathValue));

		g.click();
		sleep3second();
		WebElement b = gmDriver.findElement(By.xpath(FocusPath));

		Actions actions = new Actions(gmDriver);
		actions.moveToElement(b);
		actions.click();
		actions.sendKeys(value);
		sleep3second();
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}

	/**
	 * get iframe src Auth: grace T
	 **/
	public CharSequence get_Src_Xpath(String xpathValue) {
		LOGGER.info("start finding xpathValue: " + xpathValue);
		String element = gmDriver.findElement(By.xpath(xpathValue)).getAttribute("src");
		LOGGER.info("end getting text: '" + element + "' through xpathValue: " + xpathValue);
		System.out.println(element);
		return element;

	}

	/**
	 * returns random number Auth Grace
	 **/


	

	protected int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	/**
	 * Radio check with value Auth: Grace T
	 **/
	public void radio_check_with_value(String name, String value) {
		// Find the checkbox or radio button element by Name

		List<WebElement> oCheckBox = gmDriver.findElements(By.name(name));

		// This will tell you the number of checkboxes are present

		int iSize = oCheckBox.size();

		// Start the loop from first checkbox to last checkboxe

		for (int i = 0; i < iSize; i++) {

			// Store the checkbox name to the string variable, using 'Value' attribute

			String sValue = oCheckBox.get(i).getAttribute("nameval");

			// Select the checkbox it the value of the checkbox is same what you are looking
			// for

			if (sValue.equalsIgnoreCase(value)) {

				oCheckBox.get(i).click();

				// This will take the execution out of for loop


				break;

			}

		}
	}

	/**
	 * Organized loggers Auth Grace T
	 **/
	public void build_LogFile() {
		UseLogger tester = new UseLogger();
		try {
			MyLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating the log files");
		}
		tester.doSomeThingAndLog();
	}


	/**
	 * Looping through Div Auth: Grace T
	 **/
	
	public void loop_In_Div_By_Id(String id) {
		 List<WebElement> elements = gmDriver.findElements(By.id(id));
		 for (WebElement element : elements) {
		    System.out.println(element.getText());  
		 }
	}


}
