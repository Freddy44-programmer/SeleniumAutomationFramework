package SeleniumAutomationTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class EcommerceEndToEndAutomationTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit Wait
        //This is a global setting that applies to every element location call for the entire session
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        Thread.sleep(3000);
        addItems(driver,itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //explicit wait.
        // Explicit wait is applied only at targeted elements
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }



    public static void addItems(WebDriver driver,String[] itemsNeeded)

    {

        int j=0;

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++)
        {

            //Brocolli - 1 Kg
            //Brocolli,    1 kg
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            //format it to get actual vegetable name
            //convert array into array list for easy search
            // check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName))
            {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length)
                {
                    break;
                }
            }




        }
    }
}