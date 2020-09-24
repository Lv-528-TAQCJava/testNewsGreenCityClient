package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum EditProfileLocators implements Locator {

    HEADER(By.cssSelector("h2")),
    NAME_INPUT(By.id("name")),
    CITY_INPUT(By.id("city")),
    CREDO_INPUT(By.id("credo")),
    NAME_WARNING(By.xpath("//input[@id='name']/following-sibling::span")),
    CITY_WARNING(By.xpath("//input[@id='city']/following-sibling::span")),
    CREDO_WARNING(By.xpath("//textarea[@id='credo']/following-sibling::span")),
    SHOW_LOCATION(By.cssSelector("input[formcontrolname='showLocation']")),
    SHOW_ECOPLACES(By.cssSelector("input[formcontrolname='showEcoPlace']")),
    SHOW_SHOPPINGS(By.cssSelector("input[formcontrolname='showShoppingList']")),
    SUBMIT_BUTTON(By.cssSelector("button[type='submit']")),
    CANCEL_BUTTON(By.xpath("//button[@type='submit']/preceding-sibling::button"));

    EditProfileLocators(By path) {
        this.path = path;
    }

    private By path;

    @Override
    public By getPath() {
        return path;
    }
}
