package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The main part of news list page
 * https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public class EcoNewsListPO extends BasePageObject {
    private Label itemsFound;

    public EcoNewsListPO(WebDriver driver) {
        super(driver);
    }

    public Label getItemsFound() {
        itemsFound = new Label(driver, EcoNewsLocators.ITEMS_FOUND);
        return itemsFound;
    }
}
