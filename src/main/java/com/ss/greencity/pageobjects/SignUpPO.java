package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ss.greencity.locators.SignUpLocators.*;

/**
 *
 * An object of sign up page
 */
public class SignUpPO extends BasePageObject{

    public SignUpPO(WebDriver driver) {
        super(driver);

    }
    public SignUpPO clickSignUpButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Button signUpButton = new Button(element.findElement(SIGN_UP_BTN.getPath()));
        signUpButton.click();
        return this;
    }

    public SignUpPO setEmail(String value) {
        InputBox email= new InputBox(element.findElement(EMAIL_FIELD.getPath()));
        email.click();
        email.setData(value);
        return this;
    }

     public SignUpPO setUserName(String value) {
        InputBox username = new InputBox(element.findElement(USERNAME_FIELD.getPath()));
        username.click();
        username.setData(value);
        return this;
     }

     public SignUpPO setPassword(String value) {
        InputBox password = new InputBox(element.findElement(PASSWORD_FIELD.getPath()));
        password.click();
        password.setData(value);
        return this;
     }

     public SignUpPO setConfirmedPassword(String value) {
        InputBox confirmedPassword = new InputBox(element.findElement(CONFIRM_PASSWORD_FIELD.getPath()));
        confirmedPassword.click();
        confirmedPassword.setData(value);
        return this;
     }
     public SignUpPO clickSignUpUserButton() {
         Button button = new Button(element.findElement(SIGN_UP_USER_BTN.getPath()));
         button.click();
         return this;
     }
     public String alertEmailMessage() {
         Label label= new Label(element.findElement(EMAIL_ALERT_MESSAGE.getPath()));
         return label.getText();
     }

}
