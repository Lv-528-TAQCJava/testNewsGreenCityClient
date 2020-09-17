package com.ss.greencity.pageelements;

import com.ss.greencity.locators.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Any image
 */
public class Image extends BaseElement {

    protected Image(WebDriver driver, Locator locator) {
        super(driver, locator);
    }

    protected Image(WebElement elementToParse, Locator locator) {
        super(elementToParse, locator);
    }

    protected Image(WebElement element) {
        super(element);
    }

    public String getSource() {
        return element.getAttribute("src");
    }
    public String getAltText() {
        return element.getAttribute("alt");
    }
    public void click() {
        element.click();
    }

}
