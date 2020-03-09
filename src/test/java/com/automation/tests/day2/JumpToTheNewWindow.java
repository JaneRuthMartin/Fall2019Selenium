package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        //getWindowHandles() - returns id's of all currently opened windows
        //Set - doesn't allow duplicates

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH :"+driver.getCurrentUrl());
        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window id
        for (String windowId: windowHandles){
            //if it's not an old window, then switch
            if(!windowId.equals(windowHandle)){
                //to jump to the new window
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH :"+driver.getCurrentUrl());
        // break until 5:02

        // driver.close();
        driver.quit();
    }

    /* This method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
