import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

public class Utilities {
    private static WebDriver driver = ConfigureDriver.get().getDriver();


    public void highlighterElement() {

        WebElement dashboardName = driver.findElement(By.xpath("//*[@id=\"ctl00_lblDashBoardName\"]"));
        //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
        highLighterMethod(driver, dashboardName);

    }

    //Creating a custom function
    public void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /*public void skorkelTakeScreenShot() throws Exception{

        this.takeSnapShot("Loginsuccess.png") ;

    }*/

    public static void takeSnapShot(String screenshotName) {

        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();

        //Convert web driver object to TakeScreenshot
        String fileWithPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + screenshotName+"-"+dateFormat.format(date)+".png";


        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        try {


            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

            File DestFile = new File(fileWithPath);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<String> readExcel(String testCaseName){

        ArrayList<String> a = new ArrayList<String>();

        FileInputStream xyz = null;
        try {
            xyz = new FileInputStream("Resources/Data/TestData.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(xyz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("TestData1")) {

                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> Cells = firstRow.cellIterator();
                int k = 0;
                int coloumn = 0;
                while (Cells.hasNext()) {
                    Cell value = Cells.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {

                        coloumn = k;

                    }
                    k++;


                }
                System.out.println(coloumn);

                while (rows.hasNext()) {

                    Row r = rows.next();
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("WallPost")) {

                        Iterator<Cell> c = r.cellIterator();
                        while (c.hasNext()) {
                            a.add(c.next().getStringCellValue());
                        }
                    }
                }

            }


        }

        return a;
    }
}
