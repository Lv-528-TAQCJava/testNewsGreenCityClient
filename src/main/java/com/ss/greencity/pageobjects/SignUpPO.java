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

    private InputBox email;

    private InputBox username;

    private InputBox password;

    private InputBox confirmPassword;

    private Button signUp;

    private WebElement imagePanel;

    private Button signUpUser;


    public SignUpPO(WebDriver driver) {
        super(driver);

    }

    /**
     * Click Sign Up method
     */
    public SignUpPO clickSignUpButton() {
        this.getSignUpButton().click();
        return this;
    }

    public Button getSignUpButton() {
        signUp = new Button(driver.findElement(SIGN_UP.getPath()));
        return this.signUp;
    }

    /**
     * Click Image method
     */
    public SignUpPO clickImagePanel() {
        this.getImagePanel().click();
        return this;
    }
    public WebElement getImagePanel() {
        imagePanel = driver.findElement(IMAGE_PANEL.getPath());
        return this.imagePanel;
    }

    /**
     * Email methods
     */
    public String getEmail() {
        return "user"+Math.random()*100000+"@selenium.test";
    }

    public InputBox getEmailInput() {
        email = new InputBox(driver.findElement(EMAIL_FIELD.getPath()));
        return this.email;
    }
    public SignUpPO setEmail(String value) {
        this.getEmailInput().click().setData(value);
        return this;
    }

    /**
     * Username methods
     */
    public String getUsername() {
        return "User"+Math.random()*100000;
    }
    public InputBox getUsernameInput() {
        username = new InputBox(driver.findElement(USERNAME_FIELD.getPath()));
        return this.username;
    }
    public SignUpPO setUserName(String value) {
        this.getUsernameInput().click().setData(value);
        return this;
    }

    /**
     * Password methods
     */
    public String getPassword() {
        return "Aa123456_";
    }
    public InputBox getPasswordInput() {
        password = new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        return this.password;
    }

    public SignUpPO setPassword(String value) {
        this.getPasswordInput().click().setData(value);
        return this;
    }

    /**
     * Confirm password methods
     */
    public String getConfirmPassword() {
        return "Aa123456_";
    }

    public InputBox getConfirmPasswordInput() {
        confirmPassword = new InputBox(driver.findElement(CONFIRM_PASSWORD_FIELD.getPath()));
        return this.confirmPassword;
    }

    public SignUpPO setConfirmedPassword(String value) {
        this.getConfirmPasswordInput().click().setData(value);
        return this;
    }

    /**
     * Invalid email method
     */
    public String getInvalidEmail() {
        return "user"+Math.random()*100000+".selenium.test";
    }

    /**
     * Invalid username method
     */
    public String getInvalidUsername() {
        return "User";
    }

    /**
     * Invalid password method
     */
    public String getInvalidPassword() {
        return "1111";
    }

    /**
     * Invalid confirm password method
     */
    public String getInvalidConfirmPassword() {
        return "1111";
    }

    /**
     * Invalid password spaces method
     */
    public String getInvalidPasswordSpaces() {
        return "    ";
    }

    /**
     * Invalid confirm password spaces method
     */
    public String getInvalidConfirmPasswordSpaces() {
        return "   ";
    }

    /**
     * Sign Up User button method
     */
     public SignUpPO clickSignUpUserButton() {
         this.getSignUpUserButton().click();
         return this;
     }

     public Button getSignUpUserButton() {
         signUpUser = new Button(driver.findElement(SIGN_UP_USER_BTN.getPath()));
         return this.signUpUser;
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
