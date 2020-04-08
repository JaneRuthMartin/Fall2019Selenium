package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNGTests {

    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1(){
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        int num1 = 5;
        int num2 = 10;
        Assert.assertTrue(num1<num2);
    }
}
