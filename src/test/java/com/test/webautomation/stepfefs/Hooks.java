package com.test.webautomation.stepfefs;

import com.test.webautomation.utils.ContextManager;
import com.test.webautomation.utils.DriverFactory;
import com.test.webautomation.utils.KEY;
import com.test.webautomation.utils.ScreenShotUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;


public class Hooks {

    private ContextManager contextManager = ContextManager.getInstance();

    private void loadConfigPropertiesToContext() {
        try {
            Properties properties = new Properties();
            String projectDir = System.getProperty("user.dir");
            FileInputStream inputStream = new FileInputStream(new File(projectDir + "/src/test/resources/AutomationConfig.properties"));
            properties.load(inputStream);
            contextManager.addToContext(KEY.BROWSER_TYPE, System.getProperty("browser.type"));
            contextManager.addToContext(KEY.GECKO_DRIVER_PATH, properties.getProperty("firefox.driver.path"));
            contextManager.addToContext(KEY.CHROME_DRIVER_PATH, properties.getProperty("chrome.driver.path"));
            contextManager.addToContext(KEY.APP_URL, properties.getProperty("application.url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDriver() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.getDriver();
        try {
            contextManager.addToContext(KEY.DRIVER, driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void init() throws MalformedURLException {
        loadConfigPropertiesToContext();
        initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        ScreenShotUtils.embedScreenShotInReport(scenario, scenario.getName());
        contextManager.driver().quit();
    }
}
