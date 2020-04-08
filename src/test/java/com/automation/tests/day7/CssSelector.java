package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement heading = driver.findElement(By.cssSelector(".h3")); // . (dot) means class name
        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        WebElement btn1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement btn2 = driver.findElement(By.cssSelector("[name='button2']"));
        WebElement btn3 = driver.findElement(By.cssSelector("[id^='button_']"));
        WebElement btn4 = driver.findElement(By.cssSelector("[onclick='button4()']"));
        WebElement btn5 = driver.findElement(By.cssSelector("[onclick='button5()']"));
        WebElement btn6 = driver.findElement(By.cssSelector("#disappearing_button"));

        btn1.click();
        BrowserUtils.wait(2);

        btn2.click();
        BrowserUtils.wait(2);

        btn3.click();
        BrowserUtils.wait(2);

        btn4.click();
        BrowserUtils.wait(2);

        btn5.click();
        BrowserUtils.wait(2);

        btn6.click();
        BrowserUtils.wait(2);

        driver.quit();
    }
}