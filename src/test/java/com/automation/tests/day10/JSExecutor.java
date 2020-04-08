package com.automation.tests.day10;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/*Why do we need JavaScriptExecutor?
In Selenium Webdriver, locators like XPath, CSS, etc. are used to
identify and perform operations on a web page.
In case, these locators do not work you can use JavaScriptExecutor.
You can use JavaScriptExecutor to perform an desired operation on a web element.*/

//how to use javaScriptExecutor?
//javaScriptExecutor; it is an interface we can not create object out of it.
//But javascript executor and webDriver are like siblings
//So we will cast driver to JavascriptExecutor
//we convert webDriver object into JavaScriptExecutor
//JavascriptExecutor js = (JavascriptExecutor) driver;
//interface => they don't have implementation
//if you have interface as reference type you can see methods only coming from that interface
//you can not see other methods that are in other interfaces
//so we will use remoteWebDriver class as reference type :
//if you use remoteWebDriver class as reference type you do not need to cast anymore, it has everything
//like this => private RemoteWebDriver driver;
//driver.executeScript("window.scrollBy(0, 250)");
//you need to cast if your reference type is webDriver; like this =>  private WebDriver driver;
//JavascriptExecutor js = (JavascriptExecutor) driver;
public class JSExecutor {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }
}
