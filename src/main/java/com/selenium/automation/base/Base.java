package com.selenium.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public static WebDriver driver;

    public void initializeDriver(String browser) {
        System.out.println("***** Driver Initialization Start *******");

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "/Users/dmitryavdeenko/Documents/Tools/chromedriver_mac_arm64/chromedriver");
                ///chromedriver_mac/chromedriver
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                System.out.println("***** Driver Initialization End *******");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
