package com.unipro.test.framework.helpers.utils;

import static  com.unipro.test.framework.helpers.utils.ApplicationLogger.log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import com.cucumber.listener.Reporter;
import com.unipro.test.framework.helpers.utils.ScrollPageUitlity;

import cucumber.api.Scenario;

public class GenericWrappers {
	public static WebDriver webDriver;
	public static WebDriverWait wait;
	public static String screenShotPath;
	public static String rcwlogpath;
	public static boolean isAppClosed;

	/**
	 * This method will start the appium server
	 * 
	 * @throws MalformedURLException
	 */
	public static void startAppiumServer() throws MalformedURLException {

		log.debug("Init of server");
		if ((webDriver == null) || (webDriver != null & !(isAppiumDriver()))) {
			try {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", properties("MobileDevice"));
				cap.setCapability("platformName", "iOS");
				cap.setCapability("platformVersion", properties("Version"));
				cap.setCapability("automationName", "XCUITest");

				if (properties("Isrealdevice").equalsIgnoreCase("Yes")) {
					// cap.setCapability(MobileCapabilityType.UDID,
					// properties("UDID"));
					cap.setCapability(MobileCapabilityType.UDID, "auto");
					cap.setCapability("bundleId", properties("Bundleid"));
				} else if (properties("IsmobileApp").equalsIgnoreCase("No")) {
					cap.setCapability(MobileCapabilityType.BROWSER_NAME,
							properties("Browser"));
					if (properties("Browser").equalsIgnoreCase("chrome"))
						cap.setCapability(MobileCapabilityType.APP,
								properties("AppPath"));
				} else if (properties("IsmobileApp").equalsIgnoreCase("Yes")) {
					cap.setCapability(MobileCapabilityType.APP,
							properties("AppPath"));
					if (properties("Reset").equalsIgnoreCase("Yes"))
						cap.setCapability("fullReset", true);
					else
						cap.setCapability("noReset", true);
				}
				cap.setCapability("noReset", true);
				cap.setCapability("webkitResponseTimeout", 5000);
				cap.setCapability("newCommandTimeout", 700000);
				cap.setCapability("autoAcceptAlerts", true);
				log.debug(cap);

				webDriver = new IOSDriver<WebElement>(new URL(
						properties("AppiumURL") + "/wd/hub"), cap);
				webDriver.manage().timeouts()
						.implicitlyWait(5, TimeUnit.SECONDS);
				log.debug("Application launched successfully");

				isAppClosed = false;

			} catch (Exception e) {
				e.printStackTrace();
				log.debug("issue in driver creation");
			}
		} else if (webDriver != null && isAppiumDriver()) {
			if (isAppClosed)
				launchApp();
		}

	}

	public static void startSimulator() throws MalformedURLException {

		log.debug("Init of server");
		if ((webDriver == null) || (webDriver != null & !(isAppiumDriver()))) {
			try {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", properties("MobileDevice"));
				cap.setCapability("platformName", "iOS");
				cap.setCapability("platformVersion", properties("SDKVersion"));
				cap.setCapability("automationName", "XCUITest");
				cap.setCapability(MobileCapabilityType.APP, new File(
						properties("AppPath")).getAbsolutePath());
				cap.setCapability("noReset", true);
				cap.setCapability("sendKeyStrategy", "oneByOne");
				cap.setCapability("webkitResponseTimeout", 5000);
				cap.setCapability("autoAcceptAlerts", true);
				cap.setCapability("noReset", true);
				cap.setCapability("newCommandTimeout", 700000);
				log.debug(cap);
				webDriver = new IOSDriver<WebElement>(new URL(
						properties("AppiumURL") + "/wd/hub"), cap);
				webDriver.manage().timeouts()
						.implicitlyWait(5, TimeUnit.SECONDS);
				log.debug("Application launched successfully");

				isAppClosed = false;

			} catch (Exception e) {
				e.printStackTrace();
				log.debug("issue in driver creation");
			}
		} else if (webDriver != null && isAppiumDriver()) {
			if (isAppClosed)
				launchApp();
		}

	}

