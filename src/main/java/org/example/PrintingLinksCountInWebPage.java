package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingLinksCountInWebPage {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Get the count of links on the page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        // get the links count in the footer
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());


    }
}
