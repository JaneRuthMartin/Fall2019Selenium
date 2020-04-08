package com.automation.tests.WarmUp;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class March22 {
    /*Go to http://practice.cybertekschool.com/tables
    Click on “Last name” column name
    Verfiy that table is sorted by last name in alphabetic order.*/
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @Test
    public void click(){
        String xpath = "//table[1]//tr[1]//th[1]";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtils.wait(3);

        List<WebElement> LastNames = driver.findElements(By.xpath("//table[1]//tr//td[1]"));
        for (WebElement LastName:LastNames
             ) {
            System.out.println(LastName);
        }
    }

    @Test
    public void lastName(){
        List<WebElement> lst=driver.findElements(By.xpath("//table[1]//tr//td[1]"));
        List<String> lastNames=BrowserUtils.getTextFromWebElements(lst);
        List<String> listSorted=lastNames;
        Collections.sort(listSorted);
        driver.findElement(By.xpath("//table[1]//span[text()='Last Name']")).click();
        Assert.assertEquals(lastNames,listSorted);

    }

    @Test
    public void isOrderedWhenClicked() {
        List<String> actual = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td[1]")).stream().map(each -> each.getText()).sorted().collect(Collectors.toList());
        driver.findElement(By.xpath("(//span[text()='Last Name'])[1]")).click();
        List<String> expected = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td[1]")).stream().map(each -> each.getText()).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }
    
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }
}
