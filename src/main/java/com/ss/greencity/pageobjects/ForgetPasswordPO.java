package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.ss.greencity.locators.ForgetPasswordLocators.*;

/**
 *
 * An object of forget password page
 */
public class ForgetPasswordPO extends BasePageObject {

    private String forgotPasswordTitle;

    public ForgetPasswordPO(WebDriver driver) {
        super(driver);

    }

    public String getforgotPasswordTitle() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(FORGET_PASSWORD_LABEL.getPath()));
        Label forgotPasswordTitle= new Label(driver.findElement(FORGET_PASSWORD_LABEL.getPath()));
        return forgotPasswordTitle.getText();
    }
}
