package com.test.webautomation.businessflows;

import com.test.webautomation.pages.HomePage;

public class SearchProduct extends BaseBusinessFlow {
    public void searchProductFromCatalogue(String productCategory) {
        new HomePage().enterSearchCriteria(productCategory);
    }
}
