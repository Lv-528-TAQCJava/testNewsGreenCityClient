package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.ProfileLocators.*;


/**
 *
 * An object of profile page
 */
public class ProfilePO extends BasePageObject {

    public ProfilePO(WebDriver driver) {
        super(driver);

    }

    public String userNameField() {
        Label label= new Label(driver.findElement(USER_NAME_FIELD.getPath()));
        return label.getText();
    }
}
