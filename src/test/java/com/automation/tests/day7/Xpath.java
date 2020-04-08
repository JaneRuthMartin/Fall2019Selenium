package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automation.utilities.DriverFactory.createDriver;

public class Xpath {

public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
public static String passwordNameLocator = "//label[text()='Password']/following-sibling::input";
public static String loginBtnLocator = "//button[contains(text(), 'Login')]";

    public static void main(String[] args) {
        WebDriver driver = createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordNameLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();

        BrowserUtils.wait(3);
        driver.quit();

    }
}
