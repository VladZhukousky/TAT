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
 * Created by Vlad on 12/27/2016.
 */
public class SignUpPage extends Page {

    private static final Logger logger = LogManager.getRootLogger();
    private static final String BASE_URL = "https://www.kufar.by/account/create";

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/main/div/article/div/form/div[2]/div[2]/input")
    private WebElement inputEmail;

    @FindBy(xpath = "/html/body/div[1]/main/div/article/div/form/div[3]/div[2]/input")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[1]/main/div/article/div/form/div[4]/div[2]/input")
    private WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div[1]/main/div/article/div/form/div[6]/div[2]/input")
    private WebElement createButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/article/div/div[2]/h3")
    private WebElement confirmEmail;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Sign up page opened");
    }

    public void createAcc(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwd")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create")));
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        createButton.click();
    }

    public String getWaitingToConfirm() {
        return confirmEmail.getText();
    }

}
