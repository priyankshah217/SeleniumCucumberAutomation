package com.test.webautomation.utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private ContextManager contextManager = ContextManager.getInstance();

    public WebDriver getDriver() throws MalformedURLException {
        String browserType = System.getProperty("BrowserType");
        String hostName = System.getProperty("SeleniumHub") == null ? "localhost" : System.getProperty("SeleniumHub");
        WebDriver webDriver;
        MutableCapabilities options;
        switch (browserType) {
            case BrowserType.FIREFOX:
                options = new FirefoxOptions();
                break;
            case BrowserType.CHROME:
                options = new ChromeOptions();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type addToContext in class injection " + browserType);

        }
        webDriver = new RemoteWebDriver(new URL("http://" + hostName + ":4444/wd/hub"), options);
        initWebDriver(webDriver);
        return webDriver;
    }

    private void initWebDriver(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

}
