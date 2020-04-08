package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.getFirstSelectedOption();

        //index starts from 0
        stateSelect.selectByIndex(9); //District Of Columbia
        BrowserUtils.wait(3);

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);
        //stateSelect.getOptions().size()  --> to get size of stateselect

        BrowserUtils.wait(3);
        driver.quit();

    }
}
