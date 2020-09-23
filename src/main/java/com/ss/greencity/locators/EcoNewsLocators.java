package com.ss.greencity.locators;

import org.openqa.selenium.By;

/**
 * Locators on https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public enum EcoNewsLocators implements Locator {

    ITEMS_FOUND(By.cssSelector("div.main-wrapper")), //block with number of found news
    FILTERS_LIST(By.cssSelector("ul.ul-eco-buttons>a")), //list of buttons "Filter by"
    NEWS_LIST(By.cssSelector("ul.list>li")), //list of loaded news cards. Mind that they load on scrolling
    GALLERY_VIEW(By.cssSelector("div.gallery-view")), //button to present news cards as gallery
    LIST_VIEW(By.cssSelector("div.list-view")), //button to present news cards as list
    FIRST_NEWS_CARD(By.cssSelector("ul.list>li:nth-of-type(1)")),
    CREATE_NEWS(By.id("create-button-text")),
    NEWS_BUTTON(By.cssSelector((".navigation-menu-left a[href='#/news']")));


    EcoNewsLocators(By path) {
        this.path = path;
    }

    private By path;
    @Override
    public By getPath() {
        return path;
    }
}
