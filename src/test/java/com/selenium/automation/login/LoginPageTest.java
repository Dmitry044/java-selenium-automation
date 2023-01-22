package com.selenium.automation.login;

import com.selenium.automation.base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {

    public LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void beforeMethod() {
        initializeDriver("chrome");
        loginPage = new LoginPage();
    }

    @Test
    public void loginFunctionality() {
        boolean isLogin;
        isLogin=loginPage.verifyByLogin();
        Assert.assertTrue(isLogin);
    }


}
