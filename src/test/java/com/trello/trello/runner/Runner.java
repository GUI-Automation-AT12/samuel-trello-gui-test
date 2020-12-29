package com.trello.trello.runner;

import core.selenium.WebDriverManager;
import core.selenium.config.Environment;
import core.selenium.config.EnvironmentChrome;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/"},
        glue = {"stepdefs","com.trello.trello"}
)

public final class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Executes code before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() {
        System.setProperty("dataproviderthreadcount", "1");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    }

    /**
     * Executes code after all scenarios.
     */
    @AfterTest
    public void afterAllScenarios() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
