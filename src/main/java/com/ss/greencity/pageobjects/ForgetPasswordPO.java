package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ss.greencity.locators.ForgetPasswordLocators.*;

/**
 *
 * An object of forget password page
 */
public class ForgetPasswordPO extends BasePageObject {

    public ForgetPasswordPO(WebDriver driver) {
        super(driver);

    }

    public String forgotPasswordText() {
        Label label= new Label(driver.findElement(FORGET_PASSWORD_LABEL.getPath()));
        return label.getText();
    }
}