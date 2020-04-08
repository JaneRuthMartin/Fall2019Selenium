package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {
/*    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();*/

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/
    @Test
    public void defaultOptionsTest(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        test = report.createTest("Default Options Test");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());

        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM d, yyyy");
        //getCurrentDate() method comes from utilities package => DateTimeUtilities Class
        Assert.assertEquals(actualStartDate, expectedStartDate);
        test.pass("Default Options Test was created successfully!");
    }

    /**
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/
    @Test
    public void timeDifferenceTest(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Time Difference Test");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime = calendarEventsPage.getStartTime(); //get start time
        String endTime = calendarEventsPage.getEndTime(); //get end time
        String format = "h:mm a";//format 5:15 AM for example

        long actual = DateTimeUtilities.getTimeDifference(startTime,endTime,format);
        Assert.assertEquals(actual,1,"Time difference is not correct");
        test.pass("Time Difference Test was created successfully!");
    }

    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     */
    @Test
    public void verifyColumnNamesTest(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        test = report.createTest("Verify Column Names Test");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
        test.pass("Verify Column Names Test was created successfully!");
    }

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description) {
        //org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
        //if you have more than one test, and 1st pass but others failing,
        //you are getting session id is null exception
        //because driver object was not initialized in time
        //just create page objects inside a test

        //if you have more one test, and 1st pass but others failing,
        //you are getting session id is null exception
        //because driver object was not initialized in time
        //just create page objects inside a test
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //only for extent report. To create a test in html report
        test = report.createTest("Create calendar event for " + title);
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickOnSaveAndClose();
        //verify that calendar event info is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);
        //for extent report. specify that test passed in report (if all assertions passed)
        test.pass("Calendar event was created successfully!");
    }
    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up",  "Scrum meeting to provide updates"},
                {"Sprint Review",   "Scrum meeting where team discussing previous sprint"},
                {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"}
        };
    }
}
