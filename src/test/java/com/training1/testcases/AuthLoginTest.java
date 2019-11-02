package com.training1.testcases;


import com.training1.pages.Authlogin;
import org.testng.annotations.Test;

public class AuthLoginTest extends BaseCase {

    @Test
    public void Sucessful_login() throws InterruptedException {
        Authlogin login = new Authlogin(driver,logger);
        logger=extent.createTest("Verify that user is able to login successfully");
        login.doSuccessfulLogin();
    }

}
