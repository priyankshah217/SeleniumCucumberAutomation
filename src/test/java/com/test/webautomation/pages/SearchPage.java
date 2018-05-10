package com.test.webautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(id = "autoscoping-backlink")
    private WebElement suggestionLabel;

    public String getListedProducts() {
        waitForElementToBeClickable(suggestionLabel);
        return suggestionLabel.getText().toLowerCase();
    }
}
