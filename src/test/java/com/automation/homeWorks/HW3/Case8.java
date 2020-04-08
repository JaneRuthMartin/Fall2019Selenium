package com.automation.homeWorks.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case8 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
    }
    @Test
    public void TestCase8() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();

        String actual = driver.findElement(By.xpath("//p[text()='You selected: United States of America']")).getText();
        String expected = "You selected: United States of America";
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
