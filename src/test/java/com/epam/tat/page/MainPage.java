package com.epam.tat.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vlad on 11/29/2016.
 */
public class MainPage extends Page {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.kufar.by/минск_город/Советский/";
    public static final String SQL_INJECTION = "Select * from user;";

    @FindBy(id = "header_search")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[1]/header/form/input[2]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div[1]/h2")
    private WebElement searchResult;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("MAIN page opened");
    }

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void searchSqlInjection() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header_search")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/form/input[2]")));
        searchField.sendKeys(SQL_INJECTION);
        searchButton.click();
        logger.info("Search performed");
    }

    public String getSearchResult() {
        return searchResult.getText();
    }

}
