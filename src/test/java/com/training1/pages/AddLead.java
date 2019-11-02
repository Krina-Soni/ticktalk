package com.training1.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddLead {
    WebDriver driver;

    @FindBy(how = How.ID, using = "userNameId")
    private WebElement UserName;

    @FindBy(how = How.ID, using = "passwordId")
    private WebElement Password;

    @FindBy(how = How.ID, using = "submitID")
    private WebElement Submit;

    @FindBy(how = How.NAME, using = "name")
    private WebElement txtLeadName;

//    ExtentTest extentTest;

    public AddLead(WebDriver driver) {

        this.driver = driver;
       // this.extentTest = extent;
        PageFactory.initElements(driver, this);
    }

}
