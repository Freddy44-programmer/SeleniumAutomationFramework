package UploadDownload;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class uploadDownload {


    public static void main(String[] args) throws IOException {

        String fruitName = "Apple";
        String updatedValue = "603";
        String fileName= "C:\\Users\\Freddy\\Desktop\\Download.xlsx";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Freddy\\Desktop\\Automation Workspace\\SeleniumAutomationFramework\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        //download
        driver.findElement(By.cssSelector("#downloadButton")).click();

        //Edit excel - getColumnNumber of Price -getRownumber of APple-> update excel with row,col
        int col = getColumnNumber(fileName,"price");
        int row = getRowNumber(fileName,"Apple");
        Assert.assertTrue(updateCell(fileName,row,col, updatedValue));


        //upload
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys(fileName);

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
        Assert.assertEquals(updatedValue, actualPrice);

    }

    private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {
        ArrayList<String> a=new ArrayList<String>();
        FileInputStream fis=new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        Row rowField = sheet.getRow(row-1);
        Cell cellField = rowField.getCell(col-1);
        cellField.setCellValue(updatedValue);
        FileOutputStream fos= new FileOutputStream(fileName);
        workbook.write(fos);
        workbook.close();
        fis.close();
        return true;
    }

    private static int getRowNumber(String fileName, String text) throws IOException {
        ArrayList<String> a = new ArrayList<String>();

        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Iterator<Row> rows = sheet.iterator();

        int k =1;
        int rowIndex= -1;
        while(rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells=row.cellIterator();
            while(cells.hasNext())
            {
                Cell cell = cells.next();
                if(cell.getCellType()== CellType.STRING &&  cell.getStringCellValue().equalsIgnoreCase(text))
                {
                    rowIndex=k;
                }
        }
            k++;
        }
        return rowIndex;
    }


    private static int getColumnNumber(String fileName, String colName) throws IOException {
               ArrayList<String> a = new ArrayList<String>();

               FileInputStream fis = new FileInputStream(fileName);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet("Sheet1");

                Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
                Row firstrow = rows.next();
                Iterator<Cell> ce= firstrow.cellIterator(); // row is collection of cells

                int k=1;
                int column = 0;
                while (ce.hasNext())
                {
                    Cell value = ce.next();
                    if(value.getStringCellValue().equalsIgnoreCase(colName))
                    {
                        //desired column
                        column = k;
                    }
                    k++;
                }
        System.out.println(column);
                return column;
    }
}