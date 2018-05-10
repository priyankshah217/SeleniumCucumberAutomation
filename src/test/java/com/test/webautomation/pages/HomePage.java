package com.test.webautomation.pages;

import com.test.webautomation.utils.KEY;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "suggestions")
    private List<WebElement> suggestionDropDownList;

    @FindBy(id = "suggestions")
    private WebElement suggestionDropDown;

    public void enterSearchCriteria(String productCategory) {
        contextManager.addToContext(KEY.PROUDCT_NAME, productCategory);
        enterText(searchTextBox, productCategory);
        waitForElementToBeClickable(suggestionDropDown);
        click(suggestionDropDownList.get(0));
    }
}
