package SeleniumAutomationTutorials;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCheckBox {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // check if the checkbox is selected
        // using Assertions
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
       // check if the checkbox is selected
        // using Assertions
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //



        //Count the number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}
