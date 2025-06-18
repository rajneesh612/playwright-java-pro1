package com.thetestingacademy.ex01_Basics;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import utils.BaseTest;
import utils.ConfigReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class loginTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;


    @BeforeClass
    public void init() {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void testLoginValidUser(){
        String baseUrl = ConfigReader.get("url");
        loginPage.navigateTo(baseUrl);
        homePage = loginPage.loginValidCredentials();
        Assert.assertEquals(loginPage.getLogoutText()," Logout");

    }

    @AfterClass
    public void cleanup() {
        teardown();
    }

}
