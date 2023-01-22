package com.selenium.automation.registration;

import com.selenium.automation.util.CommonFunctions;
import com.selenium.automation.util.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.selenium.automation.base.Base.driver;

public class RegistrationPage {

    public static CommonFunctions commonFunctions;
    @FindBy(xpath="//input[@id='email']")
    private WebElement email;

    @FindBy(xpath="//input[@id='password']")
    private WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement signUpButton;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
        commonFunctions = new CommonFunctions();
    }


    public boolean verifyBySingUp(){
        boolean isSignedIn = false;
        driver.manage().deleteAllCookies();
        commonFunctions.redirectToUrl(Utils.readPropertiesFile("urlSignUp"));
        commonFunctions.clickElement(email);
        commonFunctions.sendKey(email, Utils.readPropertiesFile("email"));

        commonFunctions.sendKey(password, Utils.readPropertiesFile("password"));

        commonFunctions.clickElement(signUpButton, Duration.ofSeconds(5), "sign Up Button");

        String title = commonFunctions.getCurrentPageTile();
        System.out.println("title = "+title);
        isSignedIn = title.equalsIgnoreCase("Sign up for Codecademy | 7 Day Trial of Pro Features | Codecademy");
        //Sign up for Codecademy | 7 Day Trial of Pro Features | Codecademy
        //Welcome | Codecademy

        if (isSignedIn) {
            Utils.logStepInfo(isSignedIn,
                    "User - " + Utils.readPropertiesFile("email") + " Signed in successfully in app");
        } else {
            Utils.logStepInfo(isSignedIn,
                    "User - " + Utils.readPropertiesFile("email") + " is not Signed Up in app");
        }
        return isSignedIn;
    }
}
