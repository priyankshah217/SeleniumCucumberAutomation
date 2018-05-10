package com.test.webautomation.utils;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ContextManager {

    private static ContextManager contextManager;
    private static HashMap<Object, Object> contextMap = new HashMap<>();

    private ContextManager() {

    }

    public static ContextManager getInstance() {
        if (contextManager == null)
            return new ContextManager();
        else
            return contextManager;
    }

    public void addToContext(KEY key, Object value) {
        addToContext(key.name(), value);
    }

    private void addToContext(String keyName, Object value) {
        contextMap.put(keyName, value);
    }

    public WebDriver driver() {
        return (WebDriver) get(KEY.DRIVER);
    }

    public Object get(KEY key) {
        return get(key.name());
    }

    private Object get(String keyName) {
        return contextMap.get(keyName);
    }

}
