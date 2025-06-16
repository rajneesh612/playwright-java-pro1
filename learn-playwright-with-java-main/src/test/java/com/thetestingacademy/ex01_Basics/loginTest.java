package com.thetestingacademy.ex01_Basics;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.ConfigReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class loginTest extends BaseTest {
    private LoginPage loginPage;


    @BeforeClass
    public void init() {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void testLoginValidUser(){
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Page page = browser.newPage();
        String baseUrl = ConfigReader.get("url");
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");

        loginPage.navigateTo(baseUrl);
//        System.out.println(page.title());
        loginPage.login(email, password );
        Assert.assertEquals(loginPage.getLogoutText()," Logout");
//        assertEquals(page.title(), "Learn Software Testing & Test Automation");
//        assertTrue(page.title().contains("Learn Software Testing"));
        browser.close();
    }

    @AfterClass
    public void cleanup() {
        teardown();
    }

}
