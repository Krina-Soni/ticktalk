package com.training1.testcases;

import com.training1.pages.AddLead;
import com.training1.pages.Authlogin;
import org.testng.annotations.Test;

import java.io.IOException;

public class LeadTest extends BaseCase {

        @Test
        public void addLead() throws InterruptedException, IOException {

            //logger=extent.createTest("Verify that user is able to login successfully to application");
            AddLead HoverMenu = new AddLead(driver);
            HoverMenu.AddLead();
            Thread.sleep(5000);
        }
}
