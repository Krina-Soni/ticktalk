package com.training1.pages;
import java.io.IOException;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.training1.actions.ActionClass;
import com.training1.actions.VerificationClass;
import com.training1.constants.CommonVar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Authlogin {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.NAME, using = "sign_in_with_slack")
    private WebElement lnkrocketchat;

    @FindBy(how = How.ID, using = "emailOrUsername")
    private WebElement txtEmail;

    @FindBy(how = How.ID, using = "pass")
    private WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-card\"]/div[3]/button[1]")
    private WebElement btnLogin;

    @FindBy(how = How.XPATH, using="//*[@id=\"rocket-chat\"]/div[2]/div/form/div[1]/div[2]")
    private WebElement lblloggedinUser;

    @FindBy(how = How.XPATH, using="//*[@id=\"rocket-chat\"]/div[2]/div/form/div[3]/button[3]")
    private WebElement btnAuthorize;

    public Authlogin(WebDriver driver, ExtentTest test) {

        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }
    public void doSuccessfulLogin() throws InterruptedException {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        //Thread.sleep(8000);
        lnkrocketchat.click();
        Thread.sleep(12000);
        CommonVar commonVar = new CommonVar();
        actionclass.setValueinTextbox(txtEmail,commonVar.uname);
        actionclass.setValueinTextbox(txtPassword,commonVar.pass);
        actionclass.clickOnObject(btnLogin);
        Thread.sleep(5000);
        actionclass.clickOnObject(btnAuthorize);

    }

    public void loginWithCredentials(String username, String password) throws InterruptedException {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        lnkrocketchat.click();
        Thread.sleep(12000);
        CommonVar commonVar = new CommonVar();
        actionclass.setValueinTextbox(txtEmail,username);
        actionclass.setValueinTextbox(txtPassword,password);
        actionclass.clickOnObject(btnLogin);

    }

    public void verifyLoggedInUser(String username) throws IOException {
        VerificationClass verificationClass=new VerificationClass(driver,extentTest);
        ActionClass actionclass = new ActionClass(driver,extentTest);
        verificationClass.verifyTextPresent(lblloggedinUser,"You are logged in as\n" +username);
        actionclass.captureScreen("Valid Login");

    }

    public void verifyUserIsNotLoggedIn() throws IOException {
        VerificationClass verificationClass=new VerificationClass(driver,extentTest);
        ActionClass actionclass = new ActionClass(driver,extentTest);
        verificationClass.verifyElementNotPresent(lblloggedinUser);
        actionclass.captureScreen("Invalid Login");

    }

}
