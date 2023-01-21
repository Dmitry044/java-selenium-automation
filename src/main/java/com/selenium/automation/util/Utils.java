package com.selenium.automation.util;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static void logStepInfo(boolean isResult, String stepInfo) {

        System.out.println("-" + stepInfo);
        if (isResult) {
            Assert.assertTrue(isResult, stepInfo);
        } else {
            Assert.assertFalse(isResult, stepInfo);

        }
    }

    public static String readPropertiesFile(String keyName) {
        FileInputStream fileInputStream = null;
        Properties prop = null;
        try {
            fileInputStream = new FileInputStream(
                    "config.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        keyName = (String) prop.get(keyName);
        return keyName;
    }
}
