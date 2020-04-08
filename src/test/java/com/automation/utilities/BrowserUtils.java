package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BrowserUtils {
    /**
     * Pause test for some time
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param elements represents collection of WebElements
     * @return collection of strings
     */
/*  to collect text from web element and to be able to compare as expected
    we did an example in day11 WebTable class
    The purpose of the method in BrowserUtils is to convert the List of Collections
    to WebElement in order to use the Assert method
    We created list of WebElement in our test method.
    But in assert method we need to compare two list of Strings.
    Browser utils convert our list of WebElement to list of String.
    To make life easier. */
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }
    /**
     * waits for backgrounds processes on the browser to complete
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        // wait up to page loading is completed, java script returns "complete" about page loading
        // wait for page to be loaded, it uses webDriverWait explicit wait
        // it uses javaScript code JSExecutor
        // waits for backgrounds processes on the browser to complete
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
    /**
     * Clicks on an element using JavaScript
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * @param name screenshot name
     * @return path to the screenshot
     */

    //copy file to the previously specified location
    //FileUtils class comes from java, to work with the files, general file manipulation properties
    //It stores methods to work with file
    //takes 2 argument,where is your file and where to save it
    //FileUtils.copyFile(source,destination);
    public static String getScreenshot (String name){
        // adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        //name = LocalDateTime.now() + "_" + name;

        // where we gonna store a screenshot
        String path = "";
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }
        System.out.println("OS name: "+System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);

        // since our reference type is a WebDriver
        // we cannot see methods from TakesScreenshot interface
        // that is why do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        // screenshot itself
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // where screenshot will be saved
        File destination = new File(path);
        try {
            // copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}

