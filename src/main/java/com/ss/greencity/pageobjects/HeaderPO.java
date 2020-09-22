package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.*;
import com.ss.greencity.util.Languages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Site header, which appears on every page at top.
 * It is recommended to use HeaderAnonymousPO or HeaderSignedInPO
 */
public abstract class HeaderPO extends BasePageObject { //will not make abstract
    protected Image logo;
    protected Button news;
    protected Button tips;
    protected Button places;
    protected Button about;
    protected Button habits;
    protected Image searchBtn;
    protected DropdownList languageDropdown;

    public String currentLanguage;

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
}
