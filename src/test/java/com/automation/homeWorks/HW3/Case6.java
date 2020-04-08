package com.automation.homeWorks.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case6 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
    }

    @Test
    public void TestCase6(){
        driver.get("https://www.tempmailaddress.com/");
        driver.findElement(By.xpath("//a[@class='color cetc']")).click();
        String email = driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(2);
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Jane Truth");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        String actual= driver.findElement(By.xpath("//h3[text()='Thank you for signing up. Click the button below to return to the home page.']")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected);
        BrowserUtils.wait(2);

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        BrowserUtils.wait(4);       //tbody[@id='schranka']/tr[1]/td[1]
        String actual2 = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText().trim();
        String expected2 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual2,expected2);
        BrowserUtils.wait(4);

        driver.findElement(By.className("from")).click();
        String actual3 = driver.findElement(By.id("odesilatel")).getText();
        String expected3 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual3,expected3);

        BrowserUtils.wait(2);
        String actual4 = driver.findElement(By.id("predmet")).getText();
        String expected4 = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actual4,expected4);
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
