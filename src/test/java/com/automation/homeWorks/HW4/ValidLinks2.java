package com.automation.homeWorks.HW4;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ValidLinks2 {

    @Test (description = "Huseyin Civan")
    public void verify_links() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.selenium.dev/documentation/en/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (int x = 0; x < allLinks.size(); x++) {
            String link = allLinks.get(x).getAttribute("href");

            System.out.print(link+" --> ");
            System.out.println(verifyLink(link));

            if(link!=null){
                Assert.assertTrue(verifyLink(link)==200);
            }

        }
        driver.quit();
    }


    // The below function verifyLink(String urlLink) verifies any broken links and return the server status.
    public static int verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter
            URL link = new URL(urlLink);
            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            //Set the timeout for 2 seconds
            //httpConn.setConnectTimeout(2000);
            //connect using connect method
            httpConn.connect();
            //use getResponseCode() to get the response code.

            int respondCode = httpConn.getResponseCode();
            return respondCode;

        } catch (Exception e) {
            //e.printStackTrace();
        }
        return 0;
    }

}