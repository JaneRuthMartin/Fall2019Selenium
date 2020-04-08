package com.automation.homeWorks.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case7 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
    }
    @Test
    public void TestCase7() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/cananarikan/Desktop/Screen Shot 2020-03-19 at 7.54.37 PM.png");
        driver.findElement(By.id("file-submit")).click();
        String actual = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        String expected = "File Uploaded!";
        Assert.assertEquals(actual,expected);
        driver.findElement(By.id("uploaded-files")).isDisplayed();
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
