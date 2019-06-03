import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import sun.security.util.Password;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;

public class Login {

    String UserName;
    String Password;
    private BusinessLogic b = new BusinessLogic();
    private static WebDriver driver = ConfigureDriver.get().getDriver();
//    String CSV_PATH = "C:\\Users\\sumit\\Desktop\\Automation\\GITHUB\\skorkel\\SeleniumSkorkel\\Resources\\TestData\\UserCSV1.csv";
    String CSV_PATH = "C:\\Users\\sumit\\Desktop\\Automation\\GITHUB\\skorkel\\SeleniumSkorkel\\Resources\\TestData\\UserCSV1.csv";

    public void csvDataRead() throws IOException {

        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] csvCell;
        int len = 0;

        while ((csvCell = reader.readNext()) != null) {
            UserName=csvCell[0];
            Password=csvCell[1];
            System.out.println(csvCell[0] + "\t" + csvCell[1]);
        }

    }



//    String UserName;
//    String Password;

    public void login() {

        driver.get("http://dev.skorkel.com");
        clickEvent(Elements.btn_login);
        sendData(Elements.UserName, UserName);
        sendData(Elements.Password, Password);

        clickEvent(Elements.btn_loginPopup);

        b.isLoggedIn();
//        driver.quit();


        /*   // Wait for 5 Sec
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	    driver.quit();
	    */
    }

    public static WebElement elementFinder(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element;
        } catch (NoSuchElementException e) {
            e.getMessage();
            System.out.println("... Element not found by locator: " + locator);
            return null;
        }

    }

    public boolean clickEvent(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            System.out.println("... Element not found by locator: " + locator);
            return false;
        }

    }

    public boolean sendData(By locator, String inputData) {
        try {
            WebElement element = driver.findElement(locator);
            element.sendKeys(inputData);
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            System.out.println("... Element not found by locator: " + locator);
            return false;
        }

    }

//    public class CSVdata {
//
//        String CSV_PATH = "C:\\Users\\sumit\\Desktop\\Automation\\GITHUB\\skorkel\\SeleniumSkorkel\\Resources\\TestData\\UserCSV1.csv";
//        WebDriver driver;
//
//        public void csvDataRead() throws IOException {
//
//            CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
//            String[] csvCell;
//            //while loop will be executed till the last line In CSV.
//            while ((csvCell = reader.readNext()) != null) {
//                UserName = csvCell[0];
//                Password = csvCell[1];
//            }
//        }
//    }


}
