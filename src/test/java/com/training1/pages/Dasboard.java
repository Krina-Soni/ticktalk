package com.training1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Dasboard {
    WebDriver driver;

    @FindBy(how = How.NAME, using = "sign_in_with_slack")
    private WebElement lnkrocketchat;

    public Dasboard(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

}
