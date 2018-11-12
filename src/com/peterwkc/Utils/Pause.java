package com.peterwkc.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Pause {

	public Pause() {
	}
	
	public static void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void implicitWait(WebDriver driver, int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception ex) {
			
		}
	}

}
