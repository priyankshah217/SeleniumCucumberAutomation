package com.test.webautomation.utils;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {

    private static ContextManager contextManager = ContextManager.getInstance();

    public static void embedScreenShotInReport(Scenario scenario, String scenarioName) {
        WebDriver driver = (WebDriver) contextManager.get(KEY.DRIVER);
        if (null != driver) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
    }
}
