package com.automation.homeWorks.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.YearMonth;
import java.util.List;
import java.util.Random;

    /*1. go to http://practice.cybertekschool.com/dropdown
      2. select a random year under Select your date of birth
      3. select month January
      4. verify that days dropdown has current number of days
      5. repeat steps 3, 4 for all the months
      NOTE: if you randomly select a leap year, verify February has 29 days*/
public class YearsMonthsDays {
    private WebDriver driver;
    private String url = "http://practice.cybertekschool.com/dropdown";
    Random random = new Random();

    @BeforeClass
    public void start() {
        driver = DriverFactory.createDriver("chrome");
        driver.get(url);
        BrowserUtils.wait(3);
    }

    @Test (description = "Omer Sanlialp")
    public void test() {
        Select yearDropDown = new Select(driver.findElement(By.id("year")));
        List<WebElement> years = yearDropDown.getOptions();

        int randomNumber = random.nextInt(years.size());
        String selectedYear = years.get(randomNumber).getText();
        yearDropDown.selectByVisibleText(selectedYear);

        Select monthDropDown = new Select(driver.findElement(By.id("month")));
        List<WebElement> months = monthDropDown.getOptions();

        for (WebElement month : months) {
            monthDropDown.selectByVisibleText(month.getText());
            Select dayDropDown = new Select(driver.findElement(By.id("day")));
            List<WebElement> days = dayDropDown.getOptions();
            int actualDay = YearMonth.of(Integer.parseInt(selectedYear), months.indexOf(month)+1).lengthOfMonth();
            Assert.assertEquals(actualDay,days.size());
        }

    }

    @Test (description = "Seda Civan")
    public void verifyNumberOfDays() {
        //2. select a random year under Select your date of birth
        WebElement year = driver.findElement(By.id("year"));
        Random random = new Random();
        Select selectYear = new Select(year);
        for (int j = 0; j <15 ; j++) {
            //selectYear.getOptions().size() returns List of web elements  all years in year dropdown
            int randomYearIndex = random.nextInt(selectYear.getOptions().size());
            selectYear.selectByIndex(randomYearIndex);
            int selectedYear = Integer.parseInt(selectYear.getFirstSelectedOption().getText());
            //5. repeat steps 3, 4 for all the months
            for (int i = 0; i < 12; i++) {
                //3. select month January
                WebElement month = driver.findElement(By.id("month"));
                Select selectMonth = new Select(month);
                //selectMonth.selectByVisibleText("January");
                selectMonth.selectByIndex(i);
                //4. verify that days dropdown has current number of days
                WebElement day = driver.findElement(By.id("day"));
                Select selectDay = new Select(day);
                int actualDayCount = selectDay.getOptions().size();
                //get the number of days in that month YearMonth class comes from java
                YearMonth yearMonthObj = YearMonth.of(selectedYear, i + 1);
                int daysInMonth = yearMonthObj.lengthOfMonth();
                Assert.assertEquals(actualDayCount, daysInMonth);
            }
        }
    }

    @Test (description = "Asena Cengel")
    public void  SelectYourDateOfBirth() throws InterruptedException {
        Select years = new Select(driver.findElement(By.id("year")));
        List<WebElement> allYears = years.getOptions();
        Random random = new Random();
        int randomYear = random.nextInt(allYears.size());
        String selectedYear = allYears.get(randomYear).getText();
        years.selectByVisibleText(selectedYear);
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByIndex(0);
        YearMonth yearMonthObject = YearMonth.of(randomYear, 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        Select day = new Select(driver.findElement(By.id("day")));
        List<WebElement> allDays = day.getOptions();
        Assert.assertEquals(allDays.size(), daysInMonth );
        List<WebElement> allMonths = month.getOptions();
        for (WebElement selectedMonth : allMonths) {
            selectedMonth.click();
            // month.selectByIndex();
            YearMonth  monthOfTheYear = YearMonth.of(randomYear, Integer.parseInt(selectedMonth.getAttribute("value"))+1 );
            daysInMonth = monthOfTheYear.lengthOfMonth();
            day = new Select(driver.findElement(By.id("day")));
            allDays = day.getOptions();
            Assert.assertEquals(allDays.size(), daysInMonth );
            System.out.println(allDays.size());
            System.out.println(daysInMonth);
        }
    }

        @AfterClass
        public void tearDown () {
            driver.quit();
        }
    }
