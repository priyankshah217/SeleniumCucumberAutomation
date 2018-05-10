package com.test.webautomation.businessflows;

import com.test.webautomation.pages.SearchPage;
import com.test.webautomation.utils.KEY;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchListing extends BaseBusinessFlow {
    public void checkMyProduct() {
        assertThat("Search result not found", new SearchPage().getListedProducts().contains(contextManager.get(KEY.PROUDCT_NAME).toString()));
    }
}
