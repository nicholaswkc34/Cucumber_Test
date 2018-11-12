/**
 * 
 */
package com.peterwkc.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
/**
 * @author kwong
 *
 */
public class GetFrameName {

	public GetFrameName() {
	}
	
	public static String getFrameName(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String currentFrame = (String) jsExecutor.executeScript("return self.name");
		return currentFrame;
	}

}
