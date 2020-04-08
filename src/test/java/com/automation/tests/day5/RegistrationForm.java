package com.automation.tests.day5;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);
        //enter first name
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        driver.findElement(By.name("phone")).sendKeys("571-343-2342");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        //select gender
        genders.get(0).click();//select male, for example

        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");

        driver.findElement(By.id("inlineCheckbox2")).click();//select java

        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();//click on submit button
        BrowserUtils.wait(2);

        //ADD VALIDATION PART
        driver.quit();

    }
}