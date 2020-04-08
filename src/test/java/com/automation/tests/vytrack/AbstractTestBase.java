package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
//TestBase class => we do not call any single method from this class or we do not instantiate it!
//Driver.getDriver().get(URL);
//We instantiate webDriver (=new className) in Driver class under utilities package.
//getDriver();  method will return us driver object that comes from driver class.
//call the static getDriver() method through the classNAme
//By doing this; we will know that we are always calling the same driver

/*Configuration Properties file => store credentials connection url's info about servers
POM => store locators
keep elements inside class not in properties
you have to always keep check what is the keyname to use that locator, not convenient*/

/*so when you create a page class are you storing all the WebElement locators as variables,
and then have basic navigation methods built in as well that you can call upon? Yes*/


public class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    @Parameters ("reportName")
    public void setupTest(){
        report = new ExtentReports();
        // for Mac this is one line enough
        // String reportPath = System.getProperty("user.dir")+"/test-output/report.html";
        String reportPath = "";
        // location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        // is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        // add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void afterTest(){
        report.flush(); // to release a report
    }

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),25);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        // ITestResult class describes the result of a test.
        // if test failed, take a screenshot
        // no failure - no screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            // screenshot will have name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); // attach test name that failed
            BrowserUtils.wait(3);
            test.addScreenCaptureFromPath(screenshotPath, "Failed"); // attach screenshot
            test.fail(iTestResult.getThrowable()); // attach console output
        }
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }
}
