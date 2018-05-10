package com.test.webautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private ContextManager contextManager = ContextManager.getInstance();

    public WebDriver getDriver() {
        String browserType = contextManager.get(KEY.BROWSER_TYPE).toString();
        WebDriver webDriver;
        switch (browserType) {
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", contextManager.get(KEY.GECKO_DRIVER_PATH).toString());
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability(FirefoxDriver.MARIONETTE, false);
                FirefoxProfile geoDisabled = new FirefoxProfile();
                geoDisabled.setPreference("geo.enabled", false);
                geoDisabled.setPreference("xpinstall.signatures.required", false);
                geoDisabled.setPreference("geo.provider.use_corelocation", false);
                geoDisabled.setPreference("geo.prompt.testing", false);
                geoDisabled.setPreference("geo.prompt.testing.allow", false);
                capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
                webDriver = new FirefoxDriver();
                break;
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", contextManager.get(KEY.CHROME_DRIVER_PATH).toString());
                webDriver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type addToContext in class injection " + browserType);

        }
        initWebDriver(webDriver);
        return webDriver;
    }

    private void initWebDriver(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

}
