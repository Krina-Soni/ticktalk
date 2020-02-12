package com.training1.actions;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

public class VerificationClass {
    private static WebDriver driver;
    private static ExtentTest test;

    public VerificationClass(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }


    public void verifyTextPresent(WebElement element, String expectedText) {
        try {
            if (element.isDisplayed()) {
                String text = element.getText();
                if (text.equals(expectedText)) {
                    test.log(Status.PASS, "Expected value '" + expectedText + "' matches with actual value '" + text
                            + "' for the object : " + element.getAttribute("name"));
                    System.out.println("Expected value '" + expectedText + "' matches with actual value '" + text
                            + "' for the object : " + element.getAttribute("name"));
                } else {
                    test.log(Status.FAIL, "Expected value '" + expectedText + "' did not matche with actual value '"
                            + text + "' for the objectverifyLoggedInUser : " + element.getAttribute("name"));
                    System.out.println("Expected value '" + expectedText + "' did not matche with actual value '"
                            + text + "' for the object : " + element.getAttribute("name"));
                }
            } else {

                test.log(Status.FAIL, "Unable to find object : " + element.getAttribute("name"));
            }

        } catch (Exception e) {

            // TODO: handle exception
            // logger.log(Status.ERROR, "Error in performing action");
            System.out.println(e.getStackTrace());
        }
    }

    public void lblloggedinUser(WebElement element, String expectedText) {
        try {
            if (element.isDisplayed()) {
                String text = element.getText();
                if (text.contains(expectedText)) {
                    test.log(Status.PASS, "Actual text '" + text + "' contains the expected text '" + expectedText
                            + "' for the object : " + element.getAttribute("name"));
                    System.out.println("Actual text '" + text + "' contains the expected text '" + expectedText
                            + "' for the object : " + element.getAttribute("name"));
                } else {
                    test.log(Status.FAIL, "Expected value '" + expectedText + "' did not matche with actual value '"
                            + text + "' for the object : " + element.getAttribute("name"));
                    System.out.println("Expected value '" + expectedText + "' did not matche with actual value '"
                            + text + "' for the object : " + element.getAttribute("name"));
                }
            } else {

                test.log(Status.FAIL, "Unable to find object : " + element.getAttribute("name"));
            }

        } catch (Exception e) {

            // TODO: handle exception
            // logger.log(Status.ERROR, "Error in performing action");
            System.out.println(e.getStackTrace());
        }
    }

    public void verifyElementNotPresent(WebElement element) {
        try {
            if (element.isDisplayed() == false) {
                test.log(Status.PASS, "Element is not present for object : " + element.getAttribute("name"));
                System.out.println("Element is not present for object : " + element.getAttribute("name"));
            } else {
                test.log(Status.FAIL, "Element is  present for object : " + element.getAttribute("name"));
                System.out.println("Element is present for object : " + element.getAttribute("name"));
            }
        } catch (Exception e) {

            // TODO: handle exception
            // logger.log(Status.ERROR, "Error in performing action");
            System.out.println(e.getStackTrace());
        }
    }
}

