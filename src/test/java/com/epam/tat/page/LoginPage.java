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
 * Created by Vlad on 11/2/2016.
 */
public class LoginPage extends Page {

    private static final Logger logger = LogManager.getRootLogger();
    private static final String BASE_URL = "https://www.kufar.by/account/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[1]/div/form/input[1]")
    private WebElement inputLogin;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[1]/div/form/input[2]")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[1]/div/form/input[4]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/div")
    private WebElement linkLoggedInUser;


    @FindBy(xpath = "/html/body/div[1]/header/a[2]/i")
    private WebElement login;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/a")
    private WebElement exitButton;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }


    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwd")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));

        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();

        logger.info("Login performed");
    }

    public void exit(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/a[2]/i")));
        login.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/div/a")));
        exitButton.click();
    }

    public String getLoggedInUserName() {
        login.click();
        return linkLoggedInUser.getText();
    }
}
