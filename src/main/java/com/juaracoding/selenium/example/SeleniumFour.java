package com.juaracoding.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFour {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        delay(1);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("User berhasil login");
        driver.findElement(By.xpath("//span[normalize-space()='Recruitment']")).click();
        System.out.println("Menu Recruitment Clicked");
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        System.out.println("Button Add Clicked");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Dzikra Shanum\\Pictures\\Resume.txt");
        System.out.println("Input File TXT");
        delay(5);
        driver.quit();
        System.out.println("Browser Quit");
    }

    static void delay(int detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
