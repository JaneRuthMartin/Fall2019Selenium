package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*under fleet package create a class called VehiclesPageTests
In this class, you will need to create @beforemethod with setup
and @aftermethod with teardown part. Use LoginPageTests class as a reference.
create a test called verifyPageSubTitle
- in this test, you will need to navigate to Fleet -->
Vehicles and verify that page subtitle is equals to "All Cars"
user assertions for validation. */
public class VehiclesTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com";
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//*[@class='title title-level-1' and contains(text(),'Fleet')]");
    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        //driver.findElement(fleetBy).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//span[.='Vehicles']")).click();
        BrowserUtils.wait(4);
        String title= driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        System.out.println("title = " + title);
    }


    @Test
        public void verifyPageNumber(){
            driver.findElement(usernameBy).sendKeys(username);
            driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
            BrowserUtils.wait(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(fleetBy)).perform();
            BrowserUtils.wait(3);
            driver.findElement(By.xpath("//span[.='Vehicles']")).click();
            String actual = driver.findElement(By.xpath("//li//input[@type='number']")).getAttribute("value");
            String expected = "1";
            assertEquals(actual,expected);

        }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("80").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
