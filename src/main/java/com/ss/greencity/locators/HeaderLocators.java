package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum HeaderLocators implements Locator {
    HEADER(By.className("header")),
    LOGO(By.cssSelector("img[alt='logo']")),
    NEWS(By.cssSelector((".navigation-menu-left a[href='#/news']"))),
    TIPS(By.cssSelector((".navigation-menu-left a[href='#/tips']"))),
    PLACES(By.cssSelector((".navigation-menu-left a[href='#/map']"))),
    ABOUT(By.cssSelector((".navigation-menu-left a[href='#/about']"))),
    HABITS(By.cssSelector((".navigation-menu-left a[href*='#/profile']"))),
    SEARCH(By.cssSelector("img[alt='search']")),
    LANGUAGE(By.cssSelector("div.switcher-wrapper > ul")), //language select dropdown menu
    SIGN_IN(By.cssSelector("li.sign-in-link")),
    SIGN_UP(By.cssSelector("li.sign-up-link > div")), //could replace one implemented in SignUpLocators
    USER_PROFILE(By.cssSelector("div#user-avatar-wrapper ul"));

    HeaderLocators(By path) {
        this.path = path;
    }

    private By path;
    @Override
    public By getPath() {
        return path;
    }
}
