package com.peterwkc.Step_Definitions;

import java.io.IOException;
import java.util.logging.Level;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;
import com.peterwkc.Pages.Login_Pages;
import com.peterwkc.Runner.TestRunner;

import cucumber.api.Scenario;

import com.peterwkc.Manager.ExtentManager;
import com.peterwkc.Manager.LogManager;
import com.peterwkc.Manager.PropertiesManager;
import com.peterwkc.Manager.WebDriverManager;
import com.peterwkc.Utils.CaptureScreenshot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//@QAFTestStepProvider()
public class Login {
	private Login_Pages loginPages; 
	
	public Login() {
	}

	@Before
	public void setUp() {
		loginPages = PageFactory.initElements(TestRunner.webDriverMgr.getDriver(), Login_Pages.class);
	}
	
	@Given("^PHP Travel Home Page opens in browser$")
	public void loadPage() {
		try {
			loginPages.navigate();
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}

	@When("^I login to PHP Travel with Username and Password$")
	public void login() {
		try {
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
	}

	@Then("^Page navigate to PHP Travel Home Page$")
	public void navigatePage() {
		try {
			
		} catch (Exception ex) {
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}

	}
	
	@After
	public void tearDown(Scenario scen) {
		
	}
	
	// ============================================================================================

	
	/*  Selenium Tutorial - https://www.seleniumhq.org/docs/index.jsp
	 * 
	 *  https://www.swtestacademy.com/selenium-webdriver-api/
	 * 
	 *  Explicit Wait
	 *  WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ID")));
		
		WaitForElementVisible
		WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));
		
		Wait Until Clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
		
		Wait Until Disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divProgress")));
		
		Wait Until Presence
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  		.until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
		
		wait.until(ExpectedConditions.alertIsPresent());

		Custom Expected Condition
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(...).getText().length() != 0;
            }
        });
        
        Custom ExpectedCondition
        private class ElementContainsText implements ExpectedCondition<Boolean> { };
        
        
        Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Fluent Wait
        maximum amount of time to wait for a condition and specifies an interval period to check that status

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		
		.withTimeout(10, TimeUnit.SECONDS) 
		.pollingEvery(500, TimeUnit.MILLISECONDS) 
		.ignoring(NoSuchElementException.class);
		.withMessage("Timeout! Waited for 10 seconds.");
        
        
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
 		// It should poll webelement after every single second
 
        wait.pollingEvery(1, TimeUnit.SECONDS);
        
             
                
		// ----------------------------------------------------------------------------------------
		Drag and Drop
		// Create object of actions class
		Actions act=new Actions(driver);
		
		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
		
		// find element which we need to drop
		WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
		
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		
		Move Element
		WebElement element1 = driver.findElement(By.id("element1"));
		WebElement element2 = driver.findElement(By.id("element2"));
		 
		Actions actions = new Actions(driver);
		 
		actions.clickAndHold(element1).moveToElement(element2).release().perform();
		
		
		Double Click 
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/div/table/tbody/tr[10]/td[1]"))).doubleClick().perform()
		
		Actions action = new Actions(driver);
		WebElement element=driver.findElement(By.linkText("TEST"));
		
		//Double click
		action.doubleClick(element).perform();
		
		//Mouse over
		action.moveToElement(element).perform();
		
		//Right Click
		action.contextClick(element).perform();
		
		// ----------------------------------------------------------------------------------------------------
		
		Select Drop Down By Text
		Select dropdown = new Select(driver.findElement(By.id("identifier")));
		dropdown.selectByVisibleText("Programmer ");
		dropdown.selectByIndex(4);
		dropdown.selectByValue(“5”);
		
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		
		ele.getAttribute("innerHTML").contains("JavaScript"))
		
		Multi Select Check Box
		List<WebElement> elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
		elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
    	elements.get(i).click();
    
    	// ----------------------------------------------------------------------------------------------------- 
		Assert
		WebElement rxBtn = driver.findElement(By.className("icon-rx"));
    	WebElement otcBtn = driver.findElement(By.className("icon-otc"));
    	WebElement herbBtn = driver.findElement(By.className("icon-herb"));

	    Assert.assertEquals(true, rxBtn.isDisplayed());
	    Assert.assertEquals(true, otcBtn.isDisplayed());
	    Assert.assertEquals(true, herbBtn.isDisplayed());
		
		
		Alert Dialog
		Alert alert = driver.switchTo().alert();
        alert.accept();
		
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();		
		driver.switchTo().alert().sendKeys("Text");
		
		// -----------------------------------------------------------------------------------------------------
		
		File Upload
		WebElement fileInput = driver.findElement(By.name("uploadfile"));
		fileInput.sendKeys("C:\\path\\to\\file.jpg");
		
		
		Click on Calendar
		driver.findElement(By.id("datepicker")).click();		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele:allDates) {
			String date=ele.getText();
			if(date.equalsIgnoreCase("28")){
				ele.click();
				break;
			}
		}
		
		// -----------------------------------------------------------------------------------------------------
		
		Cookies API 
		Interact and Query with Cookies
		driver.manage
		
		.getCookies() – returns the list of all cookies
		.getCookieNamed(“cookie name”) – returns specific cookie according to its name
		.addCookie(“cookie”) – creates and adds a cookie
		.deleteCookie(“cookie”) – deletes specific cookie
		.deleteCookieName(“cookie name”) – deletes specific cookie according to its name
		.deleteAllCookies – delete all the cookies
		
		Cookie newCookie = new Cookie.Builder("myCookie","my value") //Name & value pair of the cookie (mandatory fields)
                                 .domain("www.swtestacademy.com") //Domain of the cookie
                                 .path("/") //Path of the cookie
                                 .expiresOn(tomorrow) //Expiration date
                                 .isSecure(true) //Is it secure or not?
                                 .build(); //Finally build it with 		
				
				
		
		java.awt.Robot;
		
		Scroll Page using javascript
		org.openqa.selenium.JavascriptExecutor
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		executeAsyncScript 
		
		Alert Pop window
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("alert('SW Test Academy!');");
		driver.switchTo().alert().accept();
		
		Get Page Title
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		assertThat(driver.getTitle(), is(title));
		
		Refresh Browser Window
		WebElement element = driver.findElement(By.xpath("//*[text()[contains(.,'JavaScript for DoExponent')]]"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);

		
		Hide and Show ElementJava
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Hide an element
		js.executeScript("document.getElementsByName('five')[0].style.display='none'");
		//Show an element
		js.executeScript("document.getElementsByName('five')[0].style.display='block'");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Hide an element
		js.executeScript("document.getElementsByName('five')[0].style.display='none'");
		//Show an element
		js.executeScript("document.getElementsByName('five')[0].style.display='block'");
		
		
		
		
		Handle Untrusted Certificate - Chrome
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriver driver=new ChromeDriver(cap);
		
		
		
		
		moveToElement(WebElement)-- Mouse Hover
		contextClick()-- Right click on page
		Actions act=new Actions(driver);
		act.contextClick(driver.findElement(By.linkText(“Gujarati”))).perform();

		contextClick(WebElement)-- Right click on specific Element
		sendKeys(KEYS.TAB)--For keyboard events
		act.contextClick(driver.findElement(By.linkText("Gujarati"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		clickAndHold(WebElement)--Click on element and hold until next operation
		release() Release the current control
		

		Test Focus
		element.equals(driver.switchTo().activeElement());
		
		IFrame
		switchTo().frame(int) – Switch to a frame with its index
		switchTo().frame(“name of the frame”) – Switch to a frame with its name
		switchTo().frame (WebElement) – Switch to a frame with its web element location
		switchTo().defaultContent() – Switch back to default page
		
		Window Handle
		– driver.getWindowHandle() – We can get current window’s handle
		– driver.getWindowHandles() – We can get all windows handles
		– driver.switchTo().window(String handle) – We can switch to the target window by using its handle.
				
		
		Open New Tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		Open Multiple Window
		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
 
		while(I1.hasNext()){
		   String child_window=I1.next();
			if(!parent.equals(child_window)){
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
			}
		 
		}
		
		driver.switchTo().window(parent);
		 
		}
		
		Frame
		driver.switchTo().frames(0, "name");
		
		
		Solve Stale Exception in Selenium
		WebDriverManager.driver.navigate().refresh();
		
		Solve InvalidElementStateException
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('pass').value = 'mukeshotwani';");
		
		
		Solve WebDriverException: f.QueryInterface is not a function
		Pass protocol to navigate function
		
		Cross Browser Testing
		Remote Webdriver - Sauce Labs or Browser Stack TestingBot 
		
		Selenium Grid 2
		Hub + Nodes
		Configure through CLI or Json file
		
		CLI
		Hub
		java -jar selenium-server-standalone-3.3.1.jar -port 4455 -role hub
		
		Node
		java -jar selenium-server-standalone-3.3.1.jar -role node -hub http://192.168.1.164:4444/grid/register -port 5555
		
		
		public class SeleniumGrid {
		     WebDriver driver;
		     String baseURL, nodeURL;
		
		     @BeforeTest
		     public void setUp() throws MalformedURLException {
		         baseURL = "http://demo.guru99.com/test/guru99home/";
		         nodeURL = "http://192.168.43.223:4444/wd/hub";
		         DesiredCapabilities capability = DesiredCapabilities.chrome();
		         capability.setBrowserName("chrome");
		         capability.setPlatform(Platform.WIN10);
		         driver = new RemoteWebDriver(new URL(nodeURL), capability);
		     }
		
		     @AfterTest
		     public void afterTest() {
		         driver.quit();
		     }
		     @Test
		     public void sampleTest() {
		         driver.get(baseURL);
		         driver.get(baseURL);
		
		         if (driver.getPageSource().contains("MOBILE TESTING")) {
		             Assert.assertTrue(true, "Mobile Testing Link Found");
		         } else {
		             Assert.assertTrue(false, "Failed: Link not found");
		         }
		
		     }
		
		 }
		
		https://www.guru99.com/introduction-to-selenium-grid.html
		
		
		
		
		
		
		
		
		sauce_junit
		sauce_testng
		
		<repositories>
		    <repository>
		        <id>saucelabs-repository</id>
		        <url>https://repository-saucelabs.forge.cloudbees.com/release</url>
		        <releases>
		            <enabled>true</enabled>
		        </releases>
		        <snapshots>
		            <enabled>true</enabled>
		        </snapshots>
		    </repository>
		</repositories>
		
		public class SauceLabsTest {
		    static WebDriver driver;
		    public static final String USERNAME = "PASTE YOUR USERNAME";
		    public static final String ACCESS_KEY = "PASTE YOUR ACCESS KEY";
		    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		 
		    @BeforeClass
		    public static void setupTest() throws MalformedURLException {
		        //Desired Capabilities
		        DesiredCapabilities caps = DesiredCapabilities.firefox();
		        caps.setCapability("platform", Platform.MAC);
		        caps.setCapability("version", "44");
		        driver = new RemoteWebDriver(new URL(URL), caps);
		    }
		 
		    @Test
		    public void SauceLabsTest() {
		        //Go to www.swtestacademy.com
		        driver.get("https://www.swtestacademy.com/");
		 
		        //Check title is correct
		        assertEquals("Title is not correct!", "Software Test Academy", driver.getTitle());
		    }
		 
		    @AfterClass
		    public static void quitDriver(){
		        driver.quit();
		    }
		}

		
		https://wiki.saucelabs.com/display/DOCS/Java+Test+Setup+Example
		
		
		Chrome Options
		ChromeOptions options = new ChromeOptions();
		// set some options
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new RemoteWebDriver(dc);
		
		Firefox Profile
		FirefoxProfile fp = new FirefoxProfile();
		// set something on the profile...
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, fp);
		WebDriver driver = new RemoteWebDriver(dc);
		
		Set Proxy Programmatically
		String PROXY = "localhost:8080";
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		     .setFtpProxy(PROXY)
		     .setSslProxy(PROXY);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
		
		WebDriver driver = new ChromeDriver(cap);
		
		
		
		
		Interview Questions
		http://learn-automation.com/selenium-interview-questions-and-answers/
		
		
		
		
		
		
		Running Cucumber from CLI
		mvn test
		java -cp "/Users/jreijn/.m2/repository/info/cukes/cucumber-core/1.2.5/cucumber-core-1.2.5.jar:/Users/jreijn/.m2/repository/info/cukes/gherkin/2.12.2/gherkin-2.12.2.jar:/Users/jreijn/.m2/repository/info/cukes/cucumber-java/1.2.5/cucumber-java-1.2.5.jar:/Users/jreijn/.m2/repository/info/cukes/cucumber-jvm-deps/1.0.5/cucumber-jvm-deps-1.0.5.jar" cucumber.api.cli.Main Developer/sources/github/cucumber-jvm-extentreport/src/test/resources/cucumber/feature_one.feature

	 */
	
	/*
	 * Cucumber-jvm-java8
	 * https://github.com/AndyLPK247/cucumber-jvm-java8-example
	 * 
	 */
	
	

}
