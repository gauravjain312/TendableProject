package org.tendable.seleniumproject.common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

// Class to store common methods for WebElement
public class CommonElementMethods {

    // Method to check if the element is displayed
    public boolean isElementDisplayed(WebDriver driver, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    // Method to get the text of the element
    public String getElementText(WebElement element) {
        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    // Method to set the text of the element
    public void setElementText(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (NoSuchElementException e) {
            System.out.println("setElementText: Element not found");
        }
    }

    // Method to click the element
    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("clickElement: Element not found");
        }
    }

    // Method to verify the element is enabled
    public boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to select the value of the dropdown
    public void selectDropdownValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (NoSuchElementException e) {
            System.out.println("SelectDropdown: Element not found");
        }
    }
}