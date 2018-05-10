package com.test.webautomation.pages;

import com.test.webautomation.utils.ContextManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    private final WebDriver driver;
    protected final ContextManager contextManager;

    BasePage() {
        contextManager = ContextManager.getInstance();
        driver = contextManager.driver();
        PageFactory.initElements(driver, this);
    }

    boolean waitForElementToBeClickable(WebElement webElement, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (TimeoutException | NoSuchElementException ex) {
            return false;
        }
    }

    boolean waitForElementToBeClickable(WebElement webElement) {
        return waitForElementToBeClickable(webElement, 30);
    }

    void enterText(WebElement webElement, String textValue) {
        enterText(webElement, textValue, 30);
    }

    void enterText(WebElement webElement, String textValue, int timeout) {
        if (waitForElementToBeClickable(webElement, timeout)) {
            try {
                webElement.click();
                webElement.clear();
            } catch (InvalidElementStateException ex) {
                ex.printStackTrace();
            }
            webElement.sendKeys(textValue);
        }
    }

    void click(WebElement webElement) {
        click(webElement, 30);
    }

    void click(WebElement webElement, int timeout) {
        if (waitForElementToBeClickable(webElement, timeout)) {
            webElement.click();
        }
    }
}
