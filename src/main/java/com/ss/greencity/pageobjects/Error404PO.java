package com.ss.greencity.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * A representation of not existing page.
 * Example: https://ita-social-projects.github.io/GreenCityClient/ololo
 */
public class Error404PO extends BasePageObject {
    By headingWith404Selector = By.xpath("//h1[text()='404']");

    public Error404PO(WebDriver driver) {
        super(driver);
    }

    public Error404PO(WebElement element) {
        super(element);
    }

    public boolean pageDoesNotExist() {
        ArrayList<WebElement> error404 = (ArrayList<WebElement>) driver.findElements(headingWith404Selector);
        return error404.size() > 0;
    }

    public boolean pageExists() {
        return !pageDoesNotExist();
    }
}
