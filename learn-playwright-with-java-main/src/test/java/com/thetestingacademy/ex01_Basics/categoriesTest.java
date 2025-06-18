package com.thetestingacademy.ex01_Basics;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ConfigReader;

public class categoriesTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private CategoriesPage categoriesPage;


    @BeforeClass
    public void init () {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void categoriesCases () {
        String baseUrl = ConfigReader.get("url");
        loginPage.navigateTo(baseUrl);
        homePage = loginPage.loginValidCredentials();
        categoriesPage = homePage.clickontheWomenBtn();
        categoriesPage.clickontheTopsBtn();
        Assert.assertEquals(categoriesPage.getCategoryTitleText(),"Tops Products");
        categoriesPage = homePage.clickontheWomenBtn();
        categoriesPage.clickontheDressBtn();
        Assert.assertEquals(categoriesPage.getCategoryTitleText(),"Dress");
    }
    @AfterClass
    public void cleanup() {
        teardown();
    }

}

