package com.selenium.automation.util;

import com.selenium.automation.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.selenium.automation.base.Base.driver;

public class CommonFunctions extends Base {

    public CommonFunctions(){
        super();
    }

    public void sendKey(WebElement element, String key) {
        element.clear();
        dummyWait(Duration.ofMillis(3));
        element.sendKeys(key);
    }

    public boolean clickElement(WebElement element) {
        boolean isElementClicked = false;
        try {
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElement(WebElement element, Duration timeOutInSecond, String elementName) {
        boolean isElementSuccessfullyClick;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Utils.logStepInfo(true, "clicked on " + elementName + " successfully");
            isElementSuccessfullyClick = true;
        } catch (Exception e) {
            Utils.logStepInfo(true, "clicked on " + elementName + " unsuccessful.");
            isElementSuccessfullyClick = false;
            e.printStackTrace();
        }
        return isElementSuccessfullyClick;
    }

    public boolean dummyWait(Duration timeOut) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Dummy")));
        } catch (Exception e) {
            Utils.logStepInfo(true, "Wait for " + timeOut + " sec");
        }
        return isElementDisplayed;
    }

    public void redirectToUrl(String url) {
        driver.get(url);
        waitForPageLoading();
    }
    public void redirectTourlSignUp(String urlSignUp) {
        driver.get(urlSignUp);
        waitForPageLoading();
    }

    public void waitForPageLoading() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
        } catch (Exception e) {
        }
    }

    public String getCurrentPageTile() {
        return driver.getTitle();
    }


}
