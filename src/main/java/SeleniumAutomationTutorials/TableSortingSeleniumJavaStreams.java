package SeleniumAutomationTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class TableSortingSeleniumJavaStreams {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

        //click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all Web elements into list
        List<WebElement> elementsList= driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all Web elements into new (original) list
       List<String> originalList= elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on the original list of step 3 -> sorted list
       List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());


        //compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
    }
}
