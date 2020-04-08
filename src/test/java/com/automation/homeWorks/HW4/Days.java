package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.*;

/*DAYS
1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
2. Randomly select a checkbox. As soon as you check any day, print the name of the day
and uncheck immediately.
After you check and uncheck Friday for the third time, exit the program.
NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them
when they are randomly selected. It has to be dynamic. Do not hard code Saturday and Sunday.
Use values of certain attributes.*/
public class Days {
    private WebDriver driver = Driver.getDriver();
    private String url = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox";
    private By daysBy = By.className("gwt-CheckBox");

    @Test (description = "Omer Sanlialp")
    public void days(){
        driver.get(url);
        BrowserUtils.wait(3);
        List<WebElement> chcBox = driver.findElements(daysBy);
        Random rnd = new Random();
        int count = 0;
        while(count<3) {
            int randomDay=rnd.nextInt(7);
            if(chcBox.get(randomDay).findElement(By.tagName("input")).isEnabled()) {
                chcBox.get(randomDay).click();
                // input ve label span altinda kardes
                // Bu ornekte sadece labelde text var, iki kardeste de text olsaydi ilk sirada olan inputtaki texti getirirdi
                // Eger iki kardestede text olsaydi, Labeldaki texti almak icin asagidaki code kullanmamiz gerekirdi
                // WebElement inputBox = chcBox.get(randomDay).findElement(By.tagName("label"));
                System.out.println(chcBox.get(randomDay).getText());
                chcBox.get(randomDay).click();
                if (chcBox.get(randomDay).getText().equalsIgnoreCase("friday")){
                    count++;
                }
            }
        }
    }

        @Test (description = "Mykyta Kharchenko")
        public void days2(){
            driver.get(url);
            List<WebElement> daysCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
            List<WebElement> list = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));
            Random r = new Random();
            int count = 0;
            while(count<3){
                int index = r.nextInt(list.size());
                if(daysCheckboxes.get(index).isEnabled()){
                    list.get(index).click();
                    if (list.get(index).getText().equals("Friday")){
                        count++;
                    }
                    System.out.println(list.get(index).getText());
                    list.get(index).click();
                }
            }
        }

    @AfterMethod
    public void tearDown(){
      driver.quit();
    }

}
