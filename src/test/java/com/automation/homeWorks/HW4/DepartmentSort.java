package com.automation.homeWorks.HW4;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class DepartmentSort {
    private WebDriver driver = Driver.getDriver();
    private String url = "http://amazon.com";

    @BeforeMethod
    public void setup() {
        driver.get(url);
        BrowserUtils.wait(3);
    }

    @Test (description = "Omer Sanlialp")
    public void amazonTest(){
        Assert.assertEquals("All",driver.findElement(By.className("nav-search-label")).getText());
        Select menu=new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> options=menu.getOptions();
        char current;
        char temp=65;// asci table A
        for (WebElement e:options) {
            current=e.getText().trim().charAt(0);
            if(current<temp){
                Assert.assertTrue(true," not alphabetic");
                break;
            }
            temp=current;
        }
    }

    @Test (description = "Huseyin Civan")
    public void verifyDepartmentsDropdownDefaultValue(){
        WebElement departmentDropDown= driver.findElement(By.xpath("//div[@id='nav-search']//div[@class='nav-search-facade']"));
        String actual =departmentDropDown.getText();
        String expected ="All";
        Assert.assertEquals(actual,expected);

        List<WebElement> dropDownOptions = driver.findElements(By.cssSelector("[aria-describedby='searchDropdownDescription']>option"));

        for (int x = 0; x < dropDownOptions.size()-1 ; x++) {
            String value= dropDownOptions.get(x).getText();
            String nextValue = dropDownOptions.get(x+1).getText();

            if(value.compareTo(nextValue)>0){
                // System.out.println("TEST PASSED");
                break;
            }
        }
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

}
