package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.DropdownList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HeaderSignedInComponent extends HeaderComponent {
    private DropdownList userProfile;

    public HeaderSignedInComponent(WebDriver driver) {
        super(driver);
    }

    public DropdownList getUserProfile() {
        userProfile = new DropdownList(element.findElement(HeaderLocators.USER_PROFILE.getPath()));
        return userProfile;
    }

    public EcoNewsArticlePO selectProfile() {
        DropdownList dropdown = getUserProfile();
        dropdown.click();
        ArrayList<Button> buttons = dropdown.getItems();
        buttons.get(1).click();
        return new EcoNewsArticlePO(driver);
    }

    public void signOut() {
        DropdownList dropdown = getUserProfile();
        dropdown.click();
        ArrayList<Button> buttons = dropdown.getItems();
        buttons.get(3).click();
    }
    public EcoNewsListPO goToEcoNewsPage(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(HeaderLocators.NEWS.getPath())).click();
        return new EcoNewsListPO(driver);
    }

}
