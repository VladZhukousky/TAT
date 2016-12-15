package com.epam.tat;

import com.epam.tat.step.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Vlad on 11/2/2016.
 */
public class KufarTest {
    private Step step;

    private final String USERNAME = "321test321@mail.ru";
    private final String PASSWORD = "Qwerty145671";
    private final String SearchResult="По вашему запросу ничего не найдено";
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
    @Test(description = "Search in Kufar")
    public void oneCanExit() throws InterruptedException {
        oneCanLoginKufar();
        Thread.sleep(2000);
        step.exitKufar();
        Assert.assertTrue(step.isLoggedIn(""));

    }

}
