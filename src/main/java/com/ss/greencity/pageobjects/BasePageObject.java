package com.ss.greencity.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * A template for any page object
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected String url;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
    public BasePageObject goToUrl(String url) {
        driver.get(url);
        this.url = url;
        return this;
    }
}
