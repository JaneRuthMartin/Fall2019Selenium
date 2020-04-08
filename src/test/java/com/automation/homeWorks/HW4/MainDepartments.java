package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainDepartments {
    private WebDriver driver = Driver.getDriver();
    private String url="https://www.amazon.com/gp/site-directory";

    @BeforeClass
    public void start(){
        driver.get(url);
        BrowserUtils.wait(3);
    }

    @Test (description = "Omer Sanlialp")
    public void mainDepartments(){
        List<WebElement> departments=driver.findElements(By.className("fsdDeptTitle"));
        List<String> dpName=new ArrayList<>();
        departments.forEach(n -> dpName.add(n.getText().trim()));
        Select dep=new Select(driver.findElement(By.id("searchDropdownBox")));

        List<WebElement> dropDep=dep.getOptions();
        List<String> dropDpName=new ArrayList<>();
        dropDep.forEach(n->dropDpName.add(n.getText().trim()));
        for (String name:dpName) {
            Assert.assertTrue(dropDpName.contains(name),"Expected: "+name + " doesn't appear in least");
        }
    }

    @Test (description = "Huseyin Civan")
    public void mainDepartments2(){
        driver.get("https://www.amazon.com/gp/site-directory");
        List<WebElement> mainDepartments = driver.findElements(By.cssSelector("[class=\"fsdDeptTitle\"]"));

        List<WebElement> departmentDropDownMenu = driver.findElements(By.cssSelector("[aria-describedby=\"searchDropdownDescription\"]>option"));

        List<String> allDepartmentsOnDropdownMenu = new ArrayList<>();
        for (int i = 0; i <departmentDropDownMenu.size() ; i++) {
            allDepartmentsOnDropdownMenu.add(departmentDropDownMenu.get(i).getText());
        }

        for (int y = 0; y < mainDepartments.size() ; y++) {
            Assert.assertTrue(departmentDropDownMenu.contains(mainDepartments.get(y)));
        }
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}