	public static String properties(String key) {
		Properties prob = null;
		File file = new File("./BuildDetails.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prob = new Properties();
		try {
			prob.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prob.getProperty(key);
	}

	public static void launchBrowser() {
		webDriver.get(properties("SIT.URL"));
		//webDriver.get(properties("UAT.URL"));
		//webDriver.get(properties("SC.URL"));
		//webDriver.get(properties("DEV.URL"));
	}

	/**
	 * To scroll into view on given element
	 * 
	 * @author Kalyan, Raipati
	 * @since 28-Apr-2017
	 * @param element
	 *            void
	 */
	public static void scrolltoViewElement(WebElement element) {
		((JavascriptExecutor) webDriver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	public static WebElement getElementByTextWithScroll(
			List<WebElement> elements, String value) {
		WebElement returnElement = null;
		for (WebElement element : elements) {
			scrolltoViewElement(element);
			if (element.getText().contains(value)) {
				log.debug(element.getText());
				returnElement = element;
				break;
			}
		}
		return returnElement;
	}

	/**
	 * To clck on given element using java script
	 * 
	 * @author Kalyan, Raipati
	 * @since 28-Apr-2017
	 * @param element
	 *            void
	 */
	public static void jsClickOnElement(WebElement element) {
		// waitForElementToBeClickable(element, 2);
		try {
			((JavascriptExecutor) webDriver).executeScript(
					"arguments[0].click();", element);
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			jsClickOnElement(element);
		} catch (Exception e) {
			e.printStackTrace();
			element.click();
		}
	}

	public static boolean jsGetChekedValueOnElement(WebElement element) {
		boolean checked = false;
		try {
			checked = (boolean) ((JavascriptExecutor) webDriver).executeScript(
					"arguments[0].checked;", element);
			log.debug("the checked value is " + checked);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("error on chekbox");
		}
		return checked;
	}

	public static String jsGetTextoFElement(WebElement element) {
		return (String) ((JavascriptExecutor) webDriver).executeScript(
				"arguments[0].innerHTML;", element);
	}

	/**
	 * This method will capture the screen shot for the failed sceanrio and add
	 * the path to the genie report
	 * 
	 * @param scenario
	 * @author Vicky
	 * 
	 */
	public void captureScreenShotAndAddToGeneiReport(Scenario scenario) {

		String scenarioName = scenario.getName();
		if (scenario.isFailed()) {

			try {

				File scrFile = ((TakesScreenshot) webDriver)
						.getScreenshotAs(OutputType.FILE);
				String Filename = (screenShotPath + scenarioName + ".png")
						.replaceAll(" ", "_");
				System.out.println("Screen shot saved in location " + Filename);
				try {
					FileUtils.copyFile(scrFile, new File(Filename));
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Screeshot asserted in HTML " + Filename);
				sleepInMilliSeconds(2000);
				// addImageFilePath(Filename);

			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}

		}

	}

	/**
	 * This method will will close the appium and the browser
	 * 
	 * @author Kalyan, Raipati
	 */
	@SuppressWarnings("unchecked")
	public void closeAppiumAndBrowser() {
		try {

			if (webDriver instanceof AppiumDriver<?>) {
				((AppiumDriver<WebElement>) webDriver).closeApp();
			} else
				webDriver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return the webelement based on the given string
	 * parameter
	 * 
	 * @param locators
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WebElement getWebelElement(String locators) {
		WebElement ele = null;
		String[] loc = locators.split("`");
		switch (loc[0]) {
		case "ByName":
			ele = webDriver.findElement(By.name(loc[1]));
			break;
		case "FByName":
			ele = ((AppiumDriver<WebElement>) webDriver)
					.findElementByName(loc[1]);
			break;
		case "FByClassName":
			ele = ((AppiumDriver<WebElement>) webDriver)
					.findElementByClassName(loc[1]);
			break;
		case "FByXpath":
			ele = ((AppiumDriver<WebElement>) webDriver)
					.findElementByXPath(loc[1]);
			break;

		default:
			break;
		}
		return ele;
	}

	/**
	 * This method will enter the given value using keyboard action
	 * 
	 * @param key
	 * @param value
	 */
	public void enterUsingKeyBoard(Keyboard key, String value) {
		key.pressKey(value);

	}

	/**
	 * This method will wait for the presence of the element to be located
	 * 
	 * @param locator
	 */
	public void waitForpresenceOfElementLocated(By locator) {
		wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This method will wait for the presence of the element to be located
	 * 
	 * @param element
	 */
	public void waitForpresenceOfElement(WebElement element) {
		wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait for the presence of the element to be located
	 * 
	 * @param element
	 */
	public static void waitForVisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait for the presence of the element to be located
	 * returns boolean
	 * 
	 * @param element
	 * @param waitTimeInSec
	 * @return boolean
	 */
	public static boolean waitForVisibilityOfElement(WebElement element,
			int waitTimeInSec) {
		WebElement visibleElement;
		wait = new WebDriverWait(webDriver, waitTimeInSec);
		try {
			visibleElement = wait.until(ExpectedConditions
					.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return visibleElement != null ? true : false;
	}

	public static boolean waitForPageWithTitle(String title, int waitTimeInSec) {

		Boolean isOnPage;

		try {
			wait = new WebDriverWait(webDriver, waitTimeInSec);
			return wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			e.printStackTrace();
			isOnPage = false;
			// return false;
		}
		return isOnPage;
	}

	/**
	 * This method will wait for the element to be clickable returns boolean
	 * 
	 * @param element
	 * @param waitTimeInSec
	 * @return boolean
	 */
	public static boolean waitForElementToBeClickable(WebElement element,
			int waitTimeInSec) {
		WebElement visibleElement;
		wait = new WebDriverWait(webDriver, waitTimeInSec);
		try {
			visibleElement = wait.until(ExpectedConditions
					.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return visibleElement != null ? true : false;
	}

	/**
	 * Expected condition to wait for the element to invisible
	 * 
	 * @author Kalyan, Raipati
	 * @since 28-Apr-2017
	 * @param element
	 * @param waitTimeInSec
	 * @return boolean
	 */
	public static boolean waitForInVisibilityOfElement(WebElement element,
			int waitTimeInSec) {
		boolean isVisible = false;
		List<WebElement> elements = new ArrayList<>();
		elements.add(element);
		wait = new WebDriverWait(webDriver, waitTimeInSec);
		try {
			isVisible = wait.until(ExpectedConditions
					.invisibilityOfAllElements(elements));
		} catch (Exception e) {
			e.printStackTrace();
			return isVisible;
		}

		// WebDriverWait wait = new WebDriverWait(webDriver, 30);
		// Function<WebDriver, Boolean> myFunction = new Function<WebDriver,
		// Boolean>()
		// { public Boolean apply(WebDriver arg0) {
		// System.out.println("Checking for the object!!");
		// WebElement element = arg0.findElement(By.id("dynamicText"));
		// if (element != null) {
		// System.out.println("A new dynamic object is found."); } return true;
		// }};
		// wait.until(myFunction);

		return isVisible;

	}

	/**
	 * This method will wait for the invisibility of the Element located
	 * 
	 * @param locator
	 */
	public void waitForinvisiblityOfElementLocated(By locator) {
		wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	/**
	 * This method will wait for the visibility of the given cssSelector web
	 * Element
	 * 
	 * @param locator
	 */
	public void waitForvisiblityOfGivenCssselector(String locator) {
		wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By
				.cssSelector("." + locator))));

	}

	/**
	 * This method will wait for the visibility of the given WebElement
	 * 
	 * @param ele
	 */
	public void waitForvisiblityOfGivenElement(WebElement ele) {
		wait = new WebDriverWait(webDriver, 180);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	/**
	 * This method will switch From Native to WebView
	 */
	@SuppressWarnings("unchecked")
	public static void switchFromNativeToWebView() {
		if (isAppiumDriver()) {
			if (!((AppiumDriver<WebElement>) webDriver).getContext().contains(
					"NAT")) {
				return;
			}
			Set<String> AvailableContexts = ((AppiumDriver<WebElement>) webDriver)
					.getContextHandles();
			for (String context : AvailableContexts) {
				if (context.contains("WEBVIEW"))
					((AppiumDriver<WebElement>) webDriver).context(context);
			}
		}
	}

	/**
	 * This method will switch the control to the Native App
	 */
	@SuppressWarnings("unchecked")
	public static void switchToNativeApp() {

		if (isAppiumDriver()) {
			if (((AppiumDriver<WebElement>) webDriver).getContext().contains(
					"NATIVE_APP")) {
				return;
			}
			Set<String> AvailableContexts = ((AppiumDriver<?>) webDriver)
					.getContextHandles();
			for (String context : AvailableContexts) {
				// log.debug("Available context" + context);
				if (context.contains("NATIVE_APP"))
					((AppiumDriver<WebElement>) webDriver).context(context);
			}
		}
	}

	/**
	 * This method will return the webelemnt with locator ById
	 * 
	 * @param id
	 * @return
	 */
	public WebElement getWebElementById(String id) {
		return webDriver.findElement(By.id(id));
	}

	/**
	 * This method will return the webelement with locator ByXpath
	 * 
	 * @param id
	 * @return
	 */
	public WebElement getWebElementByXpath(String xpath) {
		return webDriver.findElement(By.xpath(xpath));
	}

	public void switchElementToClick(WebElement ele, String data) {
		if (data.contains("Yes")) {
			ele.click();
		}

	}

	public void selectElementFromDropdown(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);

	}

	public void enterText(WebElement ele, String data) {
		// ele.clear();
		ele.sendKeys(data);
	}

	/**
	 * Hides the keyboard in WebView
	 * 
	 * @author Kalyan, Raipati
	 * @since 30-Mar-2017 void
	 */
	public static void hideKeyboardOnWebView() {
		switchToNativeApp();
		try {
			WebElement keyboard = webDriver.findElement(By
					.name("Hide keyboard"));
			keyboard.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		switchFromNativeToWebView();
	}

	public static void waitBeforeExecute() {

		int seconds = 3;
		long start, stop;
		start = System.currentTimeMillis();
		do {
			stop = System.currentTimeMillis();
		} while ((stop - start) < seconds * 1000);
	}

	public static void sleepInSeconds(int seconds) {

		long start, stop;
		start = System.currentTimeMillis();
		do {
			stop = System.currentTimeMillis();
		} while ((stop - start) < seconds * 1000);
	}

	public static void sleepInMilliSeconds(long milliseconds) {

		long start, stop;
		start = System.currentTimeMillis();
		do {
			stop = System.currentTimeMillis();
		} while ((stop - start) < milliseconds);
	}

	public static void closeApp() {
		if (webDriver instanceof AppiumDriver)
			((AppiumDriver) GenericWrappers.webDriver).closeApp();
	}

	/**
	 * To launch application
	 * 
	 * @author Kalyan, Raipati
	 * @since 19-Apr-2017 void
	 */
	public static void launchApp() {
		if (webDriver instanceof AppiumDriver) {
			if (isAppClosed)
				((AppiumDriver) GenericWrappers.webDriver).launchApp();
		}
	}

	/**
	 * To verify the driver instance
	 * 
	 * @author Kalyan, Raipati
	 * @since 19-Apr-2017
	 * @return boolean
	 */
	public static boolean isAppiumDriver() {
		return (webDriver instanceof AppiumDriver);
	}

	/**
	 * Quits Browser
	 * 
	 * @author Kalyan, Raipati
	 * @since 30-Mar-2017 void
	 */
	public static void quitBrowser() {
		webDriver.quit();
	}

	public static void quitApp() {
		((AppiumDriver) webDriver).quit();
	}

	/**
	 * To swipe in the iPad Settings panel
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017 void
	 */
	private static void swipeInIpadSettingPanel() {

		int height = ((AppiumDriver) webDriver)
				.findElementByClassName("UIAWindow").getSize().getHeight();
		// log.debug(height);
		int width = ((AppiumDriver) webDriver)
				.findElementByClassName("UIAWindow").getSize().getWidth();
		// log.debug(height);
		((AppiumDriver) webDriver).swipe(width - 100, height, width - 100,
				height - 200, 500);
		sleepInMilliSeconds(100);
	}

	/**
	 * To swipe off the iPad Settings panel
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017 void
	 */
	private static void swipeOffIpadSettingPanel() {
		int height = ((AppiumDriver) webDriver)
				.findElementByClassName("UIAWindow").getSize().getHeight();
		int width = ((AppiumDriver) webDriver)
				.findElementByClassName("UIAWindow").getSize().getWidth();
		((AppiumDriver) webDriver).tap(1, height / 2, width / 2, 1);
		sleepInMilliSeconds(100);
	}

	/**
	 * To verify wifi is enabled
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @return boolean
	 */
	private static boolean isWifiEnabled() {
		int value = Integer.parseInt(((AppiumDriver<?>) webDriver)
				.findElementByAccessibilityId("Wi-Fi").getAttribute("value"));
		return value == 1 ? true : false;
	}

	/**
	 * To verify id wifi is enabled by swiping the settings
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @return boolean
	 */
	private boolean isIpadWifiEnabledWithSwipe() {
		swipeInIpadSettingPanel();
		int value = Integer.parseInt(((AppiumDriver<?>) webDriver)
				.findElementByAccessibilityId("Wi-Fi").getAttribute("value"));
		swipeOffIpadSettingPanel();
		return value == 1 ? true : false;
	}

	/**
	 * To turn on the wifi on iPad
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017 void
	 */
	public static void turnOnIpadWifi() {
		switchToNativeApp();
		swipeInIpadSettingPanel();
		if (!isWifiEnabled()) {
			((AppiumDriver<?>) webDriver).findElementByAccessibilityId("Wi-Fi")
					.click();
		}
		swipeOffIpadSettingPanel();
		switchFromNativeToWebView();
	}

	/**
	 * To turn off the Wifi on iPad
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017 void
	 */
	public static void turnOffIpadWifi() {
		switchToNativeApp();
		swipeInIpadSettingPanel();
		if (isWifiEnabled()) {
			((AppiumDriver<?>) webDriver).findElementByAccessibilityId("Wi-Fi")
					.click();
		}
		swipeOffIpadSettingPanel();
		switchFromNativeToWebView();
	}

	/**
	 * To verify bluetooth is enabled
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @return boolean
	 */
	private static boolean isBluetoothEnabled() {
		int value = Integer.parseInt(((AppiumDriver<?>) webDriver)
				.findElementByAccessibilityId("Bluetooth")
				.getAttribute("value"));
		return value == 1 ? true : false;
	}

	/**
	 * To verify id bluetooth is enabled by swiping the settings
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @return boolean
	 */
	private static boolean isIpadBluetoothEnabledWithSwipe() {
		swipeInIpadSettingPanel();
		int value = Integer.parseInt(((AppiumDriver<?>) webDriver)
				.findElementByAccessibilityId("Bluetooth")
				.getAttribute("value"));
		swipeOffIpadSettingPanel();
		return value == 1 ? true : false;
	}

	/**
	 * To turn on the bluetooth on iPad
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017 void
	 */
	public static void turnOnIpadBluetooth() {
		switchToNativeApp();
		swipeInIpadSettingPanel();
		if (!isBluetoothEnabled()) {
			((AppiumDriver<?>) webDriver).findElementByAccessibilityId(
					"Bluetooth").click();
		}
		swipeOffIpadSettingPanel();
		switchFromNativeToWebView();
	}

	/**
	 * To turn on the Bluetooth on iPad
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017 void
	 */
	public static void turnOffIpadBluetooth() {
		switchToNativeApp();
		swipeInIpadSettingPanel();
		if (isBluetoothEnabled()) {
			((AppiumDriver<?>) webDriver).findElementByAccessibilityId(
					"Bluetooth").click();
		}
		swipeOffIpadSettingPanel();
		switchFromNativeToWebView();
	}

	/**
	 * Use to get WebElement from List of WebElements by its tag text
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @param elements
	 * @param value
	 * @return WebElement
	 */
	public static WebElement getElementByText(List<WebElement> elements,
			String value) {
		//GenericWrappers.sleepInSeconds(2);
		GenericWrappers.sleepInMilliSeconds(100);
		WebElement returnElement = null;
		for (WebElement element : elements) {
			//log.info(element.getText().toLowerCase());
			if (element.getText().toLowerCase().contains(value.toLowerCase())) {  // commented as LOV selection happening as "British Indian Ocean Territory" in iPad
			//if (element.getText().toLowerCase().equalsIgnoreCase(value.toLowerCase())) {
				returnElement = element;
				break;
			}
		}
		return returnElement;
	}

	public static WebElement getLOVElementByText(String value, WebElement ele) {
		WebElement returnElement = null;
		for (WebElement element : ele
				.findElements(By
				// .cssSelector(".ui-select-choices-row-inner"))) {
				// .xpath(".//div[@class='option']"))){
						.xpath("./../following-sibling::*//div[contains(@class,'option')]"))) {
			if (element.getText().toLowerCase().contains(value.toLowerCase())) {
				returnElement = element;
				break;
			}
		}
		return returnElement;
	}

	/**
	 * To get child element using locator
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @param element
	 * @param locator
	 * @return WebElement
	 */
	public static WebElement getChildByLocator(WebElement element, By locator) {
		return element.findElement(locator);
	}

	/**
	 * To get the tag Text of all the elements
	 * 
	 * @author Kalyan, Raipati
	 * @since 27-Apr-2017
	 * @param elements
	 * @return List<String>
	 */
	public static List<String> getTextOfAllElements(List<WebElement> elements) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			textList.add(element.getText().trim());
		}
		return textList;
	}

	/**
	 * Launch Driver based on browser paramaeter passed
	 * 
	 * @param browser
	 * @throws MalformedURLException
	 */
	public static void setDriver(String driver) throws MalformedURLException {

		switch (driver) {
		case "Chrome":
			String osName = System.getProperty("os.name");
			String chromeDriverStr = "webdriver.chrome.driver";
			log.debug("Operating System > " + osName);
			switch (osName) {
			case "Linux":
				System.setProperty(chromeDriverStr, properties("Chrome.linux"));
				log.debug("Operating System inside Linux Switch Case> "
						+ properties("Chrome.linux"));
				break;
			case "Mac OS X":
				System.setProperty(chromeDriverStr, properties("Chrome.mac"));
				break;
			default:
				System.setProperty(chromeDriverStr,
						properties("Chrome.windows"));
				break;
			}
			ChromeOptions options = new ChromeOptions();

			// options.addArguments("--window-size=1280,800");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			options.addArguments("disable-extensions");
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("chrome.switches", "--disable-extensions");
			options.addArguments("--test-type");
			options.addArguments("disable-infobars");
			if (System.getProperty("isHeadless") != null
					&& Boolean.parseBoolean(System.getProperty("isHeadless"))) {
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
			}
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
					UnexpectedAlertBehaviour.ACCEPT);
			webDriver = new ChromeDriver(cap);
			log.debug("Web Driver Initialsation" + webDriver);
			break;

		case "Safari":
			webDriver = new SafariDriver();
		case "iPad":
			startAppiumServer();
			break;
		case "iPadSimulator":
			startSimulator();
			break;

		default:
			break;
		}

	}

	public static boolean isNotEmpty(String s) {
		return Objects.nonNull(s) && !s.isEmpty();
	}

	public static Dimension getWindowDimention() {
		return webDriver.manage().window().getSize();
	}

	public static Dimension getElementDimention(WebElement element) {
		return element.getSize();
	}

	public static String getCheckboxValueOnElement(WebElement element) {
		return element.isSelected() ? "Yes" : "No";
	}

	public static String getFilePathOfScreenShot() {

		// if (Objects.isNull(extentReportFolder))
		// setScreenshotPath();

		String fileName = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-SSSa")
				.format(new Date());
		File scrFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);

		String filename = screenShotPath;
		filename = filename + "/" + fileName.replaceAll(" ", "_") + ".png";
		String fileNameReport = fileName.replaceAll(" ", "_") + ".png";

		log.debug(fileNameReport);
		log.debug(filename);
		try {
			FileUtils.copyFile(scrFile, new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileNameReport = Boolean.parseBoolean(GenericWrappers
				.properties("EnableExtentx")) ? filename : fileNameReport;
		return fileNameReport;
	}

	public static void takeScreenShotAndAddtoExtentReport(boolean isFullPage) {

		try {
			if ("Yes".equalsIgnoreCase(properties("EnableScreenShot"))) {
				if (isFullPage) {
					ScrollPageUitlity.scrollByPageAndTakeScreenShot();
				} else {
					// Reporter.addScreenCaptureFromPath(getFilePathOfScreenShot());
					Reporter.addScreenCaptureFromPath(getFilePathOfScreenShot());
				}
			}
		} catch (IOException e) {
			log.error("Issue in adding screenshot");
			e.printStackTrace();
		}

	}

	public static void takeScreenShotAndAddtoExtentReport() {

		try {
			if ("Yes".equalsIgnoreCase(properties("EnableScreenShot"))) {
				Reporter.addScreenCaptureFromPath(getFilePathOfScreenShot());
			}

		} catch (IOException e) {
			log.error("Issue in adding screenshot");
			e.printStackTrace();
		}

	}

	public static void takeScreenShotAndAddtoExtentReport(WebElement element) {

		if ("Yes".equalsIgnoreCase(properties("EnableScreenShot"))) {
			ScrollPageUitlity.scrollByPageAndTakeScreenShot(element);
			;
		}

	}

	public static String getReportPath() {

		String reportDate = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-SSS-a")
				.format(new Date());

		screenShotPath = "reports/" + reportDate;
		String reportPath = "reports/" + reportDate
				+ "/RTOBAutomationReport.html";

		return reportPath;

	}

	public static String getFullPageScreenshotPath() {

		Screenshot scrFile = new AShot().shootingStrategy(
				ShootingStrategies.viewportRetina(500, 0, 0, 2))
				.takeScreenshot(webDriver);
		String fileName = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-SSSa")
				.format(new Date());
		String filename = screenShotPath;
		filename = filename + "/" + fileName.replaceAll(" ", "_") + ".png";
		String fileNameReport = fileName.replaceAll(" ", "_") + ".png";

		log.debug(fileNameReport);
		log.debug(filename);
		try {
			ImageIO.write(scrFile.getImage(), "PNG", new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNameReport;
	}

	public static String getFullPageScreenshotPath(WebElement element) {
		Screenshot scrFile = null;
		scrFile = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.shootingStrategy(
						ShootingStrategies.viewportRetina(5000, 0, 0, 2))
				.takeScreenshot(webDriver, element);

		String fileName = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-SSSa")
				.format(new Date());
		String filename = screenShotPath;
		filename = filename + "/" + fileName.replaceAll(" ", "_") + ".png";
		String fileNameReport = fileName.replaceAll(" ", "_") + ".png";

		log.debug(fileNameReport);
		log.debug(filename);
		try {
			ImageIO.write(scrFile.getImage(), "PNG", new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileNameReport = Boolean.parseBoolean(GenericWrappers
				.properties("EnableExtentx")) ? filename : fileNameReport;
		return fileNameReport;
	}

	public static void setStartTime() {
		System.setProperty("current.date.time", new SimpleDateFormat(
				"dd-MM-yyyy-hh-mm-ssa").format(new Date()));
	}

	public static boolean isPresentAndDisplayed(final WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static void sendKeysOnMobile(String keysToSend) {
		((AppiumDriver<WebElement>) GenericWrappers.webDriver).getKeyboard()
				.sendKeys(keysToSend);
	}

	public static void seconds(int i) {
		// TODO Auto-generated method stub

	}

	public static void drawOnCanvas(WebElement element) {
		// Actions builder = new Actions(webDriver);
		// builder.moveToElement(element, 135, 15) // start point in the canvas
		// .click().moveByOffset(200, 60) // second point
		// .click().moveByOffset(100, 70) // third point
		// .doubleClick().build().perform();

		TouchAction action = new TouchAction(
				(AppiumDriver<WebElement>) webDriver);
		action.longPress(element, 135, 15).waitAction(10).moveTo(100, 70)
				.release().perform();

	}

	public static void drawOnCanvas(String xpath) {
		MobileElement element = (MobileElement) GenericWrappers.webDriver
				.findElement(By.xpath(xpath));
		TouchAction t = new TouchAction(
				(AppiumDriver<MobileElement>) GenericWrappers.webDriver);
		t.press(element).moveTo(10, 10).release().perform();

	}
	
	public static String getProductName(WebElement product)
	{
		String productName;
		String xpathProductName = "./../../preceding-sibling::td/span";
		productName = product.findElement(By.xpath(xpathProductName)).getText();
		return productName;
	}
	
	public static WebElement getApplyBtnFromProductName(WebElement productName)
	{
		WebElement ApplyBtn;
		String xpathProductApplyBtn = "./../following-sibling::td/span/input";
		ApplyBtn = productName.findElement(By.xpath(xpathProductApplyBtn));
		return ApplyBtn;
	}
}
