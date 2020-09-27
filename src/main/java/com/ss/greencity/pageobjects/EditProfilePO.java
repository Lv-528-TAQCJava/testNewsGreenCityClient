package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EditProfileLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.CheckBox;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;

public class EditProfilePO extends BasePageObject {

    private Label header;

    private InputBox nameInput;
    private InputBox cityInput;
    private InputBox credoInput;

    private Label nameInputHint;
    private Label cityInputHint;
    private Label credoInputHint;

    private CheckBox showLocationCheckBox;
    private CheckBox showPlacesCheckBox;
    private CheckBox showShoppingCheckBox;

    private Button cancelBttn;
    private Button submitBttn;

    public Label getNameInputHint() {
        return nameInputHint;
    }

    public Label getCityInputHint() {
        return cityInputHint;
    }

    public Label getCredoInputHint() {
        return credoInputHint;
    }

    public String getCurrentName() {
        return nameInput.getValue();
    }

    public String getCurrentCity() {
        return cityInput.getValue();
    }

    public String getCurrentCredo() {
        return credoInput.getValue();
    }

    public boolean getShowLocationState() {
        return showLocationCheckBox.isChecked();
    }

    public boolean getShowEcoPlacesState() {
        return showPlacesCheckBox.isChecked();
    }

    public boolean getShowShoppingListState() {
        return showShoppingCheckBox.isChecked();
    }

    public InputBox getNameInput() {
        return nameInput;
    }

    public InputBox getCityInput() {
        return cityInput;
    }

    public InputBox getCredoInput() {
        return credoInput;
    }

    public EditProfilePO(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        header = new Label(driver.findElement(EditProfileLocators.HEADER.getPath()));

        nameInput = new InputBox(driver.findElement(EditProfileLocators.NAME_INPUT.getPath()));
        cityInput = new InputBox(driver.findElement(EditProfileLocators.CITY_INPUT.getPath()));
        credoInput = new InputBox(driver.findElement(EditProfileLocators.CREDO_INPUT.getPath()));

        nameInputHint = new Label(driver.findElement(EditProfileLocators.NAME_WARNING.getPath()));
        cityInputHint = new Label(driver.findElement(EditProfileLocators.CITY_WARNING.getPath()));
        credoInputHint = new Label(driver.findElement(EditProfileLocators.CREDO_WARNING.getPath()));

        showLocationCheckBox = new CheckBox(driver.findElement(EditProfileLocators.SHOW_LOCATION.getPath()));
        showPlacesCheckBox = new CheckBox(driver.findElement(EditProfileLocators.SHOW_ECOPLACES.getPath()));
        showShoppingCheckBox = new CheckBox(driver.findElement(EditProfileLocators.SHOW_SHOPPINGS.getPath()));

        cancelBttn = new Button(driver.findElement(EditProfileLocators.CANCEL_BUTTON.getPath()));
        submitBttn = new Button(driver.findElement(EditProfileLocators.SUBMIT_BUTTON.getPath()));
    }

    public EditProfilePO enterName(String name, boolean append) {
        nameInput.click();
        if(!append) {
            nameInput.clear();
        }
        nameInput.setData(name);
        return this;
    }

    public EditProfilePO enterCity(String city, boolean append) {
        cityInput.click();
        if(!append) {
            cityInput.clear();
        }
        cityInput.setData(city);
        return this;
    }

    public EditProfilePO enterCredo(String credo, boolean append) {
        credoInput.click();
        if(!append) {
            credoInput.clear();
        }
        credoInput.setData(credo);
        return this;
    }

    public EditProfilePO setShowLocationCheckBox(boolean state) {
        if(state) {
            showLocationCheckBox.check();
        } else {
            showLocationCheckBox.uncheck();
        }
        return this;
    }

    public EditProfilePO setShowEcoPlaces(boolean state) {
        if(state) {
            showPlacesCheckBox.check();
        } else {
            showPlacesCheckBox.uncheck();
        }
        return this;
    }

    public EditProfilePO setShowShoppingList(boolean state) {
        if(state) {
            showShoppingCheckBox.check();
        } else {
            showShoppingCheckBox.uncheck();
        }
        return this;
    }

    /**
     * Method is not finished yet, because I need ready-to-use Profile page object to return it
     */
    public ProfilePO submitByButton() {
        submitBttn.click();
        return new ProfilePO(driver);
    }

    public ConfirmCancelationPO cancelChanges() {
        cancelBttn.click();
        return new ConfirmCancelationPO(driver);
    }
}
