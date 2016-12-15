package com.epam.tat.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by Vlad on 11/2/2016.
 */
public abstract class Page {


    protected WebDriver driver;

    public abstract void openPage();

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
