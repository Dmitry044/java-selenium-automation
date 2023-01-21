package com.selenium.automation.login;

import com.selenium.automation.base.Base;
import com.selenium.automation.util.CommonFunctions;
import com.selenium.automation.util.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class LoginPage extends Base {
    public static CommonFunctions commonFunctions;
    @FindBy(xpath="//input[@id='user_login']")
    private WebElement email;

    @FindBy(xpath="//input[@id='login__user_password']")
    private WebElement password;

    @FindBy(xpath="(//button[@class='e1w6mdco0 gamut-18luxs6-ResetElement-createButtonComponent e1bhhzie0'])")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        commonFunctions = new CommonFunctions();
    }


    public boolean verifyByLogin(){
        boolean isLoggedIn = false;
        driver.manage().deleteAllCookies();
        commonFunctions.redirectToUrl(Utils.readPropertiesFile("url"));
        commonFunctions.clickElement(email);
        commonFunctions.sendKey(email, Utils.readPropertiesFile("email"));

        commonFunctions.sendKey(password, Utils.readPropertiesFile("password"));

        commonFunctions.clickElement(loginButton, Duration.ofMillis(5), "Login Button");

        String title = commonFunctions.getCurrentPageTile();
        System.out.println("title = "+title);
        isLoggedIn = title.equalsIgnoreCase("Log in | Codecademy");

        if (isLoggedIn) {
            Utils.logStepInfo(isLoggedIn,
                    "User - " + Utils.readPropertiesFile("email") + " Logged in successfully in app");
        } else {
            Utils.logStepInfo(isLoggedIn,
                    "User - " + Utils.readPropertiesFile("email") + " is not Logged in app");
        }
        return isLoggedIn;
    }

}
