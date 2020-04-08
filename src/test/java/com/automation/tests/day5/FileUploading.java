package com.automation.tests.day5;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        //it work only for my computer because only have this file
        //and my computer username is different than yours
        String file2Path = "/Users/studio2/Downloads/image (2).png";
        //doesn't work, should be on your computer
        //String cloudFile = "https://cybertek-appium.s3.amazonaws.com/etsy.apk";

        System.out.println(filePath);//print path

        upload.sendKeys(file2Path);

        driver.findElement(By.id("file-submit")).click();//click to upload

        BrowserUtils.wait(5);
        driver.quit();
    }
}