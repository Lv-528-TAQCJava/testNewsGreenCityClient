package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A template for any page object.
 * It's recommended also to implement IAnonymousPO or ILoggedInPO where possible.
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebElement element;
    protected String url;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePageObject(WebElement element) {
        this.element = element;
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

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
