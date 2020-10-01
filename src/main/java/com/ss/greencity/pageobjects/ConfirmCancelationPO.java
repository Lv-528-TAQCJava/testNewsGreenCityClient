package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.CancelationPopupLocators;
import com.ss.greencity.pageelements.Button;
import org.openqa.selenium.WebDriver;

public class ConfirmCancelationPO extends BasePageObject {

    private Button confirm;
    private Button cancel;

    public ConfirmCancelationPO(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        cancel = new Button(driver.findElement(CancelationPopupLocators.CANCEL_BUTTON.getPath()));
        confirm = new Button(driver.findElement(CancelationPopupLocators.CONFIRM_BUTTON.getPath()));
    }

    public ProfilePO confirm() {
        confirm.click();
        return new ProfilePO(driver);
    }

    public EditProfilePO cancel() {
        cancel.click();
        return new EditProfilePO(driver);
    }
    public CreateNewsPO clickContinueEditing(){
        confirm.click();
        return new CreateNewsPO(driver);
    }
    public EcoNewsListPO clickYesCancelButton(){
        cancel.click();
        return new EcoNewsListPO(driver);
    }
}
