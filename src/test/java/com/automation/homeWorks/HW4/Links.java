package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Links {
    private WebDriver driver = Driver.getDriver();
    private String url = "https://www.w3schools.com/";

    @BeforeClass
    public void start(){
        driver.get(url);
        BrowserUtils.wait(3);
    }
    @Test
    public void test() {
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        for (WebElement element:elementList) {
            if (element.isDisplayed()){
                System.out.println(element.getText().trim());
                System.out.println(element.getAttribute("href").trim());
            }
        }
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
