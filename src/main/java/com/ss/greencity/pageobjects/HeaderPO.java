package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.DropdownList;
import com.ss.greencity.pageelements.Image;
import com.ss.greencity.util.Languages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Site header, which appears on every page at top.
 * It is abstract, use HeaderAnonymousPO or HeaderSignedInPO
 */
public abstract class HeaderPO extends BasePageObject {
    public String currentLanguage;
    protected Image logo;
    protected Button news;
    protected Button tips;
    protected Button places;
    protected Button about;
    protected Button habits;
    protected Image searchBtn;
    protected DropdownList languageDropdown;

    public HeaderPO(WebDriver driver) {
        super(driver);
        element = driver.findElement(HeaderLocators.HEADER.getPath());
    }

    public HeaderPO(WebElement element) {
        super(element);
    }


    public HeaderPO selectLanguage(Languages language) {
        DropdownList dropdown = getLanguageDropdown();
        dropdown.click();
        element.findElement(language.getPath()).click();
        currentLanguage = language.getCode();

        return this;
    }

    public DropdownList getLanguageDropdown() {
        languageDropdown = new DropdownList(element.findElement(HeaderLocators.LANGUAGE.getPath()));
        return languageDropdown;
    }

    public Image getLogo() {
        logo = new Image(element.findElement(HeaderLocators.LOGO.getPath()));
        return logo;
    }

    public Button getNews() {
        news = new Button(element.findElement(HeaderLocators.NEWS.getPath()));
        return news;
    }

    public Button getTips() {
        tips = new Button(element.findElement(HeaderLocators.TIPS.getPath()));
        return tips;
    }

    public Button getPlaces() {
        places = new Button(element.findElement(HeaderLocators.PLACES.getPath()));
        return places;
    }

    public Button getAbout() {
        about = new Button(element.findElement(HeaderLocators.ABOUT.getPath()));
        return about;
    }

    public Button getHabits() {
        habits = new Button(element.findElement(HeaderLocators.HABITS.getPath()));
        return habits;
    }

    public Image getSearchBtn() {
        searchBtn = new Image(element.findElement(HeaderLocators.SEARCH.getPath()));
        return searchBtn;
    }
}
