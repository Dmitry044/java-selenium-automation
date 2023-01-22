package com.selenium.automation.login;

import com.selenium.automation.base.Base;
import com.selenium.automation.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationPageTest extends Base {

    public RegistrationPage registrationPage;

    public RegistrationPageTest() {
        super();
    }

    @BeforeMethod
    public void beforeMethod() {
        initializeDriver("chrome");
        registrationPage = new RegistrationPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test
    public void registrationFunctionality() {
        boolean isSignUp;
        isSignUp=registrationPage.verifyBySingUp();
        Assert.assertTrue(isSignUp);
    }


}
