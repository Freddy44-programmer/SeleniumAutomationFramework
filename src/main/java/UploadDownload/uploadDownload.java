package UploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class uploadDownload {

    public static void main(String[] args) {

        String fruitName = "Apple";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        //download
        driver.findElement(By.cssSelector("#downloadButton")).click();

        //Edit excel

        //upload
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys("path where your file is saved");

        //wait for success message to show up and wait for it to disappear
        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        String toastText = driver.findElement(toastLocator).getText();
        System.out.println(toastText);
        Assert.assertEquals("Updated Excel Data Successfully.", toastText);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

        //verify updated excel data showing in the web table
        String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
      //  String actualPrice = driver.findElement(By.xpath("//div[text()='Apple'/parent::div/div[@id='cell-4-undefined'")).getText();
        String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/div[@id='"+priceColumn+"undefined'")).getText();
        System.out.println(actualPrice);
        Assert.assertEquals("350", actualPrice);

    }
}
