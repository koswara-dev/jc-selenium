package com.juaracoding.selenium.pageobject;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import com.juaracoding.selenium.pageobject.pages.Dashboard;
import com.juaracoding.selenium.pageobject.pages.Login;
import com.juaracoding.selenium.pageobject.pages.Recruitment;
import com.juaracoding.selenium.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRecruitment {
    public static WebDriver driver;
    private Login login;
    private Recruitment recruitment;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        recruitment = new Recruitment();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testRecruitmentPage() {
        delay(Constants.DETIK);
        // PreCondition
        login.login("Admin","admin123");
        delay(Constants.DETIK);
        // Step
        recruitment.menuRecruitment();
        Assert.assertEquals(recruitment.getTxtRecruitment(), "Recruitment");
        System.out.println("Test Case Recruitment Page");
    }

    @Test
    public void testSearchByHiringManager() {
        delay(Constants.DETIK);
        // Step
        recruitment.searchByHiringManager();
        Assert.assertTrue(recruitment.getTxtLinda().contains("Linda"));
        System.out.println("Test Case Search By Hiring Manager");
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
