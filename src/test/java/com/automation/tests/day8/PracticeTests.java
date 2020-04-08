package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Create a class called PracticeTests
 *
 * - setup before/after methods
 *     - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 *     - in after method - just close webdriver.
 *
 * - create a test called loginTest
 *     - go to "Form Authentication" page
 *     - enter valid credentials
 *        username: tomsmith
 *        password: SuperSecretPassword
 *
 *     - verify that following sub-header message is displayed: "Welcome to the Secure Area. When you are done click logout below."
 */
public class PracticeTests  {
    private WebDriver driver;
    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest(){
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        // driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword"+ Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("arikancnn@gmail.com",Keys.ENTER);
        BrowserUtils.wait(3);
        //driver.findElement(By.className("Retrieve password")).click();
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkboxTest(){
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElements(By.cssSelector("input[type='checkbox']")).get(0).click();

        BrowserUtils.wait(3);

        /*Rauf
        driver.navigate().to("http://practice.cybertekschool.com/checkboxes");
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).click();
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).isSelected();
        Verify if a checkbox is checked or not
        In order to check if a checkbox is checked or unchecked,
        we can used the isSelected() method over the checkbox element.
        The isSelected() method returns a boolean value of true
        if the checkbox is checked false otherwise*/
        BrowserUtils.wait(3);

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}