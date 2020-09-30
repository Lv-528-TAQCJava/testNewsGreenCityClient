package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ss.greencity.locators.ProfileLocators.*;


/**
 *
 * An object of profile page
 */
public class ProfilePO extends BasePageObject implements ILoggedInPO {

    public ProfilePO(WebDriver driver) {
        super(driver);

    }

    public String userNameField() {
        waitsSwitcher.setExplicitWait(15, ExpectedConditions
                .presenceOfElementLocated(USER_NAME_FIELD.getPath()));
        Label label= new Label(driver.findElement(USER_NAME_FIELD.getPath()));
        return label.getText();
    }
}
