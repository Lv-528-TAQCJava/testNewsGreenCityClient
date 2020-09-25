package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ss.greencity.locators.GoogleSignInLocators.*;

public class GoogleSignInPO extends BasePageObject {

    public GoogleSignInPO(WebDriver driver) {
        super(driver);

    }

    public GoogleSignInPO setEmail_Phone(String value) {
        InputBox email_phone= new InputBox(driver.findElement(EMAIL_PHONE_FIELD.getPath()));
        email_phone.click();
        email_phone.setData(value);
        return this;
    }

    public GoogleSignInPO setPassword(String value) {
        InputBox password= new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        password.click();
        password.setData(value);
        return this;
    }

    public GoogleSignInPO clickEmailNextBTN(){
        Button EmailNextBTN = new Button(driver.findElement(EMAIL_NEXT_BTN.getPath()));
        EmailNextBTN.click();
        return this;
    }

    public GoogleSignInPO clickPasswordNextBTN(){
        Button PasswordNextBTN = new Button(driver.findElement(PASSWORD_NEXT_BTN.getPath()));
        PasswordNextBTN.click();
        return this;
    }

}
