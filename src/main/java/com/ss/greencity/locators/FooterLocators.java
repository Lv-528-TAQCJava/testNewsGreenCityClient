package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum FooterLocators implements Locator {
    LOGO(By.cssSelector("img[src*='footer/greencity-logo.png']")),
    ECO_NEWS(By.cssSelector("a.router-links[href='#/news']")),
    TIPS(By.cssSelector("a.router-links[href='']")),
    PLACES(By.cssSelector("a.router-links[href='#/map']")),
    ABOUT(By.cssSelector("a.router-links[href='#/about']")),
    PROFILE(By.cssSelector("a.router-links[href*='#/profile']")),
    FOLLOW_US(By.cssSelector("div.follow-us-text > p"));


    private By path;
    @Override
    public By getPath() {
        return path;
    }

    FooterLocators(By path) {
        this.path = path;
    }
}
