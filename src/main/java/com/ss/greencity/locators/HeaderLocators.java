package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum HeaderLocators implements Locator {
    HEADER(By.className("header")),
    LOGO(By.cssSelector("")), //implement if necessary
    NEWS(By.cssSelector("")), //implement if necessary
    TIPS(By.cssSelector(".title-list.word-wrap p")), //implement if necessary
    PLACES(By.cssSelector("")), //implement if necessary
    ABOUT(By.cssSelector("")), //implement if necessary
    HABITS(By.cssSelector("")), //implement if necessary
    SEARCH(By.cssSelector("img[alt='search']")), //search button
    LANGUAGE(By.cssSelector("div.switcher-wrapper > ul")), //language select dropdown menu
    //LANGUAGE_RU(By.cssSelector("div.switcher-wrapper > ul > li:contains('Ru')")), //works in browser, but might fail in Selenium
    LANGUAGE_RU(By.xpath("//div[@class='switcher-wrapper']/ul/li[normalize-space()='Ru']")),
    LANGUAGE_UK(By.xpath("//div[@class='switcher-wrapper']/ul/li[normalize-space()='Uk']")),
    LANGUAGE_EN(By.xpath("//div[@class='switcher-wrapper']/ul/li[normalize-space()='En']")),
    SIGN_IN(By.cssSelector("li.sign-in-link")),
    SIGN_UP(By.cssSelector("li.sign-up-link > div")); //could replace one implemented in SignUpLocators

    HeaderLocators(By path) {
        this.path = path;
    }

    private By path;
    @Override
    public By getPath() {
        return path;
    }
}
