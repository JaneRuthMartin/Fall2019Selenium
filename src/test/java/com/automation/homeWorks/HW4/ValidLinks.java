package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

    /*1. go to https://www.selenium.dev/documentation/en/
    2. find all the elements in the page with the tag a
    3. verify that all the links are valid*/
public class ValidLinks {
    private WebDriver driver = Driver.getDriver();
    private String homePage = "https://www.selenium.dev/documentation/en/";
    private String url = "";

    @BeforeClass
    public void start(){
        driver.get(homePage);
        BrowserUtils.wait(3);
    }

    @Test
    public void test() {
        HttpURLConnection huc = null;
        int respCode = 200;

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");

            // Check if URL is null or Empty and skip the remaining steps if the condition is satisfied.
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                URL link = new URL(url);
                // HttpURLConnection class has methods to send HTTP request and capture HTTP response code.
                // So, output of openConnection() method (URLConnection) is type casted to HttpURLConnection.
                HttpURLConnection httpConnection = (HttpURLConnection) link.openConnection();
                // in one line
                // httpConnection = (HttpURLConnection) (new URL(url).openConnection());

                // We can set Request type as "HEAD" instead of "GET".
                // So that only headers are returned and not document body.
                httpConnection.setRequestMethod("HEAD");

                // On invoking connect() method, actual connection to url is established
                // and the request is sent.
                httpConnection.connect();

                // Using getResponseCode() method we can get response code for the request
                respCode = httpConnection.getResponseCode();

                // Based on response code we will try to check link status
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }
                Assert.assertTrue(respCode<400);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
