package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    @Test
    public void checkBoxTest(){
    driver.findElement(By.xpath("//p//a[1]")).click();
        BrowserUtils.wait(3);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//table//table//tr//td[1]"));
        BrowserUtils.wait(3);
        for (WebElement checkbox:checkboxes ) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }

    @Test
    public void updateZipCode(){
        String actual = driver.findElement(By.xpath(" //td[2][text()='Steve Johns']//following-sibling::td[7]")).getText();
        String expected = "21233";
        Assert.assertEquals(actual,expected);

        driver.findElement(By.xpath(" //td[2][text()='Steve Johns']//following-sibling::td[11]")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        String actual2 = driver.findElement(By.xpath(" //td[2][text()='Steve Johns']//following-sibling::td[7]")).getText();
        String expected2 = "20002";
        Assert.assertEquals(actual,expected);


    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
