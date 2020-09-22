package com.ss.greencity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSignedInPO extends HeaderPO {
    public HeaderSignedInPO(WebDriver driver) {
        super(driver);
    }

    public HeaderSignedInPO(WebElement element) {
        super(element);
    }
}
