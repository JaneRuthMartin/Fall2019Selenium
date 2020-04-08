package com.automation.tests.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.automation.utilities.DriverFactory.createDriver;


public class FindElementsPractice {
    public static void main(String[] args) throws Exception {
        /*we are writing same codes again and again
        we will write a method and call it : DRY Principle
        sth that support our code : utilities
        under automation package
        We created utilities package and DriverFactory class under automation package
        we wrote reusable methods inside DriverFactory class named => createDriver
        whenever we need to create webDriver object
        we will call our custom method*/
        /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();*/

        //RemoteWebDriver driver = new ChromeDriver();
        //WebDriver driver = createDriver("safari");
        WebDriver driver = createDriver("chrome");
        // Thread.sleep(2000);
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullname = driver.findElement(By.name("full_name"));
        fullname.sendKeys("Mister Twister");

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        //when you see type="submit", you can use submit() instead of click()
        //it make sense to use when click() method doesn't work
        signUp.submit();
        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
