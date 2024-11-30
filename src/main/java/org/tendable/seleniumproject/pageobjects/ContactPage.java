package org.tendable.seleniumproject.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tendable.seleniumproject.common.CommonElementMethods;

public class ContactPage{
    @FindBy(css = ".contact1_form-block #email")
    WebElement emailInput;
    @FindBy(css = ".contact1_form-block #firstname")
    WebElement firstNameInput;
    @FindBy(css = ".contact1_form-block #lastname")
    WebElement lastNameInput;
    @FindBy(css = ".contact1_form-block #company")
    WebElement companyInput;
    @FindBy(css = "form[name='Form'] select[name='message_type']")
    WebElement messageTypeSelect;
    @FindBy(css = "form[name='Form'] input[type='checkbox']")
    WebElement agreeToReceiveCheckbox;
    @FindBy(css = "form[name='Form'] button[type='submit']")
    WebElement submitButton;
    @FindBy(css = "div:nth-child(12)")
    WebElement errorMessage;

    private WebDriver driver;
    private CommonElementMethods commonElementMethods = new CommonElementMethods();

    // Constructor with PageFactory initialization for Contact Page
    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Verify if Email field is present
    public boolean isEmailInputPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, emailInput);
        } catch (NoSuchElementException | NullPointerException e) {
            return false;
        }
    }

    // Verify if First Name field is present
    public boolean isFirstNameInputPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, firstNameInput);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Last Name field is present
    public boolean isLastNameInputPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, lastNameInput);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Company field is present
    public boolean isCompanyInputPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, companyInput);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Message Type Select Dropdown is present
    public boolean isMessageTypeSelectPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, messageTypeSelect);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Agree To Receive Checkbox is present
    public boolean isAgreeToReceiveCheckboxPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, agreeToReceiveCheckbox);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Submit Button is present
    public boolean isSubmitButtonPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, submitButton);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Error Message is present
    public boolean isErrorMessagePresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, errorMessage);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify Error Validation Text
    public String getErrorValidationMessage() {
        try {
            return commonElementMethods.getElementText(errorMessage);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    // Fill Contact Form except the Message Field
    public void fillContactForm(String email, String firstName, String lastName,
                                String companyName, String messageType) {
        commonElementMethods.setElementText(emailInput, email);
        commonElementMethods.setElementText(firstNameInput, firstName);
        commonElementMethods.setElementText(lastNameInput, lastName);
        commonElementMethods.setElementText(companyInput, companyName);
        commonElementMethods.selectDropdownValue(messageTypeSelect, messageType);
        commonElementMethods.clickElement(agreeToReceiveCheckbox);
        commonElementMethods.clickElement(submitButton);
    }
}