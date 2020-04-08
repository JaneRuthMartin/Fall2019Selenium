package com.automation.homeWorks.HW4;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
/**
 * 1.go to https://amazon.com
 * 2.search for "wooden spoon"
 * 3.click search
 * 4.remember the name and the price of a random result
 * 5.click on that random result
 * 6.verify default quantity of items is 1
 * 7.verify that the name and the price is the same as the one from step 5
 * 8.verify button"Add to Cart" is visible
 */
public class AddToCart {
    private WebDriver driver = Driver.getDriver();
    private String url = "https://amazon.com";

    @Test
    public void test() {
        driver.get(url);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> prices = driver.findElements(By.cssSelector("[class='a-price'] > [class='a-offscreen']"));
        List<WebElement> descriptions = driver.findElements(By.cssSelector("[class='a-size-base-plus a-color-base a-text-normal']"));
        System.out.println("Number of prices: " + prices.size());
        System.out.println("Number of descriptions: " + descriptions.size());
        Random random = new Random();
        int randomNumber = random.nextInt(descriptions.size());
        WebElement randomPrice = prices.get(randomNumber);
        WebElement randomItem = descriptions.get(randomNumber);
        String expectedDescription = randomItem.getText().trim();
        String expectedPrice = randomPrice.getText().trim();
        randomItem.click(); //click on random item
        WebElement quantity = driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span"));
        int actual = Integer.parseInt(quantity.getText().trim());
        Assert.assertEquals(actual, 1);
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        WebElement productPrice = driver.findElement(By.cssSelector("[id='priceInsideBuyBox_feature_div'] > div"));
        String actualDescription = productTitle.getText().trim();
        String actualPrice = productPrice.getText().trim();
        Assert.assertEquals(actualDescription, expectedDescription);
        Assert.assertEquals(actualPrice, expectedPrice);
        driver.quit();
    }

}