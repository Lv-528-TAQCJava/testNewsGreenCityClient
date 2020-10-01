package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageelements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ss.greencity.locators.ForgetPasswordLocators.*;

/**
 *
 * An object of forget password page
 */
public class ForgetPasswordPO extends BasePageObject {

    private Label forgotPasswordTitle;
    private Label emailAlertMessage;
    private InputBox emailInputField;
    private Button submitLoginBTN;
    private Button googleSignInBTN;
    private Link backToSignInLink;


    public ForgetPasswordPO(WebDriver driver) {
        super(driver);

    }

    public String getforgotPasswordTitle() {
         forgotPasswordTitle= new Label(driver.findElement(FORGET_PASSWORD_LABEL.getPath()));
        return forgotPasswordTitle.getText();
    }
    public String getEmailAlertMessage() {
         emailAlertMessage= new Label(driver.findElement(EMAIL_ERROR_MESSAGE.getPath()));
        return emailAlertMessage.getText();
    }
    public Button getSubmitLoginBTN(){
        this.submitLoginBTN = new Button(driver.findElement(SUBMIT_LOGIN_BTN.getPath()));
        return submitLoginBTN;
    }
    public ForgetPasswordPO clickSubmitLoginBTN(){
        this.getSubmitLoginBTN().click();
        return this;
    }
    public Button getGoogleSignInBTN(){
        this.googleSignInBTN = new Button((driver.findElement((GOOGLE_SIGN_IN_BTN.getPath()))));
        return googleSignInBTN;
    }
    public ForgetPasswordPO clickGoogleSignInBTN(){
        this.getGoogleSignInBTN().click();
        return this;
    }
    public Link getBackToSignInLink(){
        this.backToSignInLink = new Link((driver.findElement(SIGN_IN_LINK.getPath())));
        return backToSignInLink;
    }
    public ForgetPasswordPO clickBackToSignInLink(){
        this.getBackToSignInLink().click();
        return this;
    }
    public InputBox getEmailInputField(){
        this.emailInputField = new InputBox((driver.findElement(EMAIL_FIELD.getPath())));
        return emailInputField;
    }
    public ForgetPasswordPO setEmail(String value){
        this.getEmailInputField().click().setData(value);
        return this;
    }
}
