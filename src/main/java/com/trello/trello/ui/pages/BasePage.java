package com.trello.trello.ui.pages;

import core.selenium.WebDriverHelper;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage class.
 */
public abstract class BasePage {

    private WebDriver webDrive;
    private WebDriverWait webDriveWait;

    /**
     * Constructor for BasePage.
     */
    public BasePage() {
        this.webDrive = WebDriverManager.getInstance().getWebDrive();
        this.webDriveWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDrive, this);
    }

    /**
     * Method to clickElement.
     * @param webElement
     */
    public void clickElement(final WebElement webElement) {
        WebDriverHelper.waitUntil(webElement);
        webElement.click();
    }

     /**
     * Gets CurrentUrl.
     * @return current URL
     */
    public String getCurrentUrl() {
        return webDrive.getCurrentUrl();
    }
}
