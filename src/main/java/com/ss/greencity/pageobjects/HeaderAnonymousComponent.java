package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Site header for not logged in users
 */
public class HeaderAnonymousComponent extends HeaderComponent {
    private Button signIn;
    private Button signUp;

    public HeaderAnonymousComponent(WebDriver driver) {
        super(driver);
    }

    public HeaderAnonymousComponent(WebElement element) {
        super(element);
    }

    public Button getSignIn() {
        signIn = new Button(element.findElement(HeaderLocators.SIGN_IN.getPath()));
        return signIn;
    }

    public Button getSignUp() {
        signUp = new Button(element.findElement(HeaderLocators.SIGN_UP.getPath()));
        return signUp;
    }
}
