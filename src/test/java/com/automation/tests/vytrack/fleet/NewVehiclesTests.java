package com.automation.tests.vytrack.fleet;

import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesTests extends AbstractTestBase {
    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login();

        vehiclesPage.navigateTo("Fleet","Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


    }

}
