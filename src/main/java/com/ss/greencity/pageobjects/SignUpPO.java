package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import java.util.List;

import static com.ss.greencity.locators.HeaderLocators.SIGN_UP;
import static com.ss.greencity.locators.SignUpLocators.*;

/**
 *
 * An object of sign up page
 */
public class SignUpPO extends BasePageObject{

    private final String email = "user"+Math.random()*100000+"@selenium.test";
    private final String username = "User"+Math.random()*100000;
    private final String password = "Aa123456_";
    private final String confirmPassword = "Aa123456_";
    private final String invalidEmail = "user"+Math.random()*100000+"selenium.test";
    private final String invalidUsername = "User";
    private final String invalidPassword = "1111";
    private final String invalidPasswordSpaces = " ";
    private final String invalidConfirmPassword = "11";
    private final String invalidConfirmPasswordSpaces = " ";

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getInvalidEmail() {
        return this.invalidEmail;
    }

    public String getInvalidUsername() {
        return this.invalidUsername;
    }

    public String getInvalidPassword() {
        return this.invalidPassword;
    }

    public String getInvalidConfirmPassword() {
        return this.invalidConfirmPassword;
    }

    public String getInvalidPasswordSpaces() {
        return invalidPasswordSpaces;
    }

    public String getInvalidConfirmPasswordSpaces() {
        return invalidConfirmPasswordSpaces;
    }

    public SignUpPO(WebDriver driver) {
        super(driver);

    }
    public SignUpPO clickSignUpButton() {
        Button signUpButton = new Button(driver.findElement(SIGN_UP.getPath()));
        signUpButton.click();
        return this;
    }


    public SignUpPO clickImagePanel() {
        WebElement imagePanel = driver.findElement(IMAGE_PANEL.getPath());
        imagePanel.click();
        return this;
    }

    public SignUpPO setEmail(String value) {
        InputBox email= new InputBox(driver.findElement(EMAIL_FIELD.getPath()));
        email.click();
        email.setData(value);
        return this;
    }

     public SignUpPO setUserName(String value) {
        InputBox username = new InputBox(driver.findElement(USERNAME_FIELD.getPath()));
        username.click();
        username.clear();
        username.setData(value);
        return this;
     }

     public SignUpPO setPassword(String value) {
        InputBox password = new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        password.click();
        password.clear();
        password.setData(value);
        return this;
     }


     public SignUpPO setConfirmedPassword(String value) {
        InputBox confirmedPassword = new InputBox(driver.findElement(CONFIRM_PASSWORD_FIELD.getPath()));
        confirmedPassword.click();
        confirmedPassword.clear();
        confirmedPassword.setData(value);
        return this;
     }


     public SignUpPO clickSignUpUserButton() {
         Button button = new Button(driver.findElement(SIGN_UP_USER_BTN.getPath()));
         button.click();
         return this;
     }
     public String alertEmailMessage() {
         Label label= new Label(driver.findElement(EMAIL_ALERT_MESSAGE.getPath()));
         return label.getText();
     }

     public String alertEmptyEmailMessage() {

        Label label = new Label(driver.findElement(EMPTY_EMAIL_FIELD_ALERT_MESSAGE.getPath()));
        return label.getText();
     }

     public String alertEmptyUsernameMessage() {

        Label label = new Label(driver.findElement(EMPTY_USERNAME_FIELD_ALERT_MESSAGE.getPath()));
        return label.getText();
     }

     public String alertEmptyPasswordMessage() {
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         Label label = new Label(driver.findElement(EMPTY_PASSWORD_FIELD_ALERT_MESSAGE.getPath()));
        return label.getText();
     }

     public String alertUserNameMessage() {
        Label label = new Label(driver.findElement(USERNAME_ALERT_MESSAGE.getPath()));
        return label.getText();
     }

     public String alertPasswordMessage() {
         Label label = new Label(driver.findElement(PASSWORD_FIELD_ALERT_MESSAGE.getPath()));
        return label.getText();
     }

    public String alertConfirmPasswordMessage() {
        Label label = new Label(driver.findElement(CONFIRM_PASSWORD_ALERT_MESSAGE.getPath()));
        return label.getText();
    }

    public String signedUpMessage() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Label label = new Label(driver.findElement(SIGNED_UP_USER_MESSAGE.getPath()));
        return label.getText();
    }

}
