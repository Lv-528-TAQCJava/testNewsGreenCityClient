package com.ss.greencity.pageelements;

import com.ss.greencity.locators.Locator;
import com.ss.greencity.pageobjects.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement {

    public CheckBox(WebDriver driver, Locator locator) {
        super(driver, locator);
    }

    public CheckBox(WebElement elementToParse, Locator locator) {
        super(elementToParse, locator);
    }

    public CheckBox(WebElement element) {
        super(element);
    }

    public boolean isChecked() {
        return element.isSelected();
    }

    public void check() {
        if(!element.isSelected())
            element.click();
    }

    public void uncheck() {
        if(element.isSelected())
            element.click();
    }
}
