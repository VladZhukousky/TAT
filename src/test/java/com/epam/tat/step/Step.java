package com.epam.tat.step;

import com.epam.tat.driver.Driver;
import com.epam.tat.page.LoginPage;
import com.epam.tat.page.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vlad on 11/16/2016.
 */
public class Step {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = Driver.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }

    public void loginKufar(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public void searchKufar() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.searchSqlInjection();
    }

    public void exitKufar() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.exit();
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }

    public boolean isSearched(String result) {
        MainPage mainPage = new MainPage(driver);
        return (mainPage.getSearchResult().trim().toLowerCase().equals(result.trim().toLowerCase()));

    }
}
