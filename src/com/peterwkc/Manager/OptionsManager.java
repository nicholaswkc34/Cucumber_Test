/**
 * 
 */
package com.peterwkc.Manager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;


public class OptionsManager {
	
    //Get Chrome Options
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        //options.addArguments("--incognito");
        
        //DesiredCapabilities caps = DesiredCapabilities.chrome();
        //caps.setCapability(ChromeOptions.CAPABILITY, options);
        
        return options;
        
        
        
        // new ChromeOptions()
        
        // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        /*ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeDriver driver = new ChromeDriver(service, options);*/
    }
	 
    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        
        //Use System Proxy Settings
        profile.setPreference("network.proxy.type", 5);
        /*profile.setPreference("network.proxy.http", "10.64.150.9");
        profile.setPreference("network.proxy.http_port", "8080");
        profile.setPreference("network.proxy.ssl", "10.64.150.9");
        profile.setPreference("network.proxy.ssl_port", "8080");
        profile.setPreference("network.proxy.socks", "10.64.150.9");
        profile.setPreference("network.proxy.socks_port", "8080");
        profile.setPreference("network.proxy.ftp", "10.64.150.9");
        profile.setPreference("network.proxy.ftp_port", "8080");*/
        
        
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        //options.setHeadless(true);
        
        //DesiredCapabilities caps = DesiredCapabilities.firefox();
        //caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        
        // new FirefoxOptions()
        return options;
    }
    
    // Get IE options
    public InternetExplorerOptions getIEOptions() {
    	InternetExplorerOptions options =  new InternetExplorerOptions();
    	options.enableNativeEvents();
    	options.enablePersistentHovering();
    	options.destructivelyEnsureCleanSession();
    	
    	//DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
    	//caps.setCapability("se:ieOptions", options);
    	 
    	return options;
    }
    
}
