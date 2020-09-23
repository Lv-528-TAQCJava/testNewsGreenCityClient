package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A template for any page object
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebElement element;
    protected String url;
    protected HeaderAnonymousPO headerAnon; //appears on every page, so could be placed in base class
    protected HeaderSignedInPO headerSignedIn;

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

    public HeaderAnonymousPO getHeaderAnonymous() {
        headerAnon = new HeaderAnonymousPO(driver.findElement(HeaderLocators.HEADER.getPath()));
        return headerAnon;
    }
    public HeaderSignedInPO getHeaderSignedIn() {
        headerSignedIn = new HeaderSignedInPO(driver.findElement(HeaderLocators.HEADER.getPath()));
        return headerSignedIn;
    }
}
