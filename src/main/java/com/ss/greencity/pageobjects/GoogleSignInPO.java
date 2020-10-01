package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.util.GoogleWindowSwitch;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.ss.greencity.locators.GoogleSignInLocators.*;
import static com.ss.greencity.pageobjects.SignInPO.getOriginalWindow;

public class GoogleSignInPO extends BasePageObject {

    private InputBox email_phone;
    private InputBox password;
    private Button emailNextBTN;
    private Button passwordNextBTN;

    public GoogleSignInPO(WebDriver driver) {
        super(driver);

    }

    public InputBox getEmail_Phone(){
        email_phone= new InputBox(driver.findElement(EMAIL_PHONE_FIELD.getPath()));
        return email_phone;
    }

    public GoogleSignInPO setEmail_Phone(String value) {
       this.getEmail_Phone().click().setData(value);
        return this;
    }

    public InputBox getPassword(){
        password= new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        return password;
    }

    public GoogleSignInPO setPassword(String value) {
        this.getPassword().click().setData(value);
       return this;
    }

    public Button getEmailNextBTN(){
        emailNextBTN = new Button(driver.findElement(EMAIL_NEXT_BTN.getPath()));
        return emailNextBTN;
    }

    public GoogleSignInPO clickEmailNextBTN(){
        this.getEmailNextBTN().click();
        return this;
    }

    public Button getPasswordNextBtn(){
      passwordNextBTN = new Button(driver.findElement(PASSWORD_NEXT_BTN.getPath()));
      return passwordNextBTN;
    }

    public GoogleSignInPO clickPasswordNextBTN(){
        this.getPasswordNextBtn().click();
        getSignInPO().switchWindow(getOriginalWindow());
        return this;
    }
    public ProfilePO getProfilePO (){
        return new ProfilePO(driver);
    }

    public SignInPO getSignInPO(){
        return  new SignInPO(driver);
    }

}
