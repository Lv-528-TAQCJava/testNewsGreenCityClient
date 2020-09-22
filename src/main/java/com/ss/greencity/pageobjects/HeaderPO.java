package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.*;
import com.ss.greencity.util.Languages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

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
    private DropdownList languageDropdown;

    public String currentLanguage;

    protected HeaderPO(WebDriver driver) {
        super(driver);
        element = driver.findElement(HeaderLocators.HEADER.getPath());
    }

    protected HeaderPO(WebElement element) {
        super(element);
    }


    public HeaderPO selectLanguage(Languages language) {
        DropdownList dropdown = getLanguageDropdown();
        dropdown.click();
        //ArrayList<Button> langButtons = dropdown.getItems();
        element.findElement(language.getPath()).click();
        currentLanguage = language.getCode();

        return this;
    }

    public DropdownList getLanguageDropdown() {
        languageDropdown = new DropdownList(element.findElement(HeaderLocators.LANGUAGE.getPath()));
        return languageDropdown;
    }
}
