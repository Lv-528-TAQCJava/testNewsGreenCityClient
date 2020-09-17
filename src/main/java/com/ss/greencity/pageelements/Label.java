package com.ss.greencity.pageelements;

import com.ss.greencity.locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Any one line not editable text area
 */
public class Label extends BaseElement {
    public Label(WebDriver driver, Locator locator) {
        super(driver, locator);

    }
    public Label(WebElement elementToParse, Locator locator) {
        super(elementToParse, locator);
    }
    public Label(WebElement element) {
        super(element);
    }

    public String getText() {
        return this.element.getText();
    }

    public String getAttribute(String attribute) {
        return this.element.getAttribute(attribute);
    }
}
