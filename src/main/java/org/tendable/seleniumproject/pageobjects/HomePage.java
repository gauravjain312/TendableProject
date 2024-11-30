package org.tendable.seleniumproject.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tendable.seleniumproject.common.CommonElementMethods;

// objects for Top Menu
public class HomePage {
    @FindBy(css = ".navbar7_menu-left > a:nth-of-type(1)")
    WebElement aboutLink;
    @FindBy(css = ".navbar7_menu-left > a:nth-of-type(2)")
    WebElement productsLink;
    @FindBy(css = ".navbar7_menu-left > a:nth-of-type(3)")
    WebElement sectorsLink;
    @FindBy(css = ".navbar7_menu-left > a:nth-of-type(4)")
    WebElement contentHubLink;
    @FindBy(css = ".navbar7_menu-left > a:nth-of-type(5)")
    WebElement contactLink;
    @FindBy(css = ".navbar7_menu-right .w-button:nth-of-type(2)")
    WebElement bookADemoLink;

    private WebDriver driver;
    private CommonElementMethods commonElementMethods = new CommonElementMethods();

    // Constructor with PageFactory initialization for Home Page
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Verify if About Link is present
    public boolean isAboutLinkPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, aboutLink);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Products Link is present
    public boolean isProductsLinkPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, productsLink);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Sectors Link is present
    public boolean isSectorsLinkPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, sectorsLink);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Content Hub Link is present
    public boolean isContentHubLinkPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, contentHubLink);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Contact Link is present
    public boolean isContactLinkPresent() {
        try {
            return commonElementMethods.isElementDisplayed(driver, contactLink);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Book a Demo Link is present and Enabled
    public boolean isBookADemoLinkPresentAndEnabled() {
        boolean isBookADemoLinkPresent = false;
        try {
            if (commonElementMethods.isElementDisplayed(driver, bookADemoLink)
                    && commonElementMethods.isElementEnabled(bookADemoLink)) {
                if (commonElementMethods.getElementText(bookADemoLink).equals("Book a demo")
                ) {
                    isBookADemoLinkPresent = true;
                };
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return isBookADemoLinkPresent;
    }
}