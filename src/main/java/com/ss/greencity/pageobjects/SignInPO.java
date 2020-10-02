package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageelements.Link;
import com.ss.greencity.util.GoogleWindowSwitch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static com.ss.greencity.locators.SignInLocators.*;
import static com.ss.greencity.locators.SignUpLocators.SIGNED_UP_USER_MESSAGE;


/**
 *
 * An object of sign in page
 */
public class SignInPO extends BasePageObject implements ILoggedInPO {

    private InputBox email;
    private InputBox password;
    private WebElement signInButton;
    private WebElement imagePanel;
    private Button signInUserButton;
    private Button googleSignInButton;
    private Link forgotPassword;
    private Label alertEmailMessage;
    private Label alertEmptyEmailMessage;
    private Label alertEmptyPasswordMessage;
    private Label alertPasswordMessage;
    private Label alertBadEmailOrPasswordMessage;
    private Label SignInTitle;
    private  Set<String> oldWindowsSet;
    private static String originalWindow;
    private String newWindow;

    public SignInPO(WebDriver driver) {
        super(driver);

    }

    public String  getSignInTitle (){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInTitle = new Label(driver.findElement(SIGN_IN_TITLE.getPath()));
        return SignInTitle.getText();
    }

    public static String getOriginalWindow() {
        return originalWindow;
    }

    public WebElement getSignInButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(SIGN_IN_BTN.getPath()));
        this.signInButton = driver.findElement(SIGN_IN_BTN.getPath());
        return signInButton;
    }

    public SignInPO clickSignInButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getSignInButton().click();
        return this;
    }

    public WebElement getImagePanel() {
        imagePanel = driver.findElement(IMAGE_PANEL.getPath());
        return imagePanel;
    }

    public SignInPO clickImagePanel() {
        this.getImagePanel().click();
        return this;
    }

    public InputBox getEmail(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(EMAIL_FIELD.getPath()));
        email= new InputBox(driver.findElement(EMAIL_FIELD.getPath()));
        return email;
    }

    public SignInPO setEmail(String value) {
        this.getEmail().click().setData(value);
        return this;
    }

    public InputBox getPassword(){
        password = new InputBox(driver.findElement(PASSWORD_FIELD.getPath()));
        return password;
    }

    public SignInPO setPassword(String value) {
        this.getPassword().click().setData(value);
        return this;
    }

    public Button getSignInUserButton(){
        signInUserButton = new Button(driver.findElement(SIGN_IN_USER_BTN.getPath()));
        return signInUserButton;

    }

    public SignInPO clickSignInUserButton() {
        this.getSignInUserButton().click();
        return this;
    }

    /**
     * For successful sign in scenarios
     */
    public SignInPO waitForSingInFormClosed() {
        //if there is no "forgot password" button, probably the form is closed and user is logged in
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .invisibilityOfElementLocated(FORGOT_PASSWORD_BTN.getPath()));
        return this;
    }

    public Button getGoogleSignInButton(){
        googleSignInButton = new Button(driver.findElement(GOOGLE_SIGN_IN_BTN.getPath()));
        return googleSignInButton;
    }

    public SignInPO clickGoogleSignInButton() {
        originalWindow = driver.getWindowHandle();
        oldWindowsSet = driver.getWindowHandles();
        this.getGoogleSignInButton().click();
        newWindow = GoogleWindowSwitch.WindowsHandling(oldWindowsSet, driver);
        driver.switchTo().window(newWindow);
        return this;
    }

    public Link getForgotPassword(){
        forgotPassword = new Link(driver.findElement(FORGOT_PASSWORD_BTN.getPath()));
        return forgotPassword;
    }

    public SignInPO clickForgotPassword() {
        this.getForgotPassword().click();
        return this;
    }

    public String alertEmailMessage() {
        alertEmailMessage = new Label(driver.findElement(EMAIL_ALERT_MESSAGE.getPath()));
        return alertEmailMessage.getText();
    }

    public String alertEmptyEmailMessage() {
        alertEmptyEmailMessage = new Label(driver.findElement(EMPTY_EMAIL_FIELD_ALERT_MESSAGE.getPath()));
        return alertEmptyEmailMessage.getText();
    }

    public String alertEmptyPasswordMessage() {
        alertEmptyPasswordMessage = new Label(driver.findElement(EMPTY_PASSWORD_FIELD_ALERT_MESSAGE.getPath()));
        return alertEmptyPasswordMessage.getText();
    }

    public String alertPasswordMessage() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(PASSWORD_LENGTH_ALERT_MESSAGE.getPath()));
        alertPasswordMessage= new Label(driver.findElement(PASSWORD_LENGTH_ALERT_MESSAGE.getPath()));
        return alertPasswordMessage.getText();
    }

    public String alertBadEmailOrPasswordMessage() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(INCORRECT_EMAIL_OR_PASSWORD_ALERT_MASSAGE.getPath()));
        alertBadEmailOrPasswordMessage = new Label(driver.findElement(INCORRECT_EMAIL_OR_PASSWORD_ALERT_MASSAGE.getPath()));
        return  alertBadEmailOrPasswordMessage.getText();
    }
    public ProfilePO signIn(String email, String password){
        clickSignInButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInUserButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ProfilePO(driver);
    }

    public ProfilePO getProfilePO (){
        return new ProfilePO(driver);
    }

    public GoogleSignInPO getGoogleSignInPO (){
        return new GoogleSignInPO(driver);
    }

    public ForgetPasswordPO getForgetPasswordPO (){
        return new ForgetPasswordPO(driver);
    }

    public SignInPO switchWindow(String window){
        driver.switchTo().window(window);
        return this;
    }
}
