package com.peterwkc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.peterwkc.Manager.PropertiesManager;
import com.peterwkc.Manager.WebDriverManager;
import com.peterwkc.Runner.TestRunner;
import com.peterwkc.Utils.Pause;

public class Login_Pages {
	private PropertiesManager pm;
	private WebDriver driver;
	
	public Login_Pages() {
		pm = PropertiesManager.createInstance();
		driver = TestRunner.webDriverMgr.getDriver();
	}
	
	public void navigate() {
		driver.navigate().to(pm.getProperties().getProperty("homepage")); 
		Pause.pause(5000);
	}
	
	

}
