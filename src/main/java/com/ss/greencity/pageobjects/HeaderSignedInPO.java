package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.DropdownList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSignedInPO extends HeaderPO {
    private DropdownList userProfile;

    public HeaderSignedInPO(WebDriver driver) {
        super(driver);
    }

    public HeaderSignedInPO(WebElement element) {
        super(element);
    }
    public DropdownList getUserProfile() {
        userProfile = new DropdownList(element.findElement(HeaderLocators.USER_PROFILE.getPath()));
        return userProfile;
    }
}
