package com.ss.greencity.locators;

import org.openqa.selenium.By;

/**
 * Locators on https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public enum NewsPageLocators implements Locator {

    NEWS_TEXT(By.cssSelector("div.news-text")),
    DATE(By.cssSelector("div.news-info-date")),
    AUTHOR(By.cssSelector("div.news-info-author"));


    NewsPageLocators(By path) {
        this.path = path;
    }

    private By path;
    @Override
    public By getPath() {
        return path;
    }
}
