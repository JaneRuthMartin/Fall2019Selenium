package com.automation.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Case9_12 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
    }
    @Test(description = "Verify message", dataProvider = "testData")
    public void TestCase8(String StatusCodes, String expected ) {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath(StatusCodes)).click();

        int location = driver.findElement(By.xpath("//p")).getText().indexOf(".");
        String actual = driver.findElement(By.xpath("//p")).getText().substring(0,location);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider (name = "testData")
    public Object [][] testData(){
        return new Object[][]{  {"//a[text()='200']","This page returned a 200 status code"},
                                {"//a[text()='301']","This page returned a 301 status code"},
                                {"//a[text()='404']","This page returned a 404 status code"},
                                {"//a[text()='500']","This page returned a 500 status code"},
        };
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
