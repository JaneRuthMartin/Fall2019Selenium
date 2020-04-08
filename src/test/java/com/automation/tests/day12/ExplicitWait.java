package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//until method returns webElement so we can send keys immediately.
public class ExplicitWait {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }
    @Test
    public void waitForTitle(){
        driver.get("https://google.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleContains("Google"));

        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));
    }

    public void waitForVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.name("button[type='submit'"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}