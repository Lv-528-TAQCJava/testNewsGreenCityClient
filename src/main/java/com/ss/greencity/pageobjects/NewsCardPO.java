package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.locators.Locator;
import com.ss.greencity.locators.NewsCardLocators;
import com.ss.greencity.pageelements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * An object of a news card (brief presentation of one of news pieces)
 * Mind that additional news cards load on scrolling!
 */
public class NewsCardPO extends BasePageObject {
    private int numberInList; //I have no another idea how to refer to a specific NewsCard, since we anyway have a list of them
    private Image image;
    private Label category;
    private Label heading;
    private Label text;
    private Label date; //I'm not sure we really need this, but possible test case:
    // date/author in news card similar to date/author on single news page
    private Label author;
    private Button clickableArea; //in fact, all the card is a button

    protected NewsCardPO(WebDriver driver, int numberInList) {
        super(driver);
        this.numberInList = numberInList;
    }

    public Button getClickableArea() {
        String globalPath = cssSelectorToString(EcoNewsLocators.NEWS_LIST.getPath()) + ">"
                + cssSelectorToString(NewsCardLocators.CLICKABLE_AREA.getPath());
        clickableArea = new Button(driver, () -> By.cssSelector(globalPath));
        return clickableArea;
    }

    /**
     * Converts By class object to a string representing the CSS selector
     * (I didn't find any method in By class for this)
     * @param selector
     * @return
     */
    private String cssSelectorToString(By selector) {
        return selector.toString().replace("By.cssSelector: ", "");
    }

}
