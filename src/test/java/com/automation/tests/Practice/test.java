package com.automation.tests.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test {

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "/Users/cananarikan/desktop/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/");
            List<WebElement> listofLinks = driver.findElements(By.tagName("a"));
            System.out.println(listofLinks.size());
            WebElement link = driver.findElement(By.linkText("Autocomplete"));
            link.click();
            Thread.sleep(3000L);
            driver.close();

    }
}
