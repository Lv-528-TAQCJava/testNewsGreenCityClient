package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Site header for not logged in users
 */
public class HeaderAnonymousPO extends HeaderPO {
    private Button signIn;
    private Button signUp;

    public HeaderAnonymousPO(WebDriver driver) {
        super(driver);
    }
    public HeaderAnonymousPO(WebElement element) {
        super(element);
    }
}
