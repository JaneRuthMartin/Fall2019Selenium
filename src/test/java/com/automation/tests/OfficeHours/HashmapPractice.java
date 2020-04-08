package com.automation.tests.OfficeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class HashmapPractice {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        BrowserUtils.wait(3);
        //click on contacts
        //create contact
        //Use map to store information and use it later to enter in UI

        // //tag[@attribute='value']

        WebElement contact_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        BrowserUtils.wait(3);

        String currentTitle = driver.getTitle();
        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")) {
            System.out.println("Title is expected");
        } else {
            System.out.println("Title is NOT expected");
        }
        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last name", "Smith");
        contact1.put("Phone", "517-236-4567");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");

        System.out.println("contact1 = " + contact1);


    }
}