package com.test.webautomation.businessflows;

import com.test.webautomation.utils.KEY;

public class LaunchApp extends BaseBusinessFlow {
    public void launchAmazonIndia() {
        String url = "https://" + contextManager.get(KEY.APP_URL);
        contextManager.driver().get(url);
    }
}
