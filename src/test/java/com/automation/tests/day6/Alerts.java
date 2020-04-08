package com.automation.tests.day6;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();//to click on the first button
        BrowserUtils.wait(3);
        //to get the text from popup message

        String popupText = driver.switchTo().alert().getText();
        System.out.println("popupText = " + popupText); //I am a JS Alert

        driver.switchTo().alert().accept(); //to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //if will fail, because there is a typo ##BUG##
        System.out.println("TEST #1");
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Expected = " + expected);
            System.out.println("Actual = " + actual);
        }
        BrowserUtils.wait(3);

        System.out.println("TEST #2");
        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss(); // result must be: You clicked: Cancel
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual:   "+actual2);
        }

        System.out.println("TEST #3");
        //Task : click on button 3
        //enter some text : Hello, World!
        //verify that result text ends with Hello, World!
        buttons.get(2).click();

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hello, World!");
        // driver.switchTo().alert().sendKeys("Hello, World!");
        driver.switchTo().alert().accept();

        String actual3 = driver.findElement(By.id("result")).getText();

        if(actual3.endsWith("Hello, World!")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Actual: "+actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}