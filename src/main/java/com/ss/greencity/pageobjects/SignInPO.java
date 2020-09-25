package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageelements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ss.greencity.locators.SignInLocators.*;



/**
 *
 * An object of sign in page
 */
public class SignInPO extends BasePageObject {

    public SignInPO(WebDriver driver) {
        super(driver);

    }

    public SignInPO clickSignInButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement signInButton = driver.findElement(SIGN_IN_BTN.getPath());
        signInButton.click();
        return this;
    }

    public SignInPO clickImagePanel() {
        WebElement imagePanel = driver.findElement(IMAGE_PANEL.getPath());
        imagePanel.click();
        return this;
    }

    public SignInPO setEmail(String value) {
        InputBox email= new InputBox(driver.findElement(EMAIL_FIELD.getPath()));
        email.click();
        email.setData(value);
        return this;
    }

    public SignInPO setPassword(String value) {
        InputBox password = new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        password.click();
        password.setData(value);
        return this;
    }

    public SignInPO PasswordClick() {
        InputBox password = new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        password.click();
        return this;
    }

    public SignInPO clickSignInUserButton() {
        Button button = new Button(driver.findElement(SIGN_IN_USER_BTN.getPath()));
        button.click();
        return this;
    }

    public SignInPO clickGoogleSignInButton() {
        Button button = new Button(driver.findElement(GOOGLE_SIGN_IN_BTN.getPath()));
        button.click();
        return this;
    }

    public SignInPO clickForgotPassword() {
        Link link = new Link(driver.findElement(FORGOT_PASSWORD_BTN.getPath()));
        link.click();
        return this;
    }

    public String alertEmailMessage() {
        Label label= new Label(driver.findElement(EMAIL_ALERT_MESSAGE.getPath()));
        return label.getText();
    }

    public String alertEmptyEmailMessage() {
        Label label= new Label(driver.findElement(EMPTY_EMAIL_FIELD_ALERT_MESSAGE.getPath()));
        return label.getText();
    }

    public String alertEmptyPasswordMessage() {
        Label label= new Label(driver.findElement(EMPTY_PASSWORD_FIELD_ALERT_MESSAGE.getPath()));
        return label.getText();
    }

    public String alertPasswordMessage() {
        Label label= new Label(driver.findElement(PASSWORD_LENGTH_ALERT_MESSAGE.getPath()));
        return label.getText();
    }

    public String alertBadEmailOrPasswordMessage() {
        Label label = new Label(driver.findElement(INCORRECT_EMAIL_OR_PASSWORD_ALERT_MASSAGE.getPath()));
        return  label.getText();
    }
}
