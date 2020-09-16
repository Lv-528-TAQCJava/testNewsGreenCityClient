package com.ss.greencity.locators;

import org.openqa.selenium.By;

/**
 * Locators on https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public enum EcoNewsLocators implements Locator {

    ITEMS_FOUND(By.cssSelector("div.main-wrapper")); //block with number of found news

    EcoNewsLocators(By path) {
        this.path = path;
    }

    private By path;
    @Override
    public By getPath() {
        return path;
    }
}
