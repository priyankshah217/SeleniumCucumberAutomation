package com.test.webautomation.stepfefs;

import com.test.webautomation.businessflows.LaunchApp;
import com.test.webautomation.businessflows.SearchListing;
import com.test.webautomation.businessflows.SearchProduct;
import cucumber.api.java8.En;

public class SearchProductStepDefs implements En {

    public SearchProductStepDefs() {

        Given("^I open amazon site$", () -> {
            new LaunchApp().launchAmazonIndia();
        });

        When("^I search product name as \"([^\"]*)\"$", (String productCategory) -> {
            new SearchProduct().searchProductFromCatalogue(productCategory);
        });

        Then("^It should show me listed relevant product only$", () -> {
            new SearchListing().checkMyProduct();
        });

    }
}
