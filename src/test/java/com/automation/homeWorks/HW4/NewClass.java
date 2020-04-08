package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewClass {
    private WebDriver driver = Driver.getDriver();
    private String url = "https://www.w3schools.com/";

    @BeforeClass
    public void start(){
        driver.get(url);
        BrowserUtils.wait(3);
    }
    @Test
    public void test() {

    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }
}
