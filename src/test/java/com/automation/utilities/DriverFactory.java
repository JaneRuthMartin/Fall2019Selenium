package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static WebDriver createDriver(String browserName) {

            String os = System.getProperty("os.name");
            switch (browserName) {
                case "safari":
                    if (os.equalsIgnoreCase("windows")) {
                        return null;
                    } else {
                        return new SafariDriver();
                    }
                case "edge":
                    if (os.equalsIgnoreCase("mac")) {
                        return null;
                    } else {
                        WebDriverManager.edgedriver().setup();
                        return new EdgeDriver();
                    }
                case "chrome":
                    WebDriverManager.chromedriver().version("80").setup();
                    return new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();

            }
            return null;

        }
    }