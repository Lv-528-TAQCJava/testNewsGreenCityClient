package com.ss.greencity.util;

import com.ss.greencity.pageobjects.SignUpPO;
import org.openqa.selenium.WebDriver;

/**
 * A 'static' class intended to help closing pop-up windows (such as sign in form) if they suddenly appear
 */
public final class PopUpWindowsCloser {
    private PopUpWindowsCloser() {

    }
    /**
     * Closes sign up form if it appears on the page
     */
    public static void closeSignUpForm(WebDriver driver) {
        WaitsSwitcher.sleep(0.5);
        SignUpPO signUpForm = new SignUpPO(driver);
        boolean formAppeared = signUpForm.closeForm();
        if (formAppeared) {
            System.out.println("Sign up form appeared...");
        }

    }
}
