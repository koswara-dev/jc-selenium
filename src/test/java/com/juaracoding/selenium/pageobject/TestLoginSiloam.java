package com.juaracoding.selenium.pageobject;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import com.juaracoding.selenium.pageobject.pages.LoginSiloam;
import com.juaracoding.selenium.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginSiloam {
    public static WebDriver driver;
    private LoginSiloam login;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get("https://dev.ptdika.com/siloam/panel/login/");
    }

    @BeforeMethod
    public void pageObject() {
        login = new LoginSiloam();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        driver.quit();
    }

    @Test(priority = 1)
    public void testUsernamePasswordKosong() {
        delay(Constants.DETIK);
        login.login("","");
        Assert.assertEquals(login.getTxtUsernameRequired(), "true");
        Assert.assertEquals(login.getTxtPasswordRequired(), "true");
        System.out.println("Test Case Username Password Kosong use GetAttribute");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
