package SeleniumAutomationTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class PrintingLinksCountInWebPage {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Get the count of links on the page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        // get the links count in the footer
        WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //Limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //Limiting webdriver scope
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //click on each link in the column and check if the page are opening
        for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++){
           String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000L);
        }// opens all the tabs

            // Getting the titles of child tabs with optimized while loop
            Set<String> abc = driver.getWindowHandles();
            Iterator<String> it =abc.iterator();
           while(it.hasNext()){
             driver.switchTo().window(it.next());
             System.out.println(driver.getTitle());
           }



    }
}
