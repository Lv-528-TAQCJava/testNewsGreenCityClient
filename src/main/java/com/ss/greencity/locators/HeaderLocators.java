package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum HeaderLocators implements Locator {
    HEADER(By.className("header")),
    LOGO(By.cssSelector("img[alt='logo']")),
    NEWS(By.xpath("//div[@class='navigation-menu-left']/ul/li[1]")),
    TIPS(By.xpath("//div[@class='navigation-menu-left']/ul/li[2]")),
    PLACES(By.xpath("//div[@class='navigation-menu-left']/ul/li[3]")),
    ABOUT(By.xpath("//div[@class='navigation-menu-left']/ul/li[4]")),
    HABITS(By.xpath("//div[@class='navigation-menu-left']/ul/li[5]")),
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
