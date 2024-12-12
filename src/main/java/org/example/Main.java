package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {


 //       Chrome Launch
 //       chromedriver
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//        Firefox Launch
//        geckodriver
//        System.setProperty("webdriver.gecko.driver","C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

//       Microsoft Edge Launch
//       msedgedriver
         System.setProperty("webdriver.edge.driver","C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\msedgedriver.exe");
         WebDriver driver = new EdgeDriver();



        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}