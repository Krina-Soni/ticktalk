package com.training1.testcases;


import com.training1.pages.Authlogin;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthLoginTest extends BaseCase {

    @Test
    public void Sucessful_login() throws InterruptedException, IOException {

        logger=extent.createTest("Verify that user is able to login successfully to application");
        Authlogin login = new Authlogin(driver,logger);
        login.doSuccessfulLogin();
        Thread.sleep(5000);
        login.verifyLoggedInUser("harshad");
    }
    @Test
    public void unSucessful_login() throws InterruptedException, IOException {

        logger=extent.createTest("Verify that user is able to login with invalid credentials to application");
        Authlogin login = new Authlogin(driver,logger);
        login.loginWithCredentials("johnny@gmail.com","addweb123");
        Thread.sleep(5000);
        login.verifyLoggedInUser("harshad");
    }

}
