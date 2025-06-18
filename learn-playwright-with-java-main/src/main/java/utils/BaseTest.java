package utils;

import com.microsoft.playwright.*;
import pages.LoginPage;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    private LoginPage loginPage;

    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setSlowMo(400).setHeadless(Boolean.parseBoolean(ConfigReader.get("headless")))
        );
        context = browser.newContext();
        page = context.newPage();
    }

    public static void teardown() {
        browser.close();
        playwright.close();
    }

}
