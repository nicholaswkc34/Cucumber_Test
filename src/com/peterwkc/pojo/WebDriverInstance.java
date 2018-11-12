package com.peterwkc.pojo;

import com.peterwkc.Manager.WebDriverManager;

public class WebDriverInstance {
	
	public static WebDriverManager chromeWebDriverMgr;
	public static WebDriverManager firefoxWebDriverMgr;

	public WebDriverInstance() {
	}
	
	public static WebDriverManager getChromeWebDriverMgr() {
		return chromeWebDriverMgr;
	}

	public static void setChromeWebDriverMgr(WebDriverManager chromeWebDriverMgr) {
		WebDriverInstance.chromeWebDriverMgr = chromeWebDriverMgr;
	}

	public static WebDriverManager getFirefoxWebDriverMgr() {
		return firefoxWebDriverMgr;
	}

	public static void setFirefoxWebDriverMgr(WebDriverManager firefoxWebDriverMgr) {
		WebDriverInstance.firefoxWebDriverMgr = firefoxWebDriverMgr;
	}

}
