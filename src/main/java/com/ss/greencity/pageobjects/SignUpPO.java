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

import static com.ss.greencity.locators.SignUpLocators.*;

/**
 *
 * An object of sign up page
 */
public class SignUpPO extends BasePageObject{

    //create fields with data

    public SignUpPO(WebDriver driver) {
        super(driver);

    }


    public SignUpPO clickSignUpButton() {
        WebElement signUpButton = driver.findElement(SIGN_UP_BTN.getPath());
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


     public SignUpPO clickConfirmPassword() {
         InputBox confirmedPassword = new InputBox(driver.findElement(CONFIRM_PASSWORD_FIELD.getPath()));
         confirmedPassword.click();
         return this;
     }

     public SignUpPO clickPassword() {
         InputBox password = new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
         password.click();
         return this;
     }


     public SignUpPO setConfirmedPassword(String value) {
        InputBox confirmedPassword = new InputBox(driver.findElement(CONFIRM_PASSWORD_FIELD.getPath()));
        confirmedPassword.click();
        confirmedPassword.clear();
        confirmedPassword.setData(value);
        return this;
     }

     public SignUpPO clearConfirmPassword() {
         InputBox confirmedPassword = new InputBox(driver.findElement(CONFIRM_PASSWORD_FIELD.getPath()));
         confirmedPassword.click();
         confirmedPassword.clear();
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
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Label label = new Label(driver.findElement(SIGNED_UP_USER_MESSAGE.getPath()));
        return label.getText();
    }
}
