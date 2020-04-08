package com.automation.homeWorks.HW4;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

/*1. go to http://practice.cybertekschool.com/dropdown
  2. verify that dropdowns under Select your date of birth display current year, month, day*/
public class TodaysDate {
    private WebDriver driver = Driver.getDriver();
    private String url = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox";

    @BeforeMethod
    public void setup(){
        driver.manage().window().maximize();
    }

    @Test (description = "Mykyta Kharchenko")
    public void todays_date(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);

        String year_value = y.getFirstSelectedOption().getText();
        String month_value = m.getFirstSelectedOption().getText();
        String day_value = d.getFirstSelectedOption().getText();

        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");
        Assert.assertEquals(year_value+month_value+day_value,sf.format(new Date()));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
