package com.epam.tat;

import com.epam.tat.step.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Vlad on 11/2/2016.
 */
public class KufarTest {
    private Step step;

    private static final String USERNAME = "321test321@mail.ru";
    private static final String PASSWORD = "Qwerty145671";
    private static final String SearchResult = "По вашему запросу ничего не найдено";
    private static final String SEND_AD_BELARUS = "Падаць аб'яву";
    private static final String CONFIRM_SIGN_UP = "Теперь необходимо активировать профиль.";


    @BeforeMethod(description = "Init browser")
    public void setUp() {
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "Login to Kufar")
    public void oneCanLoginKufar() throws InterruptedException {
        step.loginKufar(USERNAME, PASSWORD);
        Assert.assertTrue(step.isLoggedIn(USERNAME));
    }

    @Test(description = "Search in Kufar")
    public void oneCanSearch() throws InterruptedException {
        step.searchKufar();
        Assert.assertTrue(step.isSearched(SearchResult));

    }

    @Test(description = "Log out Kufar")
    public void oneCanExit() throws InterruptedException {
        oneCanLoginKufar();
        Thread.sleep(2000);
        step.exitKufar();
        Assert.assertTrue(step.isLoggedIn(""));

    }

    @Test(description = "Change language")
    public void oneCanChangeLang() throws InterruptedException {
        step.changeLang();
        Thread.sleep(2000);
        Assert.assertTrue(step.isChangedLang(SEND_AD_BELARUS));

    }

    @Test(description = "Sign up in Kufar")
    public void oneCanSignUp() throws InterruptedException {
        String randomEmail = UUID.randomUUID().toString() + "@mail.ru";
        String randomPass = UUID.randomUUID().toString();
        step.signUp(randomEmail, randomPass);
        Assert.assertTrue(step.isWaitingToConfirm(CONFIRM_SIGN_UP));

    }

}
