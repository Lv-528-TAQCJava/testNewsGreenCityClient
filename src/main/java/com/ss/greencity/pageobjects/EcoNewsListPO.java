package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The main part of news list page
 * https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public class EcoNewsListPO extends BasePageObject {
    private Label itemsFound;
    private NewsCardPO firstNewsCard;
    private ArrayList<Button> filters; //I'm not sure it's simple to use List here.
    //Probably we need to have each filter Button separately

    public EcoNewsListPO(WebDriver driver) {
        super(driver);
    }

    public Label getItemsFound() {
        itemsFound = new Label(driver, EcoNewsLocators.ITEMS_FOUND);
        return itemsFound;
    }

    public NewsCardPO getFirstNewsCard() {
        firstNewsCard = new NewsCardPO(driver, 1);
        return firstNewsCard;
    }

    public List<Button> getFilters() {
        ArrayList<WebElement> filters0 = (ArrayList<WebElement>) driver.findElements(EcoNewsLocators.FILTERS_LIST.getPath());
        filters = new ArrayList<Button>();
        for (WebElement b: filters0) {
            filters.add(new Button(b));
        }
        return filters;
    }
}
