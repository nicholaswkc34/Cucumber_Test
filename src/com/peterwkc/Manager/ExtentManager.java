package com.peterwkc.Manager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportFileLoc = ".\\report\\Test-Report.html";
	
	public ExtentManager() {
	}
	
	public static ExtentReports getInstance() {
        if (extent == null) {
        	createInstance();
        }
        
        return extent;
    }
	
	//Create an extent report instance
    public static ExtentReports createInstance() {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileLoc);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("vSHOC Test Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("vSHOC Test Report");
        
        extent = new ExtentReports();
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "Staging");
        extent.attachReporter(htmlReporter);

        return extent;
    }

}

// =====================================================================================================
/* cucumber-extent-reporter	
 * http://www.vimalselvam.com/cucumber-extent-reporter/
 * https://github.com/email2vimalraj/CucumberExtentReporter
 * 
 * 
 * 
 * 
 */



