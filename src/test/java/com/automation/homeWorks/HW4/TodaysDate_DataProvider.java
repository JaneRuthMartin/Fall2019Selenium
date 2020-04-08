package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.LocalDate;

    /*1. go to http://practice.cybertekschool.com/dropdown
    2. verify that dropdowns under Select your date of birth display current year, month, day*/
public class TodaysDate_DataProvider {
    private WebDriver driver;
    private String url = "http://practice.cybertekschool.com/dropdown";

    @BeforeClass
    public void start(){
        driver = DriverFactory.createDriver("chrome");
        driver.get(url);
        BrowserUtils.wait(3);
    }

    @DataProvider (name = "DropDown")
    public Object [][] testData(){
        return new Object[][] {
                {"year",    String.valueOf( LocalDate.now().getYear())        },
                {"month",   String.valueOf( LocalDate.now().getMonth())       },
                {"day",     String.valueOf( LocalDate.now().getDayOfMonth())  },
        };
    }

    @Test (dataProvider = "DropDown") // (description = "Omer Sanlialp")
    public void dayTest(String dropName, String actualData){
        String SelectedData = new Select(driver.findElement(By.id(dropName))).getFirstSelectedOption().getText().toLowerCase();
        Assert.assertEquals(actualData.toLowerCase(),SelectedData);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}














/* Before Data Provider
        Select selectedYear = new Select(driver.findElement(By.id("year")));
        String selectedyear = selectedYear.getFirstSelectedOption().getText();

        Select selectedMonth = new Select(driver.findElement(By.id("month")));
        String selectedmonth = selectedYear.getFirstSelectedOption().getText();

        Select selectedDay = new Select(driver.findElement(By.id("day")));
        String selectedday = selectedYear.getFirstSelectedOption().getText();

        String year = String.valueOf(LocalDate.now().getYear()); // int veriyor
        Assert.assertEquals(year,selectedyear);

        String month = String.valueOf(LocalDate.now().getMonth());
        Assert.assertEquals(month.toLowerCase(),selectedmonth.toLowerCase());

        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        Assert.assertEquals(day,selectedday);*/
