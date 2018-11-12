package com.peterwkc.Manager;

import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {

	private OptionsManager optionsManager; 
	private ThreadLocal<WebDriver> driver; 
	private PropertiesManager pm;
	
	public WebDriverManager() {
		optionsManager = new OptionsManager();
		driver = new ThreadLocal<>();
		pm = PropertiesManager.createInstance();
	}
			
	public synchronized void createDriver(String browser) {
		try {
			if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\.\\.\\jar\\geckodriver.exe");
				driver.set(new RemoteWebDriver(new URL(pm.getProperties().getProperty("hubURL")), optionsManager.getFirefoxOptions()));
			} 
			else if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\.\\.\\jar\\chromedriver.exe");
				driver.set(new RemoteWebDriver(new URL(pm.getProperties().getProperty("hubURL")), optionsManager.getChromeOptions()));
			} 
			else if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver", ".\\.\\.\\jar\\IEDriverServer.exe");
				driver.set(new RemoteWebDriver(new URL(pm.getProperties().getProperty("hubURL")), optionsManager.getIEOptions()));
			}
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}
	
	public synchronized void tearDown() {
		try {
			driver.get().close();
			driver.get().quit();
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}
	
	public synchronized WebDriver getDriver() {
        return driver.get();
    }
	
}

// ================================================================================================

/*
 * https://github.com/bonigarcia/webdrivermanager
 * 
 * 
 * 
 */





