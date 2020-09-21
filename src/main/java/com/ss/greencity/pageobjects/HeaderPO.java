package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Site header, which appears on every page at top.
 */
public class HeaderPO extends BasePageObject {
    private Image logo;
    private Button news;
    private Button tips;
    private Button places;
    private Button about;
    private Button habits;
    private Image searchBtn;
    private Button languageBtn;
    private Button signIn;
    private Button signUp;

    public String currentLanguage;

    protected HeaderPO(WebDriver driver) {
        super(driver);
        element = driver.findElement(HeaderLocators.HEADER.getPath());
    }

    protected HeaderPO(WebElement element) {
        super(element);
    }


    public HeaderPO selectLanguage(String languageCode) {
        getLanguageButton().click();
        Button b; //the selected language button to click
        switch (languageCode) {
            case "En":
                b = new Button(element.findElement(HeaderLocators.LANGUAGE_EN.getPath()));
                b.click();
                currentLanguage = "En";
                break;
            case "Ru":
                b = new Button(element.findElement(HeaderLocators.LANGUAGE_RU.getPath()));
                b.click();
                currentLanguage = "Ru";
                break;
            case "Uk":
                b = new Button(element.findElement(HeaderLocators.LANGUAGE_UK.getPath()));
                b.click();
                currentLanguage = "Uk";
                break;
            default:
                b = new Button(element.findElement(HeaderLocators.LANGUAGE_EN.getPath()));
                b.click();
                currentLanguage = "En";
        }
        return this;
    }

    public Button getLanguageButton() {
        languageBtn = new Button(element.findElement(HeaderLocators.LANGUAGE.getPath()));
        return languageBtn;
    }
}
