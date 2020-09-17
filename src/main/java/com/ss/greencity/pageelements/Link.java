package com.ss.greencity.pageelements;

import com.ss.greencity.locators.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Link extends BaseElement {
    protected Link(WebDriver driver, Locator locator) {
        super(driver, locator);
    }

    protected Link(WebElement elementToParse, Locator locator) {
        super(elementToParse, locator);
    }

    protected Link(WebElement element) {
        super(element);
    }

    public String getReference() {
        return element.getAttribute("href");
    }

    public void click() {
        element.click();
    }
}
