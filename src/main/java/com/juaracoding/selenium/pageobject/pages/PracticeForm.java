package com.juaracoding.selenium.pageobject.pages;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeForm {
    private WebDriver driver;

    public PracticeForm() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='gender-radio-1']")
    WebElement genderMale;

    @FindBy(xpath = "//label[contains(@for, 'gender-radio')]")
    List<WebElement> listGender;

    public void inputForm(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", genderMale);
//        genderMale.click();
        for(int i=0;i<listGender.size();i++){
            listGender.get(i).click();
        }
        for(WebElement allGender : listGender) {
            System.out.println(allGender.getText());
        }
        System.out.println("All Gander Clicked");
    }
}
