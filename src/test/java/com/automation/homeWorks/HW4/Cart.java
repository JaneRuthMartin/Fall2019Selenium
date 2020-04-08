package com.automation.homeWorks.HW4;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/*1. go to https://amazon.com
2. search for "wooden spoon"
3. click search
4. remember the name and the price of a random result
5. click on that random result
6. verify default quantity of items is 1
7. verify that the name and the price is the same as the one from step 5
8. verify button "Add to Cart" is visible*/
public class Cart {
    private WebDriver driver = Driver.getDriver();
    private String url = "https://amazon.com";
    WebDriverWait wait = new WebDriverWait(driver,10);


    @Test
    public void test(){
        driver.get(url);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']//following-sibling::input")).click();

        Random random = new Random();
        //List<WebElement> list = driver.findElements(By.className("a-size-base-plus a-color-base a-text-normal"));
        List<WebElement> list = driver.findElements(By.tagName("h2"));

        int randomSpoon = random.nextInt(list.size());

        String expectedName = list.get(randomSpoon).getText();
        list.get(randomSpoon).getAttribute("");
        list.get(randomSpoon).click();

        String actualQuantity = driver.findElement(By.xpath("//span[@class=\"a-dropdown-label\"]/following-sibling::span")).getText().trim();
        Assert.assertEquals(actualQuantity,"1");

        String actualName = driver.findElement(By.id("productTitle")).getText().trim();
        Assert.assertEquals(actualName,expectedName);

        String actualPrice = driver.findElement(By.id("price_inside_buybox")).getText().trim();
        String expectedPrice = "$12.55";
        Assert.assertEquals(actualPrice,expectedPrice);

        WebElement addToCart = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
        Assert.assertTrue(addToCart.isDisplayed());
    }
}
