package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.locators.Locator;
import com.ss.greencity.locators.NewsCardLocators;
import com.ss.greencity.pageelements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * An object of a news card (brief presentation of one of news pieces)
 * Mind that additional news cards load on scrolling!
 */
public class NewsCardPO extends BasePageObject {
    private Image image;
    private List<Label> categories;
    private Label heading;
    private Label text;
    private Label date;
    private Label author;
    private Button clickableArea; //in fact, all the card is a button

    protected NewsCardPO(WebElement element) {
        super(element);
        init();
    }

    private void init() {
        image = new Image(element, NewsCardLocators.IMAGE);

        List<WebElement> tags = element.findElements(NewsCardLocators.CATEGORIES.getPath());
        categories = new ArrayList<Label>();
        for(WebElement tag : tags) {
            categories.add(new Label(tag));
        }

        heading = new Label(element.findElement(NewsCardLocators.HEADING.getPath()));
        text = new Label(element.findElement(NewsCardLocators.TEXT.getPath()));
        date = new Label(element.findElement(NewsCardLocators.DATE.getPath()));
        author = new Label(element.findElement(NewsCardLocators.AUTHOR.getPath()));
    }

    public Button getClickableArea() {
        clickableArea = new Button(element.findElement(NewsCardLocators.CLICKABLE_AREA.getPath()));
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

    public List<Label> getTags() {
        return  categories;
    }

    public Label getDate() {
        date = new Label(element.findElement(NewsCardLocators.DATE.getPath()));;
        return date;
    }

    public Label getAuthor() {
        author = new Label(element.findElement(NewsCardLocators.AUTHOR.getPath()));
        return author;
    }
}
