package com.automation.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case1_5 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
    }

    @Test
    public void testCase1(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserUtils.wait(2);
        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//small[text()='The date of birth is not valid'")).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCase2() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);
        WebElement c = driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
        WebElement java = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
        WebElement javaScript = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));

        Assert.assertTrue(c.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(javaScript.isDisplayed());
    }

    @Test
    public void testCase3() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("firstname")).sendKeys("a");
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCase4() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("lastname")).sendKeys("a");
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCase5() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("firstname")).sendKeys("Canan");
        driver.findElement(By.name("lastname")).sendKeys("Arikan");
        driver.findElement(By.name("username")).sendKeys("CananArikan");
        driver.findElement(By.name("email")).sendKeys("arikancnn@gmail.com");
        driver.findElement(By.name("password")).sendKeys("CananArikan");
        driver.findElement(By.name("phone")).sendKeys("400-000-0000");

        driver.findElement(By.xpath("//input[@value='female']")).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2001");

        Select departments = new Select(driver.findElement(By.name("department")));
        departments.selectByVisibleText("Department of Engineering");

        Select jobTitles = new Select(driver.findElement(By.name("job_title")));
        jobTitles.selectByVisibleText("SDET");

        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//h4[text()='Well done!']/following-sibling::p")).getText();
        Assert.assertEquals(actual,expected);
    }
        @AfterMethod
        public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
