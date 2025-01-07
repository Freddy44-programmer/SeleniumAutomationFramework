package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingScrollingInTables_and_Windows_usingJavaScriptExecutor {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        JavascriptExecutor js =(JavascriptExecutor) driver;
        //Handling the web page scrolling
        js.executeScript("window.scrollBy(0,500)");
         Thread.sleep(3000);
        //Handling the table scrolling
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");



    }
}
